package lancher;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.GroupPurchaseImpl;
import rmi.GroupPurchaseService;
import assignment3.BankSystem;
import assignment3.GroupPurchaseManagementSystem;
import assignment3.GroupPurchaseManagementSystemFactory;
import assignment3.GroupPurchaseWeb;
import assignment3.ShortMessageSender;
import util.SystemLinker;

/**
 * 服务器端启动器
 * @author luMinO
 *
 */
public class SystemLauncher {
	private SystemLinker linker = new SystemLinker();
	
	private GroupPurchaseManagementSystem gpm;

	public static void main(String[] args) {
		new SystemLauncher().launch();
	}

	private void launch() {
		//获取管理系统必要的外部系统
		BankSystem bank = linker.getBankSystem();
		ShortMessageSender messageSystem = linker.getMessageSystem();
		
		//创建管理系统
		gpm = GroupPurchaseManagementSystemFactory.createGroupPurchaseManagementSystem(messageSystem, bank);
		
		//向团购系统里面添加商品
		gpm.publishGroupPurchaseItem("_seller_a_s3cret_k3y", "靴子", "捡来的", 20.55, 10);
		
		setUpRMI(gpm);
		
	
		//模拟用户端操作
		//clientSimulation(gpm);
	}

	
	
	private void setUpRMI(GroupPurchaseManagementSystem core) {
		try {
			GroupPurchaseService service = new GroupPurchaseImpl(core);
			
			LocateRegistry.createRegistry(1099);
			
			Naming.rebind("rmi://:1099/sss", service);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void clientSimulation(GroupPurchaseManagementSystem gpm) {
		GroupPurchaseWeb client = new GroupPurchaseWeb();
		client.launch(gpm);
	}

}
