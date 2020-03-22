package com.kingdee.eas.farm.carnivorous.assistbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKFreightBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCKFreightBillInfo()
    {
        this("id");
    }
    protected AbstractCKFreightBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:毛鸡运费单's 是否生成凭证property 
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
     * Object: 毛鸡运费单 's 财务组织 property 
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
     * Object:毛鸡运费单's 单据状态property 
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
     * Object: 毛鸡运费单 's 车辆 property 
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
     * Object: 毛鸡运费单 's 司机 property 
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
     * Object: 毛鸡运费单 's 品种 property 
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
     * Object: 毛鸡运费单 's 养殖场 property 
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
     * Object: 毛鸡运费单 's 批次合同 property 
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
     * Object:毛鸡运费单's 回收日期property 
     */
    public java.util.Date getRecDate()
    {
        return getDate("recDate");
    }
    public void setRecDate(java.util.Date item)
    {
        setDate("recDate", item);
    }
    /**
     * Object:毛鸡运费单's 运输距离property 
     */
    public java.math.BigDecimal getDistance()
    {
        return getBigDecimal("distance");
    }
    public void setDistance(java.math.BigDecimal item)
    {
        setBigDecimal("distance", item);
    }
    /**
     * Object:毛鸡运费单's 回收净重property 
     */
    public java.math.BigDecimal getRecSuttle()
    {
        return getBigDecimal("recSuttle");
    }
    public void setRecSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("recSuttle", item);
    }
    /**
     * Object:毛鸡运费单's 胴体重量property 
     */
    public java.math.BigDecimal getCarcassWgt()
    {
        return getBigDecimal("carcassWgt");
    }
    public void setCarcassWgt(java.math.BigDecimal item)
    {
        setBigDecimal("carcassWgt", item);
    }
    /**
     * Object:毛鸡运费单's 残鸡只数property 
     */
    public int getInCompleteQty()
    {
        return getInt("inCompleteQty");
    }
    public void setInCompleteQty(int item)
    {
        setInt("inCompleteQty", item);
    }
    /**
     * Object:毛鸡运费单's 残鸡重量property 
     */
    public java.math.BigDecimal getInCompleteWgt()
    {
        return getBigDecimal("inCompleteWgt");
    }
    public void setInCompleteWgt(java.math.BigDecimal item)
    {
        setBigDecimal("inCompleteWgt", item);
    }
    /**
     * Object:毛鸡运费单's 市场价property 
     */
    public java.math.BigDecimal getMarketPrice()
    {
        return getBigDecimal("marketPrice");
    }
    public void setMarketPrice(java.math.BigDecimal item)
    {
        setBigDecimal("marketPrice", item);
    }
    /**
     * Object:毛鸡运费单's 计算用日出肉率(%)property 
     */
    public java.math.BigDecimal getDateFmRate()
    {
        return getBigDecimal("dateFmRate");
    }
    public void setDateFmRate(java.math.BigDecimal item)
    {
        setBigDecimal("dateFmRate", item);
    }
    /**
     * Object:毛鸡运费单's 日毛鸡运费property 
     */
    public java.math.BigDecimal getDateCKFreight()
    {
        return getBigDecimal("dateCKFreight");
    }
    public void setDateCKFreight(java.math.BigDecimal item)
    {
        setBigDecimal("dateCKFreight", item);
    }
    /**
     * Object:毛鸡运费单's 出肉率调整系数(%)property 
     */
    public java.math.BigDecimal getDressingPercent()
    {
        return getBigDecimal("dressingPercent");
    }
    public void setDressingPercent(java.math.BigDecimal item)
    {
        setBigDecimal("dressingPercent", item);
    }
    /**
     * Object:毛鸡运费单's 实际毛鸡运费property 
     */
    public java.math.BigDecimal getActualCKFreight()
    {
        return getBigDecimal("actualCKFreight");
    }
    public void setActualCKFreight(java.math.BigDecimal item)
    {
        setBigDecimal("actualCKFreight", item);
    }
    /**
     * Object:毛鸡运费单's 翅淤血比例(%)property 
     */
    public java.math.BigDecimal getCyxRate()
    {
        return getBigDecimal("cyxRate");
    }
    public void setCyxRate(java.math.BigDecimal item)
    {
        setBigDecimal("cyxRate", item);
    }
    /**
     * Object:毛鸡运费单's 翅淤血扣补property 
     */
    public java.math.BigDecimal getCyxKbAmt()
    {
        return getBigDecimal("cyxKbAmt");
    }
    public void setCyxKbAmt(java.math.BigDecimal item)
    {
        setBigDecimal("cyxKbAmt", item);
    }
    /**
     * Object:毛鸡运费单's 其他扣补费property 
     */
    public java.math.BigDecimal getOtherKbAmt()
    {
        return getBigDecimal("otherKbAmt");
    }
    public void setOtherKbAmt(java.math.BigDecimal item)
    {
        setBigDecimal("otherKbAmt", item);
    }
    /**
     * Object:毛鸡运费单's 总运输费用property 
     */
    public java.math.BigDecimal getAllFreight()
    {
        return getBigDecimal("allFreight");
    }
    public void setAllFreight(java.math.BigDecimal item)
    {
        setBigDecimal("allFreight", item);
    }
    /**
     * Object:毛鸡运费单's 审核日期property 
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
     * Object: 毛鸡运费单 's 客户 property 
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
     * Object: 毛鸡运费单 's 养殖户 property 
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
     * Object: 毛鸡运费单 's 运费计算点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo getCalUnit()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo)get("calUnit");
    }
    public void setCalUnit(com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo item)
    {
        put("calUnit", item);
    }
    /**
     * Object:毛鸡运费单's 毛鸡均重property 
     */
    public java.math.BigDecimal getAverageWgt()
    {
        return getBigDecimal("averageWgt");
    }
    public void setAverageWgt(java.math.BigDecimal item)
    {
        setBigDecimal("averageWgt", item);
    }
    /**
     * Object:毛鸡运费单's 实际出肉率(%)property 
     */
    public java.math.BigDecimal getActualFmRate()
    {
        return getBigDecimal("actualFmRate");
    }
    public void setActualFmRate(java.math.BigDecimal item)
    {
        setBigDecimal("actualFmRate", item);
    }
    /**
     * Object:毛鸡运费单's 月平均出肉率(%)property 
     */
    public java.math.BigDecimal getMonthAveFmRate()
    {
        return getBigDecimal("monthAveFmRate");
    }
    public void setMonthAveFmRate(java.math.BigDecimal item)
    {
        setBigDecimal("monthAveFmRate", item);
    }
    /**
     * Object:毛鸡运费单's 派车与拉鸡差异只数property 
     */
    public int getPldiffQty()
    {
        return getInt("pldiffQty");
    }
    public void setPldiffQty(int item)
    {
        setInt("pldiffQty", item);
    }
    /**
     * Object:毛鸡运费单's 高速费property 
     */
    public java.math.BigDecimal getHighWayFee()
    {
        return getBigDecimal("highWayFee");
    }
    public void setHighWayFee(java.math.BigDecimal item)
    {
        setBigDecimal("highWayFee", item);
    }
    /**
     * Object:毛鸡运费单's 派车与拉鸡差异扣补property 
     */
    public java.math.BigDecimal getPldiffAmount()
    {
        return getBigDecimal("pldiffAmount");
    }
    public void setPldiffAmount(java.math.BigDecimal item)
    {
        setBigDecimal("pldiffAmount", item);
    }
    /**
     * Object:毛鸡运费单's 回收只数property 
     */
    public int getRecQty()
    {
        return getInt("recQty");
    }
    public void setRecQty(int item)
    {
        setInt("recQty", item);
    }
    /**
     * Object:毛鸡运费单's 增幅运费property 
     */
    public java.math.BigDecimal getGrowthFreight()
    {
        return getBigDecimal("growthFreight");
    }
    public void setGrowthFreight(java.math.BigDecimal item)
    {
        setBigDecimal("growthFreight", item);
    }
    /**
     * Object:毛鸡运费单's 最高出肉率(%)property 
     */
    public java.math.BigDecimal getMaxFmRate()
    {
        return getBigDecimal("maxFmRate");
    }
    public void setMaxFmRate(java.math.BigDecimal item)
    {
        setBigDecimal("maxFmRate", item);
    }
    /**
     * Object:毛鸡运费单's 标准出肉率(%)property 
     */
    public java.math.BigDecimal getFmRateStd()
    {
        return getBigDecimal("fmRateStd");
    }
    public void setFmRateStd(java.math.BigDecimal item)
    {
        setBigDecimal("fmRateStd", item);
    }
    /**
     * Object:毛鸡运费单's 胴体只数property 
     */
    public int getCarcassQty()
    {
        return getInt("carcassQty");
    }
    public void setCarcassQty(int item)
    {
        setInt("carcassQty", item);
    }
    /**
     * Object:毛鸡运费单's 月计算用出肉率property 
     */
    public java.math.BigDecimal getMonthCalFmRate()
    {
        return getBigDecimal("monthCalFmRate");
    }
    public void setMonthCalFmRate(java.math.BigDecimal item)
    {
        setBigDecimal("monthCalFmRate", item);
    }
    /**
     * Object:毛鸡运费单's 出肉率系数property 
     */
    public java.math.BigDecimal getFmRateCoe()
    {
        return getBigDecimal("fmRateCoe");
    }
    public void setFmRateCoe(java.math.BigDecimal item)
    {
        setBigDecimal("fmRateCoe", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A9165033");
    }
}