package com.javapro.costs.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

  @GetMapping("/login")
  public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout) {
    ModelAndView mav = new ModelAndView("login");
    if (error != null) {
      mav.addObject("error", "error");
    }
    if (logout != null) {
      mav.addObject("logout", "logout");
    }

    return mav;
  }

  @GetMapping("/me")
  public ModelAndView myInfo() {
    ModelAndView mav = new ModelAndView("me");

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String name = auth.getName(); //get logged in username
    mav.addObject("username", name);

    return mav;
  }
}
