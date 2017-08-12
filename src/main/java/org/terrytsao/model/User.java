package org.terrytsao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 4;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;

    @Column
	private String userName;

    @Column
	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Pet> myPets = new HashSet<>(0);

	public Set<Pet> getMyPets() {
		return myPets;
	}

	public void setMyPets(Set<Pet> myPets) {
		this.myPets = myPets;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
}
