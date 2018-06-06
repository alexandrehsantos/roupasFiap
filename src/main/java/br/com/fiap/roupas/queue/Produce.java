package br.com.fiap.roupas.queue;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.roupas.model.Cliente;
import br.com.fiap.roupas.model.Empresa;
import br.com.fiap.roupas.model.Item;
import br.com.fiap.roupas.model.Pedido;

public class Produce implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String url = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;

	private static String subject = "teste";

	public static void main(String[] args) throws ParseException, JsonGenerationException, JsonMappingException, JMSException, IOException {
		
		Empresa empresafake = new Empresa();
		Cliente clientefake = new Cliente();
		Pedido pedidofake = new Pedido();
		Item item1 = new Item();
		Item item2 = new Item();
		Date date;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		date = (Date) ((DateFormat) format).parse("03/03/2018");

		Map<Item, Double> itens = new HashMap<Item, Double>();	

		clientefake.setCpf("999.999.999-99");
		clientefake.setNome("Zé Pelintram");

		empresafake.setCpnj("999.999.999/0001-99");
		empresafake.setNome("Bugigangas Ltda");
		empresafake.setEndereco("Rua do Zé Ruela");
		empresafake.setIncricaoEstadual("11.1111.111-99");
		empresafake.setInscricaoMunicipal("11.1111.111-99");

		item1.setDescricao("Celular Iphone");
		item1.setValor(new BigDecimal(800.00));

		item2.setDescricao("Camera Fotografica");
		item2.setValor(new BigDecimal(250.00));

		itens.put(item1, 2d);
		itens.put(item2, 4d);

		pedidofake.setCco(123456L);
		pedidofake.setCliente(clientefake);
		pedidofake.setProdutoList(itens);
		pedidofake.setEmpresa(empresafake);
		pedidofake.setDataPedido(date);
		pedidofake.setValorTotal(new BigDecimal(1050));
		
		Produce producer = new Produce();
		producer.produceMessage(pedidofake);

	}

	public void produceMessage(Pedido pedido)
			throws JMSException, JsonGenerationException, JsonMappingException, IOException {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue(subject);

		MessageProducer producer = session.createProducer(destination);

		TextMessage message = session.createTextMessage(convertToJson(pedido));

		producer.send(message);

		System.out.println("Mensagem recebida: " + message.getText());

		connection.close();
	}

	private String convertToJson(Pedido pedido) throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		// Object to JSON in file
		mapper.writeValue(new File("c:\\json\\pedido.json"), pedido);

		// Object to JSON in String
		String pedidoJson = mapper.writeValueAsString(pedido);

		return pedidoJson;
	}
}
