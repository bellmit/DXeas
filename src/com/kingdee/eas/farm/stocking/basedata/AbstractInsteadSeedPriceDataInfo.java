package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInsteadSeedPriceDataInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractInsteadSeedPriceDataInfo()
    {
        this("id");
    }
    protected AbstractInsteadSeedPriceDataInfo(String pkField)
    {
        super(pkField);
        put("Range", new com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataRangeCollection());
        put("PriceEntry", new com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataPriceEntryCollection());
    }
    /**
     * Object: ���ά��(����) 's ��� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:���ά��(����)'s ˵��property 
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
     * Object: ���ά��(����) 's ��Ӧ���� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:���ά��(����)'s ����״̬property 
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
     * Object:���ά��(����)'s �۸�property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:���ά��(����)'s ����property 
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
     * Object: ���ά��(����) 's ������֯ property 
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
     * Object:���ά��(����)'s ʧЧ����property 
     */
    public java.util.Date getUnEffectDate()
    {
        return getDate("unEffectDate");
    }
    public void setUnEffectDate(java.util.Date item)
    {
        setDate("unEffectDate", item);
    }
    /**
     * Object: ���ά��(����) 's �۸��¼ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataPriceEntryCollection getPriceEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataPriceEntryCollection)get("PriceEntry");
    }
    /**
     * Object: ���ά��(����) 's ���÷�Χ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataRangeCollection getRange()
    {
        return (com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataRangeCollection)get("Range");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3E8049D1");
    }
}