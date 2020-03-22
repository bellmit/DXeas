package com.kingdee.eas.spray.webservices;

import java.math.BigDecimal;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.master.cssp.CustomerCollection;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.MaterialCollection;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.spray.CustomerSprayInvCollection;
import com.kingdee.eas.spray.CustomerSprayInvEntryFactory;
import com.kingdee.eas.spray.CustomerSprayInvEntryInfo;
import com.kingdee.eas.spray.CustomerSprayInvFactory;
import com.kingdee.eas.spray.CustomerSprayInvInfo;
import com.kingdee.eas.spray.DeviceDataCollection;
import com.kingdee.eas.spray.DeviceDataFactory;
import com.kingdee.eas.spray.DeviceDataInfo;
import com.kingdee.eas.spray.SparyRecordEntryInfo;
import com.kingdee.eas.spray.SparyRecordFactory;
import com.kingdee.eas.spray.SparyRecordInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class WSSprayFacadeControllerBean extends AbstractWSSprayFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.spray.webservices.WSSprayFacadeControllerBean");

	/**
	 * 得到当前余量
	 */
	protected String _getNowBalance(Context ctx, String jsonStr) throws BOSException {
		JSONObject jo=JSONObject.fromObject(jsonStr);
		if(!jo.containsKey("customerNum")) {
			return "客户编码不能为空！";
		}
		if(!jo.containsKey("materialNum")) {
			return "物料编码不能为空！";
		}
		String customerNum=jo.getString("customerNum");
		String materialNum=jo.getString("materialNum");
		try{
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			ev=new EntityViewInfo();
			SelectorItemCollection slors=new SelectorItemCollection();
			slors.add(new SelectorItemInfo("*"));
			slors.add(new SelectorItemInfo("entrys.*"));
			slors.add(new SelectorItemInfo("entrys.material.*"));
			ev.setSelector(slors);
			filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("customer.number",customerNum,CompareType.EQUALS));
			//filter.getFilterItems().add(new FilterItemInfo("entrys.material.number",materialNum,CompareType.EQUALS));
			ev.setFilter(filter);
			CustomerSprayInvCollection csiCol=CustomerSprayInvFactory.getLocalInstance(ctx).getCustomerSprayInvCollection(ev);
			if(csiCol!=null&&csiCol.size()>0) {
				for(int index=0;index<csiCol.get(0).getEntrys().size();index++) {
					if(csiCol.get(0).getEntrys().get(index).getMaterial().getNumber().equals(materialNum)) {
						return csiCol.get(0).getEntrys().get(index).getInvQty().toString();
					}
				}
			}
		}catch(Exception e){
			logger.error(e);
			return e.getMessage();
		}
		return "0";
	}

	/**
	 * 上传使用记录
	 */
	protected String _uploadUseRecord(Context ctx, String jsonStr) throws BOSException {
		JSONObject jo=JSONObject.fromObject(jsonStr);
		if(!jo.containsKey("customerNum")) {
			return "客户编码不能为空！";
		}
		if(!jo.containsKey("materialNum")) {
			return "物料编码不能为空！";
		}
		String customerNum=jo.getString("customerNum");
		String materialNum=jo.getString("materialNum");
		String deviceNum=null;
		if(jo.containsKey("deviceNum")) {//设备编码
				jo.getString("deviceNum");
		}
		BigDecimal useQty=BigDecimal.ZERO;//使用数量
		BigDecimal useTime=BigDecimal.ZERO;//使用时间
		if(jo.containsKey("useQty")) {
			useQty=new BigDecimal(jo.getDouble("useQty"));
		}
		if(jo.containsKey("useTime")) {
			useQty=new BigDecimal(jo.getDouble("useTime"));
		}
		try{
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("number",customerNum,CompareType.EQUALS));
			ev.setFilter(filter);
			CustomerCollection cusCol=CustomerFactory.getLocalInstance(ctx).getCustomerCollection(ev);
			if(cusCol==null||cusCol.size()<=0) {
				return "没有该客户";
			}	
			ev=new EntityViewInfo();
			filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("number",materialNum,CompareType.EQUALS));
			ev.setFilter(filter);
			MaterialCollection mCol=MaterialFactory.getLocalInstance(ctx).getMaterialCollection(ev);
			if(mCol==null||mCol.size()<=0) {
				return "没有该物料";
			}
			String customerID=cusCol.get(0).getString("id");
			String materialID=mCol.get(0).getString("id");

			DeviceDataInfo deviceInfo=null;//设备信息
			if(StringUtils.isNotBlank(deviceNum)) {
				ev=new EntityViewInfo();
				filter=new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("number",deviceNum,CompareType.EQUALS));
				ev.setFilter(filter);
				DeviceDataCollection deviceCol = DeviceDataFactory.getLocalInstance(ctx).getDeviceDataCollection(ev);
				if(deviceCol==null||deviceCol.size()<=0) {
					deviceInfo = deviceCol.get(0);
				}
			}
			CustomerInfo cusInfo=CustomerFactory.getLocalInstance(ctx).getCustomerInfo(new ObjectUuidPK(customerID));
			MaterialInfo mInfo=MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(materialID));

			StringBuffer sql=new StringBuffer();
			sql.append(" select tmain.FID,tEntry.fid FEntryID,tentry.FSeq");
			sql.append(" from CT_SPR_CustomerSprayInv tmain");
			sql.append(" left join CT_SPR_CustomerSprayInvEntry tEntry on (tEntry.FParentID=tmain.FID and tEntry.CFmaterialID=?)");
			sql.append(" where tmain.CFCustomerID=?");
			sql.append(" ");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(), new Object[]{materialID,customerID});
			CustomerSprayInvInfo csiInfo=null;
			String entryID;//
			if(rs.next()) {//更新记录
				csiInfo=CustomerSprayInvFactory.getLocalInstance(ctx).getCustomerSprayInvInfo(new ObjectUuidPK(rs.getString("fid")));
				entryID=rs.getString("FentryID");
				if(StringUtils.isNotBlank(entryID)) {
					CustomerSprayInvEntryInfo csiEntryInfo=CustomerSprayInvEntryFactory.getLocalInstance(ctx).getCustomerSprayInvEntryInfo(new ObjectUuidPK(entryID));
					BigDecimal invQty=csiEntryInfo.getInvQty();
					BigDecimal invTime=csiEntryInfo.getInvTime();
					invQty=invQty.subtract(useQty);
					invTime=invTime.subtract(useTime);
					csiEntryInfo.setInvQty(invQty);
					csiEntryInfo.setInvTime(invTime);
					CustomerSprayInvEntryFactory.getLocalInstance(ctx).save(csiEntryInfo);
				}else{
					CustomerSprayInvEntryInfo csiEntryInfo=new CustomerSprayInvEntryInfo();
					csiEntryInfo.setMaterial(mInfo);
					csiEntryInfo.setMaterialName(mInfo.getName());
					csiEntryInfo.setModel(mInfo.getModel());
					csiEntryInfo.setUnit(mInfo.getBaseUnit());
					csiEntryInfo.setInvQty(useQty);
					csiEntryInfo.setInvTime(useTime);
					csiInfo.getEntrys().add(csiEntryInfo);
					CustomerSprayInvFactory.getLocalInstance(ctx).save(csiInfo);
				}
			}
			rs.close();
			if(csiInfo==null) {
				csiInfo=new CustomerSprayInvInfo();
				csiInfo.setCustomer(cusInfo);
				csiInfo.setBizDate(new java.util.Date());
				CustomerSprayInvEntryInfo csiEntryInfo=new CustomerSprayInvEntryInfo();
				csiEntryInfo.setMaterial(mInfo);
				csiEntryInfo.setMaterialName(mInfo.getName());
				csiEntryInfo.setModel(mInfo.getModel());
				csiEntryInfo.setUnit(mInfo.getBaseUnit());
				csiEntryInfo.setInvQty(useQty);
				csiEntryInfo.setInvTime(useTime);
				csiInfo.getEntrys().add(csiEntryInfo);
				CustomerSprayInvFactory.getLocalInstance(ctx).save(csiInfo);
			}
			// 插入记录
			SparyRecordInfo srInfo=new SparyRecordInfo();
			srInfo.setCustomer(cusInfo);
			srInfo.setBizDate(new java.util.Date());
			srInfo.setBillStatus(BillBaseStatusEnum.SUBMITED);
			SparyRecordEntryInfo entryInfo=new SparyRecordEntryInfo();
			entryInfo.setMaterial(mInfo);
			entryInfo.setMaterialName(mInfo.getName());
			entryInfo.setModel(mInfo.getModel());
			entryInfo.setUnit(mInfo.getBaseUnit());
			entryInfo.setDevice(deviceInfo);
			entryInfo.setUseQty(useQty.multiply(new BigDecimal(-1)));
			entryInfo.setUseTime(useTime.multiply(new BigDecimal(-1)));
			entryInfo.setJustTime(new java.util.Date());
			srInfo.getEntrys().add(entryInfo);
			SparyRecordFactory.getLocalInstance(ctx).save(srInfo);
		}catch(Exception e){
			return e.getMessage();
		}
		return "0";
	}
    
}