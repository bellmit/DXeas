package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedFettleInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFeedFettleInfo()
    {
        this("id");
    }
    protected AbstractFeedFettleInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.breed.FeedFettleEntryCollection());
        put("StandardEntry", new com.kingdee.eas.farm.breed.FeedFettleStandardEntryCollection());
    }
    /**
     * Object: 委托养殖结算单 's 分录 property 
     */
    public com.kingdee.eas.farm.breed.FeedFettleEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.FeedFettleEntryCollection)get("entrys");
    }
    /**
     * Object:委托养殖结算单's 是否生成凭证property 
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
     * Object: 委托养殖结算单 's 养殖户 property 
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
     * Object: 委托养殖结算单 's 养殖批次 property 
     */
    public com.kingdee.eas.farm.breed.BreedBatchInfo getBreedBatch()
    {
        return (com.kingdee.eas.farm.breed.BreedBatchInfo)get("breedBatch");
    }
    public void setBreedBatch(com.kingdee.eas.farm.breed.BreedBatchInfo item)
    {
        put("breedBatch", item);
    }
    /**
     * Object:委托养殖结算单's 日期property 
     */
    public java.util.Date getBIMUDF0003()
    {
        return getDate("BIMUDF0003");
    }
    public void setBIMUDF0003(java.util.Date item)
    {
        setDate("BIMUDF0003", item);
    }
    /**
     * Object:委托养殖结算单's 日期property 
     */
    public java.util.Date getBIMUDF0004()
    {
        return getDate("BIMUDF0004");
    }
    public void setBIMUDF0004(java.util.Date item)
    {
        setDate("BIMUDF0004", item);
    }
    /**
     * Object:委托养殖结算单's 审核时间property 
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
     * Object:委托养殖结算单's 耗料(KG)property 
     */
    public java.math.BigDecimal getFodderQty()
    {
        return getBigDecimal("fodderQty");
    }
    public void setFodderQty(java.math.BigDecimal item)
    {
        setBigDecimal("fodderQty", item);
    }
    /**
     * Object:委托养殖结算单's 用药(元)property 
     */
    public java.math.BigDecimal getDrugAmount()
    {
        return getBigDecimal("drugAmount");
    }
    public void setDrugAmount(java.math.BigDecimal item)
    {
        setBigDecimal("drugAmount", item);
    }
    /**
     * Object:委托养殖结算单's 苗种数量property 
     */
    public int getChikenQty()
    {
        return getInt("chikenQty");
    }
    public void setChikenQty(int item)
    {
        setInt("chikenQty", item);
    }
    /**
     * Object:委托养殖结算单's 重量(KG)property 
     */
    public java.math.BigDecimal getBigChikenWeight()
    {
        return getBigDecimal("BigChikenWeight");
    }
    public void setBigChikenWeight(java.math.BigDecimal item)
    {
        setBigDecimal("BigChikenWeight", item);
    }
    /**
     * Object:委托养殖结算单's 售价(元/KG)property 
     */
    public java.math.BigDecimal getBigChickenPrice()
    {
        return getBigDecimal("bigChickenPrice");
    }
    public void setBigChickenPrice(java.math.BigDecimal item)
    {
        setBigDecimal("bigChickenPrice", item);
    }
    /**
     * Object:委托养殖结算单's 料肉比property 
     */
    public java.math.BigDecimal getMeatPerFodder()
    {
        return getBigDecimal("meatPerFodder");
    }
    public void setMeatPerFodder(java.math.BigDecimal item)
    {
        setBigDecimal("meatPerFodder", item);
    }
    /**
     * Object:委托养殖结算单's 只耗料(KG)property 
     */
    public java.math.BigDecimal getFodderPerChicken()
    {
        return getBigDecimal("fodderPerChicken");
    }
    public void setFodderPerChicken(java.math.BigDecimal item)
    {
        setBigDecimal("fodderPerChicken", item);
    }
    /**
     * Object:委托养殖结算单's 只均重(KG)property 
     */
    public java.math.BigDecimal getWeightAvg()
    {
        return getBigDecimal("weightAvg");
    }
    public void setWeightAvg(java.math.BigDecimal item)
    {
        setBigDecimal("weightAvg", item);
    }
    /**
     * Object:委托养殖结算单's 苗种成本(元)property 
     */
    public java.math.BigDecimal getChickenCost()
    {
        return getBigDecimal("chickenCost");
    }
    public void setChickenCost(java.math.BigDecimal item)
    {
        setBigDecimal("chickenCost", item);
    }
    /**
     * Object:委托养殖结算单's 养户收入property 
     */
    public java.math.BigDecimal getCustomerIncome()
    {
        return getBigDecimal("customerIncome");
    }
    public void setCustomerIncome(java.math.BigDecimal item)
    {
        setBigDecimal("customerIncome", item);
    }
    /**
     * Object:委托养殖结算单's 养户成本property 
     */
    public java.math.BigDecimal getCustomerCost()
    {
        return getBigDecimal("customerCost");
    }
    public void setCustomerCost(java.math.BigDecimal item)
    {
        setBigDecimal("customerCost", item);
    }
    /**
     * Object:委托养殖结算单's 结算标准property 
     */
    public java.math.BigDecimal getSettlementStandard()
    {
        return getBigDecimal("settlementStandard");
    }
    public void setSettlementStandard(java.math.BigDecimal item)
    {
        setBigDecimal("settlementStandard", item);
    }
    /**
     * Object:委托养殖结算单's 合同差额(元)property 
     */
    public java.math.BigDecimal getContractDIf()
    {
        return getBigDecimal("contractDIf");
    }
    public void setContractDIf(java.math.BigDecimal item)
    {
        setBigDecimal("contractDIf", item);
    }
    /**
     * Object:委托养殖结算单's 养户总利润property 
     */
    public java.math.BigDecimal getCustomerAllProfit()
    {
        return getBigDecimal("customerAllProfit");
    }
    public void setCustomerAllProfit(java.math.BigDecimal item)
    {
        setBigDecimal("customerAllProfit", item);
    }
    /**
     * Object:委托养殖结算单's 公司销售毛利property 
     */
    public java.math.BigDecimal getCompanyGrossProfit()
    {
        return getBigDecimal("companyGrossProfit");
    }
    public void setCompanyGrossProfit(java.math.BigDecimal item)
    {
        setBigDecimal("companyGrossProfit", item);
    }
    /**
     * Object:委托养殖结算单's 公司纯利property 
     */
    public java.math.BigDecimal getCompanyAllProfit()
    {
        return getBigDecimal("companyAllProfit");
    }
    public void setCompanyAllProfit(java.math.BigDecimal item)
    {
        setBigDecimal("companyAllProfit", item);
    }
    /**
     * Object: 委托养殖结算单 's 计算标准 property 
     */
    public com.kingdee.eas.farm.breed.FeedFettleStandardEntryCollection getStandardEntry()
    {
        return (com.kingdee.eas.farm.breed.FeedFettleStandardEntryCollection)get("StandardEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E6EF4550");
    }
}