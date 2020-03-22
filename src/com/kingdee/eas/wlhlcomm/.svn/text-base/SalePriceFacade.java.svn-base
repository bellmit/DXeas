package com.kingdee.eas.wlhlcomm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.math.BigDecimal;
import java.lang.String;
import com.kingdee.eas.wlhlcomm.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class SalePriceFacade extends AbstractBizCtrl implements ISalePriceFacade
{
    public SalePriceFacade()
    {
        super();
        registerInterface(ISalePriceFacade.class, this);
    }
    public SalePriceFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ISalePriceFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2F20860B");
    }
    private SalePriceFacadeController getController() throws BOSException
    {
        return (SalePriceFacadeController)getBizController();
    }
    /**
     *如果没取到价格政策单价 则 直接去物料对应的基本价格-User defined method
     *@param companyID companyID
     *@param customerID customerID
     *@param materialID materialID
     *@param bizDateStr 开票日期
     *@param orderQty orderQty
     *@param unitID unitID
     *@return
     */
    public BigDecimal getMaterialPolicyPrice(String companyID, String customerID, String materialID, String bizDateStr, BigDecimal orderQty, String unitID) throws BOSException
    {
        try {
            return getController().getMaterialPolicyPrice(getContext(), companyID, customerID, materialID, bizDateStr, orderQty, unitID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得指定物料的基本单价-User defined method
     *@param adminCUid adminCUid
     *@param materialID materialID
     *@param unitID unitID
     *@return
     */
    public BigDecimal getMaterialBasePrice(String adminCUid, String materialID, String unitID) throws BOSException
    {
        try {
            return getController().getMaterialBasePrice(getContext(), adminCUid, materialID, unitID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}