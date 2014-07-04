package logic.server;

import jms.MessageSender;
import assignment3.ShortMessageSender;
import assignment3.ShortMessageSenderFactory;

public class MessageProxy implements ShortMessageSender{
	private MessageSender sender;
	
	public MessageProxy() throws Exception{
		sender = new MessageSender();
	}

	@Override
	public boolean sendMessage(String mobile, String content) {
		boolean result = sender.send(mobile, content);
		
		return result;
	}

}
