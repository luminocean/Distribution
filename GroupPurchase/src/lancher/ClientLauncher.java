package lancher;

import java.rmi.Naming;
import java.rmi.RemoteException;

import client.GPMSClientImpl;
import assignment3.GroupPurchaseManagementSystem;
import assignment3.GroupPurchaseWeb;
import rmi.RemoteGPMSService;

/**
 * 客户端启动器
 * @author luMinO
 *
 */
public class ClientLauncher {

	public static void main(String[] args) throws Exception {
		RemoteGPMSService remoteService = (RemoteGPMSService) Naming.lookup("rmi://:1099/gpms");
		
		GroupPurchaseManagementSystem gpms = new GPMSClientImpl(remoteService);
		
		GroupPurchaseWeb client = new GroupPurchaseWeb();
		
		client.launch(gpms);
	}

}
