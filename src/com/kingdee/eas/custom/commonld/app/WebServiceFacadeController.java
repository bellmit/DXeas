package com.kingdee.eas.custom.commonld.app;

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

public interface WebServiceFacadeController extends BizController
{
    public String createNewBill(Context ctx, String param) throws BOSException, EASBizException, RemoteException;
    public String getBillList(Context ctx, String param) throws BOSException, EASBizException, RemoteException;
    public String getBillDetailInfo(Context ctx, String param) throws BOSException, EASBizException, RemoteException;
    public String deleteBill(Context ctx, String param) throws BOSException, EASBizException, RemoteException;
    public String getRptData(Context ctx, String param) throws BOSException, EASBizException, RemoteException;
    public String uploadBillWithArray(Context ctx, String param) throws BOSException, RemoteException;
    public String otherMethord(Context ctx, String param) throws BOSException, RemoteException;
}