package com.kingdee.eas.custom.signwasthetable.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.signwasthetable.ContractCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ContractController extends CoreBillBaseController
{
    public ContractCollection getContractCollection(Context ctx) throws BOSException, RemoteException;
    public ContractCollection getContractCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ContractCollection getContractCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ContractInfo getContractInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ContractInfo getContractInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ContractInfo getContractInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, ContractInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, ContractInfo model) throws BOSException, EASBizException, RemoteException;
    public void cmChange(Context ctx, ContractInfo model) throws BOSException, RemoteException;
    public void upVersion(Context ctx, ContractInfo model) throws BOSException, RemoteException;
    public void toPayReq(Context ctx, ContractInfo model) throws BOSException, RemoteException;
    public void viewHistory(Context ctx, ContractInfo model) throws BOSException, RemoteException;
    public void initial(Context ctx, ContractInfo model) throws BOSException, RemoteException;
    public void refresh(Context ctx, ContractInfo model) throws BOSException, RemoteException;
    public void setBailDays(Context ctx, ContractInfo model) throws BOSException, RemoteException;
    public void overPay(Context ctx, ContractInfo model) throws BOSException, RemoteException;
    public void overView(Context ctx, ContractInfo model) throws BOSException, RemoteException;
}