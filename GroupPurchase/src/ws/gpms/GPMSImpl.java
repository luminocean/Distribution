package ws.gpms;

import javax.jws.WebService;

import assignment3.GroupPurchaseManagementSystem;
import util.Logger;
import util.SideType;

@WebService(endpointInterface = "ws.gpms.GPMSPort")
public class GPMSImpl implements GPMSPort{
	private GroupPurchaseManagementSystem gpm;

	@Override
	public boolean confirmPurchase(String sellerSecretKey, String confirm) {
		Logger.log(SideType.团购服务器, "模拟确认购买！", this);
		
		return true;
	}

	@Override
	public boolean publishGroupPurchaseItem(String sellerSecretKey,
			String productName, String introduction, double price, int limit) {
		Logger.log(SideType.团购服务器, "模拟发布新团购！", this);
		
		if( gpm != null ){
			boolean result = gpm.publishGroupPurchaseItem(sellerSecretKey, productName, introduction, price, limit);
			
			return result;
		}else{
			Logger.log(SideType.团购服务器, "GPMS为空！", this);
			
			return false;
		}
		
	}

	public void setGPMS(GroupPurchaseManagementSystem gpm) {
		this.gpm = gpm;
	}

}
