package org.terrytsao.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vaccination {
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
	private Set<Integer> dogvacs;
	private Set<Integer> catvacs;
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
	public Set<Integer> getDogvacs() {
		return dogvacs;
	}
	public void setDogvacs(Set<Integer> dogvacs) {
		this.dogvacs = dogvacs;
	}
	public Set<Integer> getCatvacs() {
		return catvacs;
	}
	public void setCatvacs(Set<Integer> catvacs) {
		this.catvacs = catvacs;
	}
}
