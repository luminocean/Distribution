package logic.server;

import util.Logger;
import util.SideType;
import ws.bank.BankImplService;
import ws.bank.BankPort;
import assignment3.BankSystem;
import assignment3.ShortMessageSender;
import assignment3.ShortMessageSenderFactory;

/**
 * 用来建立系统和外部系统的连接
 * @author luMinO
 *
 */
public class SystemLinker {
	private ShortMessageSender sender;
	
	/**
	 * 获取消息系统的远程代理
	 * @return
	 */
	public ShortMessageSender getMessageSystem(){
		if( sender == null ){
			try{
				sender = new MessageProxy();
			}catch(Exception e){
				Logger.log(SideType.团购服务器, "连接消息服务器出错！（是否没有启动JBoss或者没有使用 -b 参数绑定正确的IP地址？）将在本地建立消息服务！", this);
				sender = ShortMessageSenderFactory.createShortMessageSender();
			}
		}
		
		return sender;
	}
	
	/**
	 * 获取银行系统的远程代理
	 * @return
	 */
	public BankSystem getBankSystem(){
		BankPort bankPort = new BankImplService().getBankImplPort();
		
		BankSystem bank = new BankProxy(bankPort);
		return bank;
	}
}
