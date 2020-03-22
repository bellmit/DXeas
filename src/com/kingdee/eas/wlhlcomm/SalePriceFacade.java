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
     *���ûȡ���۸����ߵ��� �� ֱ��ȥ���϶�Ӧ�Ļ����۸�-User defined method
     *@param companyID companyID
     *@param customerID customerID
     *@param materialID materialID
     *@param bizDateStr ��Ʊ����
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
     *���ָ�����ϵĻ�������-User defined method
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