package katas.potter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BookOrderTest {

    private BookOrder bookOrder;

    @Before
    public void setUp() {
        bookOrder = new BookOrder();
    }

    @Test
    public void calculate_price_one_book() {
        bookOrder.add(1, Book.BOOK1);

        assertThat(bookOrder.price(), is(new BookPrice("8")));
    }

    @Test
    public void calculate_price_two_same_books() {
        bookOrder.add(2, Book.BOOK1);

        assertThat(bookOrder.price(), is(new BookPrice("16")));
    }

    @Test
    public void calculate_price_two_different_books() {
        bookOrder.add(1, Book.BOOK1);
        bookOrder.add(1, Book.BOOK2);

        assertThat(bookOrder.price(), is(new BookPrice("15.2")));
    }

    @Test
    public void calculate_price_three_different_books() {
        bookOrder.add(1, Book.BOOK1);
        bookOrder.add(1, Book.BOOK2);
        bookOrder.add(1, Book.BOOK3);

        assertThat(bookOrder.price(), is(new BookPrice("21.6")));
    }

    @Test
    public void calculate_price_two_identical_and_one_different() {
        bookOrder.add(2, Book.BOOK1);
        bookOrder.add(1, Book.BOOK2);

        assertThat(bookOrder.price(), is(new BookPrice("23.2")));
    }

    @Test
    public void calculate_price_2_2_2_1_1() {
        bookOrder.add(2, Book.BOOK1);
        bookOrder.add(2, Book.BOOK2);
        bookOrder.add(2, Book.BOOK3);
        bookOrder.add(1, Book.BOOK4);
        bookOrder.add(1, Book.BOOK5);

        assertThat(bookOrder.price(), is(new BookPrice("51.2")));
    }

}
