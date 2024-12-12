import java.util.ArrayList;
import java.util.Date;

class CompanyShares {
    String stockSymbol;
    int numShares;
    Date transactionDate;

    public CompanyShares(String stockSymbol, int numShares, Date transactionDate) {
        this.stockSymbol = stockSymbol;
        this.numShares = numShares;
        this.transactionDate = transactionDate;
    }
}

class StockAccount {
    private ArrayList<CompanyShares> sharesList = new ArrayList<>();

    public void buyStock(String stockSymbol, int numShares) {
        Date transactionDate = new Date();
        CompanyShares shares = new CompanyShares(stockSymbol, numShares, transactionDate);
        sharesList.add(shares);
        System.out.println("Bought " + numShares + " shares of " + stockSymbol + " on " + transactionDate);
    }

    public void sellStock(String stockSymbol, int numShares) {
        for (CompanyShares shares : sharesList) {
            if (shares.stockSymbol.equals(stockSymbol) && shares.numShares >= numShares) {
                shares.numShares -= numShares;
                Date transactionDate = new Date();
                System.out.println("Sold " + numShares + " shares of " + stockSymbol + " on " + transactionDate);
                return;
            }
        }
        System.out.println("Stock not found or insufficient shares");
    }
}

public class StockAccountTest {
    public static void main(String[] args) {
        StockAccount account = new StockAccount();

        account.buyStock("AAPL", 100);
        account.sellStock("AAPL", 50);
        account.sellStock("AAPL", 60);  // Insufficient shares
    }
}
