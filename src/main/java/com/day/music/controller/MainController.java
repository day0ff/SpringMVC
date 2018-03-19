package com.day.music.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * The class controller realizes the business logic of Authorization.
 */
@RestController
@CrossOrigin
public class MainController {
    /**
     * property - set logger
     */
    final static Logger logger = LoggerFactory.getLogger(MainController.class);
    /**
     * property - set MessageSource bean
     */
    @Autowired
    private MessageSource messageSource;

    /**
     * Index page
     *
     * @return welcome message
     */
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String defaultPage() {
        String message = messageSource.getMessage("main.index", null, "locale not found", Locale.getDefault());
        logger.info(message);
        message = messageSource.getMessage("main.index.message", null, "locale not found", Locale.getDefault());
        return message;
    }

    /**
     * The method show admin page
     *
     * @return admin model
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage() {
        String message = messageSource.getMessage("begin", null, "locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("main.admin", null, "locale not found", Locale.getDefault());
        logger.info(message);
        String adminMessage = messageSource.getMessage("main.admin.title", null, "locale not found", Locale.getDefault());
        adminMessage += " " + messageSource.getMessage("main.admin.message", null, "locale not found", Locale.getDefault());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) authentication.getPrincipal();
        adminMessage += " " + userDetail.getUsername();
        message = messageSource.getMessage("end", null, "locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("main.admin", null, "locale not found", Locale.getDefault());
        logger.info(message);
        return adminMessage;
    }

    /**
     * The method show login page with authentication form
     *
     * @deprecated never gets here
     *
     * @return login model
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout) {
        String message = messageSource.getMessage("begin", null, "locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("main.login", null, "locale not found", Locale.getDefault());
        logger.info(message);
        String loginMessage = "";
        if (error != null) {
            loginMessage += messageSource.getMessage("main.login.error", null, "locale not found", Locale.getDefault());
            return loginMessage;
        }

        if (logout != null) {
            loginMessage += messageSource.getMessage("main.login.msg", null, "locale not found", Locale.getDefault());
            return loginMessage;
        }
        message = messageSource.getMessage("end", null, "locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("main.login", null, "locale not found", Locale.getDefault());
        logger.info(message);
        return loginMessage;
    }

    /**
     * The method show access denied page
     *
     * @return access denied model
     */
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accesssDenied() {
        String message = messageSource.getMessage("begin", null, "locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("main.403", null, "locale not found", Locale.getDefault());
        logger.info(message);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String message403 = "";
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            message403 = userDetail.getUsername() + " : ";
        }
        message403 += messageSource.getMessage("main.403", null, "locale not found", Locale.getDefault());
        message = messageSource.getMessage("end", null, "locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("main.403", null, "locale not found", Locale.getDefault());
        logger.info(message);
        return message403;
    }
}