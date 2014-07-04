package client;

import java.rmi.RemoteException;
import java.util.List;

import rmi.GPISerilized;
import rmi.RemoteGPMSService;
import assignment3.GroupPurchaseItem;
import assignment3.GroupPurchaseManagementSystem;

/**
 * 客户端使用的GroupPurchaseManagementSystem实现，内部通过RMI调用服务器端实际的实现
 * @author luMinO
 *
 */
public class GPMSClientImpl implements GroupPurchaseManagementSystem{
	private RemoteGPMSService service;
	
	public GPMSClientImpl(RemoteGPMSService remoteService){
		this.service = remoteService;
	}

	@Override
	public boolean confirmPurchase(String arg0, String arg1) {
		return false;
	}

	@Override
	public List<GroupPurchaseItem> listGroupPurchase(){
		try {
			List<GPISerilized> serilizedList = service.listGroupPurchase();
			
			return GPISerilized.deserilizeInList(serilizedList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean publishGroupPurchaseItem(String arg0, String arg1,
			String arg2, double arg3, int arg4) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean submitPurchase(String arg0, String arg1, String arg2,
			String arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
