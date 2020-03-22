package com.kingdee.eas.dep.client;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.farm.food.DeliveryCarEditFacadeFactory;
import com.kingdee.eas.farm.food.DeliveryCarInfo;
import com.kingdee.util.enums.DynamicEnum;

public class CarInfoEditDep {

	
	public void carNumberChange(UIParam param) throws BOSException{
		
//		Object selObj = param.getKDComboBox("combocarType").getSelectedItem();
//		 DynamicEnum seleEnum = (DynamicEnum)selObj;
		 String carNumber = param.getKDTextField("txtplateNumber").getText();
		 String driveName = param.getKDTextField("txtdriverName").getText();
		 DeliveryCarInfo carInfo = null;
		 if(StringUtils.isNotBlank(carNumber)){
	         carInfo = this.getDeliveryCarInfo(carNumber);
		 }else if(StringUtils.isNotBlank(driveName)){
			 carInfo = this.getDeliveryCarInfoByDriveName(driveName);
		 }
		 
         if(carInfo != null){
        	 String driverName = carInfo.getDriverName();
        	 String driverTel = carInfo.getDriverTel();
        	 if(StringUtils.isBlank(carNumber)){
        		 param.getKDTextField("txtplateNumber").setText(carInfo.getNumber());
        	 }
        	 if(StringUtils.isBlank(driveName)){
        		 param.getKDTextField("txtdriverName").setText(driverName);
        	 }
        	 
        	 param.getKDTextField("txtdriverTel").setText(driverTel);
        	 if(StringUtils.isNotBlank(carInfo.getCarType())){
	        	 DynamicEnum currEnum = DynamicEnum.getEnum("com.kingdee.eas.custom.CarType", carInfo.getCarType());
	        	 param.getKDComboBox("combocarType").setSelectedItem(currEnum);
        	 }


         }
//         else{
//        	 param.getKDTextField("txtdriverName").setText("");
//        	 param.getKDTextField("txtdriverTel").setText("");
//        	 param.getKDComboBox("combocarType").setSelectedItem(null);
//         }
	}
	
	
	
	
	/**
	 * 根据车牌号获得 车辆信息
	 * @param carNumber
	 * @return
	 * @throws BOSException
	 */
	public DeliveryCarInfo getDeliveryCarInfo(String carNumber) throws BOSException{
		return DeliveryCarEditFacadeFactory.getRemoteInstance().getDeliveryCarDetails(StringUtils.trim(carNumber));
		
	}
	
	/**
	 * 根据司机姓名获得 车辆信息
	 * @param carNumber
	 * @return
	 * @throws BOSException
	 */
	public DeliveryCarInfo getDeliveryCarInfoByDriveName(String driveName) throws BOSException{
		return DeliveryCarEditFacadeFactory.getRemoteInstance().getDeliveryCarDetailsByPersonName(StringUtils.trim(driveName));
	}
	/**
	 * 保存单据的车辆 信息
	 * @param carNumber
	 * @param carType
	 * @param driverName
	 * @param driverNumber
	 * @throws BOSException 
	 */
	public void saveDeliveryCarInfo(String carNumber, DynamicEnum  carType, String driverName, String driverTel) throws BOSException{
		DeliveryCarInfo newCar = new DeliveryCarInfo();
		newCar.setNumber(StringUtils.trim(carNumber));
		if(carType != null){
			newCar.setCarType(carType.getValue());
		}
		newCar.setDriverName(StringUtils.trim(driverName));
		newCar.setDriverTel(StringUtils.trim(driverTel));
		
		DeliveryCarEditFacadeFactory.getRemoteInstance().saveOrUpdateCarInfo(newCar);
	}
}
