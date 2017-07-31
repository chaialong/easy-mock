package calculator;

import junit.framework.Assert;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by mi on 17-7-31.
 */
@RunWith(EasyMockRunner.class)
public class MathApplicationTester {
    @TestSubject
    MathApplication mathApplication = new MathApplication();

    @Mock
    CalculatorService calculatorService;

    @Test
    public void testAdd(){
        EasyMock.expect(calculatorService.add(10.0, 20.0)).andReturn(30.0);

        calculatorService.serviceUsed();

//        EasyMock.expectLastCall().times(1);

        EasyMock.expectLastCall().atLeastOnce();

//        EasyMock.expectLastCall().times(1, 3);

        EasyMock.replay(calculatorService);

        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);

        EasyMock.verify(calculatorService);
    }
}
