package portfolio;

import org.easymock.EasyMock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mi on 17-7-31.
 */
public class PortfolioTester {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Portfolio portfolio = new Portfolio();

        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock microsoftStock = new Stock("2", "Microsoft", 100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        StockService stockServiceMock = EasyMock.createMock(StockService.class);

        EasyMock.expect(stockServiceMock.getPrice(googleStock)).andReturn(50.00);
        EasyMock.expect(stockServiceMock.getPrice(microsoftStock)).andReturn(1000.00);

        EasyMock.replay(stockServiceMock);

        portfolio.setStocks(stocks);

        portfolio.setStockService(stockServiceMock);

        double marketValue = portfolio.getMarketValue();

        System.out.println("Market value of the portfolio: " + marketValue);
    }
}
