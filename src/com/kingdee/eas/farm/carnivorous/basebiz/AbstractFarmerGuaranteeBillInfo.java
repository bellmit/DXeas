package com.kingdee.eas.farm.carnivorous.basebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerGuaranteeBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFarmerGuaranteeBillInfo()
    {
        this("id");
    }
    protected AbstractFarmerGuaranteeBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:担保申请单's 是否生成凭证property 
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
     * Object: 担保申请单 's 财务组织 property 
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
     * Object:担保申请单's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object:担保申请单's 担保人姓名property 
     */
    public String getGuarantorName()
    {
        return getString("guarantorName");
    }
    public void setGuarantorName(String item)
    {
        setString("guarantorName", item);
    }
    /**
     * Object:担保申请单's 担保人身份证号property 
     */
    public String getGuarantorIdCard()
    {
        return getString("guarantorIdCard");
    }
    public void setGuarantorIdCard(String item)
    {
        setString("guarantorIdCard", item);
    }
    /**
     * Object:担保申请单's 担保人联系电话property 
     */
    public String getGuarantorPhone()
    {
        return getString("guarantorPhone");
    }
    public void setGuarantorPhone(String item)
    {
        setString("guarantorPhone", item);
    }
    /**
     * Object:担保申请单's 担保人家庭地址property 
     */
    public String getGuarantorAddress()
    {
        return getString("guarantorAddress");
    }
    public void setGuarantorAddress(String item)
    {
        setString("guarantorAddress", item);
    }
    /**
     * Object:担保申请单's 担保人与被担保人关系 property 
     */
    public String getRelationship()
    {
        return getString("relationship");
    }
    public void setRelationship(String item)
    {
        setString("relationship", item);
    }
    /**
     * Object:担保申请单's 担保类型property 
     */
    public String getType()
    {
        return getString("type");
    }
    public void setType(String item)
    {
        setString("type", item);
    }
    /**
     * Object:担保申请单's 担保起始日期property 
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
     * Object:担保申请单's 终止日期property 
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
     * Object:担保申请单's 审核日期property 
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
     * Object: 担保申请单 's 被担保人 property 
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
     * Object:担保申请单's 被担保人身份证号property 
     */
    public String getFarmerIDcard()
    {
        return getString("farmerIDcard");
    }
    public void setFarmerIDcard(String item)
    {
        setString("farmerIDcard", item);
    }
    /**
     * Object:担保申请单's 被担保人电话property 
     */
    public String getFarmerPhone()
    {
        return getString("farmerPhone");
    }
    public void setFarmerPhone(String item)
    {
        setString("farmerPhone", item);
    }
    /**
     * Object:担保申请单's 被担保人地址property 
     */
    public String getFarmerAddress()
    {
        return getString("farmerAddress");
    }
    public void setFarmerAddress(String item)
    {
        setString("farmerAddress", item);
    }
    /**
     * Object: 担保申请单 's 业务员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5B16D615");
    }
}