package pro.sky.Course2HomeworkCalculatorTest.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Course2HomeworkCalculatorTest.Exceptions.DivideOnZeroException;
import pro.sky.Course2HomeworkCalculatorTest.Exceptions.OutOfArgumentsException;
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

    @ExceptionHandler(OutOfArgumentsException.class)
    public ResponseEntity<String> handleIllegalArgument() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Один или оба аргумента не заданы");
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> handleNumberFormatArgument() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Неверно введен аргумент. Повторите ввод в формате d.d");
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/plus")
    public String plus(
            @RequestParam(value = "num1", required = false) String num1,
            @RequestParam(value = "num2", required = false) String num2) {
        return String.valueOf(calculatorService.plus(num1, num2));
    }

    @GetMapping(path = "/minus")
    public String minus(
            @RequestParam(value = "num1", required = false) String num1,
            @RequestParam(value = "num2", required = false) String num2) {
        return String.valueOf(calculatorService.minus(num1, num2));
    }

    @GetMapping(path = "/multiply")
    public String multiply(
            @RequestParam(value = "num1", required = false) String num1,
            @RequestParam(value = "num2", required = false) String num2) {
        return String.valueOf(calculatorService.multiply(num1, num2));
    }

    @GetMapping(path = "/divide")
    public String divide(
            @RequestParam(value = "num1", required = false) String num1,
            @RequestParam(value = "num2", required = false) String num2) {
        return String.valueOf(calculatorService.divide(num1, num2));
    }
}
