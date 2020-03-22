package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLiveBirdWgtBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractLiveBirdWgtBillInfo()
    {
        this("id");
    }
    protected AbstractLiveBirdWgtBillInfo(String pkField)
    {
        super(pkField);
        put("SaleEntrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillSaleEntryCollection());
    }
    /**
     * Object:活禽过磅单's 是否生成凭证property 
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
     * Object: 活禽过磅单 's 财务组织 property 
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
     * Object:活禽过磅单's 审核时间property 
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
     * Object: 活禽过磅单 's 养殖户 property 
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
     * Object: 活禽过磅单 's 养殖场 property 
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
     * Object: 活禽过磅单 's 批次合同 property 
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
     * Object: 活禽过磅单 's 养殖批次 property 
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
     * Object:活禽过磅单's 单据状态property 
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
     * Object: 活禽过磅单 's 结算政策 property 
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
     * Object:活禽过磅单's 上苗日期property 
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
     * Object:活禽过磅单's 上苗数量property 
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
     * Object:活禽过磅单's 车次property 
     */
    public int getCarTimes()
    {
        return getInt("carTimes");
    }
    public void setCarTimes(int item)
    {
        setInt("carTimes", item);
    }
    /**
     * Object: 活禽过磅单 's 路线 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.RoadLineInfo getRoadLine()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.RoadLineInfo)get("roadLine");
    }
    public void setRoadLine(com.kingdee.eas.farm.carnivorous.basedata.RoadLineInfo item)
    {
        put("roadLine", item);
    }
    /**
     * Object:活禽过磅单's 棚前皮重property 
     */
    public java.math.BigDecimal getPreHouseTare()
    {
        return getBigDecimal("preHouseTare");
    }
    public void setPreHouseTare(java.math.BigDecimal item)
    {
        setBigDecimal("preHouseTare", item);
    }
    /**
     * Object:活禽过磅单's 棚前毛重property 
     */
    public java.math.BigDecimal getPreHouseGross()
    {
        return getBigDecimal("preHouseGross");
    }
    public void setPreHouseGross(java.math.BigDecimal item)
    {
        setBigDecimal("preHouseGross", item);
    }
    /**
     * Object:活禽过磅单's 棚前净重property 
     */
    public java.math.BigDecimal getPreHouseSuttle()
    {
        return getBigDecimal("preHouseSuttle");
    }
    public void setPreHouseSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("preHouseSuttle", item);
    }
    /**
     * Object:活禽过磅单's 死鸡只数property 
     */
    public int getDeathQty()
    {
        return getInt("deathQty");
    }
    public void setDeathQty(int item)
    {
        setInt("deathQty", item);
    }
    /**
     * Object:活禽过磅单's 棚前只数property 
     */
    public int getPreHouseQty()
    {
        return getInt("preHouseQty");
    }
    public void setPreHouseQty(int item)
    {
        setInt("preHouseQty", item);
    }
    /**
     * Object:活禽过磅单's 死鸡重量property 
     */
    public java.math.BigDecimal getDeathWgt()
    {
        return getBigDecimal("deathWgt");
    }
    public void setDeathWgt(java.math.BigDecimal item)
    {
        setBigDecimal("deathWgt", item);
    }
    /**
     * Object:活禽过磅单's 社会鸡只数property 
     */
    public int getSocialQty()
    {
        return getInt("socialQty");
    }
    public void setSocialQty(int item)
    {
        setInt("socialQty", item);
    }
    /**
     * Object:活禽过磅单's 社会鸡重量property 
     */
    public java.math.BigDecimal getSocialWgt()
    {
        return getBigDecimal("socialWgt");
    }
    public void setSocialWgt(java.math.BigDecimal item)
    {
        setBigDecimal("socialWgt", item);
    }
    /**
     * Object:活禽过磅单's 超重鸡只数property 
     */
    public int getOverWgtQty()
    {
        return getInt("overWgtQty");
    }
    public void setOverWgtQty(int item)
    {
        setInt("overWgtQty", item);
    }
    /**
     * Object:活禽过磅单's 超重鸡重量property 
     */
    public java.math.BigDecimal getOverWgtWgt()
    {
        return getBigDecimal("overWgtWgt");
    }
    public void setOverWgtWgt(java.math.BigDecimal item)
    {
        setBigDecimal("overWgtWgt", item);
    }
    /**
     * Object:活禽过磅单's 结算只数property 
     */
    public int getSettleQty()
    {
        return getInt("settleQty");
    }
    public void setSettleQty(int item)
    {
        setInt("settleQty", item);
    }
    /**
     * Object:活禽过磅单's 均重property 
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
     * Object: 活禽过磅单 's 销售数据 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillSaleEntryCollection getSaleEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillSaleEntryCollection)get("SaleEntrys");
    }
    /**
     * Object: 活禽过磅单 's 业务员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("90D40009");
    }
}