package bank;

import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import util.Logger;
import util.SideType;

@WebService(endpointInterface = "bank.BankPort")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT)
public class BankImpl implements BankPort{
	//实现本地的转账记录
	private List<Record> records = new LinkedList<Record>();

	@Override
	public boolean transfer(String account, String password, String target,
			double amount) {
		Logger.log(SideType.银行服务器, "模拟转账！To "+target+": $"+amount, this);
		
		records.add(new Record(account, target, amount));
		
		return true;
	}

	@Override
	public List<Record> listHistory(String account, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
