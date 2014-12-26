package fr.esiag.isies.pds.controller.referential.organization;

import java.util.List;

import mockit.Mocked;

import org.junit.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;


public class OrganizationControllerTest {
	
	@Mocked
	OrganizationDao orgaDao;
	@Mocked
	Model model;
	
	OrgaTypeDao orgaTypeDao;
	List<OrgaType> listTypeOrga;
	
	/**
	 * Mock Spring Security
	 */
	@Mocked SecurityContext securityContext;
	@Mocked Authentication authentication;
	
	@Before
    public void prepare() {	
		SecurityContextHolder.setContext(securityContext);
    }
}


