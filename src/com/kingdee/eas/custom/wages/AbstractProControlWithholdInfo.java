package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProControlWithholdInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProControlWithholdInfo()
    {
        this("id");
    }
    protected AbstractProControlWithholdInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.ProControlWithholdEntryCollection());
    }
    /**
     * Object: Ʒ�ؿۿ 's ��¼ property 
     */
    public com.kingdee.eas.custom.wages.ProControlWithholdEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.ProControlWithholdEntryCollection)get("entrys");
    }
    /**
     * Object:Ʒ�ؿۿ's �Ƿ�����ƾ֤property 
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
     * Object:Ʒ�ؿۿ's ����״̬property 
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
     * Object:Ʒ�ؿۿ's ��Ч����property 
     */
    public java.util.Date getStartDate()
    {
        return getDate("startDate");
    }
    public void setStartDate(java.util.Date item)
    {
        setDate("startDate", item);
    }
    /**
     * Object: Ʒ�ؿۿ 's ���� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("614C0E9D");
    }
}