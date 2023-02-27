package taev.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import taev.app.repository.CocheRepository;
import taev.app.repository.RevisionRepository;

@Controller
public class ApplicationController {

	@Autowired
	CocheRepository cocheRepository;
	
	@Autowired
	RevisionRepository revisionRepository;

	@GetMapping("/")
	public String HomePage() {
		return "intro";
	}

	@GetMapping("listacoches")
	public String GetCoches(Model model) {
		model.addAttribute("coches", cocheRepository.findAll());
		return "listacoches";
	}
	
	@GetMapping("listarevisiones")
	public String GetRevisiones(Model model) {
		model.addAttribute("revisiones", revisionRepository.findAll());
		return "listarevisiones";
	}
}
