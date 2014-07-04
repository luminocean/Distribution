package serverSupport;

import util.Logger;
import util.SideType;
import assignment3.BankSystem;

public class BankImpl implements BankSystem{

	@Override
	public boolean transfer(String arg0, String arg1, String arg2, double arg3) {
		Logger.log(SideType.团购服务器, "模拟转账！", this);
		
		return true;
	}

}
