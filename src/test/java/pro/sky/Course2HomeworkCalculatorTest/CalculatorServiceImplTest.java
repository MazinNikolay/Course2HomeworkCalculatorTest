package pro.sky.Course2HomeworkCalculatorTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.Course2HomeworkCalculatorTest.Exceptions.DivideOnZeroException;
import pro.sky.Course2HomeworkCalculatorTest.Exceptions.OutOfArgumentsException;
import pro.sky.Course2HomeworkCalculatorTest.Service.CalculatorServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceImplTest {
    private CalculatorServiceImpl calculatorServiceImpl;
    private static final String ARG_1 = "1";
    private static final String ARG_22 = "22";
    private static final String ARG_23 = "23";
    private static final String ARG_8 = "8";
    private static final String ARG_2 = "2";
    private static final String ARG_10 = "10";
    private static final String ARG_11 = "11";
    private static final double EXPECTED_ARG_11 = 11.0;
    private static final double EXPECTED_ARG_23 = 23.0;
    private static final double EXPECTED_ARG_10 = 10.0;
    private static final double EXPECTED_ARG_21 = 21.0;
    private static final double EXPECTED_ARG_8 = 8.0;
    private static final double EXPECTED_ARG_22 = 22.0;

    public static Stream<Arguments> provideArgsToPlusTest() {
        return Stream.of(
                Arguments.of(ARG_22, ARG_1, EXPECTED_ARG_23),
                Arguments.of(ARG_8, ARG_2, EXPECTED_ARG_10)
        );
    }

    public static Stream<Arguments> provideArgsToMinusTest() {
        return Stream.of(
                Arguments.of(ARG_23, ARG_2, EXPECTED_ARG_21),
                Arguments.of(ARG_10, ARG_2, EXPECTED_ARG_8)
        );
    }

    public static Stream<Arguments> provideArgsToMultiplyTest() {
        return Stream.of(
                Arguments.of(ARG_8, ARG_1, EXPECTED_ARG_8),
                Arguments.of(ARG_11, ARG_2, EXPECTED_ARG_22)
        );
    }

    public static Stream<Arguments> provideArgsToDivideTest() {
        return Stream.of(
                Arguments.of(ARG_22, ARG_2, EXPECTED_ARG_11),
                Arguments.of(ARG_8, ARG_1, EXPECTED_ARG_8)
        );
    }

    @BeforeEach
    public void setUp() {
        calculatorServiceImpl = new CalculatorServiceImpl();
    }

    @Test
    public void shouldReturnPlusCorrect() {
        double expectedValue = 5.0;
        double actualValue = calculatorServiceImpl.plus("3.0", "2");
        assertEquals(actualValue, expectedValue);
    }

    @Test
    public void shouldReturnPlusIncorrectInput() {
        assertThrows(NumberFormatException.class, () -> calculatorServiceImpl.plus("22", " "));
    }

    @Test
    public void shouldReturnMinusCorrect() {
        double expectedValue = 2.0;
        double actualValue = calculatorServiceImpl.minus("7.0", "5");
        assertEquals(actualValue, expectedValue);
    }

    @Test
    public void shouldReturnMinusIncorrectInput() {
        assertThrows(NumberFormatException.class, () -> calculatorServiceImpl.minus("asdasd", " "));
    }

    @Test
    public void shouldReturnMultiplyCorrect() {
        double expectedValue = 12.0;
        double actualValue = calculatorServiceImpl.multiply("6.0", "2");
        assertEquals(actualValue, expectedValue);
    }

    @Test
    public void shouldReturnMultiplyIncorrectInput() {
        assertThrows(OutOfArgumentsException.class, () -> calculatorServiceImpl.multiply("2", null));
    }

    @Test
    public void shouldReturnDivideCorrect() {
        double expectedValue = 4.0;
        double actualValue = calculatorServiceImpl.divide("8.0", "2");
        assertEquals(actualValue, expectedValue);
    }

    @Test
    public void shouldReturnDivideOnZero() {
        assertThrows(DivideOnZeroException.class, () -> calculatorServiceImpl.divide("1", "0"));
    }

    @ParameterizedTest
    @MethodSource("provideArgsToPlusTest")
    public void shouldPassedTestPlus(String argFirst, String argSecond, double expectedValue) {
        double actualValue = calculatorServiceImpl.plus(argFirst, argSecond);
        assertEquals(actualValue, expectedValue);
    }

    @ParameterizedTest
    @MethodSource("provideArgsToMinusTest")
    public void shouldPassedTestMinus(String argFirst, String argSecond, double expectedValue) {
        double actualValue = calculatorServiceImpl.minus(argFirst, argSecond);
        assertEquals(actualValue, expectedValue);
    }

    @ParameterizedTest
    @MethodSource("provideArgsToMultiplyTest")
    public void shouldPassedTestMultiply(String argFirst, String argSecond, double expectedValue) {
        double actualValue = calculatorServiceImpl.multiply(argFirst, argSecond);
        assertEquals(actualValue, expectedValue);
    }

    @ParameterizedTest
    @MethodSource("provideArgsToDivideTest")
    public void shouldPassedTestDivide(String argFirst, String argSecond, double expectedValue) {
        double actualValue = calculatorServiceImpl.divide(argFirst, argSecond);
        assertEquals(actualValue, expectedValue);
    }
}