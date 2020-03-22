package com.kingdee.eas.farm.pig;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.List;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.pig.app.*;
import com.kingdee.bos.util.*;

public class pigBaseDataFacade extends AbstractBizCtrl implements IpigBaseDataFacade
{
    public pigBaseDataFacade()
    {
        super();
        registerInterface(IpigBaseDataFacade.class, this);
    }
    public pigBaseDataFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IpigBaseDataFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D8B4F1A3");
    }
    private pigBaseDataFacadeController getController() throws BOSException
    {
        return (pigBaseDataFacadeController)getBizController();
    }
    /**
     *���ݿ����֯ID�����ֳ��-User defined method
     *@param stoOrgID �����֯ID
     *@return
     */
    public PigFarmInfo getPigfarm(String stoOrgID) throws BOSException
    {
        try {
            return getController().getPigfarm(getContext(), stoOrgID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ�ƶ���ֳ�����͵�  �ճ����߼ƻ�-User defined method
     *@param pigFarmType ��ֳ������
     *@param bizDate ҵ������
     *@return
     */
    public List getDailyImmunePlans(String pigFarmType, Date bizDate) throws BOSException
    {
        try {
            return getController().getDailyImmunePlans(getContext(), pigFarmType, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}