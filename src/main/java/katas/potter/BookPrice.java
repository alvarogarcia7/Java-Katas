package katas.potter;

import java.math.BigDecimal;

/**
 * Created by jllado on 8/12/14.
 */
public class BookPrice {
    public static final BigDecimal DEFAULT_PRICE_VALUE = new BigDecimal("8");

    private BigDecimal value;

    public BookPrice() {
        value = new BigDecimal("0");
    }

    public BookPrice(BigDecimal value) {
        this.value = value;
    }

    public BookPrice(String value) {
        this.value = new BigDecimal(value);
    }

    public void add(BookPrice price) {
        value = value.add(price.value);
    }

    public boolean isBestThan(BookPrice price) {
        return price.isZero() || value.compareTo(price.value) < 0;
    }

    private boolean isZero() {
        return value.equals(BigDecimal.ZERO);
    }

    public static BookPrice getDefaultPrice() {
        return new BookPrice(DEFAULT_PRICE_VALUE);
    }

    public void multiplyBy(int value) {
        this.value = this.value.multiply(new BigDecimal(value));
    }

    public void multiplyBy(BigDecimal value) {
        this.value = this.value.multiply(value);
    }

    public void apply(BookDiscount discount) {
        multiplyBy(discount.value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookPrice bookPrice = (BookPrice) o;

        if (value != null ? value.floatValue() != bookPrice.value.floatValue() : bookPrice.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
