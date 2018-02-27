package com.javapro.costs.controller;

import com.javapro.costs.model.Purchase;
import com.javapro.costs.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @RequestMapping("/purchase/id")
    public ModelAndView get(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("purchase");

        Purchase purchase = service.get(id);
        mav.addObject("purchase", purchase);

        return mav;
    }


    @RequestMapping("/purchases")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("purchases");
        List<Purchase> events = new ArrayList<>(service.getAll());
        mav.addObject("purchases", events);
        return mav;
    }

    @RequestMapping("/purchase/add")
    public ModelAndView addUser() {
        ModelAndView mav = new ModelAndView("purchase");
        mav.addObject("purchase", new Purchase());
        return mav;
    }


    @RequestMapping(value = "/purchase/addPurchase", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user") Purchase user, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        service.save(user);
        return "redirect:/purchases";
    }

    @RequestMapping(value = "/purchase/removePurchase")
    public String remove(@RequestParam("id") long purchaseId) {
        service.delete(purchaseId);
        return "redirect:/purchases";
    }


}
