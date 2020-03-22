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
     * Object: 养殖公司评比考核单 's 分录 property 
     */
    public com.kingdee.eas.custom.wages.farm.FarmRatingEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.farm.FarmRatingEntryCollection)get("entrys");
    }
    /**
     * Object:养殖公司评比考核单's 单据状态property 
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
     * Object:养殖公司评比考核单's 单据名称property 
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
     * Object: 养殖公司评比考核单 's 部门 property 
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