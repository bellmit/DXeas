package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaterialStandardCostInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractMaterialStandardCostInfo()
    {
        this("id");
    }
    protected AbstractMaterialStandardCostInfo(String pkField)
    {
        super(pkField);
        put("CostDetailEntry", new com.kingdee.eas.custom.salepayment.MaterialStandardCostCostDetailEntryCollection());
    }
    /**
     * Object: ��׼�ɱ� 's ��� property 
     */
    public com.kingdee.eas.custom.salepayment.MaterialStandardCostTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.salepayment.MaterialStandardCostTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.salepayment.MaterialStandardCostTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: ��׼�ɱ� 's �ɱ���ϸ property 
     */
    public com.kingdee.eas.custom.salepayment.MaterialStandardCostCostDetailEntryCollection getCostDetailEntry()
    {
        return (com.kingdee.eas.custom.salepayment.MaterialStandardCostCostDetailEntryCollection)get("CostDetailEntry");
    }
    /**
     * Object: ��׼�ɱ� 's ��˾ property 
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
     * Object:��׼�ɱ�'s ״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:��׼�ɱ�'s ���ʱ��property 
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
     * Object: ��׼�ɱ� 's ����� property 
     */
    public com.kingdee.eas.base.permission.UserInfo getAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("auditor");
    }
    public void setAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("auditor", item);
    }
    /**
     * Object:��׼�ɱ�'s ��property 
     */
    public int getYear()
    {
        return getInt("year");
    }
    public void setYear(int item)
    {
        setInt("year", item);
    }
    /**
     * Object:��׼�ɱ�'s ����״̬property 
     */
    public com.kingdee.eas.custom.salepayment.DisableState getDeletedStatus()
    {
        return com.kingdee.eas.custom.salepayment.DisableState.getEnum(getInt("deletedStatus"));
    }
    public void setDeletedStatus(com.kingdee.eas.custom.salepayment.DisableState item)
    {
		if (item != null) {
        setInt("deletedStatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B6F01FE5");
    }
}