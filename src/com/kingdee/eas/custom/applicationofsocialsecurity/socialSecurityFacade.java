package com.kingdee.eas.custom.applicationofsocialsecurity;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.util.ArrayList;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.applicationofsocialsecurity.app.*;
import java.util.HashMap;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class socialSecurityFacade extends AbstractBizCtrl implements IsocialSecurityFacade
{
    public socialSecurityFacade()
    {
        super();
        registerInterface(IsocialSecurityFacade.class, this);
    }
    public socialSecurityFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IsocialSecurityFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D72C1686");
    }
    private socialSecurityFacadeController getController() throws BOSException
    {
        return (socialSecurityFacadeController)getBizController();
    }
    /**
     *����shrԱ���ı����ѯshr����Ա�����Ϣ-User defined method
     *@param personNum Ա������
     *@param personName Ա������
     *@param dataBaseConnectionIngfo ���ݿ���������
     *@return
     */
    public HashMap getInfoOfPersonBaseOnNumberOrName(String personNum, String personName, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            return getController().getInfoOfPersonBaseOnNumberOrName(getContext(), personNum, personName, dataBaseConnectionIngfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���sHRϵͳ�ļ����籣״̬-User defined method
     *@param dataBaseConnectionIngfo ���ݿ���������Info
     *@return
     */
    public ArrayList getSHRSIStatus(DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            return getController().getSHRSIStatus(getContext(), dataBaseConnectionIngfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����籣״̬�����ƻ�ȡID-User defined method
     *@param SIStatusName �籣״̬����
     *@param dataBaseConnectionIngfo ���ݿ���������
     *@return
     */
    public String getSIStatusIDBaseOnHisName(String SIStatusName, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            return getController().getSIStatusIDBaseOnHisName(getContext(), SIStatusName, dataBaseConnectionIngfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����Ա�������Ŀ���籣״̬��ID����Ա�����籣״̬-User defined method
     *@param SIStatusID �籣״̬
     *@param personNum Ա������
     *@param dataBaseConnectionIngfo ���ݿ���������
     *@return
     */
    public String updateSIStatusBaseOnPersonNumAndSIStatusID(String SIStatusID, String personNum, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            return getController().updateSIStatusBaseOnPersonNumAndSIStatusID(getContext(), SIStatusID, personNum, dataBaseConnectionIngfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��shrϵͳ�л�ȡ��˾-User defined method
     *@param dataBaseConnectionIngfo ���ݿ���������
     *@return
     */
    public ArrayList getCompanyNameFromSHR(DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyNameFromSHR(getContext(), dataBaseConnectionIngfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ݹ����������sHR��Ա�������Ϣ-User defined method
     *@param dateBegin ��ְ���ڴ�
     *@param dateEnd ��ְ���ڵ�
     *@param dataBaseConnectionInfo ���ݿ���������
     *@param isIn �Ƿ���ְ
     *@param company ��˾
     *@param SIStatus �籣״̬
     *@param personName ��Ա����
     *@param personNum ��Ա����
     *@return
     */
    public ArrayList getPersonInfoByFilterItem(Date dateBegin, Date dateEnd, DataBaseConnectionInfo dataBaseConnectionInfo, boolean isIn, String company, String SIStatus, String personName, String personNum) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonInfoByFilterItem(getContext(), dateBegin, dateEnd, dataBaseConnectionInfo, isIn, company, SIStatus, personName, personNum);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}