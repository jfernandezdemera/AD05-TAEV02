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
import taev.app.domain.Coche;
import taev.app.repository.CocheRepository;

@Controller
@RequestMapping("/coche")
public class CocheController {
	@Autowired
	CocheRepository cocheRepository;

	@GetMapping("/nuevo")
	public String NuevoCoche(Model model) {
		Coche coche = new Coche();
		model.addAttribute("coche", coche);
		return "cochesForm";
	}

	@GetMapping("/editar/{id}")
	public String EditarCoche(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("coche", cocheRepository.findById(id));
		return "cochesForm";
	}

	@GetMapping("/borrar/{id}")
	public String BorrarCoche(@PathVariable("id") Integer id) {
		cocheRepository.deleteById(id);
		return "redirect:/listacoches";
	}

	@PostMapping("/submit")
	public String SubmitForm(@ModelAttribute Coche coche, HttpServletRequest request) {
		if(request.getParameter("precio") == null) {
			coche.setPrecio(0.0);
		}
		
		if (!coche.isClear())
			cocheRepository.save(coche);
		return "redirect:/listacoches";
	}
}
