package com.java4rohit.avtaar.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * @author java4rohit
 *this is career entities  which represent Careers table .
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
	private Long id;
	private String careersName;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "careers")
	private List<Activities> activities;

	public Careers(Long id, String careersName, List<Activities> activities) {
		super();
		this.id = id;
		this.careersName = careersName;
		this.activities = activities;
	}

	public Careers() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
