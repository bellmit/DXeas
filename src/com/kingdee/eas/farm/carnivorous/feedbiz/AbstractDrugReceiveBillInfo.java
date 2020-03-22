package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDrugReceiveBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDrugReceiveBillInfo()
    {
        this("id");
    }
    protected AbstractDrugReceiveBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillEntryCollection());
    }
    /**
     * Object: ҩƷ������ 's ��¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillEntryCollection)get("entrys");
    }
    /**
     * Object:ҩƷ������'s �Ƿ�����ƾ֤property 
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
     * Object:ҩƷ������'s ����״̬property 
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
     * Object: ҩƷ������ 's ������֯ property 
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
     * Object:ҩƷ������'s ���ʱ��property 
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
     * Object: ҩƷ������ 's �����֯ property 
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
     * Object:ҩƷ������'s ��ʼ������property 
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
     * Object:ҩƷ������'s �Ƿ��������ϳ���property 
     */
    public boolean isIsHasMaterial()
    {
        return getBoolean("isHasMaterial");
    }
    public void setIsHasMaterial(boolean item)
    {
        setBoolean("isHasMaterial", item);
    }
    /**
     * Object:ҩƷ������'s �Ƿ����ɵ�������property 
     */
    public boolean isIsHasTrans()
    {
        return getBoolean("isHasTrans");
    }
    public void setIsHasTrans(boolean item)
    {
        setBoolean("isHasTrans", item);
    }
    /**
     * Object: ҩƷ������ 's ��ֳ�� property 
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
     * Object: ҩƷ������ 's ��ֳ�� property 
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
     * Object: ҩƷ������ 's ���� property 
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
     * Object: ҩƷ������ 's ���κ�ͬ property 
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
     * Object: ҩƷ������ 's ˾�� property 
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
     * Object:ҩƷ������'s ��������property 
     */
    public java.util.Date getInDate()
    {
        return getDate("inDate");
    }
    public void setInDate(java.util.Date item)
    {
        setDate("inDate", item);
    }
    /**
     * Object:ҩƷ������'s ��������property 
     */
    public java.math.BigDecimal getInQty()
    {
        return getBigDecimal("inQty");
    }
    public void setInQty(java.math.BigDecimal item)
    {
        setBigDecimal("inQty", item);
    }
    /**
     * Object:ҩƷ������'s �ܳɱ�property 
     */
    public java.math.BigDecimal getTotalCost()
    {
        return getBigDecimal("totalCost");
    }
    public void setTotalCost(java.math.BigDecimal item)
    {
        setBigDecimal("totalCost", item);
    }
    /**
     * Object:ҩƷ������'s �ܽ��property 
     */
    public java.math.BigDecimal getTotalAmt()
    {
        return getBigDecimal("totalAmt");
    }
    public void setTotalAmt(java.math.BigDecimal item)
    {
        setBigDecimal("totalAmt", item);
    }
    /**
     * Object:ҩƷ������'s ƾ֤��property 
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
     * Object: ҩƷ������ 's ��ֳ���� property 
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
     * Object: ҩƷ������ 's Ʒ�� property 
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
     * Object: ҩƷ������ 's ҵ��Ա property 
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
     * Object:ҩƷ������'s �ѿ�ҩ��ֻ���property 
     */
    public java.math.BigDecimal getDrugedSingleAmt()
    {
        return getBigDecimal("drugedSingleAmt");
    }
    public void setDrugedSingleAmt(java.math.BigDecimal item)
    {
        setBigDecimal("drugedSingleAmt", item);
    }
    /**
     * Object:ҩƷ������'s ��ҩƷ����������property 
     */
    public boolean isIsFromTiaoYao()
    {
        return getBoolean("isFromTiaoYao");
    }
    public void setIsFromTiaoYao(boolean item)
    {
        setBoolean("isFromTiaoYao", item);
    }
    /**
     * Object:ҩƷ������'s ҵ������property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.DrugBizType getBizType()
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.DrugBizType.getEnum(getString("bizType"));
    }
    public void setBizType(com.kingdee.eas.farm.carnivorous.feedbiz.DrugBizType item)
    {
		if (item != null) {
        setString("bizType", item.getValue());
		}
    }
    /**
     * Object:ҩƷ������'s ��ֳ���绰property 
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
     * Object:ҩƷ������'s ��ֳ����ַproperty 
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
     * Object:ҩƷ������'s �Ѵ�ӡ����property 
     */
    public int getPrintTime()
    {
        return getInt("printTime");
    }
    public void setPrintTime(int item)
    {
        setInt("printTime", item);
    }
    /**
     * Object: ҩƷ������ 's ְҵ��ҽʦ property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.VetInfo getVet()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.VetInfo)get("vet");
    }
    public void setVet(com.kingdee.eas.farm.carnivorous.basedata.VetInfo item)
    {
        put("vet", item);
    }
    /**
     * Object: ҩƷ������ 's �ɱ����� property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostcenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costcenter");
    }
    public void setCostcenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costcenter", item);
    }
    /**
     * Object:ҩƷ������'s �ѿ�ҩ�ܽ��property 
     */
    public java.math.BigDecimal getHasDrugAmount()
    {
        return getBigDecimal("hasDrugAmount");
    }
    public void setHasDrugAmount(java.math.BigDecimal item)
    {
        setBigDecimal("hasDrugAmount", item);
    }
    /**
     * Object:ҩƷ������'s ��߿�ҩ���property 
     */
    public java.math.BigDecimal getHignDrugAmount()
    {
        return getBigDecimal("hignDrugAmount");
    }
    public void setHignDrugAmount(java.math.BigDecimal item)
    {
        setBigDecimal("hignDrugAmount", item);
    }
    /**
     * Object:ҩƷ������'s �ѿ�ҩ��ֻ���property 
     */
    public java.math.BigDecimal getHasOneDrug()
    {
        return getBigDecimal("hasOneDrug");
    }
    public void setHasOneDrug(java.math.BigDecimal item)
    {
        setBigDecimal("hasOneDrug", item);
    }
    /**
     * Object:ҩƷ������'s �ѿ�ҩ�ܽ��property 
     */
    public java.math.BigDecimal getSaveAmount()
    {
        return getBigDecimal("saveAmount");
    }
    public void setSaveAmount(java.math.BigDecimal item)
    {
        setBigDecimal("saveAmount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0E74B6E6");
    }
}