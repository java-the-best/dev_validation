package localhost.devValidation.controller;

import javax.validation.Valid;
import localhost.devValidation.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @GetMapping
  public String index(Model model) {
    model.addAttribute("person", Person.builder().build());
    return "index";
  }

  @PostMapping("/form")
  public String form(@ModelAttribute("person") @Valid Person person) {
    System.out.println(person);
    return "redirect:/";
  }
}
