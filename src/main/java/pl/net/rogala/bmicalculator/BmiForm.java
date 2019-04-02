package pl.net.rogala.bmicalculator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@Getter
@Setter
@ToString
public class BmiForm {
    @NotNull(message = "Podaj wzrost w centymetrach!")
    @NumberFormat
    private String weight;
    @NotNull(message = "Pole nie może być puste")
    @NumberFormat
    private String hight;
}
