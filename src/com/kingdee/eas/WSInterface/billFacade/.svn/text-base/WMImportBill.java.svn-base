package com.kingdee.eas.WSInterface.billFacade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.google.gson.JsonParseException;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.WSInterface.common.JSONUtils;
import com.kingdee.eas.WSInterface.common.WsCommonUtil;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.scm.cal.CostAdjustBillInfo;

//BillTypeEnum 有点问题
public class WMImportBill implements IImportBill {

	private static Logger logger = Logger.getLogger("com.kingdee.eas.custom.WSInterface.billFacade.FIBillsImportUtils");
	private static Map billClassMap = null;

	public String importing(Context ctx, String billType, String billDataJSON, int billStatus) throws BOSException,
			EASBizException {
		ResultInfo resultInfo = new ResultInfo();
		IBillSupport billSupport = getBillSupport(billType);
		if (billSupport == null) {
			/*String errStr = (new StringBuilder(String.valueOf(WSResource.getResource(ctx,
					"NOT_SUPPORT_AUDITNOT_SUPPORT_BILLTYPE")))).append(billType).toString();*/
			String errStr="不支持的单据类型的导入"+billType;
			logger.error(errStr);
			resultInfo.setStatus(1);
			resultInfo.setMsg(errStr);
			return JSONUtils.convertObjectToJson(ctx, resultInfo);
		}
		billSupport.setContext(ctx);
		AbstractObjectCollection infos = null;
		try {
			/*JSONObject js=new JSONObject(billDataJSON);
			String companyNum=js.get("company");
			CompanyOrgUnitInfo companyInfo=CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo("where number='"+companyNum+"'");
			*/
			
//			System.out.println();
			System.out.println("传入 billType：" + billType);
			System.out.println("传入 json：————————————————————————————————————————————————");
			System.out.println(billDataJSON);
			System.out.println("传入 json：————————————————————————————————————————————————");
			
			JSONArray  array = JSONArray.fromObject(billDataJSON);
			
			infos = new CoreBillBaseCollection();
			for(int i = 0; i < array.size(); i++){
//				array.get(i).
				Object info = JSONUtils.convertJsonToObject(ctx, array.get(i).toString(), billSupport.getInfoClass());
				HashMap mapInfo = JSONUtils.convertJsonToObject(ctx, array.get(i).toString());
				
				if(info instanceof CostAdjustBillInfo){
					CostAdjustBillInfo cabInfo = (CostAdjustBillInfo)info;
					if(mapInfo.get("huoguihao") != null){
						String  huiguihao = (String)mapInfo.get("huoguihao");
						cabInfo.put("huoguihao", huiguihao);
					}
					if(mapInfo.get("huogh") != null){
						if(mapInfo.get("huogh") instanceof Map){
							Map huoghMap = (Map) mapInfo.get("huogh");
							String hghNumber = (String) huoghMap.get("number");
							if(StringUtils.isNotBlank(hghNumber)){
								WsCommonUtil wcu = new WsCommonUtil();
								GeneralAsstActTypeInfo gaatInfo = wcu.getGAATInfoByNumber(ctx, hghNumber);
								cabInfo.put("huogh", gaatInfo);
							}
//							getGAATInfoByNumber
						}
//						String[]  huiguihao = (String)mapInfo.get("huogh");
					}
				}
				infos.addObject((IObjectValue) info);
			}
	
		} catch (Exception exp) {
			exp.printStackTrace();
			resultInfo.setStatus(1);
			if (exp.getCause() != null && (exp.getCause() instanceof JsonParseException))
				resultInfo.setMsg(exp.getCause().getMessage());
			else
				resultInfo.setMsg(exp.getMessage());
			return JSONUtils.convertObjectToJson(ctx, resultInfo);
		}
		AbstractObjectCollection objCol = new CoreBillBaseCollection();
		if (infos instanceof AbstractObjectCollection)
			objCol = (AbstractObjectCollection) infos;
		else
			objCol.addObject((IObjectValue) infos);
		List billErrors = null;
		if (billStatus == 1)//保存
			billErrors = billSupport.save(objCol);
		else if (billStatus == 2) {//提交
			if (billSupport.isSupportSubmit()) {
				billErrors = billSupport.submit(objCol);
			} else {
				resultInfo.setStatus(1);
				String errMsg = "不支持提交方法";//;WSResource.getResource(ctx, "NOT_SUPPORT_SUBMIT");
				resultInfo.setMsg(errMsg);
				logger.error(errMsg);
			}
		} else if (billStatus == 3) {//审核
			if (billSupport.isSupportSubmit() && billSupport.isSupportAudit()) {
				billErrors = billSupport.submit(objCol);
				billErrors = billSupport.audit(billErrors);
			} else {
				resultInfo.setStatus(1);
				String errMsg = "不支持审核方法！";//;WSResource.getResource(ctx, "NOT_SUPPORT_AUDIT");
				resultInfo.setMsg(errMsg);
				logger.error(errMsg);
			}
		} else {
			resultInfo.setStatus(1);
			//String errMsg = WSResource.getResource(ctx, "NOT_SUPPORT_STATUS");
			String errMsg ="不支持单据状态导入";
			resultInfo.setMsg(errMsg);
			logger.error(errMsg);
		}
		resultInfo.setBillErrors(billErrors);
		for(int i=0;i<billErrors.size();i++) {
			BillResultInfo ri=(BillResultInfo) billErrors.get(i);
			if(ri.getStatus()>0){
				resultInfo.setStatus(1);
				continue;
			}
		}
		/*if (billErrors != null && billErrors.size() > 0) {
			resultInfo.setBillErrors(billErrors);
			if (billErrors.size() == objCol.size())
				resultInfo.setStatus(2);
			else
				resultInfo.setStatus(1);
		} else {
			resultInfo.setStatus(0);
		}*/
		//return processResult(ctx, resultInfo);
		if(billErrors.size()>0) {
			JSONArray resultArray = new JSONArray();
			for(int i = 0; i < billErrors.size(); i++){
				
				String msg=JSONUtils.convertObjectToJson(ctx, (BillResultInfo) billErrors.get(i));
				
				msg =  msg.replace("null", "");
				resultArray.add(msg);
			}
			
			return resultArray.toString();
		}
		else 
			return null;
	}

	private String processResult(Context ctx, ResultInfo resultInfo) throws BOSException {
		if (resultInfo.getStatus() == 0) {
			resultInfo.getBillErrors().clear();
		} else {
			BillResultInfo billResult = null;
			int size = resultInfo.getBillErrors().size();
			for (int i = 0; i < size; i++) {
				billResult = (BillResultInfo) resultInfo.getBillErrors().get(i);
				if (billResult.getStatus() == 0) {
					resultInfo.getBillErrors().remove(i);
					i--;
					size--;
				}
			}

		}
		return JSONUtils.convertObjectToJson(ctx, resultInfo);
	}

	public IBillSupport getBillSupport(String billType) {
		registerBills();
		IBillSupport billSupport = null;
		Class billClass = (Class) billClassMap.get(billType);
		if (billClass != null)
			try {
				billSupport = (IBillSupport) billClass.newInstance();
			} catch (InstantiationException e) {
				logger.error(e);
			} catch (IllegalAccessException e) {
				logger.error(e);
			}
		return billSupport;
	}

	protected synchronized void registerBills() {
		/*if (billClassMap != null) {
			return;
		} else {*/
			billClassMap = new HashMap();
			/*
			 * registBill(BillTypeEnum.PURORDER.getNumber(),
			 * com.kingdee.eas.wmWs.app.billdata.PurOrderBillSupport.class);
			 * registBill(BillTypeEnum.PURREQUEST.getNumber(),
			 * com.kingdee.eas.wmWs.app.billdata.PurRequestBillSupport.class);
			 * registBill(BillTypeEnum.SALEORDER.getNumber(),
			 * com.kingdee.eas.wmWs.app.billdata.SaleOrderBillSupport.class);
			 * registBill(BillTypeEnum.PURINWARE.getNumber(),
			 * com.kingdee.eas.wmWs.app.billdata.PurInWarehsBillSupport.class);
			 * registBill(BillTypeEnum.SALEISSUE.getNumber(),
			 * com.kingdee.eas.wmWs.app.billdata.SaleIssueBillSupport.class);
			 */
			registBill("Requisition",RequisitionBillSupport.class);//BillTypeEnum.Requisition.getNumber()
			registBill("ReceiveBill",ReceiveBillSupport.class);//BillTypeEnum.Requisition.getNumber()
			registBill("CostAdjustBill",CostAdjustBillSupport.class);//成本调整单
			registBill("APOtherBill",APOthertBillSupport.class);//应付单
			registBill("AROtherBill",AROthertBillSupport.class);//应收单
			registBill("PaymentBill",PaymentBillSupport.class);//付款
			return;
		//}
	}


	private void registBill(String billType, Class billClass) {
		if (billClassMap.containsKey(billType)) {
			logger.error((new StringBuilder("bill type ")).append(billType).append(" existed.").toString());
			return;
		} else {
			billClassMap.put(billType, billClass);
			return;
		}
	}
}
