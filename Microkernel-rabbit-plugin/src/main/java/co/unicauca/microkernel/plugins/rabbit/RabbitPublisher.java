/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.plugins.rabbit;

import co.unicauca.microkernel.common.interfaces.IPublisherPlugin;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahurtado
 */
public class RabbitPublisher implements IPublisherPlugin{

    @Override
    public void publish(String msg) {
        String QUEUE_NAME = "ProductstoDelivery";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try {
            com.rabbitmq.client.Connection connection = factory.newConnection();
            com.rabbitmq.client.Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + msg + "'");
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(RabbitPublisher.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
