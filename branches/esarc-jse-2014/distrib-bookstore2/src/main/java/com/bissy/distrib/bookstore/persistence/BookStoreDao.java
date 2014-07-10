package com.bissy.distrib.bookstore.persistence;

import com.bissy.distrib.bookstore.Amount;
import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookFactory;
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
    private static Map<Book, Amount> PRICE_DATABASE = new HashMap<Book, Amount>();

    static {
        Collection<Book> books = BookFactory.createBooks();
        for (Book book : books) {
            BOOK_DATABASE.put(book.getTitle(), book);
            PRICE_DATABASE.put(book, getRandomPrice());
        }

    }

    public Book findBook(String title) throws Exception {
        return BOOK_DATABASE.get(title);
    }

    public Collection<Book> findAllBooks() throws Exception {
        return BOOK_DATABASE.values();
    }

    public Amount findPrice(Book book) {
        return PRICE_DATABASE.get(book);
    }

    public void remove(Book book) {
        BOOK_DATABASE.remove(book.getTitle());
        PRICE_DATABASE.remove(book);
    }

    private static Amount getRandomPrice() {
        MathContext context = new MathContext(2);
        BigDecimal bigDecimal = new BigDecimal(Math.random() * 100, context);
        return new Amount(bigDecimal, Amount.CurrencyEnum.EURO);
    }
}
