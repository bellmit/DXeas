package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractChickenRecBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractChickenRecBillInfo()
    {
        this("id");
    }
    protected AbstractChickenRecBillInfo(String pkField)
    {
        super(pkField);
        put("ButcherEntry", new com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillButcherEntryCollection());
        put("Entry", new com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillEntryCollection());
        put("WeigntEntry", new com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillWeigntEntryCollection());
    }
    /**
     * Object:毛鸡回收订单's 是否生成凭证property 
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
     * Object: 毛鸡回收订单 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFICompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FICompany");
    }
    public void setFICompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FICompany", item);
    }
    /**
     * Object:毛鸡回收订单's 审核时间property 
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
     * Object: 毛鸡回收订单 's 养殖户 property 
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
     * Object: 毛鸡回收订单 's 养殖场 property 
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
     * Object: 毛鸡回收订单 's 批次合同 property 
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
     * Object: 毛鸡回收订单 's 养殖批次 property 
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
     * Object:毛鸡回收订单's 单据状态property 
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
     * Object: 毛鸡回收订单 's 结算政策 property 
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
     * Object:毛鸡回收订单's 上苗日期property 
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
     * Object:毛鸡回收订单's 上苗数量property 
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
     * Object: 毛鸡回收订单 's 业务员 property 
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
     * Object:毛鸡回收订单's 养殖场地址property 
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
     * Object:毛鸡回收订单's 养殖模式property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmsType getFarmType()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmsType.getEnum(getString("farmType"));
    }
    public void setFarmType(com.kingdee.eas.farm.stocking.basedata.FarmsType item)
    {
		if (item != null) {
        setString("farmType", item.getValue());
		}
    }
    /**
     * Object:毛鸡回收订单's 养殖户联系方式property 
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
     * Object: 毛鸡回收订单 's 品种 property 
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
     * Object:毛鸡回收订单's 饲养天数property 
     */
    public int getFeedDays()
    {
        return getInt("feedDays");
    }
    public void setFeedDays(int item)
    {
        setInt("feedDays", item);
    }
    /**
     * Object: 毛鸡回收订单 's 派车信息 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillEntryCollection)get("Entry");
    }
    /**
     * Object: 毛鸡回收订单 's 棚前过磅 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillWeigntEntryCollection getWeigntEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillWeigntEntryCollection)get("WeigntEntry");
    }
    /**
     * Object: 毛鸡回收订单 's 屠宰信息 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillButcherEntryCollection getButcherEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillButcherEntryCollection)get("ButcherEntry");
    }
    /**
     * Object:毛鸡回收订单's 是否生产入property 
     */
    public boolean isIsManu()
    {
        return getBoolean("isManu");
    }
    public void setIsManu(boolean item)
    {
        setBoolean("isManu", item);
    }
    /**
     * Object:毛鸡回收订单's 是否销售出property 
     */
    public boolean isIsSaleOut()
    {
        return getBoolean("isSaleOut");
    }
    public void setIsSaleOut(boolean item)
    {
        setBoolean("isSaleOut", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B283071F");
    }
}