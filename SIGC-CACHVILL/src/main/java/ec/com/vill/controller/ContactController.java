package ec.com.vill.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ec.com.vill.constant.ViewConstant;

@Controller
@RequestMapping("/welcome")
public class ContactController {

	private static final Log LOG = LogFactory.getLog(ContactController.class);

	/*
	 * @Autowired
	 * 
	 * @Qualifier("contactServiceImpl") private ContactService contactService;
	 */

	@GetMapping("/showPage")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		LOG.info("wellcome to principal page");
		return mav;
	}

}