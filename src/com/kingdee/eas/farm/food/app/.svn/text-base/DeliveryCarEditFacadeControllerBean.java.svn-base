package com.kingdee.eas.farm.food.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.food.DeliveryCarFactory;
import com.kingdee.eas.farm.food.DeliveryCarInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

import java.lang.String;

public class DeliveryCarEditFacadeControllerBean extends AbstractDeliveryCarEditFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.food.app.DeliveryCarEditFacadeControllerBean");

    /**
     * 根据车牌号获得 送货车辆信息
     */
	@Override
	protected DeliveryCarInfo _getDeliveryCarDetails(Context ctx,
			String carNumber) throws BOSException {
		
		DeliveryCarInfo carInfo = null;
		String sql = "select fid,FNumber,CFCarType,CFDriverName,CFDriverTel from CT_FM_DeliveryCar where fnumber=?";
		Object[] args ={StringUtils.trim(carNumber)};
		IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
		try{
			if(rs.next()){
				carInfo = new DeliveryCarInfo();
				String fid = rs.getString("fid");
				String FNumber = rs.getString("FNumber");
				String CFCarType = rs.getString("CFCarType");
				String CFDriverName = rs.getString("CFDriverName");
				String CFDriverTel = rs.getString("CFDriverTel");
				
				carInfo.setId(BOSUuid.read(fid));
				carInfo.setNumber(FNumber);
				carInfo.setCarType(CFCarType);
				carInfo.setDriverName(CFDriverName);
				carInfo.setDriverTel(CFDriverTel);
			}
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		return  carInfo;
		
	}

	@Override
	protected DeliveryCarInfo _getDeliveryCarDetailsByPersonName(Context ctx,
			String personName) throws BOSException {

		DeliveryCarInfo carInfo = null;
		String sql = "select fid,FNumber,CFCarType,CFDriverName,CFDriverTel from CT_FM_DeliveryCar where CFDriverName=?";
		Object[] args ={StringUtils.trim(personName)};
		IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
		try{
			if(rs.next()){
				carInfo = new DeliveryCarInfo();
				String fid = rs.getString("fid");
				String FNumber = rs.getString("FNumber");
				String CFCarType = rs.getString("CFCarType");
				String CFDriverName = rs.getString("CFDriverName");
				String CFDriverTel = rs.getString("CFDriverTel");
				
				carInfo.setId(BOSUuid.read(fid));
				carInfo.setNumber(FNumber);
				carInfo.setCarType(CFCarType);
				carInfo.setDriverName(CFDriverName);
				carInfo.setDriverTel(CFDriverTel);
			}
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		return  carInfo;
	}

	/**
	 * 保存或新增送货车辆
	 */
	@Override
	protected void _saveOrUpdateCarInfo(Context ctx, DeliveryCarInfo car)
			throws BOSException {
		try{
//			DeliveryCarInfo carInfo  = new ;
			if(car != null && car.getNumber() != null && StringUtils.isNotBlank(car.getNumber())){
				try{
					String sql = "select fid from CT_FM_DeliveryCar where fnumber=?";
					Object[] args ={StringUtils.trim(car.getNumber())};
					IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
					
					if(rs.next()){
						String fid = rs.getString("fid");
						car.setId(BOSUuid.read(fid));
					}
//					carInfo = DeliveryCarFactory.getLocalInstance(ctx).getDeliveryCarInfo("where number = '" + StringUtils.trim(car.getNumber())+ "'");
				}catch(SQLException easb){
					easb.printStackTrace();
				}
			}
			car.setNumber(StringUtils.trim(car.getNumber()));
//			car.setCarType(car.getCarType());
//			car.setDriverName(car.getDriverName());
//			car.setDriverTel(car.getDriverTel());
			
			DeliveryCarFactory.getLocalInstance(ctx).save(car);
			
			return;
		}catch(EASBizException bize){
			bize.printStackTrace();
			return;
//			throw new BOSException(bize);
		}
		
	}
    
}