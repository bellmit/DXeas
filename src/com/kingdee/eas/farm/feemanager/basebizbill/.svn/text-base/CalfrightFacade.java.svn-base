package com.kingdee.eas.farm.feemanager.basebizbill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.eas.farm.feemanager.basebizbill.app.*;
import com.kingdee.bos.util.*;

public class CalfrightFacade extends AbstractBizCtrl implements ICalfrightFacade
{
    public CalfrightFacade()
    {
        super();
        registerInterface(ICalfrightFacade.class, this);
    }
    public CalfrightFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICalfrightFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("809AAF18");
    }
    private CalfrightFacadeController getController() throws BOSException
    {
        return (CalfrightFacadeController)getBizController();
    }
    /**
     *运费计算-User defined method
     *@param carid 车辆ID
     *@param milage 里程数
     *@param material 物料id
     *@param company 财务组织
     *@return
     */
    public HashMap calfright(String carid, String milage, String material, String company) throws BOSException
    {
        try {
            return getController().calfright(getContext(), carid, milage, material, company);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *[description]查询价格是否存在[%description][invokedemo][%invokedemo][returndesc]是否存在[%returndesc]-User defined method
     *@param company 财务组织
     *@param bizdate 业务日期
     *@return
     */
    public HashMap oiljudg(String company, String bizdate) throws BOSException
    {
        try {
            return getController().oiljudg(getContext(), company, bizdate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *标准价格查询-User defined method
     *@param company 财务组织
     *@return
     */
    public HashMap oilsjudg(String company) throws BOSException
    {
        try {
            return getController().oilsjudg(getContext(), company);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}