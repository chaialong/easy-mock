package calculator;

/**
 * Created by mi on 17-7-31.
 */
public interface CalculatorService {
    double add(double input1, double input2);

    double subtract(double input1, double input2);

    double multiply(double input1, double input2);

    double divide(double input1, double input2);

    void serviceUsed();
}
