package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDiscountSetInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDiscountSetInfo()
    {
        this("id");
    }
    protected AbstractDiscountSetInfo(String pkField)
    {
        super(pkField);
        put("entries", new com.kingdee.eas.custom.salediscount.DiscountSetEntryCollection());
    }
    /**
     * Object: 折让设置 's 具体物料价格政策 property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountSetEntryCollection getEntries()
    {
        return (com.kingdee.eas.custom.salediscount.DiscountSetEntryCollection)get("entries");
    }
    /**
     * Object:折让设置's 生效日期property 
     */
    public java.util.Date getEffectiveDate()
    {
        return getDate("effectiveDate");
    }
    public void setEffectiveDate(java.util.Date item)
    {
        setDate("effectiveDate", item);
    }
    /**
     * Object:折让设置's 失效日期property 
     */
    public java.util.Date getExpireDate()
    {
        return getDate("expireDate");
    }
    public void setExpireDate(java.util.Date item)
    {
        setDate("expireDate", item);
    }
    /**
     * Object:折让设置's 物料分类标准property 
     */
    public String getGroupStandardMaterial()
    {
        return getString("groupStandardMaterial");
    }
    public void setGroupStandardMaterial(String item)
    {
        setString("groupStandardMaterial", item);
    }
    /**
     * Object:折让设置's 审核日期property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("auditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("auditDate", item);
    }
    /**
     * Object:折让设置's 周期设置property 
     */
    public String getCycleSet()
    {
        return getString("cycleSet");
    }
    public void setCycleSet(String item)
    {
        setString("cycleSet", item);
    }
    /**
     * Object:折让设置's 禁用标志property 
     */
    public com.kingdee.eas.basedata.scm.sd.sale.ForbidStatusEnum getBlockedStatus()
    {
        return com.kingdee.eas.basedata.scm.sd.sale.ForbidStatusEnum.getEnum(getInt("blockedStatus"));
    }
    public void setBlockedStatus(com.kingdee.eas.basedata.scm.sd.sale.ForbidStatusEnum item)
    {
		if (item != null) {
        setInt("blockedStatus", item.getValue());
		}
    }
    /**
     * Object:折让设置's 审核标志property 
     */
    public com.kingdee.eas.framework.CheckedStatusEnum getCheckedStatus()
    {
        return com.kingdee.eas.framework.CheckedStatusEnum.getEnum(getInt("checkedStatus"));
    }
    public void setCheckedStatus(com.kingdee.eas.framework.CheckedStatusEnum item)
    {
		if (item != null) {
        setInt("checkedStatus", item.getValue());
		}
    }
    /**
     * Object:折让设置's 价格组合property 
     */
    public com.kingdee.eas.basedata.scm.common.PriceCompositionEnum getPriceComposition()
    {
        return com.kingdee.eas.basedata.scm.common.PriceCompositionEnum.getEnum(getInt("priceComposition"));
    }
    public void setPriceComposition(com.kingdee.eas.basedata.scm.common.PriceCompositionEnum item)
    {
		if (item != null) {
        setInt("priceComposition", item.getValue());
		}
    }
    /**
     * Object:折让设置's 客户价格组合明细property 
     */
    public com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum getPriceCompDetailCustomer()
    {
        return com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum.getEnum(getInt("priceCompDetailCustomer"));
    }
    public void setPriceCompDetailCustomer(com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum item)
    {
		if (item != null) {
        setInt("priceCompDetailCustomer", item.getValue());
		}
    }
    /**
     * Object:折让设置's 物料价格组合明细property 
     */
    public com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum getPriceCompDetailmaterial()
    {
        return com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum.getEnum(getInt("priceCompDetailmaterial"));
    }
    public void setPriceCompDetailmaterial(com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum item)
    {
		if (item != null) {
        setInt("priceCompDetailmaterial", item.getValue());
		}
    }
    /**
     * Object:折让设置's 政策名称property 
     */
    public String getName()
    {
        return getName((Locale)null);
    }
    public void setName(String item)
    {
		setName(item,(Locale)null);
    }
    public String getName(Locale local)
    {
        return TypeConversionUtils.objToString(get("name", local));
    }
    public void setName(String item, Locale local)
    {
        put("name", item, local);
    }
    /**
     * Object:折让设置's 价格组合优先级property 
     */
    public int getPriceCompositionPriority()
    {
        return getInt("priceCompositionPriority");
    }
    public void setPriceCompositionPriority(int item)
    {
        setInt("priceCompositionPriority", item);
    }
    /**
     * Object: 折让设置 's 客户分类标准 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardInfo getGroupStandardCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardInfo)get("groupStandardCustomer");
    }
    public void setGroupStandardCustomer(com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardInfo item)
    {
        put("groupStandardCustomer", item);
    }
    /**
     * Object: 折让设置 's 销售组织 property 
     */
    public com.kingdee.eas.basedata.org.SaleOrgUnitInfo getSaleOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.SaleOrgUnitInfo)get("saleOrgUnit");
    }
    public void setSaleOrgUnit(com.kingdee.eas.basedata.org.SaleOrgUnitInfo item)
    {
        put("saleOrgUnit", item);
    }
    /**
     * Object:折让设置's 折让类别property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountTypeEnum getDiscountType()
    {
        return com.kingdee.eas.custom.salediscount.DiscountTypeEnum.getEnum(getString("discountType"));
    }
    public void setDiscountType(com.kingdee.eas.custom.salediscount.DiscountTypeEnum item)
    {
		if (item != null) {
        setString("discountType", item.getValue());
		}
    }
    /**
     * Object:折让设置's 是否启用目标property 
     */
    public boolean isIsEnableAim()
    {
        return getBoolean("isEnableAim");
    }
    public void setIsEnableAim(boolean item)
    {
        setBoolean("isEnableAim", item);
    }
    /**
     * Object:折让设置's 政策类别property 
     */
    public com.kingdee.eas.custom.salediscount.DsNameTypeEnum getDsNameType()
    {
        return com.kingdee.eas.custom.salediscount.DsNameTypeEnum.getEnum(getString("dsNameType"));
    }
    public void setDsNameType(com.kingdee.eas.custom.salediscount.DsNameTypeEnum item)
    {
		if (item != null) {
        setString("dsNameType", item.getValue());
		}
    }
    /**
     * Object:折让设置's 同客户所有产品限制合并计算property 
     */
    public boolean isIsLimitMerge()
    {
        return getBoolean("isLimitMerge");
    }
    public void setIsLimitMerge(boolean item)
    {
        setBoolean("isLimitMerge", item);
    }
    /**
     * Object:折让设置's 累计销量property 
     */
    public boolean isByMonthQtyLimit()
    {
        return getBoolean("byMonthQtyLimit");
    }
    public void setByMonthQtyLimit(boolean item)
    {
        setBoolean("byMonthQtyLimit", item);
    }
    /**
     * Object:折让设置's 累计结束日期property 
     */
    public java.util.Date getAccumulaEnddate()
    {
        return getDate("accumulaEnddate");
    }
    public void setAccumulaEnddate(java.util.Date item)
    {
        setDate("accumulaEnddate", item);
    }
    /**
     * Object:折让设置's 累计开始日期property 
     */
    public java.util.Date getAccumulaBeginDate()
    {
        return getDate("accumulaBeginDate");
    }
    public void setAccumulaBeginDate(java.util.Date item)
    {
        setDate("accumulaBeginDate", item);
    }
    /**
     * Object:折让设置's 适用所有客户property 
     */
    public boolean isIsAllCustomer()
    {
        return getBoolean("isAllCustomer");
    }
    public void setIsAllCustomer(boolean item)
    {
        setBoolean("isAllCustomer", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("32599B86");
    }
}