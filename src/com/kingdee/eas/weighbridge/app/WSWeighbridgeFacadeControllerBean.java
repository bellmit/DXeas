package com.kingdee.eas.weighbridge.app;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.OrgUnitFactory;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.weighbridge.InStorageBillInfo;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.eas.weighbridge.WeighBaseType;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.jdbc.rowset.IRowSet;

import java.lang.String;

public class WSWeighbridgeFacadeControllerBean extends AbstractWSWeighbridgeFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.weighbridge.app.WSWeighbridgeFacadeControllerBean");

	/**
	 * 地磅上传
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	protected String _uploadBill(Context ctx, String billJSON) throws BOSException {
		Map map=new HashMap();
		map.put("ResultCode", "0");
		map.put("Result", "SUCESS");
		map.put("Message", "成功");
		JSONObject jsonObject=new JSONObject();
		//**执行导入 
		jsonObject.fromObject(billJSON);
		
		//**
		
		jsonObject.fromObject(map);
		return jsonObject.toString();
	}
	
    /**
     * 创建入库过榜单
     * @param ctx
     */
	private void createInStorageBill(Context ctx,JSONObject jsonObject) {
		try {
			InStorageBillInfo info=new InStorageBillInfo();
			//库存组织、财务组织
			if(StringUtils.isNotBlank(jsonObject.getString("companyNum"))) {
				OrgUnitInfo orgInfo = OrgUnitFactory.getLocalInstance(ctx).getOrgUnitInfo("where number='"+jsonObject.getString("companyNum")+"'");
				info.setStorageOrgUnit(StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK(orgInfo.getId())));
				String companyID=WeighbridgeCommUtils.getOrgIDByRelation(orgInfo.getId().toString(), 4, 1);
				if(StringUtils.isNotBlank(companyID)&&companyID.equalsIgnoreCase("testID"))
					info.setCompany(CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK( companyID)));
			}else {
				throw new BOSException("库存组织编码不能为空！");
			}
			info.setBizDate(new java.util.Date());
			// 供应商
			if(StringUtils.isNotBlank(jsonObject.getString("supplierNum"))) {
				info.setSupplier(SupplierFactory.getLocalInstance(ctx).getSupplierInfo("where number='"+jsonObject.getString("supplierNum")+"'"));
			}
			info.setBillStatus(WeighBaseStatus.finish);
			if(StringUtils.isNotBlank(jsonObject.getString("carNum"))) {
				info.setCar(CarFactory.getLocalInstance(ctx).getCarInfo("where number='"+jsonObject.getString("carNum")+"'"));
			}else {
				throw new BOSException("车辆不能为空！");
			}
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(StringUtils.isNotBlank(jsonObject.getString("inTime"))) {
				info.setInTime(sdf.parse(jsonObject.getString("inTime")));
			}
			if(StringUtils.isNotBlank(jsonObject.getString("outTime"))) {
				info.setOutTime(sdf.parse(jsonObject.getString("outTime")));
			}
			
			info.setWeighman(ContextUtil.getCurrentUserInfo(ctx).getPerson());
			if(jsonObject.get("weighType")!=null) { 
				info.setWeighType(WeighBaseType.getEnum(jsonObject.get("weighType").toString()));
			}else {
				info.setWeighType(WeighBaseType.Gross2Tare);
			}
			
			//if()
			
			if(jsonObject.get("entry")!=null) {
				JSONArray jsonArray=(JSONArray) jsonObject.get("entry");
				for(int i=0;i<jsonArray.size();i++) {
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	/**
	 * 判断 来源库存组织在对应业务日期是不是第一次过磅
	 */
	@Override
	protected boolean _isStorageOrgIsFirstIn(Context ctx, String ctrlUnitID,
			String stoOrgUnitID, Date bizDate) throws BOSException {
		SimpleDateFormat sdfBegin = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		StringBuilder sql = new StringBuilder("select 1 from CT_WHB_InStorageBill where FControlUnitID='");
		sql.append(ctrlUnitID);
		sql.append("' and CFOrderStorageOrgU='");
		sql.append(stoOrgUnitID);
		sql.append("' and FBizDate >= { ts'");
		sql.append(sdfBegin.format(bizDate));
		sql.append("'} and ");
		sql.append(" FBizDate <= { ts'");
		sql.append(sdfEnd.format(bizDate));
		sql.append("'}  ");
		
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try{
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return false;
	}
	
	
	
}