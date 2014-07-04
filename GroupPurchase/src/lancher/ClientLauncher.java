package lancher;

import java.rmi.Naming;
import java.rmi.RemoteException;

import clientSupport.GPMSClientImpl;
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
		//获取RMI接口，用这个RMI接口生成本地的GPMS实现
		RemoteGPMSService remoteService = (RemoteGPMSService) Naming.lookup("rmi://:1099/gpms");
		GroupPurchaseManagementSystem gpms = new GPMSClientImpl(remoteService);
		
		GroupPurchaseWeb client = new GroupPurchaseWeb();
		
		//launch方法只接受一个gpms接口，所以没办法只能这么写
		client.launch(gpms);
	}

}
