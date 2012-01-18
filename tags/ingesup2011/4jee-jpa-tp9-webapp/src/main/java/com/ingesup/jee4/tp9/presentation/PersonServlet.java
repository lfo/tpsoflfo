package com.ingesup.jee4.tp9.presentation;

import com.ingesup.jee4.tp9.business.PersonEJBRemote;
import com.ingesup.jee4.tp9.persistence.Person;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author lfo
 */
@WebServlet("/person")
public class PersonServlet extends HttpServlet {

    @EJB PersonEJBRemote personEJB;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getOutputStream().println("<html><ul>");
        personEJB.create("Jacques", "Smith");
        List<Person> persons = personEJB.getAllPersons();
        for (Person person : persons) {
            resp.getOutputStream().println(String.format("<li>%s %s</li>", person.getFirstName(), person.getLastName()));
        }
        resp.getOutputStream().println("</ul></html>");        
        
    }
    

    
}
