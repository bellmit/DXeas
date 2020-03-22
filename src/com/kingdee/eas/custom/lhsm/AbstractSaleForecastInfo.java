package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSaleForecastInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSaleForecastInfo()
    {
        this("id");
    }
    protected AbstractSaleForecastInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.lhsm.SaleForecastEntryCollection());
    }
    /**
     * Object: 销售预报单 's 分录 property 
     */
    public com.kingdee.eas.custom.lhsm.SaleForecastEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.lhsm.SaleForecastEntryCollection)get("entrys");
    }
    /**
     * Object:销售预报单's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 销售预报单 's 购货客户 property 
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
     * Object:销售预报单's 开始日期property 
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
     * Object:销售预报单's 结束日期property 
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
     * Object:销售预报单's 联系人property 
     */
    public String getLinkman()
    {
        return getString("linkman");
    }
    public void setLinkman(String item)
    {
        setString("linkman", item);
    }
    /**
     * Object:销售预报单's 电话property 
     */
    public String getLinkmanTel()
    {
        return getString("linkmanTel");
    }
    public void setLinkmanTel(String item)
    {
        setString("linkmanTel", item);
    }
    /**
     * Object:销售预报单's 提货方式property 
     */
    public com.kingdee.eas.custom.lhsm.WayOfTakingDeliveryEnum getWayOfTakingDelivery()
    {
        return com.kingdee.eas.custom.lhsm.WayOfTakingDeliveryEnum.getEnum(getString("wayOfTakingDelivery"));
    }
    public void setWayOfTakingDelivery(com.kingdee.eas.custom.lhsm.WayOfTakingDeliveryEnum item)
    {
		if (item != null) {
        setString("wayOfTakingDelivery", item.getValue());
		}
    }
    /**
     * Object:销售预报单's 送货地址property 
     */
    public String getSendAddress()
    {
        return getString("sendAddress");
    }
    public void setSendAddress(String item)
    {
        setString("sendAddress", item);
    }
    /**
     * Object: 销售预报单 's 销售员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSalePerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("salePerson");
    }
    public void setSalePerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("salePerson", item);
    }
    /**
     * Object: 销售预报单 's 销售组 property 
     */
    public com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo getSaleGroup()
    {
        return (com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo)get("saleGroup");
    }
    public void setSaleGroup(com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo item)
    {
        put("saleGroup", item);
    }
    /**
     * Object: 销售预报单 's 付款方式 property 
     */
    public com.kingdee.eas.basedata.assistant.PaymentTypeInfo getPayType()
    {
        return (com.kingdee.eas.basedata.assistant.PaymentTypeInfo)get("payType");
    }
    public void setPayType(com.kingdee.eas.basedata.assistant.PaymentTypeInfo item)
    {
        put("payType", item);
    }
    /**
     * Object: 销售预报单 's 公司 property 
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
     * Object: 销售预报单 's 销售组织 property 
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
     * Object:销售预报单's 总价格property 
     */
    public java.math.BigDecimal getTotalAmount()
    {
        return getBigDecimal("totalAmount");
    }
    public void setTotalAmount(java.math.BigDecimal item)
    {
        setBigDecimal("totalAmount", item);
    }
    /**
     * Object:销售预报单's 总数量property 
     */
    public java.math.BigDecimal getTotalQty()
    {
        return getBigDecimal("totalQty");
    }
    public void setTotalQty(java.math.BigDecimal item)
    {
        setBigDecimal("totalQty", item);
    }
    /**
     * Object:销售预报单's 单据状态property 
     */
    public com.kingdee.eas.custom.lhsm.ForecastEnum getState()
    {
        return com.kingdee.eas.custom.lhsm.ForecastEnum.getEnum(getString("state"));
    }
    public void setState(com.kingdee.eas.custom.lhsm.ForecastEnum item)
    {
		if (item != null) {
        setString("state", item.getValue());
		}
    }
    /**
     * Object:销售预报单's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object: 销售预报单 's 销量客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getSaleCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("saleCustomer");
    }
    public void setSaleCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("saleCustomer", item);
    }
    /**
     * Object: 销售预报单 's 部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getDepartment()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("department");
    }
    public void setDepartment(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("department", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FFAFDB4F");
    }
}