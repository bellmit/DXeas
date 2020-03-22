package com.kingdee.eas.custom.echickeninterface.billFacade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;

import com.google.gson.JsonParseException;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.echickeninterface.common.JSONUtils;
import com.kingdee.eas.framework.CoreBillBaseCollection;

public class IImportBillImpl implements IImportBill {

	private static Map billClassMap = null;

	private static Logger logger = Logger
			.getLogger("com.kingdee.eas.custom.echickeninterface.billFacade.IImportBillImpl");

	public String importing(Context ctx, String billType, String billDataJSON,
			int billStatus) throws BOSException, EASBizException {

		// 保存执行结果
		ResultInfo resultInfo = new ResultInfo();
		// 通过单据类型，获得处理单据的接口方法类
		IBillSupport billSupport = getBillSupport(billType);

		if (billSupport == null) {
			String errStr = "不支持的单据类型的导入" + billType;
			logger.error(errStr);
			resultInfo.setStatus(1);// 1是失败
			resultInfo.setMsg(errStr);
		}

		billSupport.setContext(ctx);

		AbstractObjectCollection infos = null;

		try {
			System.out.println("传入billtype：" + billType);
			System.out.println("传入json：―――――――――――――――――――――――――");
			System.out.println(billDataJSON);
			System.out.println("传入json：――――――――――――――――――――――――");

			JSONArray array = JSONArray.fromObject(billDataJSON);
			infos = new CoreBillBaseCollection();
			for (int i = 0; i < array.size(); i++) {
				Object info = JSONUtils.convertJsonToObject(ctx, array.get(i)
						.toString(), billSupport.getInfoClass());
				
				infos.addObject((IObjectValue) info);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultInfo.setStatus(1);
			if (e.getCause() != null
					&& (e.getCause() instanceof JsonParseException))
				resultInfo.setMsg(e.getCause().getMessage());
			else
				resultInfo.setMsg(e.getMessage());
			return JSONUtils.convertObjectToJson(ctx, resultInfo);
			
		}
		AbstractObjectCollection objCol = new CoreBillBaseCollection();
		if (infos instanceof AbstractObjectCollection)
			objCol = (AbstractObjectCollection) infos;
		else
			objCol.addObject((IObjectValue) infos);
		
		List billErrors = null;
		
		// ---调用billsupport中的方法
		if (billStatus == 1)// 保存
		{
			billErrors = billSupport.save(objCol);
		} else if (billStatus == 2)// 提交
		{
			if (billSupport.isSupportSbumit()) {// 判断是否支持提交操作
				billErrors = billSupport.submit(objCol);
			} else {
				resultInfo.setStatus(1);
				String errMsg = "不支持提交方法";
				resultInfo.setMsg(errMsg);
				logger.error(errMsg);
			}
		} else if (billStatus == 3)// 审核
		{
			// 判断是否支持审核和提交方法
			if (billSupport.isSupportSbumit() && billSupport.isSupportAudit()) {
				billErrors = billSupport.submit(objCol);
//				billErrors = billSupport.audit(billErrors);
			} else {
				resultInfo.setStatus(1);
				String errMsg = "不支持审核方法";
				resultInfo.setMsg(errMsg);
				logger.error(errMsg);
			}
		} else {
			resultInfo.setStatus(1);
			String errMsg = "不支持单据状态导入";
			resultInfo.setMsg(errMsg);
			logger.error(errMsg);
		}
		// 单据导入方法执行后，得到了了billErrors

		resultInfo.setBillErrors(billErrors);
		
		for (int i = 0; i < billErrors.size(); i++) {
			BillResultInfo ri = (BillResultInfo) billErrors.get(i);
			if (ri.getStatus() > 0) {
				resultInfo.setStatus(1);
				continue;
			}
		}
		
		// 如果有错误信息，则返回，否则返回null
		if (billErrors.size() > 0) {
			JSONArray resultArray = new JSONArray();
			for (int i = 0; i < billErrors.size(); i++) {
				String msg = JSONUtils.convertObjectToJson(ctx,
						(BillResultInfo) billErrors.get(i));
				msg = msg.replace("null", "");
				resultArray.add(msg);
			}
			return resultArray.toString();
		} else
			return null;
		
		
	}

	// 根据billtype获得对应的单据方法类接口的实现
	private IBillSupport getBillSupport(String billType) {
		// 注册已有的单据类型和类的实现
		registerBills();
		IBillSupport billSupport = null;
		Class billClass = (Class) billClassMap.get(billType);
		if (billClass != null) {
			try {
				billSupport = (IBillSupport) billClass.newInstance();
			} catch (InstantiationException e) {
				logger.error(e);
			} catch (IllegalAccessException e) {
				logger.error(e);
			}
		}

		return billSupport;
	}

	// 将已有的支持的单据注册一遍
	private synchronized void registerBills() {
		billClassMap = new HashMap();
		// 每支持一个类型单据的导入，就要加一个hashmap的映射
		registBill("CommecialChilkenDaily", CommecialChilkenDailySupport.class);// 商品鸡养殖日报
		return;
	}

	// 向billmap中添加对应的单据类型和support类
	private void registBill(String billType, Class billClass) {
		if (billClassMap.containsKey(billType)) {
			logger.error((new StringBuffer("bill type")).append(billType)
					.append("existed.").toString());
		} else {
			billClassMap.put(billType, billClass);
		}
		return;
	}

}
