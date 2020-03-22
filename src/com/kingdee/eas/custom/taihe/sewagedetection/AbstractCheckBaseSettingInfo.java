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
     * Object: �������� 's ��˾ property 
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
     * Object:��������'s ���ݵ�ַproperty 
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
     * Object:��������'s վ����property 
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
     * Object:��������'s վ����Կproperty 
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
     * Object:��������'s ��Ϣ���͵�ַproperty 
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