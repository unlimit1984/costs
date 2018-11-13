package com.javapro.costs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class SecurityController {

  @RequestMapping("/login")
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

  @RequestMapping("/logout")
  public ModelAndView logout() {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("", "");
    return mav;
  }

}
