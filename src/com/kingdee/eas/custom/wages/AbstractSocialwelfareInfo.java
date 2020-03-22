package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSocialwelfareInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSocialwelfareInfo()
    {
        this("id");
    }
    protected AbstractSocialwelfareInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.wages.SocialwelfareEntryCollection());
    }
    /**
     * Object: ������ 's ��¼ property 
     */
    public com.kingdee.eas.custom.wages.SocialwelfareEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.wages.SocialwelfareEntryCollection)get("entrys");
    }
    /**
     * Object:������'s �Ƿ�����ƾ֤property 
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
     * Object:������'s ����״̬property 
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
     * Object: ������ 's ��˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyOrg()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("companyOrg");
    }
    public void setCompanyOrg(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("companyOrg", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0C265977");
    }
}