package launcher;

import retail.ws.GPMSImplService;
import retail.ws.GPMSPort;

public class RetailTestDriver {

	public static void main(String[] args) {
		new RetailTestDriver().launch();
	}

	public void launch() {
		GPMSPort gpmsPort = new GPMSImplService().getGPMSImplPort();
		
		gpmsPort.publishGroupPurchaseItem("_seller_a_s3cret_k3y", "古代的老靴子", "抢来的", 200, 120);
	}

}
