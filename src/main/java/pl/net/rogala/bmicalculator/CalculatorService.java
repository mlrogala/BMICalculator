package pl.net.rogala.bmicalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.pow;

@Service
public class CalculatorService {

    private BmiForm bmiForm;

    @Autowired
    public CalculatorService(BmiForm bmiForm) {
        this.bmiForm = bmiForm;
    }

    public String calculateBmi(BmiForm bmiForm) {
        double weight = Double.valueOf(bmiForm.getWeight());
        double hight = Double.valueOf(bmiForm.getHight());

        BigDecimal bmi = new BigDecimal(weight / (pow(hight / 100, 2)));
        return String.valueOf(bmi.setScale(2, RoundingMode.HALF_UP));
    }
}