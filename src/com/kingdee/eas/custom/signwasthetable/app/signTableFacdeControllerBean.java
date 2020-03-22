package com.kingdee.eas.custom.signwasthetable.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.workflow.ProcessInstInfo;
import com.kingdee.bos.workflow.service.EnactmentServiceProxy;
import com.kingdee.bos.workflow.service.ormrpc.IEnactmentService;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;


public class signTableFacdeControllerBean extends AbstractsignTableFacdeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.signwasthetable.app.signTableFacdeControllerBean");
    /**
     * 判单单据是否在工作流中
     */
	@Override
	protected boolean _isInWorkFlow(Context ctx, String billId)
			throws BOSException {
		// TODO Auto-generated method stub
		 IEnactmentService wfService;
 		ProcessInstInfo[] processInstances=null;
 		try {
 			wfService = EnactmentServiceProxy.getEnacementService(ctx);
 	        processInstances = wfService.getProcessInstanceByHoldedObjectId(billId);//不包括已经结束的流程
 	        //ProcessInstInfo[] processInstances = wfService.getAllProcessInstancesByBizobjId(billID);//包括已经结束的流程
 		} catch (BOSException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

         if(null != processInstances &&  processInstances.length > 0)//存在流程
         	return true;
		return false;
	}
}