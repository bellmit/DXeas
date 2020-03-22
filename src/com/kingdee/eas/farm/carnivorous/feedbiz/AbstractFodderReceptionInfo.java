package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFodderReceptionInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFodderReceptionInfo()
    {
        this("id");
    }
    protected AbstractFodderReceptionInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionEntryCollection());
    }
    /**
     * Object: �������õ� 's ��¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionEntryCollection)get("entrys");
    }
    /**
     * Object:�������õ�'s �Ƿ�����ƾ֤property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:�������õ�'s ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object: �������õ� 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:�������õ�'s ���ʱ��property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object: �������õ� 's �����֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    /**
     * Object:�������õ�'s ��ʼ������property 
     */
    public boolean isIsInit()
    {
        return getBoolean("isInit");
    }
    public void setIsInit(boolean item)
    {
        setBoolean("isInit", item);
    }
    /**
     * Object: �������õ� 's ˾�� property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.DriverInfo getDriver()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.DriverInfo)get("driver");
    }
    public void setDriver(com.kingdee.eas.farm.feemanager.basedata.DriverInfo item)
    {
        put("driver", item);
    }
    /**
     * Object:�������õ�'s ���ƺ�property 
     */
    public String getCarNo()
    {
        return getString("carNo");
    }
    public void setCarNo(String item)
    {
        setString("carNo", item);
    }
    /**
     * Object:�������õ�'s ��ϵ��ʽproperty 
     */
    public String getLinkCell()
    {
        return getString("linkCell");
    }
    public void setLinkCell(String item)
    {
        setString("linkCell", item);
    }
    /**
     * Object: �������õ� 's ҵ��Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getBizPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("bizPerson");
    }
    public void setBizPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("bizPerson", item);
    }
    /**
     * Object: �������õ� 's ����Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:�������õ�'s ҵ������property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType getBillType()
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType.getEnum(getString("billType"));
    }
    public void setBillType(com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType item)
    {
		if (item != null) {
        setString("billType", item.getValue());
		}
    }
    /**
     * Object:�������õ�'s ƾ֤��property 
     */
    public String getVoucherNum()
    {
        return getString("voucherNum");
    }
    public void setVoucherNum(String item)
    {
        setString("voucherNum", item);
    }
    /**
     * Object:�������õ�'s �Ƿ��������ϳ�property 
     */
    public boolean isIsHasMaterialReq()
    {
        return getBoolean("isHasMaterialReq");
    }
    public void setIsHasMaterialReq(boolean item)
    {
        setBoolean("isHasMaterialReq", item);
    }
    /**
     * Object: �������õ� 's ���Ϲ�˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getReturnCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("returnCompany");
    }
    public void setReturnCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("returnCompany", item);
    }
    /**
     * Object:�������õ�'s ��Դ����property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.fodderSourceType getFodderSourceType()
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.fodderSourceType.getEnum(getString("fodderSourceType"));
    }
    public void setFodderSourceType(com.kingdee.eas.farm.carnivorous.feedbiz.fodderSourceType item)
    {
		if (item != null) {
        setString("fodderSourceType", item.getValue());
		}
    }
    /**
     * Object:�������õ�'s �Ƿ��������۶���property 
     */
    public boolean isIsHasSaleOrder()
    {
        return getBoolean("isHasSaleOrder");
    }
    public void setIsHasSaleOrder(boolean item)
    {
        setBoolean("isHasSaleOrder", item);
    }
    /**
     * Object:�������õ�'s �Ƿ����������˻����뵥property 
     */
    public boolean isIsHasSaleReturn()
    {
        return getBoolean("isHasSaleReturn");
    }
    public void setIsHasSaleReturn(boolean item)
    {
        setBoolean("isHasSaleReturn", item);
    }
    /**
     * Object: �������õ� 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getFarmer()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: �������õ� 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: �������õ� 's ���κ�ͬ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo getBatchContract()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo)get("batchContract");
    }
    public void setBatchContract(com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo item)
    {
        put("batchContract", item);
    }
    /**
     * Object: �������õ� 's ��ֳ���� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchInfo getBatch()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchInfo)get("batch");
    }
    public void setBatch(com.kingdee.eas.farm.carnivorous.basedata.BatchInfo item)
    {
        put("batch", item);
    }
    /**
     * Object: �������õ� 's �������� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo getSettlePolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo)get("settlePolicy");
    }
    public void setSettlePolicy(com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo item)
    {
        put("settlePolicy", item);
    }
    /**
     * Object:�������õ�'s ����property 
     */
    public int getWeekDay()
    {
        return getInt("weekDay");
    }
    public void setWeekDay(int item)
    {
        setInt("weekDay", item);
    }
    /**
     * Object:�������õ�'s ��������property 
     */
    public java.util.Date getIndate()
    {
        return getDate("indate");
    }
    public void setIndate(java.util.Date item)
    {
        setDate("indate", item);
    }
    /**
     * Object:�������õ�'s ��������property 
     */
    public java.math.BigDecimal getBatchQty()
    {
        return getBigDecimal("batchQty");
    }
    public void setBatchQty(java.math.BigDecimal item)
    {
        setBigDecimal("batchQty", item);
    }
    /**
     * Object: �������õ� 's �⹺��Ӧ�� property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object: �������õ� 's ���� property 
     */
    public com.kingdee.eas.publicdata.CarInfo getCar()
    {
        return (com.kingdee.eas.publicdata.CarInfo)get("car");
    }
    public void setCar(com.kingdee.eas.publicdata.CarInfo item)
    {
        put("car", item);
    }
    /**
     * Object:�������õ�'s �Ƿ�����property 
     */
    public boolean isIsTiLiao()
    {
        return getBoolean("isTiLiao");
    }
    public void setIsTiLiao(boolean item)
    {
        setBoolean("isTiLiao", item);
    }
    /**
     * Object:�������õ�'s �Ƿ������������ⵥproperty 
     */
    public boolean isIsOtherIssue()
    {
        return getBoolean("isOtherIssue");
    }
    public void setIsOtherIssue(boolean item)
    {
        setBoolean("isOtherIssue", item);
    }
    /**
     * Object:�������õ�'s �Ƿ��������۳���property 
     */
    public boolean isIsHasSaleIssue()
    {
        return getBoolean("isHasSaleIssue");
    }
    public void setIsHasSaleIssue(boolean item)
    {
        setBoolean("isHasSaleIssue", item);
    }
    /**
     * Object:�������õ�'s �ɵ��ϵ�����property 
     */
    public boolean isIsFromTiaoLiao()
    {
        return getBoolean("isFromTiaoLiao");
    }
    public void setIsFromTiaoLiao(boolean item)
    {
        setBoolean("isFromTiaoLiao", item);
    }
    /**
     * Object:�������õ�'s �Ƿ�ɢװproperty 
     */
    public boolean isIsSanZhuang()
    {
        return getBoolean("isSanZhuang");
    }
    public void setIsSanZhuang(boolean item)
    {
        setBoolean("isSanZhuang", item);
    }
    /**
     * Object:�������õ�'s ��ֳ���绰property 
     */
    public String getFarmerPhone()
    {
        return getString("farmerPhone");
    }
    public void setFarmerPhone(String item)
    {
        setString("farmerPhone", item);
    }
    /**
     * Object:�������õ�'s ��ֳ����ַproperty 
     */
    public String getFarmAddress()
    {
        return getString("farmAddress");
    }
    public void setFarmAddress(String item)
    {
        setString("farmAddress", item);
    }
    /**
     * Object:�������õ�'s �Ƿ����property 
     */
    public boolean isIsWeight()
    {
        return getBoolean("isWeight");
    }
    public void setIsWeight(boolean item)
    {
        setBoolean("isWeight", item);
    }
    /**
     * Object:�������õ�'s �Ѵ�ӡ����property 
     */
    public int getPrntTime()
    {
        return getInt("prntTime");
    }
    public void setPrntTime(int item)
    {
        setInt("prntTime", item);
    }
    /**
     * Object:�������õ�'s �ϲ�property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BunkerEnum getBunker()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.BunkerEnum.getEnum(getString("bunker"));
    }
    public void setBunker(com.kingdee.eas.farm.carnivorous.basedata.BunkerEnum item)
    {
		if (item != null) {
        setString("bunker", item.getValue());
		}
    }
    /**
     * Object:�������õ�'s ���ϴ������property 
     */
    public String getReturnOpinion()
    {
        return getString("returnOpinion");
    }
    public void setReturnOpinion(String item)
    {
        setString("returnOpinion", item);
    }
    /**
     * Object: �������õ� 's �ɱ����� property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCenter");
    }
    public void setCostCenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCenter", item);
    }
    /**
     * Object: �������õ� 's Ʒ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breedData");
    }
    public void setBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breedData", item);
    }
    /**
     * Object:�������õ�'s ���������property 
     */
    public java.math.BigDecimal getFeedInstance()
    {
        return getBigDecimal("feedInstance");
    }
    public void setFeedInstance(java.math.BigDecimal item)
    {
        setBigDecimal("feedInstance", item);
    }
    /**
     * Object:�������õ�'s ǰ�����м�������ϱ�׼������property 
     */
    public java.math.BigDecimal getEarlyStand()
    {
        return getBigDecimal("earlyStand");
    }
    public void setEarlyStand(java.math.BigDecimal item)
    {
        setBigDecimal("earlyStand", item);
    }
    /**
     * Object:�������õ�'s ǰ�����м���������ѿ�Ʊ������property 
     */
    public java.math.BigDecimal getEarlyVou()
    {
        return getBigDecimal("earlyVou");
    }
    public void setEarlyVou(java.math.BigDecimal item)
    {
        setBigDecimal("earlyVou", item);
    }
    /**
     * Object:�������õ�'s ǰ�����м�������������������property 
     */
    public java.math.BigDecimal getEarlyAudit()
    {
        return getBigDecimal("earlyAudit");
    }
    public void setEarlyAudit(java.math.BigDecimal item)
    {
        setBigDecimal("earlyAudit", item);
    }
    /**
     * Object:�������õ�'s ǰ�����м��������δ���������property 
     */
    public java.math.BigDecimal getEarlyUnAudit()
    {
        return getBigDecimal("earlyUnAudit");
    }
    public void setEarlyUnAudit(java.math.BigDecimal item)
    {
        setBigDecimal("earlyUnAudit", item);
    }
    /**
     * Object:�������õ�'s ǰ�����м������������Ʊ������property 
     */
    public java.math.BigDecimal getEarlyAllow()
    {
        return getBigDecimal("earlyAllow");
    }
    public void setEarlyAllow(java.math.BigDecimal item)
    {
        setBigDecimal("earlyAllow", item);
    }
    /**
     * Object:�������õ�'s �������м�������ϱ�׼������property 
     */
    public java.math.BigDecimal getMidStand()
    {
        return getBigDecimal("midStand");
    }
    public void setMidStand(java.math.BigDecimal item)
    {
        setBigDecimal("midStand", item);
    }
    /**
     * Object:�������õ�'s �������м���������ѿ�Ʊ������property 
     */
    public java.math.BigDecimal getMidVouch()
    {
        return getBigDecimal("midVouch");
    }
    public void setMidVouch(java.math.BigDecimal item)
    {
        setBigDecimal("midVouch", item);
    }
    /**
     * Object:�������õ�'s �������м�������������������property 
     */
    public java.math.BigDecimal getMidAudit()
    {
        return getBigDecimal("midAudit");
    }
    public void setMidAudit(java.math.BigDecimal item)
    {
        setBigDecimal("midAudit", item);
    }
    /**
     * Object:�������õ�'s �������м��������δ���������property 
     */
    public java.math.BigDecimal getMidUnAudit()
    {
        return getBigDecimal("midUnAudit");
    }
    public void setMidUnAudit(java.math.BigDecimal item)
    {
        setBigDecimal("midUnAudit", item);
    }
    /**
     * Object:�������õ�'s �������м������������Ʊ������property 
     */
    public java.math.BigDecimal getMidAllow()
    {
        return getBigDecimal("midAllow");
    }
    public void setMidAllow(java.math.BigDecimal item)
    {
        setBigDecimal("midAllow", item);
    }
    /**
     * Object:�������õ�'s �������м�������ϱ�׼������property 
     */
    public java.math.BigDecimal getLateStand()
    {
        return getBigDecimal("lateStand");
    }
    public void setLateStand(java.math.BigDecimal item)
    {
        setBigDecimal("lateStand", item);
    }
    /**
     * Object:�������õ�'s �������м���������ѿ�Ʊ������property 
     */
    public java.math.BigDecimal getLateVoucher()
    {
        return getBigDecimal("lateVoucher");
    }
    public void setLateVoucher(java.math.BigDecimal item)
    {
        setBigDecimal("lateVoucher", item);
    }
    /**
     * Object:�������õ�'s �������м�������������������property 
     */
    public java.math.BigDecimal getLateAudit()
    {
        return getBigDecimal("lateAudit");
    }
    public void setLateAudit(java.math.BigDecimal item)
    {
        setBigDecimal("lateAudit", item);
    }
    /**
     * Object:�������õ�'s �������м��������δ���������property 
     */
    public java.math.BigDecimal getLateUnAudit()
    {
        return getBigDecimal("lateUnAudit");
    }
    public void setLateUnAudit(java.math.BigDecimal item)
    {
        setBigDecimal("lateUnAudit", item);
    }
    /**
     * Object:�������õ�'s �������м������������Ʊ������property 
     */
    public java.math.BigDecimal getLateAllow()
    {
        return getBigDecimal("lateAllow");
    }
    public void setLateAllow(java.math.BigDecimal item)
    {
        setBigDecimal("lateAllow", item);
    }
    /**
     * Object:�������õ�'s ��ͬ����property 
     */
    public java.math.BigDecimal getContractQty()
    {
        return getBigDecimal("contractQty");
    }
    public void setContractQty(java.math.BigDecimal item)
    {
        setBigDecimal("contractQty", item);
    }
    /**
     * Object:�������õ�'s �Ƿ����ҩ����property 
     */
    public String getAllowProcess()
    {
        return getString("allowProcess");
    }
    public void setAllowProcess(String item)
    {
        setString("allowProcess", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("713C6B15");
    }
}