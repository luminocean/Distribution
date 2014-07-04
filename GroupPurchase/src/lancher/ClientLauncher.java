package lancher;

import java.rmi.Naming;
import java.rmi.RemoteException;

import assignment3.GroupPurchaseWeb;
import rmi.GroupPurchaseService;
import rmitest.Server;

/**
 * 客户端启动器
 * @author luMinO
 *
 */
public class ClientLauncher {

	public static void main(String[] args) throws Exception {
		GroupPurchaseService service = (GroupPurchaseService) Naming.lookup("rmi://:1099/sss");
		
		service.listGroupPurchase();
	}

}
