package message;
import java.util.Properties;
import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class Receiver {

	public static void main(String[] args) {
		new Receiver().run();
	}

	private void run() {
		try{
			//创建初始化上下文
			Context ctx = getInitialContext();
			//连接工厂
			ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
			//消息目的地
			Destination dest = (Destination) ctx.lookup("shortmessage");
			
			//创建连接和会话
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//进入信息的接收
			MessageConsumer receiver = session.createConsumer(dest);
			
			//TextMessage message = (TextMessage) receiver.receive();
			
			//异步接收消息
			receiver.setMessageListener(new MessageHandler());
			
			//输出关闭提示，随时准备关闭
			System.out.println("Press ENTER to shutdown...");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
			
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

class MessageHandler implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		try {
			System.out.println("Get:"+ ((TextMessage) msg).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}
