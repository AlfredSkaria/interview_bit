import java.io.*;
import java.util.*;

class Stock{
    private int buy;
    private int sell;

    public int getBuyPrice(){
        return this.buy;
    }

    public void setBuyPrice(int buy){
        this.buy = buy;
    }

    public int getSellPrice(){
        return this.sell;
    }

    public int setSellPrice(int sell){
       return this.sell = sell;
    }
} 

public class StockMarket{
    public static void main(String args[]){
        List<Stock> stockPrices = new ArrayList<Stock>();
        List<Integer> stocks = new ArrayList<Integer>(Arrays.asList(100,180,260,310,40,535,695));
        //System.out.print(stocks.toString());
        int counter = 0;
        int len = stocks.size();
        for(int i = 0; i < len; i++){
            Stock stock = new Stock();
            if(len == 1){
                break;
            }

            while(i < len-1 && stocks.get(i+1) <= stocks.get(i)){
                //System.out.print("--" + i);
                i++;
            }
                
            
            if(i == len -1){
                break;
            }
            stock.setBuyPrice(i);
            
            i++;
            while(i < len && stocks.get(i) >= stocks.get(i-1)){
                //System.out.print("**" + i);
                i++;
            }
            i--;  
            stock.setSellPrice(i);
            stockPrices.add(stock);
            counter++;
        }

        if(counter == 0){
            System.out.println("Profit can't be achieved");
        }else{
            for(Stock s : stockPrices){
               System.out.println("Buy" + stocks.get(s.getBuyPrice()) + " Sell: " + stocks.get(s.getSellPrice())); 
            }
        }
    }
}