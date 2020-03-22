package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.stocking.webservice.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class WSTheEggTableFacade extends AbstractBizCtrl implements IWSTheEggTableFacade
{
    public WSTheEggTableFacade()
    {
        super();
        registerInterface(IWSTheEggTableFacade.class, this);
    }
    public WSTheEggTableFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSTheEggTableFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CA18C6BA");
    }
    private WSTheEggTableFacadeController getController() throws BOSException
    {
        return (WSTheEggTableFacadeController)getBizController();
    }
    /**
     *���ý�����-User defined method
     *@param param ����
     *@return
     */
    public String createNewTheEggTable(String param) throws BOSException
    {
        try {
            return getController().createNewTheEggTable(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ�������б�-User defined method
     *@param param ����
     *@return
     */
    public String getTheEggTableList(String param) throws BOSException
    {
        try {
            return getController().getTheEggTableList(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ��ֳ��-User defined method
     *@param param ����
     *@return
     */
    public String getFarm(String param) throws BOSException
    {
        try {
            return getController().getFarm(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������ֳ����ȡ����-User defined method
     */
    public void getBatchByFarm() throws BOSException
    {
        try {
            getController().getBatchByFarm(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}