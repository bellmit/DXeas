package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import java.util.Map;
import java.util.List;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialSalesInfo;
import com.kingdee.eas.custom.salediscount.app.*;
import java.math.BigDecimal;
import com.kingdee.eas.custom.ResultInfo;
import com.kingdee.bos.util.*;

public class DiscountFacade extends AbstractBizCtrl implements IDiscountFacade
{
    public DiscountFacade()
    {
        super();
        registerInterface(IDiscountFacade.class, this);
    }
    public DiscountFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IDiscountFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("334BCEF6");
    }
    private DiscountFacadeController getController() throws BOSException
    {
        return (DiscountFacadeController)getBizController();
    }
    /**
     *��ѯ��˾����������Ϣ-User defined method
     *@param companyID ��˾ID
     *@return
     */
    public DiscountCompanyInfo getCompanyDSSet(String companyID) throws BOSException
    {
        try {
            return getController().getCompanyDSSet(getContext(), companyID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ָ�����ϵĻ����۸�-User defined method
     *@param CUid ������Ƶ�Ԫ
     *@param materialID ����id
     *@param unitID ������λID
     *@return
     */
    public BigDecimal getMaterialBasePrice(String CUid, String materialID, String unitID) throws BOSException
    {
        try {
            return getController().getMaterialBasePrice(getContext(), CUid, materialID, unitID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������۱��ʽ�����ý��-User defined method
     *@param saleOrgUnitID ������֯ID
     *@param customerID �ͻ�ID
     *@param materialID ����ID
     *@param noDSQty ����ǰ����
     *@param basePrice �����۸�
     *@param date ����
     *@param coefficient ����ϵ��
     *@param dsGridLogs ǰ̨�������־
     *@param seq �к�
     *@param saleOrderID ����ID
     *@param validOrderEntryIDs ��Ч�Ķ�����¼ID
     *@param isSaleReturns �Ƿ����˻����뵥
     *@param materialQtyMap ������¼����������
     *@return
     */
    public ResultInfo getLiDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            return getController().getLiDiscountValue(getContext(), saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����������-User defined method
     *@param saleOrgUnitID ������֯ID
     *@param customerID �ͻ�ID
     *@param materialID ����ID
     *@param noDSQty ����ǰ����
     *@param basePrice �����۸�
     *@param date ����
     *@param coefficient ����ϵ��
     *@param dsGridLogs ������־
     *@param seq �к�
     *@param saleOrderID ����ID
     *@param validOrderEntryIDs ��Ч�Ķ���ID
     *@param isSaleReturns �Ƿ����˻����뵥
     *@param materialQtyMap ��¼������ϸ
     *@return
     */
    public ResultInfo getZengBaoDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            return getController().getZengBaoDiscountValue(getContext(), saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������۽������۱��ʽ-User defined method
     *@param saleOrgUnitID ������֯id
     *@param customerID �ͻ�ID
     *@param materialID ����ID
     *@param noDSQty ����ǰ����
     *@param basePrice �����۸�
     *@param date ����
     *@param coefficient ϵ��
     *@param dsGridLogs ������־
     *@param seq �к�
     *@param saleOrderID ����ID
     *@param validOrderEntryIDs ��Ч�Ķ�����¼ID
     *@param isSaleReturns �Ƿ����˻����뵥
     *@param materialQtyMap ��¼������ϸ
     *@return
     */
    public ResultInfo getMonthDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            return getController().getMonthDiscountValue(getContext(), saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������� �� ���۱��ʽ-User defined method
     *@param saleOrgUnitID ������֯ID
     *@param customerID �ͻ�ID
     *@param materialID ����ID
     *@param noDSQty ����ǰ����
     *@param basePrice �����۸�
     *@param date ����
     *@param coefficient ����ϵ��
     *@param dsGridLogs ������־
     *@param seq �к�
     *@param saleOrderID ����ID
     *@param validOrderEntryIDs ��Ч�Ķ�����¼ID
     *@param isSaleReturns �Ƿ����˻����뵥
     *@param materialQtyMap ��¼������ϸ
     *@return
     */
    public ResultInfo getYearDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            return getController().getYearDiscountValue(getContext(), saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *������϶�Ӧ�۸����ߵ� �۸���������ڼ۸����ߣ���ȡ��Ӧ���ϻ����۸�*��λϵ���ļ۸���Ϊ  ���߼۸�-User defined method
     *@param companyID ��˾id
     *@param customerID �ͻ�ID
     *@param materialID ����ID
     *@param bizDate ҵ������
     *@param orderQty ��������
     *@param unitID ������λID
     *@return
     */
    public BigDecimal getMaterialPolicyPrice(String companyID, String customerID, String materialID, String bizDate, BigDecimal orderQty, String unitID) throws BOSException
    {
        try {
            return getController().getMaterialPolicyPrice(getContext(), companyID, customerID, materialID, bizDate, orderQty, unitID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�������µ��ݷ�¼״̬-User defined method
     *@param entryIDs ��¼id
     *@param entryState ���º��״̬  1 ����  2  ����
     */
    public void updateDSEntryState(List entryIDs, String entryState) throws BOSException
    {
        try {
            getController().updateDSEntryState(getContext(), entryIDs, entryState);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�жϹ�˾�Ƿ��������ô���-User defined method
     *@param saleOrgUnitID ������֯id
     *@return
     */
    public boolean isEnableDiscount(String saleOrgUnitID) throws BOSException
    {
        try {
            return getController().isEnableDiscount(getContext(), saleOrgUnitID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ָ�����������ü�����־-User defined method
     *@param orderID ����id
     */
    public void removeOrderDsgridLogs(String orderID) throws BOSException
    {
        try {
            getController().removeOrderDsgridLogs(getContext(), orderID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ָ���ͻ����ϼ��ͻ�ID-User defined method
     *@param customerID �ͻ�ID
     *@return
     */
    public String getParentCustomer(String customerID) throws BOSException
    {
        try {
            return getController().getParentCustomer(getContext(), customerID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��÷�����������-User defined method
     *@param saleOrgUnitID ������֯ID
     *@param customerID �ͻ�ID
     *@param materialID ����ID
     *@param noDSQty �����ۿ�����
     *@param basePrice �����۸�
     *@param date ����
     *@param coefficient ����ϵ��
     *@param dsGridLogs ������־
     *@param seq �к�
     *@param saleOrderID ����ID
     *@param validOrderEntryIDs ��Ч�Ķ�����¼ID
     *@param isSaleReturns �Ƿ����˻����뵥
     *@param materialQtyMap ��÷�¼������ϸ
     *@return
     */
    public ResultInfo getFenxiaoDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            return getController().getFenxiaoDiscountValue(getContext(), saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ö����ݴ��������־��¼-User defined method
     *@param orderID ����id
     *@return
     */
    public List getOrderDiscountGridLogs(String orderID) throws BOSException
    {
        try {
            return getController().getOrderDiscountGridLogs(getContext(), orderID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ɾ��ָ���Ķ�����¼������������־��Ϣ-User defined method
     *@param saleOrderID ����ID
     *@param validSaleOrderEntryID ��Ч������¼ID
     */
    public void removeOrderEntryDsgridLogs(String saleOrderID, String validSaleOrderEntryID) throws BOSException
    {
        try {
            getController().removeOrderEntryDsgridLogs(getContext(), saleOrderID, validSaleOrderEntryID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *isDiscountUsed-User defined method
     *@param dsBillID ��������ID
     *@param dsEntryID ���߷�¼ID
     *@return
     */
    public boolean isDiscountUsed(String dsBillID, String dsEntryID) throws BOSException
    {
        try {
            return getController().isDiscountUsed(getContext(), dsBillID, dsEntryID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�Ƿ�У��ͻ�Ӧ�����-User defined method
     *@param companyID ��˾ID
     *@return
     */
    public boolean isCheckCustomerBalance(String companyID) throws BOSException
    {
        try {
            return getController().isCheckCustomerBalance(getContext(), companyID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�Ƿ�У�����Ͽ��-User defined method
     *@param companyID ��˾ID
     *@return
     */
    public boolean isCheckMaterialInventory(String companyID) throws BOSException
    {
        try {
            return getController().isCheckMaterialInventory(getContext(), companyID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ָ��ʱ��� ָ�����͵Ķ�����������-User defined method
     *@param companyID ��˾
     *@param beginTime ��ʼʱ��
     *@param entTime ����ʱ��
     *@param discountType �������
     *@param periodInfo �ڼ�
     *@return
     */
    public Map getDiscountInfos(String companyID, Date beginTime, Date entTime, String discountType, PeriodInfo periodInfo) throws BOSException
    {
        try {
            return getController().getDiscountInfos(getContext(), companyID, beginTime, entTime, discountType, periodInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����ɵ���ƽ̨���ɵ����ü�¼��-User defined method
     *@param companyInfo ��˾
     *@param discountType �������
     *@param bizDate ��¼��ҵ������
     *@param adjustDSInfos ��Ҫ����ĵ�����Ϣ
     *@param adjustType tiaozhengfangshi
     *@return
     */
    public ResultInfo addDiscountRecords(CompanyOrgUnitInfo companyInfo, String discountType, Date bizDate, List adjustDSInfos, String adjustType) throws BOSException
    {
        try {
            return getController().addDiscountRecords(getContext(), companyInfo, discountType, bizDate, adjustDSInfos, adjustType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����۶����������ü�¼��-User defined method
     *@param companyID ��˾ID
     *@param discountTypes ��Ҫ���ɽ��㵥��  ���������б�
     *@param customerList �ͻ��б�
     *@param beginDate ��ʼʱ��
     *@param endDate ��������
     *@return
     */
    public boolean generateDiscountRecordbill(String companyID, List discountTypes, List customerList, Date beginDate, Date endDate) throws BOSException
    {
        try {
            return getController().generateDiscountRecordbill(getContext(), companyID, discountTypes, customerList, beginDate, endDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡָ���� ������Ϣ-User defined method
     *@param companyID ��˾ID
     *@param discountTypes ��������
     *@param beginDate ��ʼʱ��
     *@param endDate ����ʱ��
     *@param customers �ͻ�
     *@param isNotReceiving isNotReceiving
     *@param isHaveReceiving ������
     *@return
     */
    public List getDiscountCashInfos(String companyID, List discountTypes, Date beginDate, Date endDate, List customers, boolean isNotReceiving, boolean isHaveReceiving) throws BOSException
    {
        try {
            return getController().getDiscountCashInfos(getContext(), companyID, discountTypes, beginDate, endDate, customers, isNotReceiving, isHaveReceiving);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����տ-User defined method
     *@param companyID ��˾id
     *@param receivRecords ��Ҫ�����  ��¼��
     *@return
     */
    public boolean generateReceiveBills(String companyID, Map receivRecords) throws BOSException
    {
        try {
            return getController().generateReceiveBills(getContext(), companyID, receivRecords);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�жϵ����Ƿ��Ѿ����������ε���-User defined method
     *@param srcBillID ����ID
     *@param SrcBosType SrcBosType
     *@return
     */
    public boolean isExistDestBill(String srcBillID, String SrcBosType) throws BOSException
    {
        try {
            return getController().isExistDestBill(getContext(), srcBillID, SrcBosType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�ж϶�Ӧ�������ߵķ�¼�Ƿ�������������ظ�-User defined method
     *@param customerID �ͻ�ID
     *@param materialID ����ID
     *@param dsType �������
     *@param dsNameType �������
     *@param beginDate ��ʼʱ��
     *@param endDate ����ʱ��
     *@param dsInfoID ��ǰ����ID
     *@return
     */
    public boolean isExistDSInfos(String customerID, String materialID, String dsType, String dsNameType, String beginDate, String endDate, String dsInfoID) throws BOSException
    {
        try {
            return getController().isExistDSInfos(getContext(), customerID, materialID, dsType, dsNameType, beginDate, endDate, dsInfoID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�ж϶�Ӧ�������ߵķ�¼�Ƿ�������������ظ�-User defined method
     *@param discountSetID ����ID
     *@return
     */
    public Object isExistDSInfos(String discountSetID) throws BOSException
    {
        try {
            return getController().isExistDSInfos(getContext(), discountSetID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���ָ�����ϵ� ��������-User defined method
     *@param materialID materialID
     *@param companyID companyID
     *@return
     */
    public MaterialSalesInfo getMaterialSaleinfo(String materialID, String companyID) throws BOSException
    {
        try {
            return getController().getMaterialSaleinfo(getContext(), materialID, companyID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getInventoryInfo-User defined method
     *@param matid ����ID
     *@param ouid ��֯ID
     *@return
     */
    public MaterialInventoryInfo getInventoryInfo(String matid, String ouid) throws BOSException
    {
        try {
            return getController().getInventoryInfo(getContext(), matid, ouid);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ÿͻ���ָ����˾�ض�ʱ����ĳ�����Ϸ���������ϼ�-User defined method
     *@param companyID ��˾ID
     *@param customerID �ͻ�ID
     *@param materialGroupLongNumber ���Ϸ��೤����
     *@param materialID ����ID
     *@param accumulateBeginDate �ۼƿ�ʼʱ��
     *@param accumulateEndDate �ۼƽ���ʱ��
     *@param billBizDate ����ҵ������
     *@return
     */
    public BigDecimal getCusMaterialGroupSaleBaseQty(String companyID, String customerID, String materialGroupLongNumber, String materialID, Date accumulateBeginDate, Date accumulateEndDate, Date billBizDate) throws BOSException
    {
        try {
            return getController().getCusMaterialGroupSaleBaseQty(getContext(), companyID, customerID, materialGroupLongNumber, materialID, accumulateBeginDate, accumulateEndDate, billBizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ѯ���ϵ�����-User defined method
     *@param saleOrgUnitID saleOrgUnitID
     *@param materialID materialID
     *@return
     */
    public BigDecimal getMaterialBagQty(String saleOrgUnitID, String materialID) throws BOSException
    {
        try {
            return getController().getMaterialBagQty(getContext(), saleOrgUnitID, materialID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}