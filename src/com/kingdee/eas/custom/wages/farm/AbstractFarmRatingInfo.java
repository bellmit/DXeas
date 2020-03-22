package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmRatingInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFarmRatingInfo()
    {
        this("id");
    }
    protected AbstractFarmRatingInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.farm.FarmRatingEntryCollection());
    }
    /**
     * Object: ��ֳ��˾���ȿ��˵� 's ��¼ property 
     */
    public com.kingdee.eas.custom.wages.farm.FarmRatingEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.farm.FarmRatingEntryCollection)get("entrys");
    }
    /**
     * Object:��ֳ��˾���ȿ��˵�'s ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("BillStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("BillStatus", item.getValue());
		}
    }
    /**
     * Object:��ֳ��˾���ȿ��˵�'s ��������property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    /**
     * Object: ��ֳ��˾���ȿ��˵� 's ���� property 
     */
    public com.kingdee.eas.custom.wages.farm.WagesFarmOrganInfo getCompany()
    {
        return (com.kingdee.eas.custom.wages.farm.WagesFarmOrganInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.custom.wages.farm.WagesFarmOrganInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EA7FF91D");
    }
}