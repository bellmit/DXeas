package com.kingdee.eas.outinterface.base.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import javax.activation.DataHandler;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface OutAppInterfaceController extends BizController
{
    public String getData(Context ctx, String jarrayStr) throws BOSException, EASBizException, RemoteException;
    public String uploadData(Context ctx, String jarrayStr) throws BOSException, EASBizException, RemoteException;
    public String getList(Context ctx, String jarrayStr) throws BOSException, EASBizException, RemoteException;
    public String uploadAttachment(Context ctx, String jarrayStr) throws BOSException, EASBizException, RemoteException;
    public String getAttachment(Context ctx, String jarrayStr) throws BOSException, EASBizException, RemoteException;
    public String deleteAttachment(Context ctx, String jarrayStr) throws BOSException, EASBizException, RemoteException;
    public String uploadAttachment(Context ctx, DataHandler handler, String jarrayStr) throws BOSException, RemoteException;
    public String chekPwd(Context ctx, String jarrayStr) throws BOSException, EASBizException, RemoteException;
    public String getAttachmentList(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public String auditData(Context ctx, String jarrayStr) throws BOSException, EASBizException, RemoteException;
    public String unAuditData(Context ctx, String jarrayStr) throws BOSException, EASBizException, RemoteException;
    public String deleteData(Context ctx, String jarrayStr) throws BOSException, EASBizException, RemoteException;
    public String getEnumInfo(Context ctx, String jarrayStr) throws BOSException, EASBizException, RemoteException;
    public String exeFunction(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public String getDataByNum(Context ctx, String jarrayStr) throws BOSException, EASBizException, RemoteException;
    public String updateData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
}