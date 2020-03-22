package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBrowerItemNewInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBrowerItemNewInfo()
    {
        this("id");
    }
    protected AbstractBrowerItemNewInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �����Ŀ 's ������֯ property 
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
     * Object:�����Ŀ's ����״̬property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBillStatue()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("billStatue"));
    }
    public void setBillStatue(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatue", item.getValue());
		}
    }
    /**
     * Object:�����Ŀ's ��ߵ�ֻ���(Ԫ/ֻ)property 
     */
    public java.math.BigDecimal getHighBorrow()
    {
        return getBigDecimal("highBorrow");
    }
    public void setHighBorrow(java.math.BigDecimal item)
    {
        setBigDecimal("highBorrow", item);
    }
    /**
     * Object:�����Ŀ's ��ߵ��������(Ԫ)property 
     */
    public java.math.BigDecimal getHighFBorrow()
    {
        return getBigDecimal("highFBorrow");
    }
    public void setHighFBorrow(java.math.BigDecimal item)
    {
        setBigDecimal("highFBorrow", item);
    }
    /**
     * Object:�����Ŀ's �Ƿ���ȡ������Ϣproperty 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.booleanItem getIsTake()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.booleanItem.getEnum(getString("isTake"));
    }
    public void setIsTake(com.kingdee.eas.farm.carnivorous.basedata.booleanItem item)
    {
		if (item != null) {
        setString("isTake", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AA403686");
    }
}