package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractChickenDailyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractChickenDailyInfo()
    {
        this("id");
    }
    protected AbstractChickenDailyInfo(String pkField)
    {
        super(pkField);
        put("CarCassEntry", new com.kingdee.eas.farm.food.ChickenDailyCarCassEntryCollection());
        put("BodyEntry", new com.kingdee.eas.farm.food.ChickenDailyBodyEntryCollection());
    }
    /**
     * Object: 商品鸡统计 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("StorageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("StorageOrgUnit", item);
    }
    /**
     * Object:商品鸡统计's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("BillStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("BillStatus", item.getValue());
		}
    }
    /**
     * Object:商品鸡统计's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("AuditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("AuditTime", item);
    }
    /**
     * Object: 商品鸡统计 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("companyOrgUnit");
    }
    public void setCompanyOrgUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("companyOrgUnit", item);
    }
    /**
     * Object:商品鸡统计's 物理致死数量property 
     */
    public java.math.BigDecimal getPhysicalDeathQty()
    {
        return getBigDecimal("PhysicalDeathQty");
    }
    public void setPhysicalDeathQty(java.math.BigDecimal item)
    {
        setBigDecimal("PhysicalDeathQty", item);
    }
    /**
     * Object:商品鸡统计's 物理致死重量property 
     */
    public java.math.BigDecimal getPhysicalDeathWeight()
    {
        return getBigDecimal("PhysicalDeathWeight");
    }
    public void setPhysicalDeathWeight(java.math.BigDecimal item)
    {
        setBigDecimal("PhysicalDeathWeight", item);
    }
    /**
     * Object:商品鸡统计's 胴体数量property 
     */
    public java.math.BigDecimal getCarcassQty()
    {
        return getBigDecimal("CarcassQty");
    }
    public void setCarcassQty(java.math.BigDecimal item)
    {
        setBigDecimal("CarcassQty", item);
    }
    /**
     * Object:商品鸡统计's 胴体重量property 
     */
    public java.math.BigDecimal getCarcassWeight()
    {
        return getBigDecimal("CarcassWeight");
    }
    public void setCarcassWeight(java.math.BigDecimal item)
    {
        setBigDecimal("CarcassWeight", item);
    }
    /**
     * Object: 商品鸡统计 's 养殖场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getFarm()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:商品鸡统计's 风干鸡重量property 
     */
    public java.math.BigDecimal getDryingChickenWeight()
    {
        return getBigDecimal("dryingChickenWeight");
    }
    public void setDryingChickenWeight(java.math.BigDecimal item)
    {
        setBigDecimal("dryingChickenWeight", item);
    }
    /**
     * Object:商品鸡统计's 不合格胴体重量property 
     */
    public java.math.BigDecimal getUnCarcassWeight()
    {
        return getBigDecimal("unCarcassWeight");
    }
    public void setUnCarcassWeight(java.math.BigDecimal item)
    {
        setBigDecimal("unCarcassWeight", item);
    }
    /**
     * Object:商品鸡统计's 不合格胴体数量property 
     */
    public java.math.BigDecimal getUnCarcassQty()
    {
        return getBigDecimal("unCarcassQty");
    }
    public void setUnCarcassQty(java.math.BigDecimal item)
    {
        setBigDecimal("unCarcassQty", item);
    }
    /**
     * Object:商品鸡统计's 风干鸡数量property 
     */
    public java.math.BigDecimal getDryingChickenQty()
    {
        return getBigDecimal("dryingChickenQty");
    }
    public void setDryingChickenQty(java.math.BigDecimal item)
    {
        setBigDecimal("dryingChickenQty", item);
    }
    /**
     * Object:商品鸡统计's 主产重量(Kg)property 
     */
    public java.math.BigDecimal getMainPWeight()
    {
        return getBigDecimal("mainPWeight");
    }
    public void setMainPWeight(java.math.BigDecimal item)
    {
        setBigDecimal("mainPWeight", item);
    }
    /**
     * Object:商品鸡统计's 副产重量(Kg)property 
     */
    public java.math.BigDecimal getByPWeight()
    {
        return getBigDecimal("byPWeight");
    }
    public void setByPWeight(java.math.BigDecimal item)
    {
        setBigDecimal("byPWeight", item);
    }
    /**
     * Object:商品鸡统计's 鸡爪脚垫比例(%)property 
     */
    public java.math.BigDecimal getAchickenclaw()
    {
        return getBigDecimal("achickenclaw");
    }
    public void setAchickenclaw(java.math.BigDecimal item)
    {
        setBigDecimal("achickenclaw", item);
    }
    /**
     * Object:商品鸡统计's 皮炎比例(%)property 
     */
    public java.math.BigDecimal getDermatitis()
    {
        return getBigDecimal("dermatitis");
    }
    public void setDermatitis(java.math.BigDecimal item)
    {
        setBigDecimal("dermatitis", item);
    }
    /**
     * Object:商品鸡统计's 鸡胗食物property 
     */
    public java.math.BigDecimal getGizzardsFood()
    {
        return getBigDecimal("gizzardsFood");
    }
    public void setGizzardsFood(java.math.BigDecimal item)
    {
        setBigDecimal("gizzardsFood", item);
    }
    /**
     * Object:商品鸡统计's 鸡翅瘀血property 
     */
    public java.math.BigDecimal getWingBlood()
    {
        return getBigDecimal("wingBlood");
    }
    public void setWingBlood(java.math.BigDecimal item)
    {
        setBigDecimal("wingBlood", item);
    }
    /**
     * Object:商品鸡统计's 鸡体均匀度property 
     */
    public java.math.BigDecimal getChickenUniform()
    {
        return getBigDecimal("chickenUniform");
    }
    public void setChickenUniform(java.math.BigDecimal item)
    {
        setBigDecimal("chickenUniform", item);
    }
    /**
     * Object: 商品鸡统计 's 鸡体情况 property 
     */
    public com.kingdee.eas.farm.food.ChickenDailyBodyEntryCollection getBodyEntry()
    {
        return (com.kingdee.eas.farm.food.ChickenDailyBodyEntryCollection)get("BodyEntry");
    }
    /**
     * Object: 商品鸡统计 's 胴体分布 property 
     */
    public com.kingdee.eas.farm.food.ChickenDailyCarCassEntryCollection getCarCassEntry()
    {
        return (com.kingdee.eas.farm.food.ChickenDailyCarCassEntryCollection)get("CarCassEntry");
    }
    /**
     * Object:商品鸡统计's 已完成(当前批次已宰杀完成)property 
     */
    public boolean isIsBatchOver()
    {
        return getBoolean("isBatchOver");
    }
    public void setIsBatchOver(boolean item)
    {
        setBoolean("isBatchOver", item);
    }
    /**
     * Object:商品鸡统计's 汇报日期property 
     */
    public java.util.Date getReportDate()
    {
        return getDate("reportDate");
    }
    public void setReportDate(java.util.Date item)
    {
        setDate("reportDate", item);
    }
    /**
     * Object:商品鸡统计's 胴体均匀度(%)property 
     */
    public java.math.BigDecimal getCarcassUniformity()
    {
        return getBigDecimal("CarcassUniformity");
    }
    public void setCarcassUniformity(java.math.BigDecimal item)
    {
        setBigDecimal("CarcassUniformity", item);
    }
    /**
     * Object:商品鸡统计's 记账日期property 
     */
    public java.util.Date getFIBizDate()
    {
        return getDate("FIBizDate");
    }
    public void setFIBizDate(java.util.Date item)
    {
        setDate("FIBizDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C522B70E");
    }
}