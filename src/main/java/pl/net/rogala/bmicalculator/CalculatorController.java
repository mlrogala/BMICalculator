package pl.net.rogala.bmicalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CalculatorController {
    private CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping("/")
    public String showHomePage(Model model) {

        model.addAttribute("bmiForm", new BmiForm());
        return "bmiForm";
    }

    @PostMapping("/")
    public String handleBmiFoerm(Model model,
                                 @ModelAttribute @Valid BmiForm bmiForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "bmiForm";
        }
        String bmi = calculatorService.calculateBmi(bmiForm);
        model.addAttribute("bmi", bmi);
        return "result";
    }
}
