package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
import java.util.Map;
import java.lang.String;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class hatchFacade extends AbstractBizCtrl implements IhatchFacade
{
    public hatchFacade()
    {
        super();
        registerInterface(IhatchFacade.class, this);
    }
    public hatchFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IhatchFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B544A64C");
    }
    private hatchFacadeController getController() throws BOSException
    {
        return (hatchFacadeController)getBizController();
    }
    /**
     *�������ͣ�����+������+�����ڸò��������պϸ���-User defined method
     *@param period �ڼ䣨�·ݣ�
     *@return
     */
    public Map getLayEggPlan(PeriodInfo period) throws BOSException
    {
        try {
            return getController().getLayEggPlan(getContext(), period);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ĳ�������Ļ�������-User defined method
     *@return
     */
    public HatchBaseDataInfo getHatchBaseData() throws BOSException
    {
        try {
            return getController().getHatchBaseData(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ĳһ������������ƻ�-User defined method
     *@param pkDate ����
     *@return
     */
    public Map getCCBreedInfo(Date pkDate) throws BOSException
    {
        try {
            return getController().getCCBreedInfo(getContext(), pkDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��������  ����+���ղ�������-User defined method
     *@param period �ڼ�
     *@return
     */
    public Map getLayEggPlanTotal(PeriodInfo period) throws BOSException
    {
        try {
            return getController().getLayEggPlanTotal(getContext(), period);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ĳ�������Ļ�������-User defined method
     *@param stoOrg �����������֯
     *@return
     */
    public HatchBaseDataInfo getHatchBaseData(StorageOrgUnitInfo stoOrg) throws BOSException
    {
        try {
            return getController().getHatchBaseData(getContext(), stoOrg);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ִ��sql���-User defined method
     *@param sql sql
     */
    public void excuteSql(String sql) throws BOSException, EASBizException
    {
        try {
            getController().excuteSql(getContext(), sql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}