package com.kingdee.eas.farm.food.ws;

import org.apache.axis.Message;
import org.apache.axis.MessageContext;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.axis.message.SOAPHeaderElement;

import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.orm.core.ORMEngine;
import com.kingdee.bos.webservice.BeanConvertHelper;
import com.kingdee.bos.webservice.WSConfig;
import com.kingdee.bos.webservice.WSInvokeException;

public class WSWSFoodFacadeSrvProxy {
	/**
	 * 上传单据
	 * @param jsonString
	 * @return
	 * @throws WSInvokeException
	 */
	public String uploadBill(String jsonString) throws WSInvokeException {
		try {
			return getController().uploadBill(jsonString);
		} catch (Throwable e) {
			throw new WSInvokeException(e);
		}
	}
	/**
	 * 获取单据信息
	 * @param jsonString
	 * @return
	 * @throws WSInvokeException
	 */
	public String getBillInfo(String jsonString) throws WSInvokeException {
		try {
			return getController().getBillInfo(jsonString);
		} catch (Throwable e) {
			throw new WSInvokeException(e);
		}
	}
	/**
	 * 获取单据列表信息
	 * @param jsonString
	 * @return
	 * @throws WSInvokeException
	 */
	public String getBillList(String jsonString) throws WSInvokeException {
		try {
			return getController().getBillList(jsonString);
		} catch (Throwable e) {
			throw new WSInvokeException(e);
		}
	}
	
	/**
	 * 获取基础资料信息
	 * @param jsonString
	 * @return
	 * @throws WSInvokeException
	 */
	public String getBaseData(String jsonString) throws WSInvokeException {
		try {
			return getController().getBaseData(jsonString);
		} catch (Throwable e) {
			throw new WSInvokeException(e);
		}
	}

	private com.kingdee.eas.farm.food.IWSFoodFacade getController() {
		try {
			if (WSConfig.getRomoteLocate() != null && WSConfig.getRomoteLocate().equals("false")) {
				Message message = MessageContext.getCurrentContext().getRequestMessage();
				SOAPEnvelope soap = message.getSOAPEnvelope();
				SOAPHeaderElement headerElement = soap.getHeaderByName(WSConfig.loginQName, WSConfig.loginSessionId);
				String SessionId = headerElement.getValue();
				return (com.kingdee.eas.farm.food.IWSFoodFacade) BOSObjectFactory.createBOSObject(SessionId,
						"com.kingdee.eas.farm.food.WSFoodFacade");
			} else {
				return (com.kingdee.eas.farm.food.IWSFoodFacade) BOSObjectFactory.createRemoteBOSObject(WSConfig
						.getSrvURL(), "com.kingdee.eas.farm.food.WSFoodFacade",
						com.kingdee.eas.farm.food.IWSFoodFacade.class);
			}
		} catch (Throwable e) {
			return (com.kingdee.eas.farm.food.IWSFoodFacade) ORMEngine.createRemoteObject(WSConfig.getSrvURL(),
					"com.kingdee.eas.farm.food.WSFoodFacade", com.kingdee.eas.farm.food.IWSFoodFacade.class);
		}
	}

	private BeanConvertHelper getBeanConvertor() {
		return new BeanConvertHelper();
	}

}