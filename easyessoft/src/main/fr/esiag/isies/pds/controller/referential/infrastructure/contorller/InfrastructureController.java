package fr.esiag.isies.pds.controller.referential.infrastructure.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.dao.referential.infrastructure.InfrastructureDAO;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;


@Controller
@RequestMapping("ref/infra")
public class InfrastructureController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InfrastructureController.class);
	
	private InfrastructureDAO infrastructuredao;
	
	@RequestMapping("createForm")
	public String getCreateForm(Model model){
		model.addAttribute(new Infrastructure());
		LOGGER.info("EASYES Form display : Infrastructure creation ");
		return "ref/infra/create";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(@ModelAttribute Infrastructure infrastructure,Model model){
		infrastructure.setUpdateUser(SecurityContextHolder.getContext().getAuthentication().getName());
	//	if (new InfrastructureBusinessRules().verify(infrastructure)) {
			infrastructuredao.create(infrastructure);
			model.addAttribute("infrastructure",infrastructure);
			LOGGER.info("EASYES Infrastructure creation OK");
			return "ref/infra/display";
	//	}
	//	return null;
		
	}
}
