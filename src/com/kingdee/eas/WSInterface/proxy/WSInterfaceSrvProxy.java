package com.kingdee.eas.WSInterface.proxy;
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
import com.kingdee.eas.WSInterface.IWSInterfaceFacade;

public class WSInterfaceSrvProxy
{
	Context ctx;

  /**
   * 獲取幣別
   * @param queryStr
   * @return
   */
  public String getBaseData(String orgNumber,String dataType,String DateStr){
	  try {
		String queryStr= "{\"orgNumber\":\""+orgNumber+"\",\"date\":\""+DateStr+"\",\"bosType\":\""+dataType+"\"}";
		return getController().getBaseDataByOrgNum(queryStr);
	} catch (BOSException e) {
		return null;
	}
  }


  /**
   * 获得 接口
   * @return
   */
  private IWSInterfaceFacade getController() {
    try {
      if ((WSConfig.getRomoteLocate() != null) && (WSConfig.getRomoteLocate().equals("false"))) {
        Message message = MessageContext.getCurrentContext().getRequestMessage();
        SOAPEnvelope soap = message.getSOAPEnvelope();
        SOAPHeaderElement headerElement = soap.getHeaderByName("http://login.webservice.bos.kingdee.com", "SessionId");
        String SessionId = headerElement.getValue();
        if(StringUtils.isNotBlank(SessionId)){
        	ctx = SessionManager.getInstance().getSession(SessionId).getContext();
        }
        return ((IWSInterfaceFacade)BOSObjectFactory.createBOSObject(SessionId, "com.kingdee.eas.custom.WSInterface.WSInterfaceFacade"));
      }
      return ((IWSInterfaceFacade)BOSObjectFactory.createRemoteBOSObject(WSConfig.getSrvURL(), "com.kingdee.eas.custom.WSInterface.WSInterfaceFacade", IWSInterfaceFacade.class));
    }
    catch (Throwable e) {
    }
    return ((IWSInterfaceFacade)ORMEngine.createRemoteObject(WSConfig.getSrvURL(), "com.kingdee.eas.custom.WSInterface.WSInterfaceFacade", IWSInterfaceFacade.class));
  }

  
  private BeanConvertHelper getBeanConvertor()
  {
    return new BeanConvertHelper();
  }
}
