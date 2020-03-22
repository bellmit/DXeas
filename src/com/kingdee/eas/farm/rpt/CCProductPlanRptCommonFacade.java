package com.kingdee.eas.farm.rpt;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.rpt.app.CCProductPlanRptBean;
import com.kingdee.eas.farm.rpt.app.*;
import java.util.List;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.breed.HenhouseType;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public class CCProductPlanRptCommonFacade extends AbstractBizCtrl implements ICCProductPlanRptCommonFacade
{
    public CCProductPlanRptCommonFacade()
    {
        super();
        registerInterface(ICCProductPlanRptCommonFacade.class, this);
    }
    public CCProductPlanRptCommonFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICCProductPlanRptCommonFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("553402DB");
    }
    private CCProductPlanRptCommonFacadeController getController() throws BOSException
    {
        return (CCProductPlanRptCommonFacadeController)getBizController();
    }
    /**
     *��ȡrptbean���������� ��ֳ��-User defined method
     *@param param param
     *@return
     */
    public List getRptBeanStorageInfos(HashMap param) throws BOSException
    {
        try {
            return getController().getRptBeanStorageInfos(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ö�Ӧrptbean�е� ��ֳ�������� ����������  �ƻ� ��Ϣ-User defined method
     *@param ccRptBean ������ֳ����Ϣ��bean
     *@param inValidPlanIDs ��Ч�ļƻ�ID
     *@param filterBeginDate filterBeginDate
     *@param filterEndDate filterEndDate
     *@param breedDays breedDays
     *@return
     */
    public List getStoorgPlanInfo(CCProductPlanRptBean ccRptBean, List inValidPlanIDs, Date filterBeginDate, Date filterEndDate, int breedDays) throws BOSException
    {
        try {
            return getController().getStoorgPlanInfo(getContext(), ccRptBean, inValidPlanIDs, filterBeginDate, filterEndDate, breedDays);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ ��ֳ�� ����������������Ϣ-User defined method
     *@param ccRptBean ccRptBean
     *@param filterBeginDate filterBeginDate
     *@param filterEndDate filterEndDate
     *@param breedDays breedDays
     *@return
     */
    public List getStoorgBatchInfo(CCProductPlanRptBean ccRptBean, Date filterBeginDate, Date filterEndDate, int breedDays) throws BOSException
    {
        try {
            return getController().getStoorgBatchInfo(getContext(), ccRptBean, filterBeginDate, filterEndDate, breedDays);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCurrentBreedModelInfo-User defined method
     *@param houseType �������
     *@return
     */
    public BreedModelInfo getCurrentBreedModelInfo(HenhouseType houseType) throws BOSException
    {
        try {
            return getController().getCurrentBreedModelInfo(getContext(), houseType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ǰһ������ձ�����ȡ�ձ���Ӧ�Ĵ����������û����ֱ�ӷ��ش�������۴�����-User defined method
     *@param stoorgID ����ID
     *@param batchID ����ID
     *@param bizdate ����
     *@param henhouseID ����ID
     *@param henhouseIDs ��֯�ɣ�'','',''���ĸ�ʽ�ļ���id
     *@param theoryQty �������۴�����
     *@return
     */
    public int getCCPredateHenqty(String stoorgID, String batchID, Date bizdate, String henhouseID, String henhouseIDs, int theoryQty) throws BOSException
    {
        try {
            return getController().getCCPredateHenqty(getContext(), stoorgID, batchID, bizdate, henhouseID, henhouseIDs, theoryQty);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ����ʵ�ʳ�����-User defined method
     *@param stoorgID ��ֳ��ID
     *@param batchID ����ID
     *@param bizdate ҵ������
     *@param henhouseID ����ID
     *@param henhouseIDs ��֯�ɣ�'','',''���ĸ�ʽ�ļ���id
     *@return
     */
    public int getCCActualOutHenqty(String stoorgID, String batchID, Date bizdate, String henhouseID, String henhouseIDs) throws BOSException
    {
        try {
            return getController().getCCActualOutHenqty(getContext(), stoorgID, batchID, bizdate, henhouseID, henhouseIDs);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}