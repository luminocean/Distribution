package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

import assignment3.GroupPurchaseItem;
import assignment3.GroupPurchaseManagementSystem;

/**
 * RMI远程接口的实现
 * @author luMinO
 *
 */
public class RemoteGPMSImpl extends UnicastRemoteObject implements RemoteGPMSService{
	private GroupPurchaseManagementSystem core;
	
	public RemoteGPMSImpl(GroupPurchaseManagementSystem core) throws RemoteException{
		this.core = core;
	}

	@Override
	public List<GPISerilized> listGroupPurchase() throws RemoteException{
		List<GroupPurchaseItem> items =  core.listGroupPurchase();
		
		List<GPISerilized> returnList = GPISerilized.serilizeInList(items);
		return returnList;
	}

	@Override
	public boolean submitPurchase(String itemId, String bankAccount,
			String password, String phone) throws RemoteException{
		return core.submitPurchase(itemId, bankAccount, password, phone);
	}

}
