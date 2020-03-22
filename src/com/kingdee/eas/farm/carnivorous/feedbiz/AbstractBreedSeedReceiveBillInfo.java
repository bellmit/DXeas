package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedSeedReceiveBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBreedSeedReceiveBillInfo()
    {
        this("id");
    }
    protected AbstractBreedSeedReceiveBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryCollection());
    }
    /**
     * Object: �������õ� 's ��¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryCollection)get("entrys");
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
     * Object:�������õ�'s ���κ�property 
     */
    public String getStockingBatchNum()
    {
        return getString("stockingBatchNum");
    }
    public void setStockingBatchNum(String item)
    {
        setString("stockingBatchNum", item);
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
     * Object:�������õ�'s ����property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:�������õ�'s ĸ������property 
     */
    public java.math.BigDecimal getFemaleQty()
    {
        return getBigDecimal("femaleQty");
    }
    public void setFemaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleQty", item);
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
     * Object: �������õ� 's �������� property 
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
     * Object: �������õ� 's ҵ��Ա property 
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
     * Object: �������õ� 's �ɹ�Ա property 
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
     * Object:�������õ�'s ҵ������property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum getBizType()
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum.getEnum(getString("bizType"));
    }
    public void setBizType(com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum item)
    {
		if (item != null) {
        setString("bizType", item.getValue());
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
     * Object:�������õ�'s �Ƿ��������۳�property 
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
     * Object:�������õ�'s ������Դ����property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.SeedSourceType getSeedSourceType()
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.SeedSourceType.getEnum(getString("seedSourceType"));
    }
    public void setSeedSourceType(com.kingdee.eas.farm.carnivorous.feedbiz.SeedSourceType item)
    {
		if (item != null) {
        setString("seedSourceType", item.getValue());
		}
    }
    /**
     * Object: �������õ� 's ��Դ������ property 
     */
    public com.kingdee.eas.farm.hatch.HatchBaseDataInfo getSourceHatchArea()
    {
        return (com.kingdee.eas.farm.hatch.HatchBaseDataInfo)get("sourceHatchArea");
    }
    public void setSourceHatchArea(com.kingdee.eas.farm.hatch.HatchBaseDataInfo item)
    {
        put("sourceHatchArea", item);
    }
    /**
     * Object:�������õ�'s ʵ����������property 
     */
    public java.util.Date getActualBizdate()
    {
        return getDate("actualBizdate");
    }
    public void setActualBizdate(java.util.Date item)
    {
        setDate("actualBizdate", item);
    }
    /**
     * Object: �������õ� 's ��ֳ���� property 
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
     * Object: �������õ� 's �⹺��Ӧ�� property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getPurSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("purSupplier");
    }
    public void setPurSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("purSupplier", item);
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
     * Object:�������õ�'s �Ѵ�ӡ����property 
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
     * Object:�������õ�'s ������Դproperty 
     */
    public String getSeedSource()
    {
        return getString("seedSource");
    }
    public void setSeedSource(String item)
    {
        setString("seedSource", item);
    }
    /**
     * Object: �������õ� 's �ɱ����� property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostObject()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costObject");
    }
    public void setCostObject(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costObject", item);
    }
    /**
     * Object:�������õ�'s �Ƿ�ע������property 
     */
    public boolean isIsInsertImm()
    {
        return getBoolean("isInsertImm");
    }
    public void setIsInsertImm(boolean item)
    {
        setBoolean("isInsertImm", item);
    }
    /**
     * Object:�������õ�'s �Ƿ������븺��property 
     */
    public boolean isIsManuIn()
    {
        return getBoolean("isManuIn");
    }
    public void setIsManuIn(boolean item)
    {
        setBoolean("isManuIn", item);
    }
    /**
     * Object:�������õ�'s �Ƿ�������property 
     */
    public boolean isIsOtherIn()
    {
        return getBoolean("isOtherIn");
    }
    public void setIsOtherIn(boolean item)
    {
        setBoolean("isOtherIn", item);
    }
    /**
     * Object: �������õ� 's �ų�Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getChickenPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("chickenPerson");
    }
    public void setChickenPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("chickenPerson", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("681AB2A9");
    }
}