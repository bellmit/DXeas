package com.kingdee.eas.custom.taihe.sewagedetection;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCheckRecordInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractCheckRecordInfo()
    {
        this("id");
    }
    protected AbstractCheckRecordInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.taihe.sewagedetection.CheckRecordEntryCollection());
    }
    /**
     * Object:检测记录's 是否生成凭证property 
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
     * Object: 检测记录 's 公司 property 
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
     * Object: 检测记录 's 明细 property 
     */
    public com.kingdee.eas.custom.taihe.sewagedetection.CheckRecordEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.taihe.sewagedetection.CheckRecordEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9AC07B1C");
    }
}