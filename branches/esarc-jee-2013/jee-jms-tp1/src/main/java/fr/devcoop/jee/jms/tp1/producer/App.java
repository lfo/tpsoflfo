package fr.devcoop.jee.jms.tp1.producer;

import fr.devcoop.jee.jms.tp1.Constants;
import org.apache.activemq.ActiveMQConnectionFactory;

public class App {

    public static void main(String[] args) throws Exception {
        Producer producer = new Producer(new ActiveMQConnectionFactory(Constants.BROKER_URL), Constants.QUEUE_NAME);
        producer.run();
        producer.close();
    }
}