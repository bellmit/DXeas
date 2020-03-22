package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBorrowItemReturnInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBorrowItemReturnInfo()
    {
        this("id");
    }
    protected AbstractBorrowItemReturnInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.carnivorous.basedata.BorrowItemReturnEntryCollection());
    }
    /**
     * Object:借款项目还款标准's 单据状态property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBillStatue()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("billStatue"));
    }
    public void setBillStatue(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatue", item.getValue());
		}
    }
    /**
     * Object: 借款项目还款标准 's 公司 property 
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
     * Object: 借款项目还款标准 's 借款项目 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo getBorrowItem()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo)get("borrowItem");
    }
    public void setBorrowItem(com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo item)
    {
        put("borrowItem", item);
    }
    /**
     * Object:借款项目还款标准's 最低单只净利润(元/只)property 
     */
    public java.math.BigDecimal getLessOneProfit()
    {
        return getBigDecimal("lessOneProfit");
    }
    public void setLessOneProfit(java.math.BigDecimal item)
    {
        setBigDecimal("lessOneProfit", item);
    }
    /**
     * Object:借款项目还款标准's 开始日期property 
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
     * Object:借款项目还款标准's 结束日期property 
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
     * Object: 借款项目还款标准 's 基础信息 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BorrowItemReturnEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BorrowItemReturnEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("723CAF9A");
    }
}