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
     * Object: �������� 's �������ϼ۸����� property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountSetEntryCollection getEntries()
    {
        return (com.kingdee.eas.custom.salediscount.DiscountSetEntryCollection)get("entries");
    }
    /**
     * Object:��������'s ��Ч����property 
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
     * Object:��������'s ʧЧ����property 
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
     * Object:��������'s ���Ϸ����׼property 
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
     * Object:��������'s �������property 
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
     * Object:��������'s ��������property 
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
     * Object:��������'s ���ñ�־property 
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
     * Object:��������'s ��˱�־property 
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
     * Object:��������'s �۸����property 
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
     * Object:��������'s �ͻ��۸������ϸproperty 
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
     * Object:��������'s ���ϼ۸������ϸproperty 
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
     * Object:��������'s ��������property 
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
     * Object:��������'s �۸�������ȼ�property 
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
     * Object: �������� 's �ͻ������׼ property 
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
     * Object: �������� 's ������֯ property 
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
     * Object:��������'s �������property 
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
     * Object:��������'s �Ƿ�����Ŀ��property 
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
     * Object:��������'s �������property 
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
     * Object:��������'s ͬ�ͻ����в�Ʒ���ƺϲ�����property 
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
     * Object:��������'s �ۼ�����property 
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
     * Object:��������'s �ۼƽ�������property 
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
     * Object:��������'s �ۼƿ�ʼ����property 
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
     * Object:��������'s �������пͻ�property 
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