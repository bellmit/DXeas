package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWageFoodOrganInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractWageFoodOrganInfo()
    {
        this("id");
    }
    protected AbstractWageFoodOrganInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������֯�ܹ� 's ��� property 
     */
    public com.kingdee.eas.custom.wages.food.WageFoodOrganTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.wages.food.WageFoodOrganTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.wages.food.WageFoodOrganTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:������֯�ܹ�'s ҹ�ಹ����׼property 
     */
    public java.math.BigDecimal getNightAllowance()
    {
        return getBigDecimal("NightAllowance");
    }
    public void setNightAllowance(java.math.BigDecimal item)
    {
        setBigDecimal("NightAllowance", item);
    }
    /**
     * Object:������֯�ܹ�'s �Ӱಹ�����죩property 
     */
    public java.math.BigDecimal getOverTimeD()
    {
        return getBigDecimal("OverTimeD");
    }
    public void setOverTimeD(java.math.BigDecimal item)
    {
        setBigDecimal("OverTimeD", item);
    }
    /**
     * Object:������֯�ܹ�'s ����״̬property 
     */
    public com.kingdee.eas.custom.wages.BasicStatus getBasestatus()
    {
        return com.kingdee.eas.custom.wages.BasicStatus.getEnum(getString("basestatus"));
    }
    public void setBasestatus(com.kingdee.eas.custom.wages.BasicStatus item)
    {
		if (item != null) {
        setString("basestatus", item.getValue());
		}
    }
    /**
     * Object:������֯�ܹ�'s �������׼property 
     */
    public String getTravelallowance()
    {
        return getString("travelallowance");
    }
    public void setTravelallowance(String item)
    {
        setString("travelallowance", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("37D2DA49");
    }
}