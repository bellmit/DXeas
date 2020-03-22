package com.kingdee.eas.custom.taihe.sewagedetection;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCheckBaseSettingInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractCheckBaseSettingInfo()
    {
        this("id");
    }
    protected AbstractCheckBaseSettingInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 基础设置 's 公司 property 
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
     * Object:基础设置's 数据地址property 
     */
    public String getCheckUrl()
    {
        return getString("checkUrl");
    }
    public void setCheckUrl(String item)
    {
        setString("checkUrl", item);
    }
    /**
     * Object:基础设置's 站点编号property 
     */
    public String getSiteNum()
    {
        return getString("siteNum");
    }
    public void setSiteNum(String item)
    {
        setString("siteNum", item);
    }
    /**
     * Object:基础设置's 站点秘钥property 
     */
    public String getSitePwd()
    {
        return getString("sitePwd");
    }
    public void setSitePwd(String item)
    {
        setString("sitePwd", item);
    }
    /**
     * Object:基础设置's 消息推送地址property 
     */
    public String getPostMsgUrl()
    {
        return getString("postMsgUrl");
    }
    public void setPostMsgUrl(String item)
    {
        setString("postMsgUrl", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E792FA54");
    }
}