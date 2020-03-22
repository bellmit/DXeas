package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCompanyinfoInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCompanyinfoInfo()
    {
        this("id");
    }
    protected AbstractCompanyinfoInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.foodtrac.CompanyinfoEntryCollection());
        put("Picentrys", new com.kingdee.eas.custom.foodtrac.CompanyinfoPicentryCollection());
    }
    /**
     * Object: 公司信息 's 分录 property 
     */
    public com.kingdee.eas.custom.foodtrac.CompanyinfoEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.foodtrac.CompanyinfoEntryCollection)get("entrys");
    }
    /**
     * Object:公司信息's 是否生成凭证property 
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
     * Object:公司信息's 公司名称property 
     */
    public String getCompanyname()
    {
        return getString("companyname");
    }
    public void setCompanyname(String item)
    {
        setString("companyname", item);
    }
    /**
     * Object:公司信息's 公司编码property 
     */
    public String getCompanynumber()
    {
        return getString("companynumber");
    }
    public void setCompanynumber(String item)
    {
        setString("companynumber", item);
    }
    /**
     * Object:公司信息's 公司地址property 
     */
    public String getNewaddress()
    {
        return getString("newaddress");
    }
    public void setNewaddress(String item)
    {
        setString("newaddress", item);
    }
    /**
     * Object:公司信息's 公司描述property 
     */
    public String getNewdesc()
    {
        return getString("newdesc");
    }
    public void setNewdesc(String item)
    {
        setString("newdesc", item);
    }
    /**
     * Object:公司信息's 营业范围property 
     */
    public String getNewbusiness()
    {
        return getString("newbusiness");
    }
    public void setNewbusiness(String item)
    {
        setString("newbusiness", item);
    }
    /**
     * Object: 公司信息 's 图片分录 property 
     */
    public com.kingdee.eas.custom.foodtrac.CompanyinfoPicentryCollection getPicentrys()
    {
        return (com.kingdee.eas.custom.foodtrac.CompanyinfoPicentryCollection)get("Picentrys");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3F1DACC6");
    }
}