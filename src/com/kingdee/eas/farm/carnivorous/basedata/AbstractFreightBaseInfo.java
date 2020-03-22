package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFreightBaseInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFreightBaseInfo()
    {
        this("id");
    }
    protected AbstractFreightBaseInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.carnivorous.basedata.FreightBaseEntryCollection());
    }
    /**
     * Object: �˷ѻ������� 's ��˾ property 
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
     * Object:�˷ѻ�������'s ��ʼ����property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:�˷ѻ�������'s ��������property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object:�˷ѻ�������'s ����״̬property 
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
     * Object: �˷ѻ������� 's �˷�ϵ����¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FreightBaseEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FreightBaseEntryCollection)get("Entry");
    }
    /**
     * Object: �˷ѻ������� 's ����� property 
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
     * Object:�˷ѻ�������'s ���ʱ��property 
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
     * Object:�˷ѻ�������'s �˷�����property 
     */
    public com.kingdee.eas.farm.carnivorous.assistbiz.FreightTypeEnum getFreightType()
    {
        return com.kingdee.eas.farm.carnivorous.assistbiz.FreightTypeEnum.getEnum(getString("freightType"));
    }
    public void setFreightType(com.kingdee.eas.farm.carnivorous.assistbiz.FreightTypeEnum item)
    {
		if (item != null) {
        setString("freightType", item.getValue());
		}
    }
    /**
     * Object:�˷ѻ�������'s ��ʽ�ı�property 
     */
    public String getFormalText()
    {
        return getString("formalText");
    }
    public void setFormalText(String item)
    {
        setString("formalText", item);
    }
    /**
     * Object:�˷ѻ�������'s ���׶�λproperty 
     */
    public java.math.BigDecimal getCellValue()
    {
        return getBigDecimal("cellValue");
    }
    public void setCellValue(java.math.BigDecimal item)
    {
        setBigDecimal("cellValue", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C7C1B9D2");
    }
}