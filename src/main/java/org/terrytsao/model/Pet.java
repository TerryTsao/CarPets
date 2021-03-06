package org.terrytsao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pet implements Serializable {

	private static final long serialVersionUID = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	@Column(nullable = false)
	private String petName;

	private String ownerName;

	@Enumerated
	@Column(nullable = false)
	private Species species;

	@Column(nullable = false)
	private Date DOB;

	@Column(nullable = false)
	@Enumerated
	private PetGender gender;

	@Column
	private String microchipNO;
	private String breed;

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public PetGender getGender() {
		return gender;
	}
	public void setGender(PetGender gender) {
		this.gender = gender;
	}
	public String getMicrochipNO() {
		return microchipNO;
	}
	public void setMicrochipNO(String microchipNO) {
		this.microchipNO = microchipNO;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
