package com.bootcamp.ektha.rewardsprogram.form;

import com.bootcamp.ektha.rewardsprogram.service.StoreServicesImpl;

public class Demo {
	
	public static void main(String[] args) {
		StoreServicesImpl impl = new StoreServicesImpl();
		impl.getStoreListByState("SID00108");
	}
}
