package models;

import java.util.ArrayList;

public class Photo {
	boolean ispublic;
	ArrayList<String> tags;
	ArrayList<String> shares;
	String lurl;
	String surl;
	String name;
	String owner;
	public Photo(String lurl,String surl,String name,boolean pub,String owner){
		this.owner=owner;
		this.ispublic=pub;
		this.lurl=lurl;
		this.surl=surl;
		this.name=name;
		this.tags=new ArrayList<String>();
		this.shares=new ArrayList<String>();
	}
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
	}
}
