package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonFarmerRangeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPersonFarmerRangeInfo()
    {
        this("id");
    }
    protected AbstractPersonFarmerRangeInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeEntryCollection());
    }
    /**
     * Object: ����Ա������Χ 's ��� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: ����Ա������Χ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.PersonFarmerRangeEntryCollection)get("Entry");
    }
    /**
     * Object:����Ա������Χ's ����״̬property 
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
     * Object: ����Ա������Χ 's ����Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object: ����Ա������Χ 's ������֯ property 
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
        return new BOSObjectType("B444FBA3");
    }
}