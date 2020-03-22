package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractYieldDataBaseDisRateEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractYieldDataBaseDisRateEntryInfo()
    {
        this("id");
    }
    protected AbstractYieldDataBaseDisRateEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ����ϵ����¼ 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:����ϵ����¼'s �����ʲ�����property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CarcassTypeEnum getCarcassType()
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.CarcassTypeEnum.getEnum(getString("carcassType"));
    }
    public void setCarcassType(com.kingdee.eas.farm.carnivorous.recyclebiz.CarcassTypeEnum item)
    {
		if (item != null) {
        setString("carcassType", item.getValue());
		}
    }
    /**
     * Object:����ϵ����¼'s ����ϵ��property 
     */
    public java.math.BigDecimal getDisRate()
    {
        return getBigDecimal("disRate");
    }
    public void setDisRate(java.math.BigDecimal item)
    {
        setBigDecimal("disRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("300AEF8A");
    }
}