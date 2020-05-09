package com.kingdee.eas.outinterface.base.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.outinterface.base.utils.IDynamicDeal;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface OutInterfaceDynamicBillFacadeController extends BizController
{
    public JSONObject getDataByID(Context ctx, String jsonStr, IDynamicDeal ideal) throws BOSException, EASBizException, RemoteException;
    public JSONObject uploadDataByBosType(Context ctx, String bosType, String jsonStr, IDynamicDeal iupload) throws BOSException, EASBizException, RemoteException;
    public JSONObject getBillList(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public JSONObject getEumInfo(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public JSONObject exeFunciton(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public JSONObject uploadData(Context ctx, String bosType, String jsonStr, IDynamicDeal iupload) throws BOSException, EASBizException, RemoteException;
    public JSONObject deleteData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public JSONObject uploadAttachment(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public JSONObject getAttachmentList(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public JSONObject getAttachmentData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public JSONObject deleteAttachment(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public JSONObject getRptData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public JSONObject getDataByNumber(Context ctx, String jsonStr, IDynamicDeal ideal) throws BOSException, EASBizException, RemoteException;
    public JSONObject updateData(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
}