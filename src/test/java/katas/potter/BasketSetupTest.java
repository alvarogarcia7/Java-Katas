package katas.potter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BasketSetupTest {

    private BasketSetup basketSetup;
    private BookOrder bookOrder;

    @Before
    public void setUp() {
        bookOrder = new BookOrder();
        bookOrder.add(2, new Book(Book.BOOK1));
        bookOrder.add(2, new Book(Book.BOOK3));
        bookOrder.add(2, new Book(Book.BOOK2));
        bookOrder.add(1, new Book(Book.BOOK4));
        bookOrder.add(1, new Book(Book.BOOK5));
    }

    @Test
    public void get_basketSetup_with_bookSetSize_one() {
        basketSetup = BasketSetup.createBy(bookOrder, 1);

        assertThat(basketSetup.getBookSets().size(), is(8));
    }

    @Test
    public void get_basketSetup_with_bookSetSize_two() {
        basketSetup = BasketSetup.createBy(bookOrder, 2);

        assertThat(basketSetup.getBookSets().size(), is(4));
    }

    @Test
    public void get_basketSetup_with_bookSetSize_three() {
        basketSetup = BasketSetup.createBy(bookOrder, 3);

        assertThat(basketSetup.getBookSets().size(), is(3));
    }

    @Test
    public void get_basketSetup_with_bookSetSize_four() {
        basketSetup = BasketSetup.createBy(bookOrder, 4);

        assertThat(basketSetup.getBookSets().size(), is(2));
    }

    @Test
    public void get_basketSetup_with_bookSetSize_five() {
        basketSetup = BasketSetup.createBy(bookOrder, 5);

        assertThat(basketSetup.getBookSets().size(), is(2));
    }
}