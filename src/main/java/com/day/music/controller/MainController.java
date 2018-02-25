package com.day.music.controller;

import com.day.music.config.DataConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/**
 * The class controller realizes the business logic of Authorization.
 */
@Controller
public class MainController {
	/**
	 * property - set logger
	 */
	final static Logger logger = LoggerFactory.getLogger(MainController.class);
	/**
	 * property - set MessageSource bean
	 */
	@Autowired
	private MessageSource messageSource;	/**
	 * Index page
	 *
	 * @return welcome message
	 */
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	@ResponseBody
	public String defaultPage() {
		String message = messageSource.getMessage("main.index", null,"locale not found", Locale.getDefault());
		logger.info(message);
		message = messageSource.getMessage("main.index.message", null,"locale not found", Locale.getDefault());
		return message;
	}
	/**
	 * The method show admin page
	 *
	 * @return admin model
	 */
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		String message = messageSource.getMessage("begin", null, "locale not found", Locale.getDefault())
				+ " " + messageSource.getMessage("main.admin", null, "locale not found", Locale.getDefault());
		logger.info(message);
		ModelAndView model = new ModelAndView();
		message = messageSource.getMessage("main.admin.title", null, "locale not found", Locale.getDefault());
		model.addObject("title", message);
		message = messageSource.getMessage("main.admin.message", null, "locale not found", Locale.getDefault());
		model.addObject("message", message);
		model.setViewName("admin");
		message = messageSource.getMessage("end", null, "locale not found", Locale.getDefault())
				+ " " + messageSource.getMessage("main.admin", null, "locale not found", Locale.getDefault());
		logger.info(message);
		return model;

	}
	/**
	 * The method show login page with authentication form
	 *
	 * @return login model
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
		String message = messageSource.getMessage("begin", null, "locale not found", Locale.getDefault())
				+ " " + messageSource.getMessage("main.login", null, "locale not found", Locale.getDefault());
		logger.info(message);
		ModelAndView model = new ModelAndView();
		if (error != null) {
			message = messageSource.getMessage("main.login.error", null, "locale not found", Locale.getDefault());
			model.addObject("error", message);
		}

		if (logout != null) {
			message = messageSource.getMessage("main.login.msg", null, "locale not found", Locale.getDefault());
			model.addObject("msg", message);
		}
		model.setViewName("login");
		message = messageSource.getMessage("end", null, "locale not found", Locale.getDefault())
				+ " " + messageSource.getMessage("main.login", null, "locale not found", Locale.getDefault());
		logger.info(message);
		return model;
	}
	/**
	 * The method show access denied page
	 *
	 * @return  access denied model
	 */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		String message = messageSource.getMessage("begin", null, "locale not found", Locale.getDefault())
				+ " " + messageSource.getMessage("main.403", null, "locale not found", Locale.getDefault());
		logger.info(message);
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}
		model.setViewName("403");
		message = messageSource.getMessage("end", null, "locale not found", Locale.getDefault())
				+ " " + messageSource.getMessage("main.403", null, "locale not found", Locale.getDefault());
		logger.info(message);
		return model;

	}

}