package com.springhibernate.mvc;



import java.sql.SQLException;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springhibernate.dao.BddStudent;
import com.springhibernate.entity.student;



@Controller
public class HomeController {
	
	@Autowired // permet de créer l'objet quand on veut l'utiliser
	private BddStudent bdd;
	
	
	
	@RequestMapping("/")
	public String afficherTest() 
	{

		//bdd.modifier();
	
	return "Index";
	}
	
	@RequestMapping("/FormStudent")
	public String formStudent(Model m) 	{
		
		student s = new student();
		m.addAttribute("student",s);
		

		return "FormStudent";
	}
	

	@RequestMapping("/ajoutBdd")
	public String ajoutBDD(@Valid  @ModelAttribute("student")student s,	BindingResult bd) 	
		{
		
		if(bd.hasErrors())
		{
			return "FormStudent";
		}
		else {
		
		bdd.AjouterStudent(s);
		return "redirect:/AfficherStudent";
		}
		}
		
		
		
		@RequestMapping("/modifierbdd")
		public String ModifierBDD( @ModelAttribute("bModifier")int bmod) 	
			{
	//va metter le meme tableau mais pour la ligne selectioner on mais un formulaire


			System.out.println(bmod);
			
			return "redirect:/AfficherStudent";
			}
	
	
	
	@RequestMapping("/AfficherStudent")
	public String formStudentaffichage(Model m ) 	{
		

		ArrayList<student>liStudent = new ArrayList<student>();
		liStudent=	bdd.afficher();
		m.addAttribute("Liststu",liStudent);
		
		

		return "AfficherStudent";
	}
	
	@RequestMapping("/delete")
	public String formStuentaffichage(@ModelAttribute(value="id") int idstudenet) 
			{
		bdd.suprimerStudent(idstudenet);
		return "redirect:/AfficherStudent";
			}
	
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
	
	





	
		
	
