package com.kingdee.eas.custom.settlebill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarcassRateInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCarcassRateInfo()
    {
        this("id");
    }
    protected AbstractCarcassRateInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.settlebill.CarcassRateEntryCollection());
        put("DisRateEntry", new com.kingdee.eas.custom.settlebill.CarcassRateDisRateEntryCollection());
    }
    /**
     * Object: ������������׼ 's ��� property 
     */
    public com.kingdee.eas.custom.settlebill.CarcassRateTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.settlebill.CarcassRateTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.settlebill.CarcassRateTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: ������������׼ 's ��¼ property 
     */
    public com.kingdee.eas.custom.settlebill.CarcassRateEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.settlebill.CarcassRateEntryCollection)get("Entry");
    }
    /**
     * Object:������������׼'s ��Ч����property 
     */
    public java.util.Date getEffectDate()
    {
        return getDate("effectDate");
    }
    public void setEffectDate(java.util.Date item)
    {
        setDate("effectDate", item);
    }
    /**
     * Object:������������׼'s ʧЧ����property 
     */
    public java.util.Date getUneffectDate()
    {
        return getDate("uneffectDate");
    }
    public void setUneffectDate(java.util.Date item)
    {
        setDate("uneffectDate", item);
    }
    /**
     * Object: ������������׼ 's ��˾ property 
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
     * Object:������������׼'s ����״̬property 
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
     * Object: ������������׼ 's �ۿ�ϵ����¼ property 
     */
    public com.kingdee.eas.custom.settlebill.CarcassRateDisRateEntryCollection getDisRateEntry()
    {
        return (com.kingdee.eas.custom.settlebill.CarcassRateDisRateEntryCollection)get("DisRateEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E8649C81");
    }
}