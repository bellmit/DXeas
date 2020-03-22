package com.kingdee.eas.WSInterface.billFacade;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.google.gson.JsonParseException;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.WSInterface.WSResource;
import com.kingdee.eas.WSInterface.common.JSONUtils;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.util.BOSResourceBundle;

//BillTypeEnum 有点问题
public class RequisitionImportBill implements IImportBill {

	private static Logger logger = Logger.getLogger("com.kingdee.eas.custom.WSInterface.billFacade.FIBillsImportUtils");
	private static Map billClassMap = null;

	public String importing(Context ctx, String billType, String billDataJSON, int billStatus) throws BOSException,
			EASBizException {
		ResultInfo resultInfo = new ResultInfo();
		IBillSupport billSupport = getBillSupport(billType);
		if (billSupport == null) {
			/*String errStr = (new StringBuilder(String.valueOf(WSResource.getResource(ctx,
					"NOT_SUPPORT_AUDITNOT_SUPPORT_BILLTYPE")))).append(billType).toString();*/
			String errStr="不支持的单据类型"+billType;
			logger.error(errStr);
			resultInfo.setStatus(1);
			resultInfo.setMsg(errStr);
			return JSONUtils.convertObjectToJson(ctx, resultInfo);
		}
		billSupport.setContext(ctx);
		Object infos = null;
		try {
			infos = JSONUtils.convertJsonToObject(ctx, billDataJSON, billSupport.getInfoClass());
		} catch (Exception exp) {
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
				String errMsg = WSResource.getResource(ctx, "NOT_SUPPORT_SUBMIT");
				resultInfo.setMsg(errMsg);
				logger.error(errMsg);
			}
		} else if (billStatus == 3) {//审核
			if (billSupport.isSupportSubmit() && billSupport.isSupportAudit()) {
				billErrors = billSupport.submit(objCol);
				billErrors = billSupport.audit(billErrors);
			} else {
				resultInfo.setStatus(1);
				String errMsg = WSResource.getResource(ctx, "NOT_SUPPORT_AUDIT");
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
		if (billErrors != null && billErrors.size() > 0) {
			resultInfo.setBillErrors(billErrors);
			if (billErrors.size() == objCol.size())
				resultInfo.setStatus(2);
			else
				resultInfo.setStatus(1);
		} else {
			resultInfo.setStatus(0);
		}
		return processResult(ctx, resultInfo);
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
		if (billClassMap != null) {
			return;
		} else {
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
			registBill(BillTypeEnum.Requisition.getNumber(),BaseBillSupport.class);
			registeExt();
			return;
		}
	}

	/**
	 * ??作用不明
	 */
	protected void registeExt() {
		String resClassName = "com.kingdee.eas.wmWs.WSimportclasses";
		try {
			ResourceBundle resBundle = BOSResourceBundle.getBundle(resClassName, new Locale("l1"));
			for (Enumeration keyIter = resBundle.getKeys(); keyIter.hasMoreElements();) {
				String billType = (String) keyIter.nextElement();
				String className = resBundle.getString(billType);
				if (className != null)
					registBill(billType, className);
			}

		} catch (Exception e) {
			logger.info(e);
		}
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

	private void registBill(String billType, String billClassName) {
		if (billClassMap.containsKey(billType)) {
			logger.error((new StringBuilder("bill type ")).append(billType).append(" existed.").toString());
			return;
		}
		Class billClass = getClass(billClassName);
		if (billClass != null)
			billClassMap.put(billType, billClass);
	}

	private Class getClass(String className) {
		Class billClass = null;
		try {
			billClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		return billClass;
	}

}
