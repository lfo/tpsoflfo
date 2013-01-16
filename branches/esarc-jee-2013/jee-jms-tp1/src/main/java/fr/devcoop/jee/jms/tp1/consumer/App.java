package fr.devcoop.jee.jms.tp1.consumer;

import fr.devcoop.jee.jms.tp1.Constants;
import javax.jms.JMSException;
import org.apache.activemq.ActiveMQConnectionFactory;

public class App {

    public static void main(String[] args) throws JMSException {
        Consumer consumer = new Consumer(new ActiveMQConnectionFactory(Constants.BROKER_URL), Constants.QUEUE_NAME);
        consumer.start();
    }

   
}