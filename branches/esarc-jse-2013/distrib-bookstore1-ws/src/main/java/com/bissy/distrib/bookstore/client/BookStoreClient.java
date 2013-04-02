package com.bissy.distrib.bookstore.client;

import com.bissy.distrib.bookstore.Book;
import com.bissy.distrib.bookstore.BookStoreService;
import java.util.Collection;
import javax.xml.namespace.QName;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 *
 * @author lforet
 */
public class BookStoreClient implements BookStoreService {

    private BookStoreService bsWS;

    public BookStoreClient() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.getInInterceptors().add(new LoggingInInterceptor());
        factory.getOutInterceptors().add(new LoggingOutInterceptor());
        factory.setServiceClass(BookStoreService.class);
        factory.setAddress("http://localhost:9000/bookStore");
        bsWS = (BookStoreService) factory.create();
    }

    public Collection<Book> findAllBooks() throws Exception {
        return bsWS.findAllBooks();
    }

    public Collection<Book> findBooks(String title) throws Exception {
        return bsWS.findBooks(title);
    }
}
