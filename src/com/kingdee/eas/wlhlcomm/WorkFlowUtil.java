package com.kingdee.eas.wlhlcomm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.workflow.ProcessInstInfo;
import com.kingdee.bos.workflow.service.ormrpc.EnactmentServiceFactory;
import com.kingdee.bos.workflow.service.ormrpc.IEnactmentService;

/**
 * 工作流 工具类
 * @author USER
 *
 */
public class WorkFlowUtil {
	/**
	 * 校验单据编号是否正在流程中
	 * @param ctx
	 * @param id
	 * @return
	 * @throws BOSException
	 */
	public static boolean checkBillInWorkflow(Context ctx, String id) throws BOSException {  
        ProcessInstInfo instInfo = null;  
        ProcessInstInfo procInsts[] = null;  
       
        IEnactmentService service2 = null;
        if(ctx != null){
        	service2 = EnactmentServiceFactory.createEnactService(ctx); 
        }else{
        	service2 = EnactmentServiceFactory.createRemoteEnactService();  
        }
        procInsts = service2.getProcessInstanceByHoldedObjectId(id);  
        int i = 0;  
        for (int n = procInsts.length; i < n; i++)  
            if("open.running".equals(procInsts[i].getState()) || "open.not_running.suspended".equals(procInsts[i].getState()))  
                instInfo = procInsts[i];  
        if (instInfo != null) {  
            return true;  
        }  
        return false;  
    }  
}
