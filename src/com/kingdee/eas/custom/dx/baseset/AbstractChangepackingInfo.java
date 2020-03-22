package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractChangepackingInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractChangepackingInfo()
    {
        this("id");
    }
    protected AbstractChangepackingInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.dx.baseset.ChangepackingEntryCollection());
    }
    /**
     * Object:包装换算关系's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 包装换算关系 's 产品明细 property 
     */
    public com.kingdee.eas.custom.dx.baseset.ChangepackingEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.dx.baseset.ChangepackingEntryCollection)get("Entry");
    }
    /**
     * Object: 包装换算关系 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("35D43EAD");
    }
}