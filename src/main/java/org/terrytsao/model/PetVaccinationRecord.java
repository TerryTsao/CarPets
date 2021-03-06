package org.terrytsao.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PetVaccinationRecord {
	@Id
	@GeneratedValue
	private int vid;

	@ManyToOne(cascade = CascadeType.ALL)
	private Pet pet;
	@Column(nullable = false)
	private Date vacDate;
	@Column
	private double weight;
	private String vet;
	private int[] vacs;

	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	public Date getVacDate() {
		return vacDate;
	}
	public void setVacDate(Date vacDate) {
		this.vacDate = vacDate;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getVet() {
		return vet;
	}
	public void setVet(String vet) {
		this.vet = vet;
	}
	public int[] getVacs() {
		return vacs;
	}
	public void setVacs(int[] vacs) {
		this.vacs = vacs;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}

}
