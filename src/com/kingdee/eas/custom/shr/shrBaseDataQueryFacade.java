package com.kingdee.eas.custom.shr;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.util.ArrayList;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.shr.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class shrBaseDataQueryFacade extends AbstractBizCtrl implements IshrBaseDataQueryFacade
{
    public shrBaseDataQueryFacade()
    {
        super();
        registerInterface(IshrBaseDataQueryFacade.class, this);
    }
    public shrBaseDataQueryFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IshrBaseDataQueryFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("31F946A0");
    }
    private shrBaseDataQueryFacadeController getController() throws BOSException
    {
        return (shrBaseDataQueryFacadeController)getBizController();
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]���ص��ǳ��λ�����վ��Ļ������ϣ����ƣ�[%returndesc]-User defined method
     *@param queryStr ��ѯ���ַ���
     *@return
     */
    public ArrayList queryForBusList(String queryStr) throws BOSException
    {
        try {
            return getController().queryForBusList(getContext(), queryStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ѯ���е�վ��-User defined method
     *@param sqlStopList ��ѯվ����Ϣ��sql
     *@return
     */
    public ArrayList queryForStopList(String sqlStopList) throws BOSException
    {
        try {
            return getController().queryForStopList(getContext(), sqlStopList);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]ִ��update������Ҫ����ֵ[%returndesc]-User defined method
     *@param excuteStr    
     */
    public void excuteBusAndStop(String excuteStr) throws BOSException
    {
        try {
            getController().excuteBusAndStop(getContext(), excuteStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ѯԱ������Ϣ-User defined method
     *@param sqlPerson ��ѯ������������Ա
     *@return
     */
    public ArrayList queryForEmpInfo(String sqlPerson) throws BOSException
    {
        try {
            return getController().queryForEmpInfo(getContext(), sqlPerson);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ѯͨ����Ϣ��ȫ��Ա��-User defined method
     *@param updateDate ���θ�������
     *@return
     */
    public String queryForOtherPerson(String updateDate) throws BOSException
    {
        try {
            return getController().queryForOtherPerson(getContext(), updateDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}