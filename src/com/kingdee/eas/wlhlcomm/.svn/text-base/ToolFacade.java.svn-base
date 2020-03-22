package com.kingdee.eas.wlhlcomm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.List;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.eas.wlhlcomm.app.*;
import com.kingdee.eas.basedata.scm.sd.sale.MaterialBasePriceInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class ToolFacade extends AbstractBizCtrl implements IToolFacade
{
    public ToolFacade()
    {
        super();
        registerInterface(IToolFacade.class, this);
    }
    public ToolFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IToolFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D0C1A963");
    }
    private ToolFacadeController getController() throws BOSException
    {
        return (ToolFacadeController)getBizController();
    }
    /**
     *execute-User defined method
     *@param sql sql
     */
    public void execute(String sql) throws BOSException
    {
        try {
            getController().execute(getContext(), sql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *executeQuery-User defined method
     *@param sql sql
     *@return
     */
    public IRowSet executeQuery(String sql) throws BOSException
    {
        try {
            return getController().executeQuery(getContext(), sql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *execute-User defined method
     *@param sql sql
     *@param params params
     */
    public void execute(String sql, Object[] params) throws BOSException
    {
        try {
            getController().execute(getContext(), sql, params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *executeQuery-User defined method
     *@param sql sql
     *@param params params
     *@return
     */
    public IRowSet executeQuery(String sql, Object[] params) throws BOSException
    {
        try {
            return getController().executeQuery(getContext(), sql, params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取物料基本价格设置-User defined method
     *@param adminCUID 控制单元ID
     *@param priceTypeID 价格类型ID
     *@param materialID 物料ID
     *@param unitID 计量单位ID
     *@param currencyID 币别ID
     *@return
     */
    public MaterialBasePriceInfo getMaterialBasePrice(String adminCUID, String priceTypeID, String materialID, String unitID, String currencyID) throws BOSException
    {
        try {
            return getController().getMaterialBasePrice(getContext(), adminCUID, priceTypeID, materialID, unitID, currencyID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取启用状态的后台事务定义-User defined method
     *@param jobName 事务名称
     *@return
     */
    public List getEnableJobs(String jobName) throws BOSException
    {
        try {
            return getController().getEnableJobs(getContext(), jobName);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getJobByNames-User defined method
     *@param jobNames jobNames
     *@return
     */
    public List getJobByNames(String[] jobNames) throws BOSException
    {
        try {
            return getController().getJobByNames(getContext(), jobNames);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getInOutStoreGatherParam-User defined method
     *@param stoorgID stoorgID
     *@param warehouseID warehouseID
     *@param beginDate beginDate
     *@param endDate endDate
     *@param matid matid
     *@return
     */
    public RptParams getInOutStoreGatherParam(String stoorgID, String warehouseID, Date beginDate, Date endDate, String matid) throws BOSException
    {
        try {
            return getController().getInOutStoreGatherParam(getContext(), stoorgID, warehouseID, beginDate, endDate, matid);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getInOutStoreGatherParamArray-User defined method
     *@param stoArray stoArray
     *@param wareid wareid
     *@param beginDate beginDate
     *@param endDate endDate
     *@param matid matid
     *@return
     */
    public RptParams getInOutStoreGatherParamArray(StorageOrgUnitInfo[] stoArray, String wareid, Date beginDate, Date endDate, String matid) throws BOSException
    {
        try {
            return getController().getInOutStoreGatherParamArray(getContext(), stoArray, wareid, beginDate, endDate, matid);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}