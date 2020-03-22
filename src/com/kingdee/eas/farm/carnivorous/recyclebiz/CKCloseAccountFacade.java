package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.recyclebiz.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class CKCloseAccountFacade extends AbstractBizCtrl implements ICKCloseAccountFacade
{
    public CKCloseAccountFacade()
    {
        super();
        registerInterface(ICKCloseAccountFacade.class, this);
    }
    public CKCloseAccountFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICKCloseAccountFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("05367C94");
    }
    private CKCloseAccountFacadeController getController() throws BOSException
    {
        return (CKCloseAccountFacadeController)getBizController();
    }
    /**
     *��ѯ�Ƿ��ѹ���-User defined method
     *@param companyID ��˾ID
     *@param periodID �ڼ�ID
     *@return
     */
    public boolean checkIsClosed(String companyID, String periodID) throws BOSException, EASBizException
    {
        try {
            return getController().checkIsClosed(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����-User defined method
     *@param companyID ��˾ID
     *@param periodID �ڼ�
     */
    public void closeAccount(String companyID, String periodID) throws BOSException, EASBizException
    {
        try {
            getController().closeAccount(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������-User defined method
     *@param companyID ��˾ID
     *@param periodID �ڼ�ID
     */
    public void unCloseAccount(String companyID, String periodID) throws BOSException, EASBizException
    {
        try {
            getController().unCloseAccount(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}