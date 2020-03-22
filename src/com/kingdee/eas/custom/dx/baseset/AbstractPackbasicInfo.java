package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPackbasicInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractPackbasicInfo()
    {
        this("id");
    }
    protected AbstractPackbasicInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.dx.baseset.PackbasicEntryCollection());
    }
    /**
     * Object:包装信息维护's 是否生成凭证property 
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
     * Object: 包装信息维护 's 产品明细 property 
     */
    public com.kingdee.eas.custom.dx.baseset.PackbasicEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.dx.baseset.PackbasicEntryCollection)get("Entry");
    }
    /**
     * Object: 包装信息维护 's 公司 property 
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
        return new BOSObjectType("EAD218E9");
    }
}