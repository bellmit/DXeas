package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractGuaranteeApplyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractGuaranteeApplyInfo()
    {
        this("id");
    }
    protected AbstractGuaranteeApplyInfo(String pkField)
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
     * Object:担保申请单's 申请额度property 
     */
    public String getApplyLimit()
    {
        return getString("applyLimit");
    }
    public void setApplyLimit(String item)
    {
        setString("applyLimit", item);
    }
    /**
     * Object: 担保申请单 's 财务组织 property 
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
     * Object:担保申请单's 本人使用额度property 
     */
    public String getUseQuota()
    {
        return getString("useQuota");
    }
    public void setUseQuota(String item)
    {
        setString("useQuota", item);
    }
    /**
     * Object: 担保申请单 's 员工 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:担保申请单's 身份证号码property 
     */
    public String getIDCardNo()
    {
        return getString("IDCardNo");
    }
    public void setIDCardNo(String item)
    {
        setString("IDCardNo", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1ADA8673");
    }
}