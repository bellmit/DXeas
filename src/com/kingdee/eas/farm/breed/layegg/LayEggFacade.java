package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.util.List;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.breed.layegg.app.*;
import com.kingdee.bos.util.*;

public class LayEggFacade extends AbstractBizCtrl implements ILayEggFacade
{
    public LayEggFacade()
    {
        super();
        registerInterface(ILayEggFacade.class, this);
    }
    public LayEggFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ILayEggFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6D392CC8");
    }
    private LayEggFacadeController getController() throws BOSException
    {
        return (LayEggFacadeController)getBizController();
    }
    /**
     *���ָ������� ��������-User defined method
     *@param henhouseID ����id
     *@return
     */
    public Object getHouseLayEggSet(String henhouseID) throws BOSException
    {
        try {
            return getController().getHouseLayEggSet(getContext(), henhouseID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ָ�������֯���е� ���ʹ���Ϣ-User defined method
     *@param stoOrgID �ֿ�id
     *@return
     */
    public List getConveyors(String stoOrgID) throws BOSException
    {
        try {
            return getController().getConveyors(getContext(), stoOrgID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��� ��ֳ�淶�еĲ����淶��¼��ϸ-User defined method
     *@param henType 1������2��3������
     *@return
     */
    public Map getLayeggStandard(String henType) throws BOSException
    {
        try {
            return getController().getLayeggStandard(getContext(), henType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����ι�淶-User defined method
     *@param henType ��������
     *@return
     */
    public Map getFeedStandard(String henType) throws BOSException
    {
        try {
            return getController().getFeedStandard(getContext(), henType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�ж�ָ�����ε�ָ�������Ƿ��Ѿ�����-User defined method
     *@param batchID ����ID
     *@param bizDate ҵ������
     *@return
     */
    public boolean isBatchFixed(String batchID, Date bizDate) throws BOSException
    {
        try {
            return getController().isBatchFixed(getContext(), batchID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡָ��ҵ�����ڶ�Ӧ��ֳ����  ��������-User defined method
     *@param internalFarmID �ڲ���ֳ��ID
     *@param bizDate ҵ������
     *@return
     */
    public ParentBreedBatchInfo getCurrentParentBatch(String internalFarmID, Date bizDate) throws BOSException
    {
        try {
            return getController().getCurrentParentBatch(getContext(), internalFarmID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *У��ָ������ֳ����ĳ���Ƿ��Ѿ������ձ�-User defined method
     *@param breedBatchID breedBatchID
     *@param bizDate bizDate
     *@param batchID batchID
     *@return
     */
    public boolean checkDateDailyState(String breedBatchID, Date bizDate, String batchID) throws BOSException
    {
        try {
            return getController().checkDateDailyState(getContext(), breedBatchID, bizDate, batchID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ɷ����ձ�-User defined method
     */
    public void toStockDaily() throws BOSException
    {
        try {
            getController().toStockDaily(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}