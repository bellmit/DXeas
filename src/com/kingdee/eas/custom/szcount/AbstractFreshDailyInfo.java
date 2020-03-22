package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFreshDailyInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractFreshDailyInfo()
    {
        this("id");
    }
    protected AbstractFreshDailyInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.szcount.FreshDailyEntryCollection());
    }
    /**
     * Object:生产日报单's 是否生成凭证property 
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
     * Object:生产日报单's 宰杀只数property 
     */
    public int getSlaughterAmt()
    {
        return getInt("slaughterAmt");
    }
    public void setSlaughterAmt(int item)
    {
        setInt("slaughterAmt", item);
    }
    /**
     * Object:生产日报单's 收购运费property 
     */
    public java.math.BigDecimal getBuyFreight()
    {
        return getBigDecimal("buyFreight");
    }
    public void setBuyFreight(java.math.BigDecimal item)
    {
        setBigDecimal("buyFreight", item);
    }
    /**
     * Object:生产日报单's 收购金额property 
     */
    public java.math.BigDecimal getBuyMoney()
    {
        return getBigDecimal("buyMoney");
    }
    public void setBuyMoney(java.math.BigDecimal item)
    {
        setBigDecimal("buyMoney", item);
    }
    /**
     * Object:生产日报单's 保本价格property 
     */
    public java.math.BigDecimal getCostPrice()
    {
        return getBigDecimal("costPrice");
    }
    public void setCostPrice(java.math.BigDecimal item)
    {
        setBigDecimal("costPrice", item);
    }
    /**
     * Object:生产日报单's 毛鸡成本property 
     */
    public java.math.BigDecimal getGrossChickenCost()
    {
        return getBigDecimal("GrossChickenCost");
    }
    public void setGrossChickenCost(java.math.BigDecimal item)
    {
        setBigDecimal("GrossChickenCost", item);
    }
    /**
     * Object:生产日报单's 结算胴体重property 
     */
    public java.math.BigDecimal getSettlementCarcass()
    {
        return getBigDecimal("settlementCarcass");
    }
    public void setSettlementCarcass(java.math.BigDecimal item)
    {
        setBigDecimal("settlementCarcass", item);
    }
    /**
     * Object:生产日报单's 结算毛重property 
     */
    public java.math.BigDecimal getSettlementGrossWgt()
    {
        return getBigDecimal("settlementGrossWgt");
    }
    public void setSettlementGrossWgt(java.math.BigDecimal item)
    {
        setBigDecimal("settlementGrossWgt", item);
    }
    /**
     * Object:生产日报单's 市场价格property 
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
     * Object:生产日报单's 毛鸡均价property 
     */
    public java.math.BigDecimal getGrossChickenAPrice()
    {
        return getBigDecimal("GrossChickenAPrice");
    }
    public void setGrossChickenAPrice(java.math.BigDecimal item)
    {
        setBigDecimal("GrossChickenAPrice", item);
    }
    /**
     * Object:生产日报单's 商品鸡均价property 
     */
    public java.math.BigDecimal getCommodityChickenAPrice()
    {
        return getBigDecimal("commodityChickenAPrice");
    }
    public void setCommodityChickenAPrice(java.math.BigDecimal item)
    {
        setBigDecimal("commodityChickenAPrice", item);
    }
    /**
     * Object:生产日报单's 吨毛利润property 
     */
    public java.math.BigDecimal getTonGrossProfit()
    {
        return getBigDecimal("tonGrossProfit");
    }
    public void setTonGrossProfit(java.math.BigDecimal item)
    {
        setBigDecimal("tonGrossProfit", item);
    }
    /**
     * Object:生产日报单's 商品鸡只数property 
     */
    public java.math.BigDecimal getCommodityChickenAmt()
    {
        return getBigDecimal("commodityChickenAmt");
    }
    public void setCommodityChickenAmt(java.math.BigDecimal item)
    {
        setBigDecimal("commodityChickenAmt", item);
    }
    /**
     * Object:生产日报单's 市场鸡只数property 
     */
    public java.math.BigDecimal getMarketChickenAmt()
    {
        return getBigDecimal("marketChickenAmt");
    }
    public void setMarketChickenAmt(java.math.BigDecimal item)
    {
        setBigDecimal("marketChickenAmt", item);
    }
    /**
     * Object:生产日报单's 小鸡重量property 
     */
    public java.math.BigDecimal getSmallChickenWgt()
    {
        return getBigDecimal("SmallChickenWgt");
    }
    public void setSmallChickenWgt(java.math.BigDecimal item)
    {
        setBigDecimal("SmallChickenWgt", item);
    }
    /**
     * Object:生产日报单's 残鸡重量property 
     */
    public java.math.BigDecimal getResidualChickenWgt()
    {
        return getBigDecimal("ResidualChickenWgt");
    }
    public void setResidualChickenWgt(java.math.BigDecimal item)
    {
        setBigDecimal("ResidualChickenWgt", item);
    }
    /**
     * Object:生产日报单's 残鸡只数property 
     */
    public int getResidualChickenAmt()
    {
        return getInt("ResidualChickenAmt");
    }
    public void setResidualChickenAmt(int item)
    {
        setInt("ResidualChickenAmt", item);
    }
    /**
     * Object:生产日报单's 本日纯利property 
     */
    public java.math.BigDecimal getTodayNetProfit()
    {
        return getBigDecimal("todayNetProfit");
    }
    public void setTodayNetProfit(java.math.BigDecimal item)
    {
        setBigDecimal("todayNetProfit", item);
    }
    /**
     * Object:生产日报单's 按胴体核算残鸡重量property 
     */
    public java.math.BigDecimal getCarcassRCWgt()
    {
        return getBigDecimal("CarcassRCWgt");
    }
    public void setCarcassRCWgt(java.math.BigDecimal item)
    {
        setBigDecimal("CarcassRCWgt", item);
    }
    /**
     * Object:生产日报单's 按胴体核算小鸡重量property 
     */
    public java.math.BigDecimal getCarcassSCWgt()
    {
        return getBigDecimal("CarcassSCWgt");
    }
    public void setCarcassSCWgt(java.math.BigDecimal item)
    {
        setBigDecimal("CarcassSCWgt", item);
    }
    /**
     * Object:生产日报单's 总毛重property 
     */
    public java.math.BigDecimal getAllGrossWgt()
    {
        return getBigDecimal("allGrossWgt");
    }
    public void setAllGrossWgt(java.math.BigDecimal item)
    {
        setBigDecimal("allGrossWgt", item);
    }
    /**
     * Object:生产日报单's 后区加到混合油内板油产量property 
     */
    public java.math.BigDecimal getBackAreaLeafFatYield()
    {
        return getBigDecimal("backAreaLeafFatYield");
    }
    public void setBackAreaLeafFatYield(java.math.BigDecimal item)
    {
        setBigDecimal("backAreaLeafFatYield", item);
    }
    /**
     * Object:生产日报单's 吸水率%property 
     */
    public java.math.BigDecimal getWaterAbsorption()
    {
        return getBigDecimal("waterAbsorption");
    }
    public void setWaterAbsorption(java.math.BigDecimal item)
    {
        setBigDecimal("waterAbsorption", item);
    }
    /**
     * Object:生产日报单's 总金额property 
     */
    public java.math.BigDecimal getAllMoney()
    {
        return getBigDecimal("allMoney");
    }
    public void setAllMoney(java.math.BigDecimal item)
    {
        setBigDecimal("allMoney", item);
    }
    /**
     * Object:生产日报单's 主产出成率%property 
     */
    public java.math.BigDecimal getMainRatio()
    {
        return getBigDecimal("mainRatio");
    }
    public void setMainRatio(java.math.BigDecimal item)
    {
        setBigDecimal("mainRatio", item);
    }
    /**
     * Object:生产日报单's 主产分割出成率%property 
     */
    public java.math.BigDecimal getMainDivisionRatio()
    {
        return getBigDecimal("mainDivisionRatio");
    }
    public void setMainDivisionRatio(java.math.BigDecimal item)
    {
        setBigDecimal("mainDivisionRatio", item);
    }
    /**
     * Object:生产日报单's 副产出成率%property 
     */
    public java.math.BigDecimal getViceRatio()
    {
        return getBigDecimal("viceRatio");
    }
    public void setViceRatio(java.math.BigDecimal item)
    {
        setBigDecimal("viceRatio", item);
    }
    /**
     * Object:生产日报单's 主产售价property 
     */
    public java.math.BigDecimal getMainPrice()
    {
        return getBigDecimal("mainPrice");
    }
    public void setMainPrice(java.math.BigDecimal item)
    {
        setBigDecimal("mainPrice", item);
    }
    /**
     * Object:生产日报单's 副产售价property 
     */
    public java.math.BigDecimal getVicePrice()
    {
        return getBigDecimal("vicePrice");
    }
    public void setVicePrice(java.math.BigDecimal item)
    {
        setBigDecimal("vicePrice", item);
    }
    /**
     * Object:生产日报单's 成品重量property 
     */
    public java.math.BigDecimal getFinishedProductWgt()
    {
        return getBigDecimal("finishedProductWgt");
    }
    public void setFinishedProductWgt(java.math.BigDecimal item)
    {
        setBigDecimal("finishedProductWgt", item);
    }
    /**
     * Object:生产日报单's 鸡毛单价property 
     */
    public java.math.BigDecimal getChickenPeatherPrice()
    {
        return getBigDecimal("chickenPeatherPrice");
    }
    public void setChickenPeatherPrice(java.math.BigDecimal item)
    {
        setBigDecimal("chickenPeatherPrice", item);
    }
    /**
     * Object:生产日报单's 鸡肠单价property 
     */
    public java.math.BigDecimal getChickenIntestinePrice()
    {
        return getBigDecimal("chickenIntestinePrice");
    }
    public void setChickenIntestinePrice(java.math.BigDecimal item)
    {
        setBigDecimal("chickenIntestinePrice", item);
    }
    /**
     * Object:生产日报单's 鸡嗉子单价property 
     */
    public java.math.BigDecimal getChickenCropPrice()
    {
        return getBigDecimal("chickenCropPrice");
    }
    public void setChickenCropPrice(java.math.BigDecimal item)
    {
        setBigDecimal("chickenCropPrice", item);
    }
    /**
     * Object:生产日报单's 杂油单价property 
     */
    public java.math.BigDecimal getMixedOilPrice()
    {
        return getBigDecimal("mixedOilPrice");
    }
    public void setMixedOilPrice(java.math.BigDecimal item)
    {
        setBigDecimal("mixedOilPrice", item);
    }
    /**
     * Object:生产日报单's 鸡毛金额property 
     */
    public java.math.BigDecimal getChickenPeatherMoney()
    {
        return getBigDecimal("chickenPeatherMoney");
    }
    public void setChickenPeatherMoney(java.math.BigDecimal item)
    {
        setBigDecimal("chickenPeatherMoney", item);
    }
    /**
     * Object:生产日报单's 鸡血单价property 
     */
    public java.math.BigDecimal getChickenBloodPrice()
    {
        return getBigDecimal("chickenBloodPrice");
    }
    public void setChickenBloodPrice(java.math.BigDecimal item)
    {
        setBigDecimal("chickenBloodPrice", item);
    }
    /**
     * Object:生产日报单's 鸡血金额property 
     */
    public java.math.BigDecimal getChickenBloodMoney()
    {
        return getBigDecimal("chickenBloodMoney");
    }
    public void setChickenBloodMoney(java.math.BigDecimal item)
    {
        setBigDecimal("chickenBloodMoney", item);
    }
    /**
     * Object:生产日报单's 鸡肠金额property 
     */
    public java.math.BigDecimal getChickenIntestineMoney()
    {
        return getBigDecimal("chickenIntestineMoney");
    }
    public void setChickenIntestineMoney(java.math.BigDecimal item)
    {
        setBigDecimal("chickenIntestineMoney", item);
    }
    /**
     * Object:生产日报单's 鸡嗉子金额property 
     */
    public java.math.BigDecimal getChickenCropMoney()
    {
        return getBigDecimal("chickenCropMoney");
    }
    public void setChickenCropMoney(java.math.BigDecimal item)
    {
        setBigDecimal("chickenCropMoney", item);
    }
    /**
     * Object:生产日报单's 杂油金额property 
     */
    public java.math.BigDecimal getMixedOilMoney()
    {
        return getBigDecimal("mixedOilMoney");
    }
    public void setMixedOilMoney(java.math.BigDecimal item)
    {
        setBigDecimal("mixedOilMoney", item);
    }
    /**
     * Object:生产日报单's 胴体出成率%property 
     */
    public java.math.BigDecimal getCarcassRatio()
    {
        return getBigDecimal("carcassRatio");
    }
    public void setCarcassRatio(java.math.BigDecimal item)
    {
        setBigDecimal("carcassRatio", item);
    }
    /**
     * Object: 生产日报单 's 公司 property 
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
     * Object:生产日报单's 综合出成率%property 
     */
    public java.math.BigDecimal getComprehensiveRatio()
    {
        return getBigDecimal("comprehensiveRatio");
    }
    public void setComprehensiveRatio(java.math.BigDecimal item)
    {
        setBigDecimal("comprehensiveRatio", item);
    }
    /**
     * Object:生产日报单's 分割出成率%property 
     */
    public java.math.BigDecimal getDivisionRatio()
    {
        return getBigDecimal("divisionRatio");
    }
    public void setDivisionRatio(java.math.BigDecimal item)
    {
        setBigDecimal("divisionRatio", item);
    }
    /**
     * Object:生产日报单's 综合售价property 
     */
    public java.math.BigDecimal getComprehensivePrice()
    {
        return getBigDecimal("comprehensivePrice");
    }
    public void setComprehensivePrice(java.math.BigDecimal item)
    {
        setBigDecimal("comprehensivePrice", item);
    }
    /**
     * Object:生产日报单's 毛鸡均重property 
     */
    public java.math.BigDecimal getGrossChickenAWgt()
    {
        return getBigDecimal("GrossChickenAWgt");
    }
    public void setGrossChickenAWgt(java.math.BigDecimal item)
    {
        setBigDecimal("GrossChickenAWgt", item);
    }
    /**
     * Object:生产日报单's 半包产品property 
     */
    public java.math.BigDecimal getHalfAPackProduct()
    {
        return getBigDecimal("halfAPackProduct");
    }
    public void setHalfAPackProduct(java.math.BigDecimal item)
    {
        setBigDecimal("halfAPackProduct", item);
    }
    /**
     * Object:生产日报单's 吨产品用水property 
     */
    public java.math.BigDecimal getTonProductWater()
    {
        return getBigDecimal("tonProductWater");
    }
    public void setTonProductWater(java.math.BigDecimal item)
    {
        setBigDecimal("tonProductWater", item);
    }
    /**
     * Object:生产日报单's 吨产品用煤property 
     */
    public java.math.BigDecimal getTonProductCoal()
    {
        return getBigDecimal("tonProductCoal");
    }
    public void setTonProductCoal(java.math.BigDecimal item)
    {
        setBigDecimal("tonProductCoal", item);
    }
    /**
     * Object:生产日报单's 吨产品制冷用电property 
     */
    public java.math.BigDecimal getTonProductColdEle()
    {
        return getBigDecimal("tonProductColdEle");
    }
    public void setTonProductColdEle(java.math.BigDecimal item)
    {
        setBigDecimal("tonProductColdEle", item);
    }
    /**
     * Object:生产日报单's 吨产品生产用电property 
     */
    public java.math.BigDecimal getTonProductionEle()
    {
        return getBigDecimal("tonProductionEle");
    }
    public void setTonProductionEle(java.math.BigDecimal item)
    {
        setBigDecimal("tonProductionEle", item);
    }
    /**
     * Object:生产日报单's 吨总用电量property 
     */
    public java.math.BigDecimal getTonAllEle()
    {
        return getBigDecimal("tonAllEle");
    }
    public void setTonAllEle(java.math.BigDecimal item)
    {
        setBigDecimal("tonAllEle", item);
    }
    /**
     * Object:生产日报单's 吨包装费用property 
     */
    public java.math.BigDecimal getTonPackingCost()
    {
        return getBigDecimal("tonPackingCost");
    }
    public void setTonPackingCost(java.math.BigDecimal item)
    {
        setBigDecimal("tonPackingCost", item);
    }
    /**
     * Object:生产日报单's 总人数property 
     */
    public int getAllPeople()
    {
        return getInt("allPeople");
    }
    public void setAllPeople(int item)
    {
        setInt("allPeople", item);
    }
    /**
     * Object:生产日报单's 出勤人数property 
     */
    public int getAttendancePeople()
    {
        return getInt("attendancePeople");
    }
    public void setAttendancePeople(int item)
    {
        setInt("attendancePeople", item);
    }
    /**
     * Object:生产日报单's 用工时间property 
     */
    public java.math.BigDecimal getWorkTime()
    {
        return getBigDecimal("workTime");
    }
    public void setWorkTime(java.math.BigDecimal item)
    {
        setBigDecimal("workTime", item);
    }
    /**
     * Object:生产日报单's 人均效率property 
     */
    public java.math.BigDecimal getPerCatipaEfficiency()
    {
        return getBigDecimal("perCatipaEfficiency");
    }
    public void setPerCatipaEfficiency(java.math.BigDecimal item)
    {
        setBigDecimal("perCatipaEfficiency", item);
    }
    /**
     * Object:生产日报单's 吨费用property 
     */
    public java.math.BigDecimal getTonPrice()
    {
        return getBigDecimal("tonPrice");
    }
    public void setTonPrice(java.math.BigDecimal item)
    {
        setBigDecimal("tonPrice", item);
    }
    /**
     * Object:生产日报单's 出成率常数property 
     */
    public java.math.BigDecimal getRatioConstant()
    {
        return getBigDecimal("ratioConstant");
    }
    public void setRatioConstant(java.math.BigDecimal item)
    {
        setBigDecimal("ratioConstant", item);
    }
    /**
     * Object:生产日报单's 主产产量property 
     */
    public java.math.BigDecimal getMainProductQty()
    {
        return getBigDecimal("mainProductQty");
    }
    public void setMainProductQty(java.math.BigDecimal item)
    {
        setBigDecimal("mainProductQty", item);
    }
    /**
     * Object:生产日报单's 其他产量property 
     */
    public java.math.BigDecimal getOtherProductQty()
    {
        return getBigDecimal("otherProductQty");
    }
    public void setOtherProductQty(java.math.BigDecimal item)
    {
        setBigDecimal("otherProductQty", item);
    }
    /**
     * Object:生产日报单's 主产金额property 
     */
    public java.math.BigDecimal getMainProductAmt()
    {
        return getBigDecimal("mainProductAmt");
    }
    public void setMainProductAmt(java.math.BigDecimal item)
    {
        setBigDecimal("mainProductAmt", item);
    }
    /**
     * Object:生产日报单's 其他金额property 
     */
    public java.math.BigDecimal getOtherProductAmt()
    {
        return getBigDecimal("otherProductAmt");
    }
    public void setOtherProductAmt(java.math.BigDecimal item)
    {
        setBigDecimal("otherProductAmt", item);
    }
    /**
     * Object:生产日报单's 板油数量property 
     */
    public java.math.BigDecimal getSuetQty()
    {
        return getBigDecimal("suetQty");
    }
    public void setSuetQty(java.math.BigDecimal item)
    {
        setBigDecimal("suetQty", item);
    }
    /**
     * Object:生产日报单's 鸡头数量property 
     */
    public java.math.BigDecimal getHeadQty()
    {
        return getBigDecimal("headQty");
    }
    public void setHeadQty(java.math.BigDecimal item)
    {
        setBigDecimal("headQty", item);
    }
    /**
     * Object: 生产日报单 's 产品明细 property 
     */
    public com.kingdee.eas.custom.szcount.FreshDailyEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.szcount.FreshDailyEntryCollection)get("Entry");
    }
    /**
     * Object:生产日报单's 副产产量property 
     */
    public java.math.BigDecimal getByProductQty()
    {
        return getBigDecimal("byProductQty");
    }
    public void setByProductQty(java.math.BigDecimal item)
    {
        setBigDecimal("byProductQty", item);
    }
    /**
     * Object:生产日报单's 副产金额property 
     */
    public java.math.BigDecimal getByProductAmt()
    {
        return getBigDecimal("byProductAmt");
    }
    public void setByProductAmt(java.math.BigDecimal item)
    {
        setBigDecimal("byProductAmt", item);
    }
    /**
     * Object:生产日报单's 产品类型property 
     */
    public com.kingdee.eas.custom.szcount.ProductType getProductType()
    {
        return com.kingdee.eas.custom.szcount.ProductType.getEnum(getInt("productType"));
    }
    public void setProductType(com.kingdee.eas.custom.szcount.ProductType item)
    {
		if (item != null) {
        setInt("productType", item.getValue());
		}
    }
    /**
     * Object:生产日报单's 棚前损耗毛重property 
     */
    public java.math.BigDecimal getShedBLossGrossWgt()
    {
        return getBigDecimal("ShedBLossGrossWgt");
    }
    public void setShedBLossGrossWgt(java.math.BigDecimal item)
    {
        setBigDecimal("ShedBLossGrossWgt", item);
    }
    /**
     * Object:生产日报单's 是否半天班property 
     */
    public boolean isHalfWorkDay()
    {
        return getBoolean("halfWorkDay");
    }
    public void setHalfWorkDay(boolean item)
    {
        setBoolean("halfWorkDay", item);
    }
    /**
     * Object:生产日报单's 上午宰杀数量property 
     */
    public java.math.BigDecimal getMorningQty()
    {
        return getBigDecimal("morningQty");
    }
    public void setMorningQty(java.math.BigDecimal item)
    {
        setBigDecimal("morningQty", item);
    }
    /**
     * Object:生产日报单's 下午宰杀数量property 
     */
    public java.math.BigDecimal getAfternoonQty()
    {
        return getBigDecimal("afternoonQty");
    }
    public void setAfternoonQty(java.math.BigDecimal item)
    {
        setBigDecimal("afternoonQty", item);
    }
    /**
     * Object:生产日报单's 休班人数property 
     */
    public int getOffduty()
    {
        return getInt("offduty");
    }
    public void setOffduty(int item)
    {
        setInt("offduty", item);
    }
    /**
     * Object:生产日报单's 请假人数property 
     */
    public int getLeavenumber()
    {
        return getInt("Leavenumber");
    }
    public void setLeavenumber(int item)
    {
        setInt("Leavenumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("19270D36");
    }
}