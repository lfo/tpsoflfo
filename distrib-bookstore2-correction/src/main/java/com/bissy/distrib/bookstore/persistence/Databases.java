package com.bissy.distrib.bookstore.persistence;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bissy.distrib.bookstore.Amount;
import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookFactory;
import com.bissy.distrib.bookstore.CurrencyEnum;

public class Databases {

    public static Map<String, Book> MERIGNAC_BOOK_DATABASE = new HashMap<String, Book>();
    public static Map<String, Amount> MERIGNAC_PRICE_DATABASE = new HashMap<String, Amount>();
    public static Map<String, Book> LONDON_BOOK_DATABASE = new HashMap<String, Book>();
    public static Map<String, Amount> LONDON_PRICE_DATABASE = new HashMap<String, Amount>();
    public static Map<String, Book> NEW_YORK_BOOK_DATABASE = new HashMap<String, Book>();
    public static Map<String, Amount> NEW_YORK_PRICE_DATABASE = new HashMap<String, Amount>();

    static {
        List<Book> books = BookFactory.createBooks();
        MERIGNAC_BOOK_DATABASE.put(books.get(2).getTitle(), books.get(2));
        MERIGNAC_PRICE_DATABASE.put(books.get(2).getIsbn(), new Amount(new BigDecimal(42), CurrencyEnum.EURO));

        NEW_YORK_BOOK_DATABASE.put(books.get(0).getTitle(), books.get(0));
        NEW_YORK_PRICE_DATABASE.put(books.get(0).getIsbn(), new Amount(new BigDecimal(32), CurrencyEnum.US_DOLLAR));

        NEW_YORK_BOOK_DATABASE.put(books.get(1).getTitle(), books.get(1));
        NEW_YORK_PRICE_DATABASE.put(books.get(1).getIsbn(), new Amount(new BigDecimal(56), CurrencyEnum.US_DOLLAR));

        LONDON_BOOK_DATABASE.put(books.get(3).getTitle(), books.get(3));
        LONDON_PRICE_DATABASE.put(books.get(3).getIsbn(), new Amount(new BigDecimal(45), CurrencyEnum.POUND_STERLING));
    }
}
