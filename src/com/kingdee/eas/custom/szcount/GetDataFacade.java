package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.szcount.app.*;
import com.kingdee.bos.util.*;

public class GetDataFacade extends AbstractBizCtrl implements IGetDataFacade
{
    public GetDataFacade()
    {
        super();
        registerInterface(IGetDataFacade.class, this);
    }
    public GetDataFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IGetDataFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A1DEED4F");
    }
    private GetDataFacadeController getController() throws BOSException
    {
        return (GetDataFacadeController)getBizController();
    }
    /**
     *��ȡ����-User defined method
     *@param Params ��Ҫ������
     *@return
     */
    public String GetData(String Params) throws BOSException
    {
        try {
            return getController().GetData(getContext(), Params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��òֿ�-User defined method
     *@param PersonID ��ȡ��ԱID
     *@return
     */
    public String GetWarehouse(String PersonID) throws BOSException
    {
        try {
            return getController().GetWarehouse(getContext(), PersonID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��������-User defined method
     *@param Params ��ȡ��������
     *@return
     */
    public String SaveData(String Params) throws BOSException
    {
        try {
            return getController().SaveData(getContext(), Params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ�û�����Ȩ��-User defined method
     *@param Params �û�����
     *@return
     */
    public String GetPersonPost(String Params) throws BOSException
    {
        try {
            return getController().GetPersonPost(getContext(), Params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ��ͳ����Ϣ-User defined method
     *@param params ����_������λ_�û���
     *@return
     */
    public String GetStatisticsData(String params) throws BOSException
    {
        try {
            return getController().GetStatisticsData(getContext(), params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}