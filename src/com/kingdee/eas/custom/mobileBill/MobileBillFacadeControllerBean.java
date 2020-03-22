package com.kingdee.eas.custom.mobileBill;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.workflow.service.ormrpc.EnactmentServiceFactory;
import com.kingdee.bos.workflow.service.ormrpc.IEnactmentService;
import com.kingdee.eas.base.param.util.ParamManager;
import com.kingdee.eas.basedata.assistant.CurrencyFactory;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitFactory;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.common.BizTypeFactory;
import com.kingdee.eas.basedata.scm.common.BizTypeInfo;
import com.kingdee.eas.basedata.scm.common.DeliveryTypeFactory;
import com.kingdee.eas.basedata.scm.common.DeliveryTypeInfo;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupFactory;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.scm.sd.sale.SaleOrderEntryFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderEntryInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.BaseException;

public class MobileBillFacadeControllerBean extends AbstractMobileBillFacadeControllerBean
{
    private static Logger logger = Logger.getLogger("com.kingdee.eas.custom.mobileBill.MobileBillFacadeControllerBean");
    /**
     * 根据登录用户查询用户所在的销售组织
     */
    protected String _selectSaleOrg(Context ctx, String param)throws BOSException
    {
    	JSONObject jo = JSONObject.fromObject(param);
    	JSONObject resultJson = new JSONObject();
    	if(jo.containsKey("number") && StringUtils.isNotBlank(jo.getString("number"))){
    		String number = jo.getString("number");
    		JSONArray arr = new JSONArray();
    		StringBuffer sb = new StringBuffer();
    		sb.append("SELECT ");
    		sb.append("DISTINCT ");
    		sb.append("T3.FNAME_L2,T2.FSALEORGID ");
    		sb.append("FROM ");
    		sb.append("T_BD_SALEPERSON T1 ");
    		sb.append("INNER JOIN T_BD_SALEGROUP T2 ON T2.FID=T1.FSALEGROUPID ");
    		sb.append("INNER JOIN T_ORG_SALE T3 ON T2.FSALEORGID=T3.FID ");
    		sb.append("WHERE T1.FPERSONID=(SELECT FPERSONID FROM T_PM_USER WHERE FNUMBER='"+ number +"')");
    		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
    		try {
    			while(rs.next()){
    				JSONObject obj = new JSONObject();
    				String saleOrg = rs.getString("FName_l2");
    				String saleOrgID = rs.getString("FSALEORGID");
    				if(StringUtils.isNotBlank(saleOrg) && StringUtils.isNotBlank(saleOrgID)){
    					obj.put("saleOrgName", saleOrg);
    					obj.put("saleOrgID",saleOrgID);
    					arr.add(obj);
    				}
    			}
    			if(!arr.isEmpty()){
    				resultJson.put("result", true);
    				resultJson.put("data", arr.toString());
    				return resultJson.toString();
    			}else{
    				resultJson.put("result", false);
    				resultJson.put("failReason", "请检查用户是否为销售员!");
    			}
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			resultJson.put("result", false);
    			resultJson.put("failReason", e.getMessage());
    			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
    		}
    	}
        return resultJson.toString();
    	
    }
    
    /**
     * 查询销售订单历史
     */
    
	@Override
	protected String _saleOrderHistory(Context ctx, String param)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		JSONObject resultJson = new JSONObject();
		int startNum = 0;
		int endNum = 0;
		String saleOrgID = "";
		String number = "";
		String customerID = "";
		JSONObject jo = JSONObject.fromObject(param);
		if(jo.containsKey("pageSize") && jo.containsKey("startPage") && StringUtils.isNotBlank(jo.getString("pageSize")) && StringUtils.isNotBlank(jo.getString("startPage"))){
			int pageSize = Integer.parseInt(jo.getString("pageSize"));
			int startPage = Integer.parseInt(jo.getString("startPage"));
			startNum = pageSize*(startPage-1)+1; 
			endNum = startPage+pageSize;
		}
		
		//销售组织ID
		if(jo.containsKey("saleOrgID") && StringUtils.isNotBlank(jo.getString("saleOrgID"))){
			saleOrgID = jo.getString("saleOrgID");
		}
		
		//销售员ID
		if(jo.containsKey("number") && StringUtils.isNotBlank(jo.getString("number"))){
			number = jo.getString("number");
		}

		//客户ID
		if(jo.containsKey("customerID") && StringUtils.isNotBlank(jo.getString("customerID"))){
			customerID = jo.getString("customerID");
		}
		JSONArray arr = new JSONArray();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM (SELECT ROWNUM num,FID,billNumber,customerName,amount,bizDate,status FROM (");
		sb.append("SELECT ");
		sb.append("t1.FID FID,t1.FNumber billNumber,t2.FName_l2 customerName,t1.FTotalTaxAmount amount,t1.FBizDate bizDate, ");
		sb.append("CASE t1.FBaseStatus ");
		sb.append("WHEN '0' THEN '新增' ");
		sb.append("WHEN '1' THEN '保存' ");
		sb.append("WHEN '2' THEN '提交' ");
		sb.append("WHEN '3' THEN '作废' ");
		sb.append("WHEN '4' THEN '审核' ");
		sb.append("WHEN '5' THEN '下达' ");
		sb.append("WHEN '6' THEN '冻结' ");
		sb.append("WHEN '7' THEN '关闭' ");
		sb.append("WHEN '8' THEN '完工' ");
		sb.append("WHEN '90' THEN '完成' ");
		sb.append("WHEN '10' THEN '发布' ");
		sb.append("WHEN '11' THEN '结案' " );
		sb.append("WHEN '-2' THEN '变更中' ");
		sb.append("WHEN '-3' THEN '历史版本' else '其他' END AS status ");
		sb.append("FROM ");
		sb.append("T_SD_SaleOrder                AS t1 ");
		sb.append("INNER JOIN T_BD_Customer      AS t2 ");
		sb.append("ON t1.FOrderCustomerID=t2.FID ");
		sb.append("WHERE ");
		sb.append("t1.FSaleOrgUnitID='"+ saleOrgID +"' ");
		sb.append("AND ");
		sb.append("t1.FSalePersonID=(SELECT FPERSONID FROM T_PM_USER WHERE FNUMBER='"+ number +"') ");
		//(SELECT FPERSONID FROM T_PM_USER WHERE FNUMBER='"+ number +"')"
		if(!StringUtils.isBlank(customerID)){
			sb.append("AND t1.FOrderCustomerID='"+ customerID +"' ");
		}
		sb.append("ORDER BY t1.FBizDate DESC) AS T) ");
		sb.append("WHERE ");
		sb.append("num>=" + startNum + " ");
		sb.append("AND ");
		sb.append("num<" + endNum + " ");
		sb.append("order by num asc");
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
		if(rs.size() < 1){
			resultJson.put("result", false);
			resultJson.put("failReason", "未查询到历史销售订单！");
		}else{
			try {
				while(rs.next()){
					JSONObject obj = new JSONObject();
					obj.put("billID",rs.getString("FID"));
					obj.put("index", rs.getString("num"));
					obj.put("billNumber", rs.getString("billNumber"));
					obj.put("customerName", rs.getString("customerName"));
					obj.put("amount", rs.getString("amount"));
					obj.put("bizDate", rs.getString("bizDate"));
					obj.put("status", rs.getString("status"));
					arr.add(obj);
				}
				resultJson.put("result", true);
				resultJson.put("data", arr.toString());
				return resultJson.toString();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultJson.put("result", false);
    			resultJson.put("failReason", e.getMessage());
    			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
			}
		}
		return resultJson.toString();
	}

	/**
	 * 查询销售订单详细信息
	 * @param billNumber 
	 */
	@Override
	protected String _saleOrderDetial(Context ctx, String param) throws BOSException {
		// TODO Auto-generated method stub
		JSONObject resultJson = new JSONObject();
		String saleOrderID = "";
		JSONObject jo = JSONObject.fromObject(param);
		JSONArray arr = new JSONArray();
		StringBuffer sb = new StringBuffer();
		if(jo.containsKey("saleOrderID") && StringUtils.isNotBlank(jo.getString("saleOrderID"))){
			saleOrderID = jo.getString("saleOrderID");
		}
    	try {
    		sb.append("SELECT ");
    		sb.append("t1.FID AS FID,");
    		sb.append("t1.FNumber AS billNumber,");
    		sb.append("t1.CFKDNUMBERTEXTFIELD AS discount,");
    		sb.append("t1.FSaleOrgUnitID AS saleOrgUnitID,");
    		sb.append("t3.FName_l2 AS saleOrgName,");
    		sb.append("t4.FID AS bizTypeID,");
    		sb.append("t4.FName_l2 AS bizType,");
    		sb.append("t5.FID AS customerID,");
    		sb.append("t5.FName_l2 AS customerName,");
    		sb.append("t1.FBizdate AS bizdate,");
    		sb.append("t1.FTotalTaxAmount AS totalTaxAmount,");
    		sb.append("t1.FDescription AS description,");
    		sb.append("t6.FName_l2 AS materialName,");
    		sb.append("t7.FName_l2 AS unit,");
    		sb.append("t2.FTaxPrice AS taxPrice,");
    		sb.append("t2.FQty AS qty,");
    		sb.append("t2.FTaxAmount AS amount,");
    		sb.append("t1.FBaseStatus AS statusVal,");
    		sb.append("CASE t1.FBaseStatus ");
    		sb.append("WHEN '0' THEN '新增' ");
    		sb.append("WHEN '1' THEN '保存' ");
    		sb.append("WHEN '2' THEN '提交' ");
    		sb.append("WHEN '3' THEN '作废' ");
    		sb.append("WHEN '4' THEN '审核' ");
    		sb.append("WHEN '5' THEN '下达' ");
    		sb.append("WHEN '6' THEN '冻结' ");
    		sb.append("WHEN '7' THEN '关闭' ");
    		sb.append("WHEN '8' THEN '完工' ");
    		sb.append("WHEN '90' THEN '完成' ");
    		sb.append("WHEN '10' THEN '发布' ");
    		sb.append("WHEN '11' THEN '结案' " );
    		sb.append("WHEN '-2' THEN '变更中' ");
    		sb.append("WHEN '-3' THEN '历史版本' else '其他' end AS status ");
    		sb.append("FROM ");
    		sb.append("  T_SD_SaleOrder AS t1 INNER JOIN T_SD_SaleorderEntry   AS t2  ON t2.FParentID=t1.FID ");
    		sb.append("					 LEFT OUTER JOIN T_ORG_Sale            AS t3  ON t1.FSaleOrgUnitID=t3.FID ");
    		sb.append("					 LEFT OUTER JOIN T_SCM_BizType         AS t4  ON t1.FBizTypeID=t4.FID ");
    		sb.append("					 LEFT OUTER JOIN T_BD_Customer         AS t5  ON t1.FOrderCustomerID=t5.FID ");
    		sb.append("					 LEFT OUTER JOIN T_BD_Material         AS t6  ON t2.FMaterialID=t6.FID ");
    		sb.append("					 LEFT OUTER JOIN T_BD_MeasureUnit      AS t7  ON t2.FUnitID =t7.FID ");
    		sb.append("WHERE t1.fid='" + saleOrderID + "'");
    		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("saleOrderID", rs.getString("FID"));
				obj.put("totalTaxAmount", rs.getString("totalTaxAmount"));
				obj.put("billNumber", rs.getString("billNumber"));
				obj.put("discount", rs.getString("discount"));
				obj.put("saleOrgUnitID", rs.getString("saleOrgUnitID"));
				obj.put("saleOrgName", rs.getString("saleOrgName"));
				obj.put("bizTypeID",rs.getString("bizTypeID"));
				obj.put("bizType", rs.getString("bizType"));
				obj.put("customerID", rs.getString("customerID"));
				obj.put("customerName", rs.getString("customerName"));
				obj.put("bizDate", rs.getString("bizDate"));
				obj.put("description", rs.getString("description"));
				obj.put("materialName", rs.getString("materialName"));
				obj.put("unit", rs.getString("unit"));
				obj.put("price", rs.getString("taxPrice"));
				obj.put("qty", rs.getString("qty"));
				obj.put("amount", rs.getString("amount"));
				obj.put("status", rs.getString("status"));
				obj.put("statusVal", rs.getString("statusVal"));
				arr.add(obj);
			}
			resultJson.put("result", true);
			resultJson.put("data", arr.toString());
			return resultJson.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
		}
		return resultJson.toString();
	}

	/**
	 * 新增销售订单
	 * 保存、提交方法
	 */
	@Override
	protected String _addNewSaleOrder(Context ctx, String orderInfo) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		System.out.println(orderInfo);
		JSONObject resultJson = new JSONObject();
		CompanyOrgUnitInfo companyInfo = null;
		CtrlUnitInfo cuInfo = null;
		CustomerInfo customerInfo = null;
		JSONObject jsonObject = JSONObject.fromObject(orderInfo);
		
		if(jsonObject.containsKey("billID") && StringUtils.isNotBlank(jsonObject.getString("billID"))){
			SaleOrderInfo saleOrderInfo = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(new ObjectUuidPK(jsonObject.getString("billID")));//通过订单ID获取销售订单Info
			//设置订单日期
			if(jsonObject.containsKey("bizdate") && StringUtils.isNotBlank(jsonObject.getString("bizdate"))){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date bizDate = null;
				try {
					bizDate = sdf.parse(jsonObject.getString("bizdate"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				saleOrderInfo.setBizDate(bizDate);
			}
			
			//业务类型  info d8e80652-010e-1000-e000-04c5c0a812202407435C
			if(jsonObject.containsKey("saleType") && StringUtils.isNotBlank(jsonObject.getString("saleType"))){
				BizTypeInfo bizTypeInfo = BizTypeFactory.getLocalInstance(ctx).getBizTypeInfo(new ObjectUuidPK(jsonObject.getString("saleType")));
				saleOrderInfo.setBizType(bizTypeInfo);
			}else{
				BizTypeInfo bizTypeInfo = BizTypeFactory.getLocalInstance(ctx).getBizTypeInfo(new ObjectUuidPK("d8e80652-010e-1000-e000-04c5c0a812202407435C"));
				saleOrderInfo.setBizType(bizTypeInfo);
			}
			
			//订货客户  info
			if(jsonObject.containsKey("customer") && StringUtils.isNotBlank(jsonObject.getString("customer"))){
				customerInfo = CustomerFactory.getLocalInstance(ctx).getCustomerInfo(new ObjectUuidPK(jsonObject.getString("customer")));
				saleOrderInfo.setOrderCustomer(customerInfo);
			}
			
			//销售组织  info
			if(jsonObject.containsKey("orgID") && StringUtils.isNotBlank(jsonObject.getString("orgID"))){
				SaleOrgUnitInfo saleOrgUnitInfo = SaleOrgUnitFactory.getLocalInstance(ctx).getSaleOrgUnitInfo(new ObjectUuidPK(jsonObject.getString("orgID")));
				saleOrderInfo.setSaleOrgUnit(saleOrgUnitInfo);
			}
			
			//销售组  info
			if(jsonObject.containsKey("saleGroup") && StringUtils.isNotBlank(jsonObject.getString("saleGroup"))){
				SaleGroupInfo saleGroupInfo = SaleGroupFactory.getLocalInstance(ctx).getSaleGroupInfo(new ObjectUuidPK(jsonObject.getString("aleGroup")));
				saleOrderInfo.setSaleGroup(saleGroupInfo);
			}else{
				SaleGroupInfo saleGroupInfo = SaleGroupFactory.getLocalInstance(ctx).getSaleGroupInfo(new ObjectUuidPK("mxAdrAg2TWCg7gxru85DDCIHAEM="));
				saleOrderInfo.setSaleGroup(saleGroupInfo);
			}
			
			//销售员  info
			if(jsonObject.containsKey("userNumber") && StringUtils.isNotBlank(jsonObject.getString("userNumber"))){
				PersonInfo personInfo = null;
				try {
					personInfo = getInfoByPersonNumber(ctx, jsonObject.getString("userNumber"));
					companyInfo = (CompanyOrgUnitInfo)getDefaultOrg(ctx, jsonObject.getString("userNumber"), false);
					cuInfo = (CtrlUnitInfo)getDefaultOrg(ctx, jsonObject.getString("userNumber"), true);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				saleOrderInfo.setSalePerson(personInfo);
				saleOrderInfo.setCU(cuInfo);//设置CU
			}
			
			//币别  info
			if(jsonObject.containsKey("currency") && StringUtils.isNotBlank(jsonObject.getString("currency"))){
				CurrencyInfo currencyInfo = CurrencyFactory.getLocalInstance(ctx).getCurrencyInfo(new ObjectUuidPK(jsonObject.getString("currency")));
				saleOrderInfo.setCurrency(currencyInfo);
			}else{
				CurrencyInfo currencyInfo = CurrencyFactory.getLocalInstance(ctx).getCurrencyInfo(new ObjectUuidPK("dfd38d11-00fd-1000-e000-1ebdc0a8100dDEB58FDC"));
				saleOrderInfo.setCurrency(currencyInfo);
			}
			
			// 含税金额
			if(jsonObject.containsKey("price") && StringUtils.isNotBlank(jsonObject.getString("price"))){
				saleOrderInfo.setTotalTaxAmount(new BigDecimal(jsonObject.getString("price")));
			}
			
			//整单折扣  **********************************
			if(jsonObject.containsKey("discount") && StringUtils.isNotBlank(jsonObject.getString("discount"))){
				saleOrderInfo.put("kDNumberTextField", new BigDecimal(jsonObject.getString("discount")));
			}
			
			//交货方式  info
			if(jsonObject.containsKey("deliveryType") && StringUtils.isNotBlank(jsonObject.getString("deliveryType"))){
				DeliveryTypeInfo deliveryTypeInfo = DeliveryTypeFactory.getLocalInstance(ctx).getDeliveryTypeInfo(new ObjectUuidPK(jsonObject.getString("deliveryType")));
				saleOrderInfo.setDeliveryType(deliveryTypeInfo);
			}else{
				DeliveryTypeInfo deliveryTypeInfo = DeliveryTypeFactory.getLocalInstance(ctx).getDeliveryTypeInfo(new ObjectUuidPK("51eb893e-0105-1000-e000-0c00c0a8123362E9EE3F"));
				saleOrderInfo.setDeliveryType(deliveryTypeInfo);
			}
			
			//是否含税
			if(jsonObject.containsKey("isInTax") && StringUtils.isNotBlank(jsonObject.getString("isInTax"))){
				
			}else{
				saleOrderInfo.setIsInTax(true);
			}
			
			//摘要
			if(jsonObject.containsKey("remark") && StringUtils.isNotBlank(jsonObject.getString("remark"))){
				saleOrderInfo.setDescription(jsonObject.getString("remark"));
			}
			
			//销售订单分录
			saleOrderInfo.getEntries().clear();
			if(jsonObject.containsKey("billEntity") && StringUtils.isNotBlank(jsonObject.getString("billEntity"))){
				String jsonArr = JSONObject.fromObject(jsonObject.getString("billEntity")).getString("data");
				JSONArray arr = JSONArray.fromObject(jsonArr);
				for(int i = 0 ; i < arr.size() ; i++){
					SaleOrderEntryInfo eInfo = new SaleOrderEntryInfo();
					JSONObject object = arr.getJSONObject(i);
					if(object.containsKey("materialID") && StringUtils.isNotBlank(object.getString("materialID"))){
						MaterialInfo materialInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(object.getString("materialID")));
						//分录物料组
						MaterialGroupInfo groupInfo = MaterialGroupFactory.getLocalInstance(ctx).getMaterialGroupInfo(new ObjectUuidPK(materialInfo.getMaterialGroup().getId().toString()));
						eInfo.setMaterialGroup(groupInfo);
						//分录物料
						eInfo.setMaterial(materialInfo);
						
						//分录计量单位
						MeasureUnitInfo measureUnitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(materialInfo.getBaseUnit().getId().toString()));
						eInfo.setUnit(measureUnitInfo);
						
						//数量
						eInfo.setQty(new BigDecimal(object.getString("number").trim()));
						
						//税率
						if(object.containsKey("taxRate") && StringUtils.isNotBlank(object.getString("taxRate"))){
							eInfo.setTaxRate(new BigDecimal(object.getString("taxRate").trim()));
						}else{
							eInfo.setTaxRate(new BigDecimal("17"));
						}
						
						//含税单价
						if(object.containsKey("price") && StringUtils.isNotBlank(object.getString("price"))){
							eInfo.setTaxPrice(new BigDecimal(object.getString("price").trim()));
						}
						
						//发货日期
						eInfo.setDeliveryDate(new Date());
						
						//发货组织
						eInfo.setCompanyOrgUnit(companyInfo);
						
						//送货客户
						eInfo.setDeliveryCustomer(customerInfo);
						
						//收款客户
						eInfo.setPaymentCustomer(customerInfo);
						
						//应收客户
						eInfo.setReceiveCustomer(customerInfo);
					}
					saleOrderInfo.getEntries().add(eInfo);
				}
			}

			//订单保存或提交
			String type = jsonObject.getString("type");
			if("save".equals(type)){
				SaleOrderFactory.getLocalInstance(ctx).save(saleOrderInfo);
			}else if ("submit".equals(type)){
				SaleOrderFactory.getLocalInstance(ctx).submit(saleOrderInfo);
			}
			
			if(saleOrderInfo.getNumber() != null && saleOrderInfo.getId() != null){
				JSONObject obj = new JSONObject();
				obj.put("number", saleOrderInfo.getNumber());
				obj.put("id", saleOrderInfo.getId().toString());
				resultJson.put("result", true);
				resultJson.put("data", obj.toString());
				return resultJson.toString();
			}else{
				resultJson.put("result", false);
				resultJson.put("failReason",  "保存失败！");
				return resultJson.toString();
			}
		}//已生成订单修改执行完毕
		else{
			SaleOrderInfo saleOrderInfo = new SaleOrderInfo();//新建销售订单Info
			//设置订单日期
			if(jsonObject.containsKey("bizdate") && StringUtils.isNotBlank(jsonObject.getString("bizdate"))){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date bizDate = null;
				try {
					bizDate = sdf.parse(jsonObject.getString("bizdate"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				saleOrderInfo.setBizDate(bizDate);
			}
//			saleOrderInfo.setNumber(InitCommon.getAutoCode(ctx, "00000000-0000-0000-0000-000000000000CCE7AED4", saleOrderInfo));  //放到日期后面
//		saleOrderInfo.setNumber("test11110");
			
			
			//业务类型  info d8e80652-010e-1000-e000-04c5c0a812202407435C
			if(jsonObject.containsKey("saleType") && StringUtils.isNotBlank(jsonObject.getString("saleType"))){
				BizTypeInfo bizTypeInfo = BizTypeFactory.getLocalInstance(ctx).getBizTypeInfo(new ObjectUuidPK(jsonObject.getString("saleType")));
				saleOrderInfo.setBizType(bizTypeInfo);
			}else{
				BizTypeInfo bizTypeInfo = BizTypeFactory.getLocalInstance(ctx).getBizTypeInfo(new ObjectUuidPK("d8e80652-010e-1000-e000-04c5c0a812202407435C"));
				saleOrderInfo.setBizType(bizTypeInfo);
			}
			
			//订货客户  info
			if(jsonObject.containsKey("customer") && StringUtils.isNotBlank(jsonObject.getString("customer"))){
				customerInfo = CustomerFactory.getLocalInstance(ctx).getCustomerInfo(new ObjectUuidPK(jsonObject.getString("customer")));
				saleOrderInfo.setOrderCustomer(customerInfo);
			}
			
			//销售组织  info
			if(jsonObject.containsKey("orgID") && StringUtils.isNotBlank(jsonObject.getString("orgID"))){
				SaleOrgUnitInfo saleOrgUnitInfo = SaleOrgUnitFactory.getLocalInstance(ctx).getSaleOrgUnitInfo(new ObjectUuidPK(jsonObject.getString("orgID")));
				saleOrderInfo.setSaleOrgUnit(saleOrgUnitInfo);
			}
			
			//销售组  info
			if(jsonObject.containsKey("saleGroup") && StringUtils.isNotBlank(jsonObject.getString("saleGroup"))){
				SaleGroupInfo saleGroupInfo = SaleGroupFactory.getLocalInstance(ctx).getSaleGroupInfo(new ObjectUuidPK(jsonObject.getString("aleGroup")));
				saleOrderInfo.setSaleGroup(saleGroupInfo);
			}else{
				SaleGroupInfo saleGroupInfo = SaleGroupFactory.getLocalInstance(ctx).getSaleGroupInfo(new ObjectUuidPK("mxAdrAg2TWCg7gxru85DDCIHAEM="));
				saleOrderInfo.setSaleGroup(saleGroupInfo);
			}
			
			//销售员  info
			if(jsonObject.containsKey("userNumber") && StringUtils.isNotBlank(jsonObject.getString("userNumber"))){
				PersonInfo personInfo = null;
				try {
					personInfo = getInfoByPersonNumber(ctx, jsonObject.getString("userNumber"));
					companyInfo = (CompanyOrgUnitInfo)getDefaultOrg(ctx, jsonObject.getString("userNumber"), false);
					cuInfo = (CtrlUnitInfo)getDefaultOrg(ctx, jsonObject.getString("userNumber"), true);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				saleOrderInfo.setSalePerson(personInfo);
				saleOrderInfo.setCU(cuInfo);//设置cu
			}
			
			//币别  info
			if(jsonObject.containsKey("currency") && StringUtils.isNotBlank(jsonObject.getString("currency"))){
				CurrencyInfo currencyInfo = CurrencyFactory.getLocalInstance(ctx).getCurrencyInfo(new ObjectUuidPK(jsonObject.getString("currency")));
				saleOrderInfo.setCurrency(currencyInfo);
			}else{
				CurrencyInfo currencyInfo = CurrencyFactory.getLocalInstance(ctx).getCurrencyInfo(new ObjectUuidPK("dfd38d11-00fd-1000-e000-1ebdc0a8100dDEB58FDC"));
				saleOrderInfo.setCurrency(currencyInfo);
			}
			
			// 含税金额
			if(jsonObject.containsKey("price") && StringUtils.isNotBlank(jsonObject.getString("price"))){
				saleOrderInfo.setTotalTaxAmount(new BigDecimal(jsonObject.getString("price")));
			}
			
			//整单折扣  **********************************
			if(jsonObject.containsKey("discount") && StringUtils.isNotBlank(jsonObject.getString("discount"))){
				saleOrderInfo.put("kDNumberTextField", new BigDecimal(jsonObject.getString("discount")));
			}
			
			//交货方式  info
			if(jsonObject.containsKey("deliveryType") && StringUtils.isNotBlank(jsonObject.getString("deliveryType"))){
				DeliveryTypeInfo deliveryTypeInfo = DeliveryTypeFactory.getLocalInstance(ctx).getDeliveryTypeInfo(new ObjectUuidPK(jsonObject.getString("deliveryType")));
				saleOrderInfo.setDeliveryType(deliveryTypeInfo);
			}else{
				DeliveryTypeInfo deliveryTypeInfo = DeliveryTypeFactory.getLocalInstance(ctx).getDeliveryTypeInfo(new ObjectUuidPK("51eb893e-0105-1000-e000-0c00c0a8123362E9EE3F"));
				saleOrderInfo.setDeliveryType(deliveryTypeInfo);
			}
			
			//是否含税
			if(jsonObject.containsKey("isInTax") && StringUtils.isNotBlank(jsonObject.getString("isInTax"))){
				
			}else{
				saleOrderInfo.setIsInTax(true);
			}
			
			//摘要
			if(jsonObject.containsKey("remark") && StringUtils.isNotBlank(jsonObject.getString("remark"))){
				saleOrderInfo.setDescription(jsonObject.getString("remark"));
			}
			
			//销售订单分录
			if(jsonObject.containsKey("billEntity") && StringUtils.isNotBlank(jsonObject.getString("billEntity"))){
				String jsonArr = JSONObject.fromObject(jsonObject.getString("billEntity")).getString("data");
				JSONArray arr = JSONArray.fromObject(jsonArr);
				for(int i = 0 ; i < arr.size() ; i++){
					SaleOrderEntryInfo eInfo = new SaleOrderEntryInfo();
					JSONObject object = arr.getJSONObject(i);
					if(object.containsKey("materialID") && StringUtils.isNotBlank(object.getString("materialID"))){
						MaterialInfo materialInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(object.getString("materialID")));
						//分录物料组
						MaterialGroupInfo groupInfo = MaterialGroupFactory.getLocalInstance(ctx).getMaterialGroupInfo(new ObjectUuidPK(materialInfo.getMaterialGroup().getId().toString()));
						eInfo.setMaterialGroup(groupInfo);
						//分录物料
						eInfo.setMaterial(materialInfo);
						
						//分录计量单位
						MeasureUnitInfo measureUnitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(materialInfo.getBaseUnit().getId().toString()));
						eInfo.setUnit(measureUnitInfo);
						
						//数量
						eInfo.setQty(new BigDecimal(object.getString("number").trim()));
						
						//税率
						if(object.containsKey("taxRate") && StringUtils.isNotBlank(object.getString("taxRate"))){
							eInfo.setTaxRate(new BigDecimal(object.getString("taxRate").trim()));
						}else{
							eInfo.setTaxRate(new BigDecimal("17"));
						}
						
						//含税单价
						if(object.containsKey("price") && StringUtils.isNotBlank(object.getString("price"))){
							eInfo.setTaxPrice(new BigDecimal(object.getString("price").trim()));
						}
						
						//发货日期
						eInfo.setDeliveryDate(new Date());
						
						//发货组织
						eInfo.setCompanyOrgUnit(companyInfo);
						
						//送货客户
						eInfo.setDeliveryCustomer(customerInfo);
						
						//收款客户
						eInfo.setPaymentCustomer(customerInfo);
						
						//应收客户
						eInfo.setReceiveCustomer(customerInfo);
					}
					saleOrderInfo.getEntries().add(eInfo);
				}
			}
			String type = jsonObject.getString("type");
			
			//订单保存或提价
			if("save".equals(type)){
				SaleOrderFactory.getLocalInstance(ctx).save(saleOrderInfo);
			}else if("submit".equals(type)){
				SaleOrderFactory.getLocalInstance(ctx).submit(saleOrderInfo);
			}
			
			//方法返回值
			if(saleOrderInfo.getNumber() != null && saleOrderInfo.getId() != null){
				JSONObject obj = new JSONObject();
				obj.put("number", saleOrderInfo.getNumber());
				obj.put("id", saleOrderInfo.getId().toString());
				resultJson.put("result", true);
				resultJson.put("data", obj.toString());
				return resultJson.toString();
			}else{
				resultJson.put("result", false);
				resultJson.put("failReason",  "保存失败！");
				return resultJson.toString();
			}
		}
	}
	

	/**
	 * 修改销售订单
	 * 什么状态的销售订单允许修改？
	 * 
	 */
	
	@Override
	protected String _alterOrder(Context ctx, String alterInfo) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CustomerInfo customerInfo = new CustomerInfo();
		CompanyOrgUnitInfo companyInfo = new CompanyOrgUnitInfo();
		JSONObject jsonObject = JSONObject.fromObject(alterInfo);
		JSONObject resultJson = new JSONObject();
		try {
			StringBuffer sb = new StringBuffer();
			String saleOrderID = "";
			//销售订单FID
			if(jsonObject.containsKey("id") && StringUtils.isNotBlank(jsonObject.getString("id"))){
				saleOrderID = jsonObject.getString("id");
			}else {
				resultJson.put("result", false);
				resultJson.put("failReason", "单据ID为空！");
			}
			
			sb.append("select FBASESTATUS bs from T_SD_SaleOrder where Fid='"+ saleOrderID +"'");
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
			if(rs.next()){
				int i = rs.getInt("bs");
				if(1 == i || 2 == i){
					
					//获取销售订单Info
					SaleOrderInfo saleOrderInfo = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(new ObjectUuidPK(saleOrderID));
					String str = ParamManager.getParamValue(null, null, "duplicateSubmitWorkflow");
					if ((!(StringUtils.isEmpty(str))) && ("true".equals(str)) && (checkHasSubmitWorkflowJustBefore(saleOrderID))) {
						resultJson.put("result", false);
						resultJson.put("failReason", "单据已在工作流中，禁止修改！");
						return resultJson.toString();
					}
					
					//获取销售订单原分录
					SaleOrderEntryInfo saleOrderEntryInfo = saleOrderInfo.getEntries().get(0);
					if(!saleOrderEntryInfo.isEmpty()){
						String id = saleOrderEntryInfo.getId().toString();
						SaleOrderEntryInfo entryInfo = SaleOrderEntryFactory.getLocalInstance(ctx).getSaleOrderEntryInfo(new ObjectUuidPK(id));
						CompanyOrgUnitInfo companyOrgUnit = entryInfo.getCompanyOrgUnit();
						CustomerInfo deliveryCustomer = entryInfo.getDeliveryCustomer();
//						CustomerInfo paymentCustomer = entryInfo.getPaymentCustomer();
//						CustomerInfo receiveCustomer = entryInfo.getReceiveCustomer();
						if(!companyOrgUnit.isEmpty() && !deliveryCustomer.isEmpty() ){
							companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyOrgUnit.getId()));
							customerInfo = CustomerFactory.getLocalInstance(ctx).getCustomerInfo(new ObjectUuidPK(deliveryCustomer.getId()));
						}
							
					}
						
					//业务日期
					if(jsonObject.containsKey("bizDate") && StringUtils.isNotBlank(jsonObject.getString("bizDate"))){
						String bizDate = jsonObject.getString("bizDate");
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date date = sdf.parse(bizDate);
						saleOrderInfo.setBizDate(date);
					}
					
					//整单折扣
					if(jsonObject.containsKey("DARate") && StringUtils.isNotBlank(jsonObject.getString("DARate"))){
						BigDecimal DARate = new BigDecimal(jsonObject.getString("DARate").trim());
						saleOrderInfo.put("kDNumberTextField", DARate);
					}
					
					//含税总金额
					if(jsonObject.containsKey("price") && StringUtils.isNotBlank(jsonObject.getString("price"))){
						saleOrderInfo.setTotalTaxAmount(new BigDecimal(jsonObject.getString("key")));
					}
					
					//销售订单分录
					saleOrderInfo.getEntries().clear();
					if(jsonObject.containsKey("billEntity") && StringUtils.isNotBlank(jsonObject.getString("billEntity"))){
						String jsonArr = JSONObject.fromObject(jsonObject.getString("billEntity")).getString("data");
						JSONArray arr = JSONArray.fromObject(jsonArr);
						for(int j = 0 ; j < arr.size() ; j++){
							SaleOrderEntryInfo eInfo = new SaleOrderEntryInfo();
							JSONObject object = arr.getJSONObject(j);
							if(object.containsKey("materialID") && StringUtils.isNotBlank(object.getString("materialID"))){
								MaterialInfo materialInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(object.getString("materialID")));
								//分录物料组
								MaterialGroupInfo groupInfo = MaterialGroupFactory.getLocalInstance(ctx).getMaterialGroupInfo(new ObjectUuidPK(materialInfo.getMaterialGroup().getId().toString()));
								eInfo.setMaterialGroup(groupInfo);
								//分录物料
								eInfo.setMaterial(materialInfo);
								
								//分录计量单位
								MeasureUnitInfo measureUnitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(materialInfo.getBaseUnit().getId().toString()));
								eInfo.setUnit(measureUnitInfo);
								
								//数量
								eInfo.setQty(new BigDecimal(object.getString("number").trim()));
								
								//税率
								if(object.containsKey("taxRate") && StringUtils.isNotBlank(object.getString("taxRate"))){
									eInfo.setTaxRate(new BigDecimal(object.getString("taxRate").trim()));
								}else{
									eInfo.setTaxRate(new BigDecimal("17"));
								}
								
								//含税单价
								if(object.containsKey("price") && StringUtils.isNotBlank(object.getString("price"))){
									eInfo.setTaxPrice(new BigDecimal(object.getString("price").trim()));
								}
								
								//发货日期
								eInfo.setDeliveryDate(new Date());
								
								//发货组织
								eInfo.setCompanyOrgUnit(companyInfo);
								
								//送货客户
								eInfo.setDeliveryCustomer(customerInfo);
								
								//收款客户
								eInfo.setPaymentCustomer(customerInfo);
								
								//应收客户
								eInfo.setReceiveCustomer(customerInfo);
							}
							saleOrderInfo.getEntries().add(eInfo);
						}
					}
					
					//修改后的单据保存
					int value = saleOrderInfo.getBaseStatus().getValue();
					if(1 == value){
						SaleOrderFactory.getLocalInstance(ctx).save(saleOrderInfo);
					}else{
						SaleOrderFactory.getLocalInstance(ctx).submit(saleOrderInfo);
					}
					if(saleOrderInfo.getNumber() != null && saleOrderInfo.getId() != null){
						JSONObject obj = new JSONObject();
						obj.put("number", saleOrderInfo.getNumber());
						obj.put("id", saleOrderInfo.getId().toString());
						resultJson.put("result", true);
						resultJson.put("data", obj.toString());
						return resultJson.toString();
					}else{
						resultJson.put("result", false);
						resultJson.put("failReason",  "保存失败！");
						return resultJson.toString();
					}
					
				}else{
					resultJson.put("result", false);
					resultJson.put("failReason", "只允许修改保存或提交状态的订单！");
					return resultJson.toString();
				}
			}else{
				resultJson.put("result", false);
				resultJson.put("failReason", "未查询到订单ID为" + saleOrderID + "的单据！");
				return resultJson.toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultJson.toString();
	}

	/**
	 * 根据用户查询客户所属销售员
	 * @param personID 员工ID
	 */
	@Override
	protected String _queryCustomerByUser(Context ctx, String param) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		JSONObject resultJson = new JSONObject();
		System.out.println(param);
		JSONObject jo = JSONObject.fromObject(param);
		StringBuffer sb = new StringBuffer();
		JSONArray arr = new JSONArray();
		String number = "";
		String saleOrgID = "";
		if(jo.containsKey("number") && StringUtils.isNotBlank(jo.getString("number"))){
			number = jo.getString("number");
		}
		if(jo.containsKey("saleOrgID") && StringUtils.isNotBlank(jo.getString("saleOrgID"))){
			saleOrgID = jo.getString("saleOrgID");
		}
		sb.append("SELECT DISTINCT t3.FID AS FID,t3.FName_l2 AS customerName ");
		sb.append("FROM ");
		sb.append("T_BD_CustomerSaler                AS t1 ");
		sb.append("INNER JOIN T_BD_CustomerSaleInfo  AS t2 ");
		sb.append("ON ");
		sb.append("t1.FCustomerSaleID=t2.FID ");
		sb.append("INNER JOIN T_BD_Customer         AS t3 ");
		sb.append("on t2.FCustomerID=t3.FID ");
		sb.append("WHERE ");
		sb.append("t1.FPersonID=(SELECT FPERSONID FROM T_PM_USER WHERE FNUMBER='"+ number +"') ");
		sb.append("and t2.FSaleOrgID='" + saleOrgID + "' ");
		sb.append("and t3.FUsedStatus=1");
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
		try {
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("customerID", rs.getString("FID"));
				obj.put("customerName", rs.getString("customerName"));
				arr.add(obj);
			}
			if(!arr.isEmpty()){
				resultJson.put("result", true);
				resultJson.put("data", arr.toString());
			}else{
				resultJson.put("result", false);
				resultJson.put("failReason", "没有查询到客户！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
		}
		
		return resultJson.toString();
	}

	/**
	 * 客户可销售物料
	 */
	@Override
	protected String _queryMaterialByCustomer(Context ctx, String param) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		JSONObject resultJson = new JSONObject();
		JSONObject jo = JSONObject.fromObject(param);
		String customerID = "";
		if(jo.containsKey("customerID") && StringUtils.isNotBlank(jo.getString("customerID"))){
			customerID = jo.getString("customerID");
		}
		JSONArray arr = new JSONArray();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("t1.FMaterialID AS ID,t2.FName_l2 AS materialName,t3.FName_l2 AS unit,t4.FPrice AS price ");
		sb.append("FROM ");
		sb.append("T_CHA_CustomersMR          AS t1 ");
		sb.append("LEFT JOIN ");
		sb.append("T_BD_Material              AS t2 ");
		sb.append("ON ");
		sb.append("t1.FMaterialID=t2.FID ");
		sb.append("LEFT JOIN ");
		sb.append("T_BD_MeasureUnit           AS t3 ");
		sb.append("ON ");
		sb.append("t1.FOrderMeasureUnitID=t3.FID ");
		sb.append("LEFT JOIN ");
		sb.append("T_SD_MaterialBasePrice     AS t4 ");
		sb.append("ON ");
		sb.append("t1.FMaterialID=t4.FMaterialID ");
		sb.append("WHERE t1.FCustomerID='" + customerID + "'");
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
		try {
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("materialID", rs.getString("ID"));
				obj.put("materialName", rs.getString("materialName"));
				obj.put("unit", rs.getString("unit"));
				obj.put("price", rs.getString("price"));
				arr.add(obj);
			}
			if(arr.isEmpty()){
				resultJson.put("result", false);
				resultJson.put("failReason", "未查询到客户可销售物料！");
			}else{
				resultJson.put("result", true);
				resultJson.put("data", arr.toString());
				System.out.println(arr.size());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
		}
		return resultJson.toString();
	}
	
	@Override
	protected String _queryBizType(Context ctx)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		JSONObject resultJson = new JSONObject();
		JSONArray arr = new JSONArray();
		sb.append("select t1.FBizTypeID AS bizTypeID,t2.FName_l2 AS bizTypeName from T_SCM_billBizType t1 inner join  T_SCM_BizType t2 on t1.FBizTypeID=t2.FID　where FBillTypeID='510b6503-0105-1000-e000-0113c0a812fd463ED552'");
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
		try {
			while(rs.next()){
				JSONObject obj = new JSONObject();
				String bizTypeName = rs.getString("bizTypeName");
				String bizTypeID = rs.getString("bizTypeID");
				obj.put("bizTypeID", bizTypeID);
				obj.put("bizTypeName", bizTypeName);
				arr.add(obj);
			}
			resultJson.put("result", true);
			resultJson.put("data", arr.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultJson.toString();
	}
	
	//根据业务类型名称获取业务类型Info
	private BizTypeInfo getInfoByName(Context ctx,String bizTypeName) throws BaseException, SQLException{
		StringBuffer sb = new StringBuffer();
		BizTypeInfo bizTypeInfo = null;
		sb.append("select Fid from T_SCM_BizType where FName_l2='"+ bizTypeName +"'");
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
		if(rs.next()){
			String bizTypeID = rs.getString("Fid");
			bizTypeInfo = BizTypeFactory.getLocalInstance(ctx).getBizTypeInfo(new ObjectUuidPK(bizTypeID));
		}
		
		return bizTypeInfo;
		
	}

	//根据销售员FNumber获取销售员Info
	private PersonInfo getInfoByPersonNumber(Context ctx, String fnumber) throws BOSException, SQLException, EASBizException{
		PersonInfo personInfo = new PersonInfo();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT FPERSONID FROM T_PM_USER WHERE FNUMBER='"+ fnumber +"'");
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
		if(rs.next()){
			String personID = rs.getString("FPERSONID");
			personInfo = PersonFactory.getLocalInstance(ctx).getPersonInfo(new ObjectUuidPK(personID));
		}
		return personInfo;
	}
	
	//获取员工缺省组织
	private OrgUnitInfo getDefaultOrg(Context ctx, String fnumber, Boolean isCU) throws SQLException, EASBizException{
		CompanyOrgUnitInfo info = new CompanyOrgUnitInfo();
		CtrlUnitInfo cuInfo = null;
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT FDefOrgUnitID FROM T_PM_USER WHERE FNUMBER='" + fnumber + "'");
		try {
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
			if(rs.next()){
				String id = rs.getString("FDefaultOrgUnitID");
				info = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(id));
				cuInfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(new ObjectUuidPK(id));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isCU ? cuInfo:info;
	}
	
	//
	private boolean checkHasSubmitWorkflowJustBefore(String billId) throws Exception {
		IEnactmentService service = EnactmentServiceFactory.createRemoteEnactService();
	    if (StringUtils.isEmpty(billId)) {
	    	return false;
	    	}
	    boolean flag = service.selectProcessRecordForduplicateCommit(billId);
	    return flag;
	    }
}