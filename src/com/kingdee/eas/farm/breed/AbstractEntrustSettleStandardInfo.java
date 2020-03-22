package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEntrustSettleStandardInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractEntrustSettleStandardInfo()
    {
        this("id");
    }
    protected AbstractEntrustSettleStandardInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ί����ֳ�����׼ 's ��� property 
     */
    public com.kingdee.eas.farm.breed.EntrustSettleStandardTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.breed.EntrustSettleStandardTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.breed.EntrustSettleStandardTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:ί����ֳ�����׼'s ������property 
     */
    public String getFodderQty()
    {
        return getString("fodderQty");
    }
    public void setFodderQty(String item)
    {
        setString("fodderQty", item);
    }
    /**
     * Object:ί����ֳ�����׼'s �����property 
     */
    public String getMeatPerFodder()
    {
        return getString("meatPerFodder");
    }
    public void setMeatPerFodder(String item)
    {
        setString("meatPerFodder", item);
    }
    /**
     * Object:ί����ֳ�����׼'s ���վ���property 
     */
    public java.math.BigDecimal getAvgWeight()
    {
        return getBigDecimal("avgWeight");
    }
    public void setAvgWeight(java.math.BigDecimal item)
    {
        setBigDecimal("avgWeight", item);
    }
    /**
     * Object:ί����ֳ�����׼'s ֻҩ��property 
     */
    public java.math.BigDecimal getDrugAmountPer()
    {
        return getBigDecimal("drugAmountPer");
    }
    public void setDrugAmountPer(java.math.BigDecimal item)
    {
        setBigDecimal("drugAmountPer", item);
    }
    /**
     * Object:ί����ֳ�����׼'s ֻ����property 
     */
    public String getProfitPer()
    {
        return getString("profitPer");
    }
    public void setProfitPer(String item)
    {
        setString("profitPer", item);
    }
    /**
     * Object:ί����ֳ�����׼'s ֻ���ز�����property 
     */
    public java.math.BigDecimal getPerWeightLimit()
    {
        return getBigDecimal("perWeightLimit");
    }
    public void setPerWeightLimit(java.math.BigDecimal item)
    {
        setBigDecimal("perWeightLimit", item);
    }
    /**
     * Object:ί����ֳ�����׼'s ֻú��property 
     */
    public java.math.BigDecimal getCoalPer()
    {
        return getBigDecimal("coalPer");
    }
    public void setCoalPer(java.math.BigDecimal item)
    {
        setBigDecimal("coalPer", item);
    }
    /**
     * Object:ί����ֳ�����׼'s ����ϵ��property 
     */
    public java.math.BigDecimal getReward()
    {
        return getBigDecimal("reward");
    }
    public void setReward(java.math.BigDecimal item)
    {
        setBigDecimal("reward", item);
    }
    /**
     * Object:ί����ֳ�����׼'s �ͷ�ϵ��property 
     */
    public java.math.BigDecimal getPunish()
    {
        return getBigDecimal("punish");
    }
    public void setPunish(java.math.BigDecimal item)
    {
        setBigDecimal("punish", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("38EF653D");
    }
}