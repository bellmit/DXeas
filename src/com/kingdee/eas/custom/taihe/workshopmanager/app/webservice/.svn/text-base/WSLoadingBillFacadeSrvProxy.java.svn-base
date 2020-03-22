package com.kingdee.eas.custom.taihe.workshopmanager.app.webservice;

import org.apache.axis.Message;
import org.apache.axis.MessageContext;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.axis.message.SOAPHeaderElement;

import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.orm.core.ORMEngine;
import com.kingdee.bos.webservice.BeanConvertHelper;
import com.kingdee.bos.webservice.WSConfig;
import com.kingdee.bos.webservice.WSInvokeException;

public class WSLoadingBillFacadeSrvProxy {

	public String uploadData(String jsonStr) throws WSInvokeException {
		try {
			return getController().uploadData(jsonStr);
		} catch (Throwable e) {
			throw new WSInvokeException(e);
		}
	}

	public String downloadData(String jsonStr) throws WSInvokeException {
		try {
			return getController().downloadData(jsonStr);
		} catch (Throwable e) {
			throw new WSInvokeException(e);
		}
	}

	public String queryData(String jsonStr) throws WSInvokeException {
		try {
			return getController().queryData(jsonStr);
		} catch (Throwable e) {
			throw new WSInvokeException(e);
		}
	}
	
	public String create2SaleIssure(String jsonStr) throws WSInvokeException {
		try {
			return getController().create2SaleIssure(jsonStr);
		} catch (Throwable e) {
			throw new WSInvokeException(e);
		}
	}
	
	public String finishLoading(String jsonStr) throws WSInvokeException {
		try {
			return getController().finishLoading(jsonStr);
		} catch (Throwable e) {
			throw new WSInvokeException(e);
		}
	}

	public String deleteData(String jsonStr) throws WSInvokeException {
		try {
			return getController().deleteData(jsonStr);
		} catch (Throwable e) {
			throw new WSInvokeException(e);
		}
	}
	private com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade getController() {
		try {
			if (WSConfig.getRomoteLocate() != null && WSConfig.getRomoteLocate().equals("false")) {
				Message message = MessageContext.getCurrentContext().getRequestMessage();
				SOAPEnvelope soap = message.getSOAPEnvelope();
				SOAPHeaderElement headerElement = soap.getHeaderByName(WSConfig.loginQName, WSConfig.loginSessionId);
				String SessionId = headerElement.getValue();
				return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade) BOSObjectFactory.createBOSObject(
						SessionId, "com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillFacade");
			} else {
				return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade) BOSObjectFactory.createRemoteBOSObject(
						WSConfig.getSrvURL(), "com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillFacade",
						com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade.class);
			}
		} catch (Throwable e) {
			return (com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade) ORMEngine.createRemoteObject(WSConfig
					.getSrvURL(), "com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillFacade",
					com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillFacade.class);
		}
	}

	private BeanConvertHelper getBeanConvertor() {
		return new BeanConvertHelper();
	}

}