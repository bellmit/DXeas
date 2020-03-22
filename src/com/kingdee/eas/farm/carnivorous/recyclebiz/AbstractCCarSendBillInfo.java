package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCarSendBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCCarSendBillInfo()
    {
        this("id");
    }
    protected AbstractCCarSendBillInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillEntryCollection());
    }
    /**
     * Object:毛鸡派车单's 是否生成凭证property 
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
     * Object: 毛鸡派车单 's 财务组织 property 
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
     * Object:毛鸡派车单's 审核时间property 
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
     * Object: 毛鸡派车单 's 养殖户 property 
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
     * Object: 毛鸡派车单 's 养殖场 property 
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
     * Object: 毛鸡派车单 's 批次合同 property 
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
     * Object: 毛鸡派车单 's 养殖批次 property 
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
     * Object:毛鸡派车单's 单据状态property 
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
     * Object: 毛鸡派车单 's 结算政策 property 
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
     * Object:毛鸡派车单's 上苗日期property 
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
     * Object:毛鸡派车单's 上苗数量property 
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
     * Object: 毛鸡派车单 's 业务员 property 
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
     * Object:毛鸡派车单's 养殖场地址property 
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
     * Object:毛鸡派车单's 养殖模式property 
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
     * Object:毛鸡派车单's 销售类型property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType getSaleType()
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType.getEnum(getString("saleType"));
    }
    public void setSaleType(com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType item)
    {
		if (item != null) {
        setString("saleType", item.getValue());
		}
    }
    /**
     * Object: 毛鸡派车单 's 客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object:毛鸡派车单's 计划均重property 
     */
    public java.math.BigDecimal getPlanAverageQty()
    {
        return getBigDecimal("planAverageQty");
    }
    public void setPlanAverageQty(java.math.BigDecimal item)
    {
        setBigDecimal("planAverageQty", item);
    }
    /**
     * Object:毛鸡派车单's 养殖户联系方式property 
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
     * Object: 毛鸡派车单 's 品种 property 
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
     * Object:毛鸡派车单's 收购类型property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.PurType getPurType()
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.PurType.getEnum(getString("purType"));
    }
    public void setPurType(com.kingdee.eas.farm.carnivorous.recyclebiz.PurType item)
    {
		if (item != null) {
        setString("purType", item.getValue());
		}
    }
    /**
     * Object:毛鸡派车单's 里程property 
     */
    public java.math.BigDecimal getMileage()
    {
        return getBigDecimal("mileage");
    }
    public void setMileage(java.math.BigDecimal item)
    {
        setBigDecimal("mileage", item);
    }
    /**
     * Object:毛鸡派车单's 本车只数property 
     */
    public int getDeliverQty()
    {
        return getInt("deliverQty");
    }
    public void setDeliverQty(int item)
    {
        setInt("deliverQty", item);
    }
    /**
     * Object:毛鸡派车单's 是否生成棚前过磅单property 
     */
    public boolean isIsHasPQGB()
    {
        return getBoolean("isHasPQGB");
    }
    public void setIsHasPQGB(boolean item)
    {
        setBoolean("isHasPQGB", item);
    }
    /**
     * Object: 毛鸡派车单 's 车辆 property 
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
     * Object: 毛鸡派车单 's 司机 property 
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
     * Object:毛鸡派车单's 司机联系方式property 
     */
    public String getDriverPhone()
    {
        return getString("driverPhone");
    }
    public void setDriverPhone(String item)
    {
        setString("driverPhone", item);
    }
    /**
     * Object:毛鸡派车单's 到厂时间property 
     */
    public java.util.Date getArriveTime()
    {
        return getDate("arriveTime");
    }
    public void setArriveTime(java.util.Date item)
    {
        setDate("arriveTime", item);
    }
    /**
     * Object:毛鸡派车单's 顺序号property 
     */
    public int getSeq()
    {
        return getInt("seq");
    }
    public void setSeq(int item)
    {
        setInt("seq", item);
    }
    /**
     * Object:毛鸡派车单's 外销价格property 
     */
    public java.math.BigDecimal getOutSalePrice()
    {
        return getBigDecimal("outSalePrice");
    }
    public void setOutSalePrice(java.math.BigDecimal item)
    {
        setBigDecimal("outSalePrice", item);
    }
    /**
     * Object:毛鸡派车单's 种源property 
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
     * Object: 毛鸡派车单 's 基础信息 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EC5D9C5D");
    }
}