package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCSlaughterBillQCEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCSlaughterBillQCEntryInfo()
    {
        this("id");
    }
    protected AbstractCSlaughterBillQCEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 质检扣罚分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 质检扣罚分录 's 质检项目 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemInfo getQCItem()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemInfo)get("QCItem");
    }
    public void setQCItem(com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemInfo item)
    {
        put("QCItem", item);
    }
    /**
     * Object:质检扣罚分录's 实际比例(%)property 
     */
    public java.math.BigDecimal getActualRate()
    {
        return getBigDecimal("actualRate");
    }
    public void setActualRate(java.math.BigDecimal item)
    {
        setBigDecimal("actualRate", item);
    }
    /**
     * Object:质检扣罚分录's 扣罚金额property 
     */
    public java.math.BigDecimal getPunishAmt()
    {
        return getBigDecimal("punishAmt");
    }
    public void setPunishAmt(java.math.BigDecimal item)
    {
        setBigDecimal("punishAmt", item);
    }
    /**
     * Object:质检扣罚分录's 实际重量property 
     */
    public java.math.BigDecimal getActualWgt()
    {
        return getBigDecimal("actualWgt");
    }
    public void setActualWgt(java.math.BigDecimal item)
    {
        setBigDecimal("actualWgt", item);
    }
    /**
     * Object:质检扣罚分录's 扣罚重量(kg)property 
     */
    public java.math.BigDecimal getPunishWgt()
    {
        return getBigDecimal("punishWgt");
    }
    public void setPunishWgt(java.math.BigDecimal item)
    {
        setBigDecimal("punishWgt", item);
    }
    /**
     * Object:质检扣罚分录's 奖惩类型property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.PunishType getRandPType()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.PunishType.getEnum(getString("randPType"));
    }
    public void setRandPType(com.kingdee.eas.farm.carnivorous.basedata.PunishType item)
    {
		if (item != null) {
        setString("randPType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("14DD3EAC");
    }
}