package com.springhibernate.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springhibernate.entity.student;

@Repository
public class BddStudent {
	
@Autowired
SessionFactory factory;

private int idModif;
	
public SessionFactory getSessFact() {
	return factory;
}

public void setSessFact(SessionFactory sessFact) {
	this.factory = sessFact;
}

private  Session session ;
private student stu;

//on fait tout la config dans le xml de hibernate on a plus besoi de faire les comit et le beginTrasaction
//il le fait automatiquement

@Transactional
	public void AjouterStudent(String nom,String prenom,String email)
	{
	
		 
	  session = factory.getCurrentSession();
		 
		 stu = new student();
		 stu.setNom(nom);
		 stu.setPrenom(prenom);
		 stu.setEmail(email);
		 
			session.persist(stu);

		
	}
@Transactional
	public void AjouterStudent(student etudiant)
	{

	  session = factory.getCurrentSession();

		 stu = new student();
		 stu.setNom(etudiant.getNom());
		 stu.setPrenom(etudiant.getPrenom());
		 stu.setEmail(etudiant.getEmail());
		 
			session.persist(stu);
		
	}
	

	@Transactional
	public ArrayList afficher()
	{
		  session = factory.getCurrentSession();
		
		
		ArrayList<student> listStudent= (ArrayList<student>) session.createQuery("FROM student").list();
	
		return listStudent;
		 
	}
	@Transactional
	public void suprimerStudent(int id)
	{
		  session = factory.getCurrentSession();

		
		student inst = (student)session.load(student.class, id);

		session.remove(inst);
	
	}
	
	@Transactional
	public void modifier(int id)
	{
		  //session = factory.getCurrentSession();
		
				
			//	student inst = (student)session.load(student.class, 65);
				
				//inst.setNom("pierre");
		idModif = id;
			
	}

	public int getIdModif() {
		return idModif;
	}

	public void setIdModif(int idModif) {
		this.idModif = idModif;
	}
	

	
	
	
	
	
}
