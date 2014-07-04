package rmi;

import java.io.Serializable;

import assignment3.GroupPurchaseItem;

public class GPISerilized extends GroupPurchaseItem implements Serializable{
	
	public GPISerilized(GroupPurchaseItem item){
		this.setId(item.getId());
		this.setIntroduction(item.getIntroduction());
		this.setLimit(item.getLimit());
		this.setPrice(item.getPrice());
		this.setProductName(item.getProductName());
		this.setSeller(item.getSeller());
	}

	public GroupPurchaseItem deserilize() {
		GroupPurchaseItem item = new GroupPurchaseItem();
		
		item.setId(this.getId());
		item.setIntroduction(this.getIntroduction());
		item.setLimit(this.getLimit());
		item.setPrice(this.getPrice());
		item.setProductName(this.getProductName());
		item.setSeller(this.getSeller());
		
		return item;
	}

}
