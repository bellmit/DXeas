package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractExtractFromInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractExtractFromInfo()
    {
        this("id");
    }
    protected AbstractExtractFromInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.wages.ExtractFromEntryCollection());
    }
    /**
     * Object: 提取来源 's 物料明细 property 
     */
    public com.kingdee.eas.custom.wages.ExtractFromEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.wages.ExtractFromEntryCollection)get("Entry");
    }
    /**
     * Object:提取来源's 资料状态property 
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
     * Object: 提取来源 's 公司 property 
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
        return new BOSObjectType("0EFD8EC3");
    }
}