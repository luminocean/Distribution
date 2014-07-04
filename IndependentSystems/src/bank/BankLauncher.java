package bank;

import javax.xml.ws.Endpoint;

import util.Logger;
import util.SideType;

public class BankLauncher {

	public static void main(String[] args) {
		new BankLauncher().launch();
		
	}

	private void launch() {
		Endpoint.publish("http://localhost:8080/ws/bank", new BankImpl());
		
		Logger.log(SideType.银行服务器, "银行端Web Service启动", this);
	}
}
