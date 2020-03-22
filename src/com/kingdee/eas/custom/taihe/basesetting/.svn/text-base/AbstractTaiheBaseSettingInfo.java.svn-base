package com.kingdee.eas.custom.taihe.basesetting;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTaiheBaseSettingInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractTaiheBaseSettingInfo()
    {
        this("id");
    }
    protected AbstractTaiheBaseSettingInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 基础设置 's 财务组织 property 
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
     * Object:基础设置's 标准出栏天数property 
     */
    public int getStdOutDays()
    {
        return getInt("stdOutDays");
    }
    public void setStdOutDays(int item)
    {
        setInt("stdOutDays", item);
    }
    /**
     * Object:基础设置's 饲养类别property 
     */
    public com.kingdee.eas.custom.taihe.contract.FeedType getFeedingType()
    {
        return com.kingdee.eas.custom.taihe.contract.FeedType.getEnum(getString("feedingType"));
    }
    public void setFeedingType(com.kingdee.eas.custom.taihe.contract.FeedType item)
    {
		if (item != null) {
        setString("feedingType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FA9DEB0F");
    }
}