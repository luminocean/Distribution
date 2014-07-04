package logic.server;

import jms.MessageSender;
import assignment3.ShortMessageSender;

public class MessageProxy implements ShortMessageSender{
	private MessageSender sender = new MessageSender();

	@Override
	public boolean sendMessage(String mobile, String content) {
		boolean result = sender.send(mobile, content);
		
		return result;
	}

}
