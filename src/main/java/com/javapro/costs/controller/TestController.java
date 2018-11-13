package com.javapro.costs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

  @GetMapping("/test")
  public String test(Model model) {

    model.addAttribute("message", "World!");
    return "test";
  }
}
