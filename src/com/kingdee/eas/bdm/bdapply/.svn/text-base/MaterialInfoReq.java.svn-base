package com.kingdee.eas.bdm.bdapply;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.bdm.bdapply.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MaterialInfoReq extends CoreBillBase implements IMaterialInfoReq
{
    public MaterialInfoReq()
    {
        super();
        registerInterface(IMaterialInfoReq.class, this);
    }
    public MaterialInfoReq(Context ctx)
    {
        super(ctx);
        registerInterface(IMaterialInfoReq.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("126A0892");
    }
    private MaterialInfoReqController getController() throws BOSException
    {
        return (MaterialInfoReqController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MaterialInfoReqCollection getMaterialInfoReqCollection() throws BOSException
    {
        try {
            return getController().getMaterialInfoReqCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param view 取集合
     *@return
     */
    public MaterialInfoReqCollection getMaterialInfoReqCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMaterialInfoReqCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param oql 取集合
     *@return
     */
    public MaterialInfoReqCollection getMaterialInfoReqCollection(String oql) throws BOSException
    {
        try {
            return getController().getMaterialInfoReqCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MaterialInfoReqInfo getMaterialInfoReqInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialInfoReqInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
     *@return
     */
    public MaterialInfoReqInfo getMaterialInfoReqInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialInfoReqInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param oql 取值
     *@return
     */
    public MaterialInfoReqInfo getMaterialInfoReqInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialInfoReqInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *物料资料审核-User defined method
     *@param model model
     */
    public void materialInfoAudit(MaterialInfoReqInfo model) throws BOSException
    {
        try {
            getController().materialInfoAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *资料审核不通过-User defined method
     *@param model model
     */
    public void basenotby(MaterialInfoReqInfo model) throws BOSException
    {
        try {
            getController().basenotby(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *批量审核-User defined method
     *@param model model
     */
    public void allAudit(MaterialInfoReqInfo model) throws BOSException
    {
        try {
            getController().allAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}