package com.kingdee.eas.custom.taihe.contract.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.taihe.contract.BatchContractCollection;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.taihe.contract.BatchContractInfo;
import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlBillBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BatchContractController extends WlhlBillBaseController
{
    public BatchContractCollection getBatchContractCollection(Context ctx) throws BOSException, RemoteException;
    public BatchContractCollection getBatchContractCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BatchContractCollection getBatchContractCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public BatchContractInfo getBatchContractInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BatchContractInfo getBatchContractInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BatchContractInfo getBatchContractInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void distribution(Context ctx, BatchContractInfo model) throws BOSException, RemoteException;
    public void close(Context ctx, BatchContractInfo model) throws BOSException, RemoteException;
    public void backClose(Context ctx, BatchContractInfo model) throws BOSException, RemoteException;
    public void allAudit(Context ctx, BatchContractInfo model) throws BOSException, RemoteException;
}