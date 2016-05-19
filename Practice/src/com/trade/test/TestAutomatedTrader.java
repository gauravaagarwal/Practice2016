package com.trade.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import junit.framework.TestCase;

import com.trade.businessservices.AutomatedTrader;
import com.trade.queue.ProductPriceQueue;
import com.trade.type.Price;
import com.trade.type.Trade;

public class TestAutomatedTrader extends TestCase {

    AutomatedTrader automatedTrader = null;

    public void atestTrade() {
        List<Price> prices = new ArrayList<Price>();
        prices.add(new Price("AA", new BigDecimal(11.12)));
        prices.add(new Price("AA", new BigDecimal(11.12)));
        prices.add(new Price("AA", new BigDecimal(11.12)));
        prices.add(new Price("BB", new BigDecimal(11.12)));
        prices.add(new Price("CC", new BigDecimal(11.12)));
        Price price = new Price("AA", new BigDecimal(12.12));
        prices.add(price);
        Trade trade = automatedTrader.receivePrices(prices);
        assertNotNull(trade);
        assertEquals(price.getPrice(), trade.getProductPrice().getPrice());
        System.out.println(trade.toString());
        //System.out.println(automatedTrader.toString());
    }

    public void atestTradeNull() {
        List<Price> prices = new ArrayList<Price>();
        prices.add(new Price("AA", new BigDecimal(11.12)));
        prices.add(new Price("BB", new BigDecimal(11.12)));
        prices.add(new Price("DD", new BigDecimal(13.12)));
        prices.add(new Price("AA", new BigDecimal(11.12)));
        Price price = new Price("BB", new BigDecimal(11.12));
        prices.add(price);
        Trade trade = automatedTrader.receivePrices(prices);
        assertNull(trade);
    }

    private class FirstThread extends Thread {
        public boolean success;
        public void run() {
            try {
                atestTrade();
                success=true;
            } finally {
            }
        }
    }

    private class SecondThread extends Thread {
        public boolean success;
        public void run() {
            try {
                atestTradeNull();
                success=true;
            } finally {
            }
        }
    }

    final static int multiplier = 100;


    public void testMutiThreadTradeUsingExecutor() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List threads=new ArrayList();
        for (int i = 0; i < multiplier; i++) {
            Runnable firstThread = new FirstThread();
            executor.execute(firstThread);
            threads.add(firstThread);
            Runnable secondThread = new SecondThread();
            executor.execute(secondThread);
            threads.add(secondThread);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        for (Object thread:threads) {
            boolean status=false;
            if (thread instanceof FirstThread) {
                status=((FirstThread)thread).success;
                
            }else if (thread instanceof SecondThread) {
                status=((SecondThread)thread).success;
                
            }
            assertTrue(status);
        }
        
    }

    public void testSingleThreadTrade() {
        for (int i = 0; i < 1 * multiplier; i++) {
            atestTrade();
            atestTradeNull();
        }
    }

    public void setUp() {
        automatedTrader = new AutomatedTrader();
        String[] productNames = { "AA", "BB", "CC", "DD" };
        //automatedTrader.init(productNames, ConcurrentProductPriceQueue.class);
        automatedTrader.init(productNames,ProductPriceQueue.class); // Not working in multithreaded test
    }
}
