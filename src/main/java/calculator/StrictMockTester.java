package calculator;

import junit.framework.Assert;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mi on 17-7-31.
 */
public class StrictMockTester {
    private MathApplication mathApplication;

    private CalculatorService calculatorService;

    @Before
    public void setUp(){
        mathApplication = new MathApplication();

        calculatorService = EasyMock.createStrictMock(CalculatorService.class);

        mathApplication.setCalculatorService(calculatorService);
    }

    @Test
    public void testAddAndSubtract(){
        EasyMock.expect(calculatorService.add(20.0, 10.0)).andReturn(30.0);

        EasyMock.expect(calculatorService.subtract(20.0, 10.0)).andReturn(10.0);

        Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);

        Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);

        EasyMock.replay(calculatorService);

        EasyMock.verify(calculatorService);
    }
}
