package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettingEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettingEntryInfo()
    {
        this("id");
    }
    protected AbstractSettingEntryInfo(String pkField)
    {
        super(pkField);
        put("MaterialEntrys", new com.kingdee.eas.weighbridge.SettingEntryMaterialEntryCollection());
    }
    /**
     * Object: ��ϸ�������� 's null property 
     */
    public com.kingdee.eas.weighbridge.SettingInfo getParent()
    {
        return (com.kingdee.eas.weighbridge.SettingInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.weighbridge.SettingInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��ϸ��������'s ��������property 
     */
    public com.kingdee.eas.weighbridge.WeighBillType getWeighBillType()
    {
        return com.kingdee.eas.weighbridge.WeighBillType.getEnum(getString("weighBillType"));
    }
    public void setWeighBillType(com.kingdee.eas.weighbridge.WeighBillType item)
    {
		if (item != null) {
        setString("weighBillType", item.getValue());
		}
    }
    /**
     * Object:��ϸ��������'s Ĭ��ҵ������property 
     */
    public com.kingdee.eas.weighbridge.WeighBizType getDefaultBizType()
    {
        return com.kingdee.eas.weighbridge.WeighBizType.getEnum(getString("defaultBizType"));
    }
    public void setDefaultBizType(com.kingdee.eas.weighbridge.WeighBizType item)
    {
		if (item != null) {
        setString("defaultBizType", item.getValue());
		}
    }
    /**
     * Object:��ϸ��������'s Ĭ�ϳ��ط�ʽproperty 
     */
    public com.kingdee.eas.weighbridge.WeighBaseType getDefaultWeighType()
    {
        return com.kingdee.eas.weighbridge.WeighBaseType.getEnum(getString("defaultWeighType"));
    }
    public void setDefaultWeighType(com.kingdee.eas.weighbridge.WeighBaseType item)
    {
		if (item != null) {
        setString("defaultWeighType", item.getValue());
		}
    }
    /**
     * Object: ��ϸ�������� 's ���Ϸ�Χ property 
     */
    public com.kingdee.eas.weighbridge.SettingEntryMaterialEntryCollection getMaterialEntrys()
    {
        return (com.kingdee.eas.weighbridge.SettingEntryMaterialEntryCollection)get("MaterialEntrys");
    }
    /**
     * Object:��ϸ��������'s �Զ����ɿ�浥��property 
     */
    public boolean isIsAuto2Inv()
    {
        return getBoolean("isAuto2Inv");
    }
    public void setIsAuto2Inv(boolean item)
    {
        setBoolean("isAuto2Inv", item);
    }
    /**
     * Object:��ϸ��������'s ��Χ����property 
     */
    public java.math.BigDecimal getRange()
    {
        return getBigDecimal("range");
    }
    public void setRange(java.math.BigDecimal item)
    {
        setBigDecimal("range", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1CBE335D");
    }
}