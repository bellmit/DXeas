package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBasePriceAdjustPolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBasePriceAdjustPolicyInfo()
    {
        this("id");
    }
    protected AbstractBasePriceAdjustPolicyInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyEntryCollection());
    }
    /**
     * Object: �����۸�������� 's ������֯ property 
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
     * Object:�����۸��������'s ����״̬property 
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
     * Object: �����۸�������� 's Ʒ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreed()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breed");
    }
    public void setBreed(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breed", item);
    }
    /**
     * Object:�����۸��������'s ��ʼ����property 
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
     * Object:�����۸��������'s ��������property 
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
     * Object: �����۸�������� 's ������Ŀ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo getSettleItem()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo)get("settleItem");
    }
    public void setSettleItem(com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo item)
    {
        put("settleItem", item);
    }
    /**
     * Object:�����۸��������'s ��׼ë���������ֵproperty 
     */
    public java.math.BigDecimal getStandHenWeightLow()
    {
        return getBigDecimal("standHenWeightLow");
    }
    public void setStandHenWeightLow(java.math.BigDecimal item)
    {
        setBigDecimal("standHenWeightLow", item);
    }
    /**
     * Object:�����۸��������'s ��׼ë���������ֵproperty 
     */
    public java.math.BigDecimal getStandHenWeightHign()
    {
        return getBigDecimal("standHenWeightHign");
    }
    public void setStandHenWeightHign(java.math.BigDecimal item)
    {
        setBigDecimal("standHenWeightHign", item);
    }
    /**
     * Object:�����۸��������'s ժҪproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:�����۸��������'s �ı�property 
     */
    public String getBIMUDF0010()
    {
        return getString("BIMUDF0010");
    }
    public void setBIMUDF0010(String item)
    {
        setString("BIMUDF0010", item);
    }
    /**
     * Object:�����۸��������'s �ı�property 
     */
    public String getBIMUDF0011()
    {
        return getString("BIMUDF0011");
    }
    public void setBIMUDF0011(String item)
    {
        setString("BIMUDF0011", item);
    }
    /**
     * Object:�����۸��������'s �ı�property 
     */
    public String getBIMUDF0012()
    {
        return getString("BIMUDF0012");
    }
    public void setBIMUDF0012(String item)
    {
        setString("BIMUDF0012", item);
    }
    /**
     * Object: �����۸�������� 's ��Ŀ property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5D3A3E57");
    }
}