package taev.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import taev.app.domain.Revision;
import taev.app.repository.CocheRepository;
import taev.app.repository.RevisionRepository;

@Controller
@RequestMapping("/revision")
public class RevisionController {
	@Autowired
	CocheRepository cocheRepository;

	@Autowired
	RevisionRepository revisionRepository;

	@GetMapping("/nuevo")
	public String NuevaRevision(Model model) {
		Revision revision = new Revision();
		model.addAttribute("revision", revision);
		model.addAttribute("coches", cocheRepository.findAll());
		return "revisionesForm";
	}

	@GetMapping("/editar/{id}")
	public String EditarRevision(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("revision", revisionRepository.findById(id));
		model.addAttribute("coches", cocheRepository.findAll());
		return "revisionesForm";
	}

	@GetMapping("/borrar/{id}")
	public String BorrarRevision(@PathVariable("id") Integer id) {
		revisionRepository.deleteById(id);
		return "redirect:/listarevisiones";
	}

	@PostMapping("/submit")
	public String SubmitRevision(@ModelAttribute Revision revision, HttpServletRequest request) {
		
		revision.setAceite(0);
		revision.setFiltro(0);
		revision.setFrenos(0);
		if ( (request.getParameter("aceite") != null)) {
			revision.setAceite(1);
		}
		
		if ( (request.getParameter("filtro") != null)) {
			revision.setFiltro(1);
		}
		
		if ( (request.getParameter("frenos") != null)) {
			revision.setFrenos(1);
		}
		
		if(!revision.isClear()) {
			revisionRepository.save(revision);
		}
		return "redirect:/listarevisiones";
	}
}
