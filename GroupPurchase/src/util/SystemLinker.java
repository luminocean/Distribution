package util;

import assignment3.BankSystem;
import assignment3.ShortMessageSender;
import assignment3.ShortMessageSenderFactory;

/**
 * 用来建立系统和外部系统的连接
 * @author luMinO
 *
 */
public class SystemLinker {
	
	/**
	 * 获取消息系统的远程代理
	 * @return
	 */
	public ShortMessageSender getMessageSystem(){
		//直接new一个出来代替远程获取
		ShortMessageSender messageSender = ShortMessageSenderFactory.createShortMessageSender();
		return messageSender;
	}
	
	/**
	 * 获取银行系统的远程代理
	 * @return
	 */
	public BankSystem getBankSystem(){
		BankSystem bank = new BankImpl();
		return bank;
	}
}
