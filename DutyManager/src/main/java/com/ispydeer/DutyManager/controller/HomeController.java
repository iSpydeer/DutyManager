package com.ispydeer.DutyManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Controller for handling requests to the home page of the Duty Manager application.
 * This controller redirects users to the manage duties page.
 */
@SessionAttributes("username")
@Controller
public class HomeController {

    /**
     * Redirects the user to the manage duties page when accessing the home page.
     *
     * @param modelMap the ModelMap to hold attributes for the view (not used in this method)
     * @return the redirect path to the manage duties page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToHomePage(ModelMap modelMap) {
        return "redirect:manage-duties";
    }

}
