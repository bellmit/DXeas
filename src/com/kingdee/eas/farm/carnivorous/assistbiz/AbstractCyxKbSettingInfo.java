package com.kingdee.eas.farm.carnivorous.assistbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCyxKbSettingInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCyxKbSettingInfo()
    {
        this("id");
    }
    protected AbstractCyxKbSettingInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.farm.carnivorous.assistbiz.CyxKbSettingEntryCollection());
    }
    /**
     * Object: ³áÓÙÑª¿Û²¹ 's ²ÆÎñ×éÖ¯ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFICompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FICompany");
    }
    public void setFICompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FICompany", item);
    }
    /**
     * Object: ³áÓÙÑª¿Û²¹ 's Æ·ÖÖ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breedData");
    }
    public void setBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breedData", item);
    }
    /**
     * Object:³áÓÙÑª¿Û²¹'s »ù±¾×´Ì¬property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: ³áÓÙÑª¿Û²¹ 's ·ÖÂ¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.assistbiz.CyxKbSettingEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.CyxKbSettingEntryCollection)get("Entrys");
    }
    /**
     * Object: ³áÓÙÑª¿Û²¹ 's ¿Í»§ property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object: ³áÓÙÑª¿Û²¹ 's ÖÊ¼ìÏîÄ¿ property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemInfo getQCItem()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemInfo)get("QCItem");
    }
    public void setQCItem(com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemInfo item)
    {
        put("QCItem", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8363C686");
    }
}