package pro.sky.Course2HomeworkCalculatorTest.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Course2HomeworkCalculatorTest.Exceptions.DivideOnZeroException;
import pro.sky.Course2HomeworkCalculatorTest.Service.CalculatorService;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ExceptionHandler(DivideOnZeroException.class)
    public ResponseEntity<String> handleDivideOnZero() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Попытка деления на 0");
    }
}
