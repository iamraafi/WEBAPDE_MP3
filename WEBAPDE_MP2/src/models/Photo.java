package models;

import java.sql.Blob;
import java.util.ArrayList;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table(name="image")
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Lob 
	@Basic(fetch=FetchType.LAZY)
	private byte[] image;
	//@Column(name="image", length=100000)
	//@Column(name = "image")
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getImage() {
		return image;
	}
	
	public String getsrcImage() {
		return "/WEBAPDE_MP2/image.html?id="+id;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getIspublic() {
		return ispublic;
	}
	public void setIspublic(int ispublic) {
		this.ispublic = ispublic;
	}
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "ispublic")
	int ispublic;
	@Column(name = "personid")
	int personid;
	@Column(name = "name")
	String name;
	
	//boolean ispublic;
	//ArrayList<String> tags;
	//ArrayList<String> shares;
	//String lurl;
	//String surl;
	//String name;
	//String owner;
	/*
	public Photo(String lurl,String surl,String name,boolean pub,String owner){
		this.owner=owner;
		this.ispublic=pub;
		this.lurl=lurl;
		this.surl=surl;
		this.name=name;
		this.tags=new ArrayList<String>();
		this.shares=new ArrayList<String>();
	}*/
	/*
	public String getOwner() {
		return owner;
	}
	public void addtag(String tag){
		tags.add(tag);
	}
	public boolean isIspublic() {
		return ispublic;
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public ArrayList<String> getShares() {
		return shares;
	}
	public String getLurl() {
		return lurl;
	}
	public String getSurl() {
		return surl;
	}
	public String getName() {
		return name;
	}
	public void sharewith(String user){
		shares.add(user);
	}
	public String getHtmlTag(){
		String htmlTags="";
		for(int i=0;i<tags.size();i++){
			if(i==0){
				htmlTags+=tags.get(i);
			}else
				htmlTags+=","+tags.get(i);
		}
		return htmlTags;
	}
	public String getHtmlShare(){
		if(ispublic)return "everyone";
		String htmlShare="";
		for(int i=0;i<shares.size();i++){
			if(i==0){
				htmlShare+=shares.get(i);
			}else
				htmlShare+=","+shares.get(i);
		}
		return htmlShare;
	}*/
}
