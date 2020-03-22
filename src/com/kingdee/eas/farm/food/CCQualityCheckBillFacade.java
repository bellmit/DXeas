package com.kingdee.eas.farm.food;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.util.ArrayList;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.farm.food.app.*;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class CCQualityCheckBillFacade extends AbstractBizCtrl implements ICCQualityCheckBillFacade
{
    public CCQualityCheckBillFacade()
    {
        super();
        registerInterface(ICCQualityCheckBillFacade.class, this);
    }
    public CCQualityCheckBillFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICCQualityCheckBillFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("871FF6B4");
    }
    private CCQualityCheckBillFacadeController getController() throws BOSException
    {
        return (CCQualityCheckBillFacadeController)getBizController();
    }
    /**
     *[description]����ҵ�����ڻ�ȡ�ʼ���Ϣ[%description][invokedemo][%invokedemo][returndesc]�ʼ쵥info��list[%returndesc]-User defined method
     *@param bizDate ҵ������
     *@param stoOrgUnitID �����֯ID
     *@return
     */
    public ArrayList getQualityCheckInfoByBizDate(Date bizDate, String stoOrgUnitID) throws BOSException, EASBizException
    {
        try {
            return getController().getQualityCheckInfoByBizDate(getContext(), bizDate, stoOrgUnitID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}