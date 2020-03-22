package com.kingdee.eas.farm.stocking.basebizbill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMarginBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMarginBillInfo()
    {
        this("id");
    }
    protected AbstractMarginBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.basebizbill.MarginBillEntryCollection());
    }
    /**
     * Object: 保证金业务 's 分录 property 
     */
    public com.kingdee.eas.farm.stocking.basebizbill.MarginBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.MarginBillEntryCollection)get("entrys");
    }
    /**
     * Object:保证金业务's 是否生成凭证property 
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
     * Object:保证金业务's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object: 保证金业务 's 财务组织 property 
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
     * Object:保证金业务's 审核时间property 
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
     * Object: 保证金业务 's 养户名称 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object:保证金业务's 业务类型property 
     */
    public com.kingdee.eas.farm.stocking.basebizbill.MarginBizTypeEnum getBizType()
    {
        return com.kingdee.eas.farm.stocking.basebizbill.MarginBizTypeEnum.getEnum(getInt("bizType"));
    }
    public void setBizType(com.kingdee.eas.farm.stocking.basebizbill.MarginBizTypeEnum item)
    {
		if (item != null) {
        setInt("bizType", item.getValue());
		}
    }
    /**
     * Object: 保证金业务 's 保证金类型 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.MarginTypeInfo getMarginType()
    {
        return (com.kingdee.eas.farm.stocking.basedata.MarginTypeInfo)get("MarginType");
    }
    public void setMarginType(com.kingdee.eas.farm.stocking.basedata.MarginTypeInfo item)
    {
        put("MarginType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3052D876");
    }
}