package com.kingdee.eas.farm.breed;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.breed.app.*;
import java.util.Map;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.farm.breed.comm.BreedBatchDetailInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public class BreedFacade extends AbstractBizCtrl implements IBreedFacade
{
    public BreedFacade()
    {
        super();
        registerInterface(IBreedFacade.class, this);
    }
    public BreedFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("70039994");
    }
    private BreedFacadeController getController() throws BOSException
    {
        return (BreedFacadeController)getBizController();
    }
    /**
     *���ݲֿ��ü�����Ϣ-User defined method
     *@param warehouseId �ֿ�id
     *@return
     */
    public HenhouseInfo getWarehsHenhouse(String warehouseId) throws BOSException
    {
        try {
            return getController().getWarehsHenhouse(getContext(), warehouseId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����ֳ������Ϣ-User defined method
     *@param batchID ����ID
     *@param costObjectID �ɱ�����ID
     *@param bizDate ҵ������
     *@return
     */
    public BreedBatchDetailInfo getBreedBatchDetailInfos(String batchID, String costObjectID, Date bizDate) throws BOSException
    {
        try {
            return getController().getBreedBatchDetailInfos(getContext(), batchID, costObjectID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ݼ����������ֳ�淶��Ϣ-User defined method
     *@param henHouseType �������
     *@return
     */
    public BreedModelInfo getBreedModelByHouseType(String henHouseType) throws BOSException
    {
        try {
            return getController().getBreedModelByHouseType(getContext(), henHouseType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ݳɱ������ö�Ӧ��������Ϣ-User defined method
     *@param costObjectID �ɱ�����ID
     *@return
     */
    public BreedBatchInfo getBreedBatchInfoByCostObjID(String costObjectID) throws BOSException
    {
        try {
            return getController().getBreedBatchInfoByCostObjID(getContext(), costObjectID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ���ε���ǰ���ڵ����������-User defined method
     *@param batchID ����ID
     *@param bizDate ҵ������
     *@return
     */
    public HashMap getBatchWeekages(String batchID, Date bizDate) throws BOSException
    {
        try {
            return getController().getBatchWeekages(getContext(), batchID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���������ö�Ӧ����ֳ�淶����-User defined method
     *@param modelID modelid
     *@param week week  ���ɺͲ�������
     *@param days ���� ��Ʒ����
     *@return
     */
    public BreedModelEntryInfo getBreedModelEntryInfo(String modelID, int week, int days) throws BOSException
    {
        try {
            return getController().getBreedModelEntryInfo(getContext(), modelID, week, days);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *У��ָ����������Ϣ�Ƿ��Ѿ����ɹ��ձ���-User defined method
     *@param batchID batchID
     *@param henHouseType �������
     *@return
     */
    public boolean isBatchGeneratedDailyInfos(String batchID, String henHouseType) throws BOSException
    {
        try {
            return getController().isBatchGeneratedDailyInfos(getContext(), batchID, henHouseType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��Ʒ�����շ�¼��������-User defined method
     *@param breedBatchID ����id
     *@param henhouseID ����ID
     *@param bizDate ҵ������
     *@return
     */
    public int getCommecialBatchDayage(String breedBatchID, String henhouseID, Date bizDate) throws BOSException
    {
        try {
            return getController().getCommecialBatchDayage(getContext(), breedBatchID, henhouseID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡָ�����εĵ�ǰ������-User defined method
     *@param batchID ����ID
     *@param bizDate ����
     *@return
     */
    public Map getBatchBreedingStock(String batchID, Date bizDate) throws BOSException
    {
        try {
            return getController().getBatchBreedingStock(getContext(), batchID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�ų���ǰID-User defined method
     *@param breedBatchID ����ID
     *@param bizDate ҵ������
     *@param henhouseType �������
     *@param dailyID ��ǰ�ձ�id
     *@return
     */
    public boolean checkDateDailyState(String breedBatchID, Date bizDate, String henhouseType, String dailyID) throws BOSException
    {
        try {
            return getController().checkDateDailyState(getContext(), breedBatchID, bizDate, henhouseType, dailyID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�������ָ������ı����-User defined method
     *@param batchID ����ID
     *@param henhouseID ����ID
     *@param bizDate ҵ������
     *@param chikenType �����
     *@return
     */
    public int getBatchEntryEditInfos(String batchID, String henhouseID, Date bizDate, String chikenType) throws BOSException
    {
        try {
            return getController().getBatchEntryEditInfos(getContext(), batchID, henhouseID, bizDate, chikenType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡָ����ֳ������ĳɱ�����-User defined method
     *@param farmID ��ֳ��ID
     *@return
     */
    public CostObjectInfo getFarmLatestCostObject(String farmID) throws BOSException
    {
        try {
            return getController().getFarmLatestCostObject(getContext(), farmID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�������η�¼����״̬�ͳ�������-User defined method
     *@param batchID ����ID
     *@param houseID ����ID
     *@param isAllOut �Ƿ���ȫ����
     *@param outQty ��������
     *@param outDate ��������
     *@return
     */
    public boolean updateBatchEntryOutState(String batchID, String houseID, boolean isAllOut, int outQty, Date outDate) throws BOSException
    {
        try {
            return getController().updateBatchEntryOutState(getContext(), batchID, houseID, isAllOut, outQty, outDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����ָ����Ʒ�����εĳ������-User defined method
     *@param batchID ����ID
     */
    public void updateBatchOutState(String batchID) throws BOSException
    {
        try {
            getController().updateBatchOutState(getContext(), batchID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *[description]��Ԥ�Ƴ������Ⱥ�˳�� ��ѯ�ƶ���������Ʒ��������Ϣ[%description][invokedemo][%invokedemo][returndesc]����ֵ��keyΪ����1,2,3,4,5[%returndesc]-User defined method
     *@param bizDate ��ѯ����
     *@param breedDays ��ֳ����
     *@param count ����
     *@return
     */
    public Map getCCBatchAgeAndQty(Date bizDate, int breedDays, int count) throws BOSException
    {
        try {
            return getController().getCCBatchAgeAndQty(getContext(), bizDate, breedDays, count);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������ֳ���ͳ������ڻ�� ��ֳ����-User defined method
     *@param stoOrgID ��ֳ��ID
     *@param outDate ��������
     *@return
     */
    public BreedBatchInfo getBreedBatchByOrgAndOutDate(String stoOrgID, Date outDate) throws BOSException
    {
        try {
            return getController().getBreedBatchByOrgAndOutDate(getContext(), stoOrgID, outDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡָ������ ָ�� �����ת��ͳ��-User defined method
     *@param batchID ����ID
     *@param henhouseID ����ID
     *@param bizDate ҵ������
     *@return
     */
    public int getBatchEntryTransQty(String batchID, String henhouseID, Date bizDate) throws BOSException
    {
        try {
            return getController().getBatchEntryTransQty(getContext(), batchID, henhouseID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ����ҩ������-User defined method
     *@param materialID ����ID
     *@return
     */
    public int getMaterialResidueDays(String materialID) throws BOSException
    {
        try {
            return getController().getMaterialResidueDays(getContext(), materialID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������ϲ�������-User defined method
     *@param materialID ����ID
     *@return
     */
    public ResidueSetInfo getMaterialResidueSet(String materialID) throws BOSException
    {
        try {
            return getController().getMaterialResidueSet(getContext(), materialID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]�����û����ڵ���ֳ�� ����Ӣ������[%returndesc]-User defined method
     *@param user �û�
     *@return
     */
    public String getPermission(UserInfo user) throws BOSException
    {
        try {
            return getController().getPermission(getContext(), user);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��� �����֯��Ӧ�� ��ֳ��-User defined method
     *@param storageID storageID
     *@return
     */
    public BreedStoorgSetInfo getStorageFarmInfo(String storageID) throws BOSException
    {
        try {
            return getController().getStorageFarmInfo(getContext(), storageID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}