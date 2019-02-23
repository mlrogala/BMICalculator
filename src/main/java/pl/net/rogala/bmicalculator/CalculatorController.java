package pl.net.rogala.bmicalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.lang.String.valueOf;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String showHomePage(){
        return "home";
    }

    @GetMapping("/bmi")
    public String showBmi(Model model, Model modelTwo, Model modelThree, @RequestParam Double weight, @RequestParam Double hight){
        model.addAttribute("weight", weight);
        modelTwo.addAttribute("hight", hight);
        String bmi = valueOf((weight.doubleValue())/((hight.doubleValue()*0.01)*(hight.doubleValue()*0.01)));
        modelThree.addAttribute("bmi", bmi);
        return "bmi";
    }
}
