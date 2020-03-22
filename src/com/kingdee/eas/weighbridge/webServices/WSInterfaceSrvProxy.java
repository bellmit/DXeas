package com.kingdee.eas.weighbridge.webServices;
import org.apache.axis.Message;
import org.apache.axis.MessageContext;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.Context;
import com.kingdee.bos.framework.session.SessionManager;
import com.kingdee.bos.orm.core.ORMEngine;
import com.kingdee.bos.webservice.BeanConvertHelper;
import com.kingdee.bos.webservice.WSConfig;
import com.kingdee.eas.weighbridge.IWSWeighbridgeFacade;

public class WSInterfaceSrvProxy
{
	Context ctx;

  /**
   * 上传过榜单
   * @param billJSON
   * @return
   */
  public String upLoadWeighBill(String billJSON){
	  try {
		return getController().uploadBill(billJSON);
	} catch (BOSException e) {
		return null;
	}
  }


  /**
   * 获得 接口
   * @return
   */
  private IWSWeighbridgeFacade getController() {
    try {
      if ((WSConfig.getRomoteLocate() != null) && (WSConfig.getRomoteLocate().equals("false"))) {
        Message message = MessageContext.getCurrentContext().getRequestMessage();
        SOAPEnvelope soap = message.getSOAPEnvelope();
        SOAPHeaderElement headerElement = soap.getHeaderByName("http://login.webservice.bos.kingdee.com", "SessionId");
        String SessionId = headerElement.getValue();
        if(StringUtils.isNotBlank(SessionId)){
        	ctx = SessionManager.getInstance().getSession(SessionId).getContext();
        }
        return ((IWSWeighbridgeFacade)BOSObjectFactory.createBOSObject(SessionId, "com.kingdee.eas.weighbridge.WSWeighbridgeFacade"));
      }
      return ((IWSWeighbridgeFacade)BOSObjectFactory.createRemoteBOSObject(WSConfig.getSrvURL(), "com.kingdee.eas.weighbridge.WSWeighbridgeFacade", IWSWeighbridgeFacade.class));
    }
    catch (Throwable e) {
    }
    return ((IWSWeighbridgeFacade)ORMEngine.createRemoteObject(WSConfig.getSrvURL(), "com.kingdee.eas.weighbridge.WSWeighbridgeFacade", IWSWeighbridgeFacade.class));
  }

  
  private BeanConvertHelper getBeanConvertor()
  {
    return new BeanConvertHelper();
  }
}
