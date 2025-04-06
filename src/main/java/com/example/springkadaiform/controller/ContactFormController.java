package com.example.springkadaiform.controller;

import com.example.springkadaiform.form.ContactForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactFormController {
	
	@GetMapping("/form")
    public String showForm(ContactForm contactForm) {
        return "contactFormView";
    }

    @PostMapping("/form/confirm")
    public String confirmForm(@Valid @ModelAttribute ContactForm contactForm,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "contactFormView";
        }
        model.addAttribute("contactForm", contactForm);
        return "confirmView";
    }


}
