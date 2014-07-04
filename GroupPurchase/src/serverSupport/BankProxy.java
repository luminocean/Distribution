package serverSupport;

import bankService.BankPort;
import util.Logger;
import util.SideType;
import assignment3.BankSystem;

public class BankProxy implements BankSystem{
	private BankPort bankPort;

	public BankProxy(BankPort bankPort) {
		this.bankPort = bankPort;
	}

	@Override
	public boolean transfer(String account, String password, String target, double amount) {
		Logger.log(SideType.团购服务器, "请求转账！", this);
		
		boolean result = bankPort.transfer(account, password, target, amount);
		
		return result;
	}

}
