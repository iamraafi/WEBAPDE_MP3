package services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import models.Person;
import models.Photo;
import models.Shares;
import utility.DBUtil;

public class ImageServices {
	public static Photo firstimage(int i,String user,String OG){
		EntityManager em = DBUtil.getEntityManager();
		// create query and pass :username and :password parameters
		Query query = em.createQuery("select p from Photo as p where p.personid=:id");
		query.setParameter("id", i); // note username and password
													// are base on the parameter
													// :username and :password
													// without the ':'
		//query.setParameter("password", password); // usually password should be
													// encrypted before saving
		// for the sake of this example, we just simply use the actual password
		try {
			List<Photo> image = (List<Photo>) query.getResultList();
			boolean realuser=false;
			if(user.equals(OG))
				realuser=true;
			int z=0;
			Photo temp=null;
			for(Photo k: image){
				if(((k.getPersonid()<0)||z==0)&&((realuser)||(k.getIspublic()>0))){
					z=k.getPersonid();
					temp=k;
				}
			}
			
			if(temp!=null){
				System.out.println("not found whyyyy");
				return temp;
			}
			System.out.println("it was found whyyyy");
			return null;
		} catch (NoResultException e) {
			System.out.println("no results whyyyy");
			return null;
		} finally {
			em.close();
		}
	}
	public static byte[] loadImage(int i){
		EntityManager em = DBUtil.getEntityManager();
		return em.find(Photo.class, i).getImage();
	}
	public static List<Photo> OGphotos(int i){
		EntityManager em = DBUtil.getEntityManager();
		// create query and pass :username and :password parameters
		Query query = em.createQuery("select p from Photo as p where p.personid=:id");
		query.setParameter("id", i);
		try {
			List<Photo> image = (List<Photo>) query.getResultList();
			return image;
		
		} catch (NoResultException e) {
			System.out.println("no results whyyyy");
			return null;
		} finally {
			em.close();
		}
	}
	public static List<Photo> sharedphoto(int id){
		EntityManager em = DBUtil.getEntityManager();
		// create query and pass :username and :password parameters
		Query query = em.createQuery("SELECT s FROM Shares as s where s.personId=:id");
		query.setParameter("id", id);
		try {
			List<Shares> shares = (List<Shares>) query.getResultList();
			List<Photo> images = new ArrayList<Photo>();
			for(Shares s:shares){
				Photo p;
				if((p=getphoto(s.getIid()))!=null){
					images.add(p);
				}
			}
			return images;
		} catch (NoResultException e) {
			System.out.println("no results whyyyy");
			return null;
		} finally {
			em.close();
		}
	}
	private static Photo getphoto(int id){
		EntityManager em = DBUtil.getEntityManager();
		// create query and pass :username and :password parameters
		Query query = em.createQuery("select p from Photo as p where p.id=:id");
		query.setParameter("id", id);
		try {
			Photo image= (Photo)query.getSingleResult();
			return image;
		
		} catch (NoResultException e) {
			System.out.println("no results whyyyy");
			return null;
		} finally {
			em.close();
		}
	}
	/*
	public static byte[] imagedata(String name){
		EntityManager em = DBUtil.getEntityManager();
		// create query and pass :username and :password parameters
		Query query = em.createQuery("select p from Photo as p where p.name=:name");
		query.setParameter("name", name); // note username and password
													// are base on the parameter
													// :username and :password
													// without the ':'
		//query.setParameter("password", password); // usually password should be
													// encrypted before saving
		// for the sake of this example, we just simply use the actual password
		try {
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			Photo image = (Photo) query.getSingleResult();
			Blob blob=image.getImage();
			byte[] buf=new byte[1024];
			InputStream in=blob.getBinaryStream();
			int n=0;
			while((n=in.read(buf))>=0){
				baos.write(buf, 0, n);
			}
			in.close();
			byte[] bytes=baos.toByteArray();
			return bytes;
		} catch (NoResultException e) {
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}*/
}
