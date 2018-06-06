package br.com.fiap.roupas.queue;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.fiap.roupas.model.Pedido;

public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String url = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;
	
	private static String subject = "teste";
	
	public void sendMessage(Pedido pedido) throws JMSException, JsonGenerationException, JsonMappingException, IOException {
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue(subject);
		
		MessageConsumer consumer =  session.createConsumer(destination);
		
		Message message = consumer.receive();
		
		if(message instanceof TextMessage ) {
			TextMessage textMessage =  (TextMessage) message;
			System.out.println("Mensagem recebida: " + textMessage.getText());
		}
		
		connection.close();		
	}	

	public static void main(String[] args) {
	
	}

}
