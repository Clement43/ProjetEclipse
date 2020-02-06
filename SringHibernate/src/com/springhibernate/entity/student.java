package com.springhibernate.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
public class student {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	@NotNull(message="Veuillez saisir le prenom de l'étudiant")
	private String prenom;
	
	@Column(name="last_name")
	@NotNull(message="Veuillez saisir le nom de l'étudiant")
	private String nom;
	
	@Column(name="email")
	@NotNull(message="Veuillez saisir le email de l'étudiant")
	@Email(message="Le format est invalide")
	private String email;
	
	 
	 


	public student() {}
	 
	 public student(String nom,String prenom,String email) {
		 this.email=email;
		 this.prenom=prenom;
		 this.nom=nom;
		 
	 }
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	

}
