package lancher;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.xml.ws.Endpoint;

import logic.server.SystemLinker;
import rmi.RemoteGPMSImpl;
import rmi.RemoteGPMSService;
import util.ConfigManager;
import util.Logger;
import util.SideType;
import ws.gpms.GPMSImpl;
import assignment3.BankSystem;
import assignment3.GroupPurchaseManagementSystem;
import assignment3.GroupPurchaseManagementSystemFactory;
import assignment3.GroupPurchaseWeb;
import assignment3.ShortMessageSender;

/**
 * 服务器端启动器
 * @author luMinO
 *
 */
public class ServerLauncher {
	private SystemLinker linker = new SystemLinker();
	
	private GroupPurchaseManagementSystem gpm;

	public static void main(String[] args) {
		new ServerLauncher().launch();
	}

	public void launch() {
		//获取管理系统必要的外部系统
		BankSystem bank = linker.getBankSystem();
		ShortMessageSender messageSystem = linker.getMessageSystem();
		
		//创建管理系统，放点东西进去
		gpm = GroupPurchaseManagementSystemFactory.createGroupPurchaseManagementSystem(messageSystem, bank);
		gpm.publishGroupPurchaseItem("_seller_a_s3cret_k3y", "长矛", "捡的", 200, 120);
		
		//设置RMI
		setUpRMI(gpm);
		
		GPMSImpl gpmsWS = new GPMSImpl();
		gpmsWS.setGPMS(gpm);
		
		//发布WSDL
		Endpoint.publish(ConfigManager.getValue("gpmswsdl"), gpmsWS);
		
		Logger.log(SideType.团购服务器, "团购服务器已启动", this);
	}

	
	/**
	 * 搭建RMI的服务，该服务调用本地的GPMS完成功能
	 * @param core GPMS核心系统
	 */
	private void setUpRMI(GroupPurchaseManagementSystem core) {
		try {
			RemoteGPMSService service = new RemoteGPMSImpl(core);
			
			try{
				String portStr = ConfigManager.getValue("rmiport");
				int port = Integer.parseInt(portStr);
				LocateRegistry.createRegistry(port);
				Naming.rebind(ConfigManager.getValue("rmi"), service);
			}catch(Exception e){
				Logger.log(SideType.团购服务器, "获取并使用rmi端口失败！", this);
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
