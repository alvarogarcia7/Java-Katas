package katas.potter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BasketSetup {

    private List<BookSet> bookSets;

    public BasketSetup() {
        bookSets = new ArrayList<BookSet>();
    }


    public static BasketSetup createBy(BookOrder bookOrder, int bookSetSize) {
        BasketSetup basketSetup = new BasketSetup();

        BookOrder newBookOrder = new BookOrder(bookOrder);
        while (basketSetup.isThereBooksIn(newBookOrder)) {
            BookSet bookSet = BookSet.createBy(newBookOrder, basketSetup.bookSetSize(bookSetSize, newBookOrder));
            basketSetup.add(bookSet);
            newBookOrder.removeBooksBy(bookSet);
        }
        return basketSetup;
    }


    private int bookSetSize(int bookSetSize, BookOrder bookOrder) {
        if (bookOrder.booksSize() >= bookSetSize) {
            return bookSetSize;
        } else {
            return bookOrder.booksSize();
        }
    }

    private boolean isThereBooksIn(BookOrder bookOrder) {
        return bookOrder.booksSize() > 0;
    }


    public void add(BookSet bookSet) {
        bookSets.add(bookSet);
    }

    public List<BookSet> getBookSets() {
        return bookSets;
    }

    public int size() {
        return bookSets.size();
    }

    public BigDecimal price() {
        BigDecimal price = new BigDecimal("0");
        for (BookSet bookSet : bookSets) {
            price = price.add(bookSet.price());
        }
        return price;
    }

}