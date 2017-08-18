package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="sharing")
public class Shares {
	public int getPid() {
		return personId;
	}
	public void setPid(int pid) {
		this.personId = pid;
	}
	public int getIid() {
		return imageId;
	}
	public void setIid(int iid) {
		this.imageId = iid;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;
	@Column(name = "personId")
	private int personId;
	@Column(name = "imageId")
	private int imageId;
}
