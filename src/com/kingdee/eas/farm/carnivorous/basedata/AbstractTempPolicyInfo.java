package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTempPolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractTempPolicyInfo()
    {
        this("id");
    }
    protected AbstractTempPolicyInfo(String pkField)
    {
        super(pkField);
        put("MarketPriceEntrys", new com.kingdee.eas.farm.carnivorous.basedata.TempPolicyMarketPriceEntryCollection());
        put("PolicyEntry", new com.kingdee.eas.farm.carnivorous.basedata.TempPolicyPolicyEntryCollection());
        put("Entrys", new com.kingdee.eas.farm.carnivorous.basedata.TempPolicyEntryCollection());
    }
    /**
     * Object: ��ʱ���� 's ������֯ property 
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
     * Object:��ʱ����'s ����״̬property 
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
     * Object:��ʱ����'s ҵ������property 
     */
    public java.util.Date getBizDate()
    {
        return getDate("bizDate");
    }
    public void setBizDate(java.util.Date item)
    {
        setDate("bizDate", item);
    }
    /**
     * Object:��ʱ����'s �������ڹ���property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.DateRelate getDateRelate()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.DateRelate.getEnum(getString("dateRelate"));
    }
    public void setDateRelate(com.kingdee.eas.farm.carnivorous.basedata.DateRelate item)
    {
		if (item != null) {
        setString("dateRelate", item.getValue());
		}
    }
    /**
     * Object:��ʱ����'s ��ʼ����property 
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
     * Object:��ʱ����'s ��������property 
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
     * Object:��ʱ����'s ����ѡ��property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.MaterialType getMaterialType()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.MaterialType.getEnum(getString("materialType"));
    }
    public void setMaterialType(com.kingdee.eas.farm.carnivorous.basedata.MaterialType item)
    {
		if (item != null) {
        setString("materialType", item.getValue());
		}
    }
    /**
     * Object:��ʱ����'s ���㵥λproperty 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.CalUnit getCalUnit()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.CalUnit.getEnum(getString("calUnit"));
    }
    public void setCalUnit(com.kingdee.eas.farm.carnivorous.basedata.CalUnit item)
    {
		if (item != null) {
        setString("calUnit", item.getValue());
		}
    }
    /**
     * Object:��ʱ����'s �۲�����property 
     */
    public java.math.BigDecimal getKbPrice()
    {
        return getBigDecimal("kbPrice");
    }
    public void setKbPrice(java.math.BigDecimal item)
    {
        setBigDecimal("kbPrice", item);
    }
    /**
     * Object:��ʱ����'s ������ʼֵproperty 
     */
    public java.math.BigDecimal getAvgWgtFrom()
    {
        return getBigDecimal("avgWgtFrom");
    }
    public void setAvgWgtFrom(java.math.BigDecimal item)
    {
        setBigDecimal("avgWgtFrom", item);
    }
    /**
     * Object:��ʱ����'s ������ֵֹproperty 
     */
    public java.math.BigDecimal getAvgWgtTo()
    {
        return getBigDecimal("avgWgtTo");
    }
    public void setAvgWgtTo(java.math.BigDecimal item)
    {
        setBigDecimal("avgWgtTo", item);
    }
    /**
     * Object:��ʱ����'s ȫ����ֳ��property 
     */
    public boolean isForAll()
    {
        return getBoolean("forAll");
    }
    public void setForAll(boolean item)
    {
        setBoolean("forAll", item);
    }
    /**
     * Object: ��ʱ���� 's ��¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.TempPolicyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.TempPolicyEntryCollection)get("Entrys");
    }
    /**
     * Object: ��ʱ���� 's �г��۲��� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.TempPolicyMarketPriceEntryCollection getMarketPriceEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.TempPolicyMarketPriceEntryCollection)get("MarketPriceEntrys");
    }
    /**
     * Object: ��ʱ���� 's Ʒ�� property 
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
     * Object: ��ʱ���� 's ������ϸ property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.TempPolicyPolicyEntryCollection getPolicyEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.TempPolicyPolicyEntryCollection)get("PolicyEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0A9A9548");
    }
}