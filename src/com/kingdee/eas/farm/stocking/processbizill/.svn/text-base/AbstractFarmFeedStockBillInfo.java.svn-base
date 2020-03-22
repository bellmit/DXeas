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
     * Object: 种禽养殖户饲料库存单 's 分录 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.FarmFeedStockBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.FarmFeedStockBillEntryCollection)get("entrys");
    }
    /**
     * Object:种禽养殖户饲料库存单's 是否生成凭证property 
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
     * Object:种禽养殖户饲料库存单's 单据状态property 
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
     * Object: 种禽养殖户饲料库存单 's 财务组织 property 
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
     * Object:种禽养殖户饲料库存单's 摘要property 
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