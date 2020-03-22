package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractContractTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractContractTypeInfo()
    {
        this("id");
    }
    protected AbstractContractTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 合同类别 's 创建组织 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("orgUnit");
    }
    public void setOrgUnit(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("orgUnit", item);
    }
    /**
     * Object:合同类别's 备注property 
     */
    public String getBIMUDF0003()
    {
        return getString("BIMUDF0003");
    }
    public void setBIMUDF0003(String item)
    {
        setString("BIMUDF0003", item);
    }
    /**
     * Object:合同类别's 状态property 
     */
    public com.kingdee.eas.custom.signwasthetable.UsedStatus getBillStatus()
    {
        return com.kingdee.eas.custom.signwasthetable.UsedStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.signwasthetable.UsedStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object:合同类别's 超额付款property 
     */
    public boolean isOverPay()
    {
        return getBoolean("overPay");
    }
    public void setOverPay(boolean item)
    {
        setBoolean("overPay", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("639C3776");
    }
}