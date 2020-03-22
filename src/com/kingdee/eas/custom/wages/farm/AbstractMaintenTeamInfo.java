package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaintenTeamInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMaintenTeamInfo()
    {
        this("id");
    }
    protected AbstractMaintenTeamInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.farm.MaintenTeamEntryCollection());
    }
    /**
     * Object: 维修队工时计算单 's 分录 property 
     */
    public com.kingdee.eas.custom.wages.farm.MaintenTeamEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.farm.MaintenTeamEntryCollection)get("entrys");
    }
    /**
     * Object:维修队工时计算单's 单据状态property 
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
     * Object:维修队工时计算单's 厂区工时系数property 
     */
    public String getTimerate()
    {
        return getString("timerate");
    }
    public void setTimerate(String item)
    {
        setString("timerate", item);
    }
    /**
     * Object:维修队工时计算单's 单据名称property 
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
     * Object:维修队工时计算单's 公司工时系数property 
     */
    public String getCompanyrate()
    {
        return getString("companyrate");
    }
    public void setCompanyrate(String item)
    {
        setString("companyrate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B64259D7");
    }
}