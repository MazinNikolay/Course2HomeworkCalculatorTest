package pro.sky.Course2HomeworkCalculatorTest.Service;

import org.springframework.stereotype.Service;
import pro.sky.Course2HomeworkCalculatorTest.Exceptions.DivideOnZeroException;
import pro.sky.Course2HomeworkCalculatorTest.Exceptions.OutOfArgumentsException;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double plus(String num1, String num2) {
        isIllegalArguments(num1, num2);
        return toNumeric(num1) + toNumeric(num2);
    }

    @Override
    public double minus(String num1, String num2) {
        isIllegalArguments(num1, num2);
        return toNumeric(num1) - toNumeric(num2);
    }

    @Override
    public double multiply(String num1, String num2) {
        isIllegalArguments(num1, num2);
        return toNumeric(num1) * toNumeric(num2);
    }

    @Override
    public double divide(String num1, String num2) {
        isIllegalArguments(num1, num2);
        if (isZeroArgument(num2)) {
            throw new DivideOnZeroException();
        }
        return toNumeric(num1) / toNumeric(num2);
    }

    private boolean isZeroArgument(String arg) {
        return toNumeric(arg) == 0.0;
    }

    private void isIllegalArguments(String arg1, String arg2) {
        boolean isNul = arg1 == null || arg2 == null;
        boolean isEmpty = false;
        if (!isNul) {
            isEmpty = arg1.isEmpty() || arg2.isEmpty();
        }
        if (isEmpty || isNul) {
            throw new OutOfArgumentsException();
        }
    }

    private double toNumeric(String arg) {
        return Double.parseDouble(arg);
    }
}
