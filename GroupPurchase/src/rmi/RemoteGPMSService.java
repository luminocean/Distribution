package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import assignment3.GroupPurchaseItem;

/**
 * 供客户端调用的远程接口
 * @author luMinO
 *
 */
public interface RemoteGPMSService extends Remote{
	List<GPISerilized> listGroupPurchase() throws RemoteException;
	boolean submitPurchase(String itemId, String bankAccount, String password, String phone) throws RemoteException;
}
