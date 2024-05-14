package com.vivek.SpringBootAOPAndSecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@Autowired
	AnimalRepo repo;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("called");

		return "index";
	}
	
	@GetMapping("getAnimals")
	public String getAnimals(Model m) {
		m.addAttribute("res",repo.findAll());
		return "result";
	}
	
	@GetMapping("getAnimalsByName")
	public String getAnimals(@RequestParam("name") String name, Model m) {

		m.addAttribute("res", repo.findByAnameOrderByAageDesc(name));
		return "result";
	}
	
	@GetMapping("getAnimalsWithName")
	public String getAnimalsWithName(@RequestParam("name") String name, Model m) {
		
		m.addAttribute("res", repo.findAnimalsWithName(name));
		return "result";
	}
	
	@PostMapping("addAnimal")
	public String addAnimal(@ModelAttribute("res") Animal an) {
		repo.save(an);
		return "result";
	}
	
	@GetMapping("getAnimal")
	public String getAnimal(@RequestParam("aid") int id, Model m) {
		m.addAttribute("res", repo.findById(id));
		return "result";
	}

}
