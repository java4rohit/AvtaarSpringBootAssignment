package com.java4rohit.avtaar.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author java4rohit
 *this is career table  which content Careers related endpoint.
 */
@Entity
@Table(name = "careers")
public class Careers extends GenericEntities {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String careersName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "careers")
	private List<Activities> activities;

	public Careers(int id, String careersName, List<Activities> activities) {
		super();
		this.id = id;
		this.careersName = careersName;
		this.activities = activities;
	}

	public Careers() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCareersName() {
		return careersName;
	}

	public void setCareersName(String careersName) {
		this.careersName = careersName;
	}

	public List<Activities> getActivities() {
		return activities;
	}

	public void setActivities(List<Activities> activities) {
		this.activities = activities;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Careers [id=" + id + ", careersName=" + careersName + ", activities=" + activities + "]";
	}

}
