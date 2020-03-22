package com.kingdee.eas.weighbridge;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.weighbridge.app.*;
import com.kingdee.bos.BOSException;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class WSWeighbridgeFacade extends AbstractBizCtrl implements IWSWeighbridgeFacade
{
    public WSWeighbridgeFacade()
    {
        super();
        registerInterface(IWSWeighbridgeFacade.class, this);
    }
    public WSWeighbridgeFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSWeighbridgeFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BB1525E8");
    }
    private WSWeighbridgeFacadeController getController() throws BOSException
    {
        return (WSWeighbridgeFacadeController)getBizController();
    }
    /**
     *�ϴ�����-User defined method
     *@param billJSON billJSON
     *@return
     */
    public String uploadBill(String billJSON) throws BOSException
    {
        try {
            return getController().uploadBill(getContext(), billJSON);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��֤�����ڲɹ�ҵ���  �����֯�Ƿ��ǵ����һ�ι���-User defined method
     *@param ctrlUnitID ctrlUnitID
     *@param stoOrgUnitID �����֯ID
     *@param bizDate bizDate
     *@return
     */
    public boolean isStorageOrgIsFirstIn(String ctrlUnitID, String stoOrgUnitID, Date bizDate) throws BOSException
    {
        try {
            return getController().isStorageOrgIsFirstIn(getContext(), ctrlUnitID, stoOrgUnitID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}