package message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MessageHandler implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		try {
			System.out.println("Get:"+ ((TextMessage) msg).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}