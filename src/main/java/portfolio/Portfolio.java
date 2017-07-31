package portfolio;

import java.util.List;

/**
 * Created by mi on 17-7-31.
 */
public class Portfolio {
    private List<Stock> stocks;
    private StockService stockService;
    private double marketValue;

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    public double getMarketValue() {
        double result = 0;

        for (Stock stock : stocks) {
            result += stock.getQuantity() * stockService.getPrice(stock);
        }

        return result;
    }
}
