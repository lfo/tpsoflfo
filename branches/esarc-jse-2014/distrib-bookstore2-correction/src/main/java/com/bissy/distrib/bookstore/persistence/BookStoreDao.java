package com.bissy.distrib.bookstore.persistence;

import com.bissy.distrib.bookstore.Amount;
import com.bissy.distrib.bookstore.Book;
import java.util.Collection;
import java.util.Map;

/**
 * Data Access Object du magazin en ligne.
 */
public class BookStoreDao {

    private Map<String, Book> bookDatabaseMap;
    private Map<String, Amount> priceDatabaseMap;

    public BookStoreDao(Map<String, Book> bookDatabaseMap,
            Map<String, Amount> priceDatabaseMap) {
        super();
        this.bookDatabaseMap = bookDatabaseMap;
        this.priceDatabaseMap = priceDatabaseMap;
    }

    public Book findBook(String title) throws Exception {
        return bookDatabaseMap.get(title);
    }

    public Collection<Book> findAllBooks() throws Exception {
        return bookDatabaseMap.values();
    }

    public Amount findPrice(Book book) throws Exception {
        return priceDatabaseMap.get(book.getIsbn());
    }

    public void remove(Book book) throws Exception {
        bookDatabaseMap.remove(book.getTitle());
        priceDatabaseMap.remove(book.getTitle());
    }
//    private static Amount getRandomPrice() {
//        MathContext context = new MathContext(2);
//        BigDecimal bigDecimal = new BigDecimal(Math.random() * 100, context);
//        return new Amount(bigDecimal, Amount.CurrencyEnum.EURO);
//    }
}
