package fr.devcoop.jee.jms.tp1.consumer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author lforet
 */
public class Consumer implements MessageListener {

    private ConnectionFactory factory;
    private Connection connection;
    private Session session;
    private MessageConsumer consumer;
    private String queueName;

    public Consumer(ConnectionFactory factory, String queueName) throws JMSException {
        this.factory = factory;
        this.queueName = queueName;
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    public void onMessage(Message message) {

        if (message instanceof TextMessage) {
            try {
                TextMessage txtMessage = (TextMessage) message;
                System.out.println("Message received: " + txtMessage.getText());
            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            System.out.println("Invalid message received.");
        }

    }

    public void start() throws JMSException {
        Destination destination = session.createQueue(queueName);
        consumer = session.createConsumer(destination);
        consumer.setMessageListener(this);
    }
}
