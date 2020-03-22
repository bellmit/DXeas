package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTranOutInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractTranOutInfo()
    {
        this("id");
    }
    protected AbstractTranOutInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.processbizill.TranOutEntryCollection());
    }
    /**
     * Object: 转出单 's 分录 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.TranOutEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.TranOutEntryCollection)get("entrys");
    }
    /**
     * Object:转出单's 是否生成凭证property 
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
     * Object:转出单's 出场时间property 
     */
    public java.sql.Time getOutTime()
    {
        return getTime("outTime");
    }
    public void setOutTime(java.sql.Time item)
    {
        setTime("outTime", item);
    }
    /**
     * Object:转出单's 运输车辆property 
     */
    public String getTranCar()
    {
        return getString("tranCar");
    }
    public void setTranCar(String item)
    {
        setString("tranCar", item);
    }
    /**
     * Object:转出单's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object:转出单's 单据状态property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.wzBillBaseStatus getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.processbizill.wzBillBaseStatus.getEnum(getString("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.processbizill.wzBillBaseStatus item)
    {
		if (item != null) {
        setString("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 转出单 's 公司 property 
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
        return new BOSObjectType("4103891E");
    }
}