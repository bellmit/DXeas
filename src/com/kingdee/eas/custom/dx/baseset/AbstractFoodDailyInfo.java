package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFoodDailyInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractFoodDailyInfo()
    {
        this("id");
    }
    protected AbstractFoodDailyInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.dx.baseset.FoodDailyEntryCollection());
    }
    /**
     * Object:ʳƷ��Ӫ�ձ�'s �Ƿ�����ƾ֤property 
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
     * Object:ʳƷ��Ӫ�ձ�'s ��ɱֻ��property 
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
     * Object:ʳƷ��Ӫ�ձ�'s ë���ɱ�property 
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
     * Object:ʳƷ��Ӫ�ձ�'s ���մ���property 
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
     * Object:ʳƷ��Ӫ�ձ�'s ��ˮ��%property 
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
     * Object:ʳƷ��Ӫ�ձ�'s �ܽ��property 
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
     * Object:ʳƷ��Ӫ�ձ�'s �����ۼ�property 
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
     * Object:ʳƷ��Ӫ�ձ�'s �����ۼ�property 
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
     * Object: ʳƷ��Ӫ�ձ� 's ��˾ property 
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
     * Object:ʳƷ��Ӫ�ձ�'s ������property 
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
     * Object:ʳƷ��Ӫ�ձ�'s ��������property 
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
     * Object:ʳƷ��Ӫ�ձ�'s �ù�ʱ��property 
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
     * Object:ʳƷ��Ӫ�ձ�'s �˾�Ч��property 
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
     * Object:ʳƷ��Ӫ�ձ�'s �ַ���property 
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
     * Object:ʳƷ��Ӫ�ձ�'s �����ʳ���property 
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
     * Object:ʳƷ��Ӫ�ձ�'s ��������property 
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
     * Object:ʳƷ��Ӫ�ձ�'s ��������property 
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
     * Object:ʳƷ��Ӫ�ձ�'s �������property 
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
     * Object:ʳƷ��Ӫ�ձ�'s �������property 
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
     * Object:ʳƷ��Ӫ�ձ�'s ��������property 
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
     * Object:ʳƷ��Ӫ�ձ�'s ��ͷ����property 
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
     * Object: ʳƷ��Ӫ�ձ� 's ��Ʒ��ϸ property 
     */
    public com.kingdee.eas.custom.dx.baseset.FoodDailyEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.dx.baseset.FoodDailyEntryCollection)get("Entry");
    }
    /**
     * Object:ʳƷ��Ӫ�ձ�'s ��������property 
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
     * Object:ʳƷ��Ӫ�ձ�'s �������property 
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
     * Object:ʳƷ��Ӫ�ձ�'s ��Ʒ����property 
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
     * Object:ʳƷ��Ӫ�ձ�'s �ݰ�����property 
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
     * Object:ʳƷ��Ӫ�ձ�'s �������property 
     */
    public int getLeavenumber()
    {
        return getInt("Leavenumber");
    }
    public void setLeavenumber(int item)
    {
        setInt("Leavenumber", item);
    }
    /**
     * Object:ʳƷ��Ӫ�ձ�'s �۾ɷ�property 
     */
    public java.math.BigDecimal getZjf()
    {
        return getBigDecimal("zjf");
    }
    public void setZjf(java.math.BigDecimal item)
    {
        setBigDecimal("zjf", item);
    }
    /**
     * Object:ʳƷ��Ӫ�ձ�'s �⳵��property 
     */
    public java.math.BigDecimal getZcf()
    {
        return getBigDecimal("zcf");
    }
    public void setZcf(java.math.BigDecimal item)
    {
        setBigDecimal("zcf", item);
    }
    /**
     * Object:ʳƷ��Ӫ�ձ�'s ����property 
     */
    public java.math.BigDecimal getCailiao()
    {
        return getBigDecimal("cailiao");
    }
    public void setCailiao(java.math.BigDecimal item)
    {
        setBigDecimal("cailiao", item);
    }
    /**
     * Object:ʳƷ��Ӫ�ձ�'s �����property 
     */
    public java.math.BigDecimal getZulengku()
    {
        return getBigDecimal("zulengku");
    }
    public void setZulengku(java.math.BigDecimal item)
    {
        setBigDecimal("zulengku", item);
    }
    /**
     * Object:ʳƷ��Ӫ�ձ�'s ������֧property 
     */
    public java.math.BigDecimal getOtherpay()
    {
        return getBigDecimal("otherpay");
    }
    public void setOtherpay(java.math.BigDecimal item)
    {
        setBigDecimal("otherpay", item);
    }
    /**
     * Object:ʳƷ��Ӫ�ձ�'s ������property 
     */
    public java.math.BigDecimal getChaochanfei()
    {
        return getBigDecimal("chaochanfei");
    }
    public void setChaochanfei(java.math.BigDecimal item)
    {
        setBigDecimal("chaochanfei", item);
    }
    /**
     * Object:ʳƷ��Ӫ�ձ�'s ë������property 
     */
    public java.math.BigDecimal getGrossWeight()
    {
        return getBigDecimal("GrossWeight");
    }
    public void setGrossWeight(java.math.BigDecimal item)
    {
        setBigDecimal("GrossWeight", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3BA82B8F");
    }
}