package com.bootcamp.ektha.rewardsprogram.service;

import java.util.ArrayList;

import com.bootcamp.ektha.rewardsprogram.dao.StoreDAO;
import com.bootcamp.ektha.rewardsprogram.entity.Store;

public class StoreServicesImpl {
	
	public ArrayList<Store> getStoreListByState(String stateId){
		ArrayList<Store> storeList = new ArrayList<>();
		
		StoreDAO storeDao = new StoreDAO();
		
		storeList = storeDao.getStoreList(stateId);
		System.out.println(storeList);
		return storeList;
		
	}
}
