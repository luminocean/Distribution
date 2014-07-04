package jms;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Sender {

	public static void main(String[] args) {
		new Sender().run();
	}

	private void run() {
		try{
			Context ctx = getInitialContext();
			
			ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
			Destination dest = (Destination) ctx.lookup("myqueue");
			
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer sender = session.createProducer(dest);
			
			sender.setDeliveryMode(DeliveryMode.PERSISTENT);
			sender.setTimeToLive(1000);
			
			TextMessage message = session.createTextMessage();
			message.setStringProperty("Contype", "txt");
			message.setText("Helloooo~~");
			
			sender.send(message);
			session.close();
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	
	private Context getInitialContext() {
		Context ctx = null;

		try {
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jnp.interfaces.NamingContextFactory");
			props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			
			ctx = new InitialContext(props);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return ctx;
	}

}
