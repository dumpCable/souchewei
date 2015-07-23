package souchewei.owner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import souchewei.owner.dao.ParkingPlaceOwnerDaoImpl;
import souchewei.owner.model.ParkingPlaceOwner;

@Service
@Transactional
public class ParkingPlaceOwnerService {
	
	@Autowired
	private ParkingPlaceOwnerDaoImpl ownerDao;
	
	/**
	 * 根据openId查找
	 * @param openId
	 * @return
	 */
	public ParkingPlaceOwner findByOpenId(String openId){
		String queryString="FROM ParkingPlaceOwner where openId=?";
		
		List list=ownerDao.find(queryString, new Object[]{openId});
		if(list!=null&&list.size()!=0){
			return (ParkingPlaceOwner) list.get(0);
		}
		return null;
	}
}
