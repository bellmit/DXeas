package com.kingdee.eas.custom.workflow.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface WSWorkFlowFacadeController extends BizController
{
    public String getMessageList(Context ctx, String userNumber) throws BOSException, RemoteException;
    public String quickApprove(Context ctx, String assignIds, String ifpass, String opinion, String policy, String userNumber) throws BOSException, RemoteException;
    public String getApproveHistory(Context ctx, String billId) throws BOSException, RemoteException;
    public String getMessageDetailList(Context ctx, String userNumber) throws BOSException, RemoteException;
    public void updateMesStatusById(Context ctx, String messageId) throws BOSException, RemoteException;
    public String getUserInfoByXtId(Context ctx, String xtId) throws BOSException, RemoteException;
    public String getFNumberByPhone(Context ctx, String phone) throws BOSException, EASBizException, RemoteException;
    public String submitApprove(Context ctx, String jsonStr) throws BOSException, RemoteException;
}