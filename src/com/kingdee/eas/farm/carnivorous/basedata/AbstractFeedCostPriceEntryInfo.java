package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedCostPriceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFeedCostPriceEntryInfo()
    {
        this("id");
    }
    protected AbstractFeedCostPriceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 标准运输距离(km)property 
     */
    public java.math.BigDecimal getStandInstance()
    {
        return getBigDecimal("standInstance");
    }
    public void setStandInstance(java.math.BigDecimal item)
    {
        setBigDecimal("standInstance", item);
    }
    /**
     * Object:分录's 公司承担运费价格(元/kg)property 
     */
    public java.math.BigDecimal getCompanyPrice()
    {
        return getBigDecimal("companyPrice");
    }
    public void setCompanyPrice(java.math.BigDecimal item)
    {
        setBigDecimal("companyPrice", item);
    }
    /**
     * Object:分录's 超出标准距离养户承担运费价格(元/kg)property 
     */
    public java.math.BigDecimal getOverStandFarmerPrice()
    {
        return getBigDecimal("overStandFarmerPrice");
    }
    public void setOverStandFarmerPrice(java.math.BigDecimal item)
    {
        setBigDecimal("overStandFarmerPrice", item);
    }
    /**
     * Object: 分录 's 养殖场 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:分录's 比较类型property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.fodderInstanceEnum getCompareTyp()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.fodderInstanceEnum.getEnum(getString("compareTyp"));
    }
    public void setCompareTyp(com.kingdee.eas.farm.carnivorous.basedata.fodderInstanceEnum item)
    {
		if (item != null) {
        setString("compareTyp", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0A79EEB6");
    }
}