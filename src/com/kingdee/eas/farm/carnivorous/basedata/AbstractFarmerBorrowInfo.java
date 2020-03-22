package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerBorrowInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFarmerBorrowInfo()
    {
        this("id");
    }
    protected AbstractFarmerBorrowInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖户借款单 's 财务组织 property 
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
     * Object:养殖户借款单's 单据状态property 
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
     * Object:养殖户借款单's 业务日期property 
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
     * Object: 养殖户借款单 's 养殖户 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getFarmer()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object:养殖户借款单's 金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:养殖户借款单's 业务类型property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.isBorrow getIsBorrow()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.isBorrow.getEnum(getString("isBorrow"));
    }
    public void setIsBorrow(com.kingdee.eas.farm.carnivorous.basedata.isBorrow item)
    {
		if (item != null) {
        setString("isBorrow", item.getValue());
		}
    }
    /**
     * Object: 养殖户借款单 's 地区 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo getFarmerTree()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo)get("farmerTree");
    }
    public void setFarmerTree(com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo item)
    {
        put("farmerTree", item);
    }
    /**
     * Object:养殖户借款单's 银行卡号property 
     */
    public String getAccountNum()
    {
        return getString("accountNum");
    }
    public void setAccountNum(String item)
    {
        setString("accountNum", item);
    }
    /**
     * Object: 养殖户借款单 's 借款项目 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo getBrowerItem()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo)get("browerItem");
    }
    public void setBrowerItem(com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo item)
    {
        put("browerItem", item);
    }
    /**
     * Object:养殖户借款单's 备注property 
     */
    public String getRamerk()
    {
        return getString("ramerk");
    }
    public void setRamerk(String item)
    {
        setString("ramerk", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F47D9DDA");
    }
}