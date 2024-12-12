import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    String name;
    int numShares;
    double pricePerShare;

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", numShares=" + numShares +
                ", pricePerShare=" + pricePerShare +
                '}';
    }

    public Stock(String name, int numShares, double pricePerShare) {
        this.name = name;
        this.numShares = numShares;
        this.pricePerShare = pricePerShare;
    }

    public double totalValue() {
        return numShares * pricePerShare;
    }


}

class StockPortfolio {
    private ArrayList<Stock> stocks = new ArrayList<>();

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double totalPortfolioValue() {
        double total = 0;
        for (Stock stock : stocks) {
            total += stock.totalValue();
        }
        return total;
    }


    public void printReport() {
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
        System.out.println("Total Portfolio Value: $" + totalPortfolioValue());
    }
}

public class StockAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPortfolio portfolio = new StockPortfolio();

        System.out.print("Enter number of stocks: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter stock name: ");
            String name = scanner.nextLine();

            System.out.print("Enter number of shares: ");
            int numShares = scanner.nextInt();

            System.out.print("Enter price per share: ");
            double pricePerShare = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            Stock stock = new Stock(name, numShares, pricePerShare);
            portfolio.addStock(stock);
        }

        portfolio.printReport();
        scanner.close();
    }
}
