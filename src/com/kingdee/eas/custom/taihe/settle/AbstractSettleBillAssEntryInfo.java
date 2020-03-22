package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleBillAssEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettleBillAssEntryInfo()
    {
        this("id");
    }
    protected AbstractSettleBillAssEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 结算明细 's null property 
     */
    public com.kingdee.eas.custom.taihe.settle.SettleBillInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.settle.SettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.settle.SettleBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:结算明细's 称重类型property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarcassType getWgtType()
    {
        return com.kingdee.eas.custom.taihe.weight.CarcassType.getEnum(getString("wgtType"));
    }
    public void setWgtType(com.kingdee.eas.custom.taihe.weight.CarcassType item)
    {
		if (item != null) {
        setString("wgtType", item.getValue());
		}
    }
    /**
     * Object:结算明细's 只数property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:结算明细's 重量property 
     */
    public java.math.BigDecimal getWgt()
    {
        return getBigDecimal("wgt");
    }
    public void setWgt(java.math.BigDecimal item)
    {
        setBigDecimal("wgt", item);
    }
    /**
     * Object:结算明细's 折算系数property 
     */
    public java.math.BigDecimal getDisRate()
    {
        return getBigDecimal("disRate");
    }
    public void setDisRate(java.math.BigDecimal item)
    {
        setBigDecimal("disRate", item);
    }
    /**
     * Object:结算明细's 折算后重量property 
     */
    public java.math.BigDecimal getWgtAfterDis()
    {
        return getBigDecimal("wgtAfterDis");
    }
    public void setWgtAfterDis(java.math.BigDecimal item)
    {
        setBigDecimal("wgtAfterDis", item);
    }
    /**
     * Object:结算明细's 结算重量property 
     */
    public java.math.BigDecimal getSettleWgt()
    {
        return getBigDecimal("settleWgt");
    }
    public void setSettleWgt(java.math.BigDecimal item)
    {
        setBigDecimal("settleWgt", item);
    }
    /**
     * Object:结算明细's 胴体出成系数property 
     */
    public java.math.BigDecimal getSettleRate()
    {
        return getBigDecimal("settleRate");
    }
    public void setSettleRate(java.math.BigDecimal item)
    {
        setBigDecimal("settleRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1A311D06");
    }
}