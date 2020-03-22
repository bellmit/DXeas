package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractConFeedContractPolicyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractConFeedContractPolicyEntryInfo()
    {
        this("id");
    }
    protected AbstractConFeedContractPolicyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���߷�¼ 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ���߷�¼ 's �������� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo getConfeedPolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo)get("confeedPolicy");
    }
    public void setConfeedPolicy(com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo item)
    {
        put("confeedPolicy", item);
    }
    /**
     * Object:���߷�¼'s ��ʼ����property 
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
     * Object:���߷�¼'s ��ֹ����property 
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
     * Object:���߷�¼'s �Ƿ�Ĭ��property 
     */
    public boolean isIsDefault()
    {
        return getBoolean("isDefault");
    }
    public void setIsDefault(boolean item)
    {
        setBoolean("isDefault", item);
    }
    /**
     * Object:���߷�¼'s ��������property 
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
     * Object: ���߷�¼ 's Ʒ�� property 
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
     * Object:���߷�¼'s ��������property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SubsidyType getSubsidyType()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.SubsidyType.getEnum(getString("subsidyType"));
    }
    public void setSubsidyType(com.kingdee.eas.farm.carnivorous.basedata.SubsidyType item)
    {
		if (item != null) {
        setString("subsidyType", item.getValue());
		}
    }
    /**
     * Object:���߷�¼'s ��������property 
     */
    public java.math.BigDecimal getSubsidy()
    {
        return getBigDecimal("subsidy");
    }
    public void setSubsidy(java.math.BigDecimal item)
    {
        setBigDecimal("subsidy", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BC2964F2");
    }
}