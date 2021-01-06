package com.java4rohit.avtaar.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
/**
 * 
 * @author java4rohit
 * this is activities table  which content Activities related endpoint..
 *
 */
@Entity
@Table(name = "activities")
public class Activities extends GenericEntities {


	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long id;
	private String activitiesName;
	private String activitiesDescription;
	
   @JsonBackReference
   @ManyToOne()
   @JoinColumn(name = "career_id",nullable = false)
   private Careers careers;
   
   

	public Activities() {
	super();
}

	public Activities(Long id, String activitiesName, String activitiesDescription) {
		super();
		this.id = id;
		this.activitiesName = activitiesName;
		this.activitiesDescription = activitiesDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActivitiesName() {
		return activitiesName;
	}

	public void setActivitiesName(String activitiesName) {
		this.activitiesName = activitiesName;
	}

	public String getActivitiesDescription() {
		return activitiesDescription;
	}

	public void setActivitiesDescription(String activitiesDescription) {
		this.activitiesDescription = activitiesDescription;
	}

	public Careers getCareers() {
		return careers;
	}

	public void setCareers(Careers careers) {
		this.careers = careers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Activities [id=" + id + ", activitiesName=" + activitiesName + ", activitiesDescription="
				+ activitiesDescription + ", careers=" + careers + "]";
	}
	
	


}
