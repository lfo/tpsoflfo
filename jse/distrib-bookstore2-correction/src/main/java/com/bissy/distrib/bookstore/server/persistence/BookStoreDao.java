package com.bissy.distrib.bookstore.server.persistence;

import com.bissy.distrib.bookstore.Amount;
import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookFactory;
import com.bissy.distrib.bookstore.CurrencyEnum;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Data Acces Object du magazin en ligne.
 */
public class BookStoreDao {

    private static Map<String, Book> BOOK_DATABASE = new HashMap<String, Book>();
    private static Map<String, Amount> PRICE_DATABASE = new HashMap<String, Amount>();

    static {
        Collection<Book> books = BookFactory.createBooks();
        for (Book book : books) {
            BOOK_DATABASE.put(book.getTitle(), book);
            PRICE_DATABASE.put(book.getTitle(), getRandomPrice());
        }

    }

    public Book findBook(String title) throws Exception {
        return BOOK_DATABASE.get(title);
    }

    public Collection<Book> findAllBook() throws Exception {
        return BOOK_DATABASE.values();
    }

    public Amount findPrice(Book book) {
        return PRICE_DATABASE.get(book.getTitle());
    }

    public void remove(Book book) {
        BOOK_DATABASE.remove(book.getTitle());
        PRICE_DATABASE.remove(book.getTitle());
    }

    private static Amount getRandomPrice() {
        MathContext context = new MathContext(2);
        BigDecimal bigDecimal = new BigDecimal(Math.random() * 100, context);
        return new Amount(bigDecimal, CurrencyEnum.EURO);
    }
}
