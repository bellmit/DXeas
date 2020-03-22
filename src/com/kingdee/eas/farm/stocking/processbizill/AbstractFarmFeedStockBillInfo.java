package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmFeedStockBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFarmFeedStockBillInfo()
    {
        this("id");
    }
    protected AbstractFarmFeedStockBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.processbizill.FarmFeedStockBillEntryCollection());
    }
    /**
     * Object: ������ֳ�����Ͽ�浥 's ��¼ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.FarmFeedStockBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.FarmFeedStockBillEntryCollection)get("entrys");
    }
    /**
     * Object:������ֳ�����Ͽ�浥's �Ƿ�����ƾ֤property 
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
     * Object:������ֳ�����Ͽ�浥's ����״̬property 
     */
    public com.kingdee.eas.scm.common.EntryBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.EntryBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.EntryBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: ������ֳ�����Ͽ�浥 's ������֯ property 
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
     * Object:������ֳ�����Ͽ�浥's ժҪproperty 
     */
    public String getDigest()
    {
        return getString("digest");
    }
    public void setDigest(String item)
    {
        setString("digest", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3A06FAE4");
    }
}