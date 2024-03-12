package pro.sky.Course2HomeworkCalculatorTest.Service;

import org.springframework.stereotype.Service;
import pro.sky.Course2HomeworkCalculatorTest.Exceptions.DivideOnZeroException;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) {
        if (isZeroArgument(num2)) {
            throw new DivideOnZeroException();
        }
        return num1 / num2;
    }

    private boolean isZeroArgument(int arg) {
        return arg == 0;
    }
}
