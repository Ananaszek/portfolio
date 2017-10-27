package pl.agataanaszewicz.portfolioAgataAnaszewicz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.agataanaszewicz.portfolioAgataAnaszewicz.ContactService;
import pl.agataanaszewicz.portfolioAgataAnaszewicz.PortfolioRepository;
import pl.agataanaszewicz.portfolioAgataAnaszewicz.models.forms.ContactForm;


@Controller
public class MainController {

    @Autowired
    TemplateEngine templateEngine;
    @Autowired
    ContactService contactService;
    @Autowired
    PortfolioRepository portfolioRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("emailClass", new ContactForm());
        model.addAttribute("success", false);
        model.addAttribute("projects", portfolioRepository.findAll());

        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String Form(@RequestBody ContactForm contact, Model model) {
        Context context = new Context();
        context.setVariable("name", "Name: " + contact.getName());
        context.setVariable("phonenumber", "Phone number: " + contact.getPhonenumber());
        context.setVariable("message", contact.getMessage());

        String bodyHTML = templateEngine.process("email", context);

        contactService.sendEmail(contact.getEmail(),bodyHTML);

        model.addAttribute("success", true);
        model.addAttribute("emailClass", new ContactForm());
        System.out.println("<!> WYSŁANO MAILA <!> Adres zwrotny: " + contact.getEmail());
        return "index";
    }
}
