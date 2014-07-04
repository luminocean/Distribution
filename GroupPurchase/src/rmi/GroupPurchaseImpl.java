package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

import assignment3.GroupPurchaseItem;
import assignment3.GroupPurchaseManagementSystem;

public class GroupPurchaseImpl extends UnicastRemoteObject implements GroupPurchaseService{
	private GroupPurchaseManagementSystem core;
	
	public GroupPurchaseImpl(GroupPurchaseManagementSystem core) throws RemoteException{
		this.core = core;
	}

	@Override
	public List<GPISerilized> listGroupPurchase() throws RemoteException{
		List<GroupPurchaseItem> items =  core.listGroupPurchase();
		
		List<GPISerilized> resultList = new LinkedList<GPISerilized>();
		for( GroupPurchaseItem item: items ){
			GPISerilized newItem = new GPISerilized(item);
			resultList.add(newItem);
		}
		
		return resultList;
	}

	@Override
	public boolean submitPurchase(String itemId, String bankAccount,
			String password, String phone) throws RemoteException{
		return core.submitPurchase(itemId, bankAccount, password, phone);
	}

}
