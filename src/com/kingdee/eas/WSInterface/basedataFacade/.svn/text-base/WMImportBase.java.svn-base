package com.kingdee.eas.WSInterface.basedataFacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.JsonParseException;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.WSInterface.billFacade.ResultInfo;
import com.kingdee.eas.WSInterface.common.JSONUtils;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBillBaseCollection;

public class WMImportBase implements IImportBaseData {

	private static Logger logger = Logger.getLogger("com.kingdee.eas.custom.WSInterface.basedataFacade.WMImportBase");
	private static Map billClassMap = null;

	public WMImportBase() {
	}

	public final class opBillStatus {// 操作单据状态
		public final int UPDATE = 0;
		public final int SAVE = 3;
		public final int SUBMIT = 4;
	}

	public String importing(Context ctx, String billType, String billDataJSON, int billStatus) throws BOSException,
			EASBizException {
		ResultInfo resultInfo = new ResultInfo();
		billClassMap = null;
		IBaseSupport baseSupport = getBillSupport(billType);
		if (baseSupport == null) {
			String errStr = ("不支持单据类型！");
			logger.error(errStr);
			resultInfo.setStatus(1);
			resultInfo.setMsg(errStr);
			return JSONUtils.convertObjectToJson(ctx, resultInfo);
		}
		baseSupport.setContext(ctx);
		Object infos = null;
		try {
			infos = JSONUtils.convertJsonToObject(ctx, billDataJSON, baseSupport.getInfoClass());
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
		List billErrors = new ArrayList();
		/*
		 * com.kingdee.bos.metadata.entity.EntityObjectInfo eo =
		 * WsCommonUtil.getEntityObjectInfo(ctx, new
		 * GeneralAsstActTypeInfo().getBOSType().toString()); Map map =
		 * WsCommonImportUtil.getBillHeadProperties(eo);
		 */
		billErrors = baseSupport.operationBill(billStatus, objCol, billErrors);
		if (billErrors != null && billErrors.size() > 0) {
			int success = 0;
			for (int i = 0; i < billErrors.size(); i++) {
				BaseResultInfo baseResultInfo = (BaseResultInfo) billErrors.get(i);
				if (baseResultInfo.getStatus() == 0)
					success++;
			}

			if (success == objCol.size())
				resultInfo.setStatus(0);
			else if (success == 0)
				resultInfo.setStatus(1);
			else
				resultInfo.setStatus(2);
		} else {
			resultInfo.setStatus(1);
		}
		resultInfo.setBillErrors(billErrors);
		return processResult(ctx, resultInfo);
	}

	private String processResult(Context ctx, ResultInfo resultInfo) throws BOSException {
		BaseResultInfo billResult = null;
		int size = resultInfo.getBillErrors().size();
		for (int i = 0; i < size; i++)
			billResult = (BaseResultInfo) resultInfo.getBillErrors().get(i);

		return JSONUtils.convertObjectToJson(ctx, resultInfo);
	}

	public IBaseSupport getBillSupport(String billType) {
		registerBills();
		IBaseSupport billSupport = null;
		Class billClass = (Class) billClassMap.get(billType);
		if (billClass != null)
			try {
				billSupport = (IBaseSupport) billClass.newInstance();
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
			registBill("GeneralAsstActType", GeneralAsstActTypeSupport.class);
			return;
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
}