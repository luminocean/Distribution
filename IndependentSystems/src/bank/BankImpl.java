package bank;

import java.util.List;

import javax.jws.WebService;

import util.Logger;
import util.SideType;

@WebService(endpointInterface = "bank.BankPort")
public class BankImpl implements BankPort{

	@Override
	public boolean transfer(String account, String password, String target,
			double amount) {
		Logger.log(SideType.银行服务器, "模拟转账！", this);
		
		return true;
	}

	@Override
	public List<Record> listHistory(String account, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
