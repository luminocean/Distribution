package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import assignment3.GroupPurchaseItem;

public interface GroupPurchaseService extends Remote{
	List<GPISerilized> listGroupPurchase() throws RemoteException;
	boolean submitPurchase(String itemId, String bankAccount, String password, String phone) throws RemoteException;
}
