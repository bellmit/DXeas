package com.kingdee.eas.farm.carnivorous.basebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaiginReturnBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMaiginReturnBillInfo()
    {
        this("id");
    }
    protected AbstractMaiginReturnBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:保证金退还单's 是否生成凭证property 
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
     * Object:保证金退还单's 缴费金额property 
     */
    public java.math.BigDecimal getPayAmount()
    {
        return getBigDecimal("payAmount");
    }
    public void setPayAmount(java.math.BigDecimal item)
    {
        setBigDecimal("payAmount", item);
    }
    /**
     * Object:保证金退还单's 审核时间property 
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
     * Object:保证金退还单's 审批意见property 
     */
    public String getAuditOpinion()
    {
        return getString("auditOpinion");
    }
    public void setAuditOpinion(String item)
    {
        setString("auditOpinion", item);
    }
    /**
     * Object:保证金退还单's 单据状态property 
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
     * Object:保证金退还单's 业务类型property 
     */
    public com.kingdee.eas.farm.carnivorous.basebiz.bizType getBizType()
    {
        return com.kingdee.eas.farm.carnivorous.basebiz.bizType.getEnum(getString("bizType"));
    }
    public void setBizType(com.kingdee.eas.farm.carnivorous.basebiz.bizType item)
    {
		if (item != null) {
        setString("bizType", item.getValue());
		}
    }
    /**
     * Object: 保证金退还单 's 养殖户 property 
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
     * Object: 保证金退还单 's 公司 property 
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
     * Object:保证金退还单's 保证金总额property 
     */
    public java.math.BigDecimal getTotalMargin()
    {
        return getBigDecimal("totalMargin");
    }
    public void setTotalMargin(java.math.BigDecimal item)
    {
        setBigDecimal("totalMargin", item);
    }
    /**
     * Object:保证金退还单's 可用保证金property 
     */
    public java.math.BigDecimal getEnableMargin()
    {
        return getBigDecimal("enableMargin");
    }
    public void setEnableMargin(java.math.BigDecimal item)
    {
        setBigDecimal("enableMargin", item);
    }
    /**
     * Object:保证金退还单's 占用保证金property 
     */
    public java.math.BigDecimal getOccupyMargin()
    {
        return getBigDecimal("occupyMargin");
    }
    public void setOccupyMargin(java.math.BigDecimal item)
    {
        setBigDecimal("occupyMargin", item);
    }
    /**
     * Object: 保证金退还单 's 凭证号 property 
     */
    public com.kingdee.eas.fi.gl.VoucherInfo getVoucherNum()
    {
        return (com.kingdee.eas.fi.gl.VoucherInfo)get("voucherNum");
    }
    public void setVoucherNum(com.kingdee.eas.fi.gl.VoucherInfo item)
    {
        put("voucherNum", item);
    }
    /**
     * Object:保证金退还单's 身份证号码property 
     */
    public String getIdentity()
    {
        return getString("identity");
    }
    public void setIdentity(String item)
    {
        setString("identity", item);
    }
    /**
     * Object:保证金退还单's 银行账号property 
     */
    public String getBankNo()
    {
        return getString("bankNo");
    }
    public void setBankNo(String item)
    {
        setString("bankNo", item);
    }
    /**
     * Object:保证金退还单's 手机号property 
     */
    public String getPhone()
    {
        return getString("phone");
    }
    public void setPhone(String item)
    {
        setString("phone", item);
    }
    /**
     * Object: 保证金退还单 's 技术员 property 
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
     * Object:保证金退还单's 款项来源property 
     */
    public com.kingdee.eas.farm.carnivorous.basebiz.moneySource getMoneySource()
    {
        return com.kingdee.eas.farm.carnivorous.basebiz.moneySource.getEnum(getString("moneySource"));
    }
    public void setMoneySource(com.kingdee.eas.farm.carnivorous.basebiz.moneySource item)
    {
		if (item != null) {
        setString("moneySource", item.getValue());
		}
    }
    /**
     * Object:保证金退还单's 是否生成收款单property 
     */
    public boolean isIsHasReceivingBill()
    {
        return getBoolean("isHasReceivingBill");
    }
    public void setIsHasReceivingBill(boolean item)
    {
        setBoolean("isHasReceivingBill", item);
    }
    /**
     * Object:保证金退还单's 是否生成付款单property 
     */
    public boolean isIsHasPaymentBill()
    {
        return getBoolean("isHasPaymentBill");
    }
    public void setIsHasPaymentBill(boolean item)
    {
        setBoolean("isHasPaymentBill", item);
    }
    /**
     * Object: 保证金退还单 's 开户银行 property 
     */
    public com.kingdee.eas.fm.be.BEBankInfo getBEBank()
    {
        return (com.kingdee.eas.fm.be.BEBankInfo)get("bEBank");
    }
    public void setBEBank(com.kingdee.eas.fm.be.BEBankInfo item)
    {
        put("bEBank", item);
    }
    /**
     * Object:保证金退还单's 开户地址property 
     */
    public String getBEBankAddress()
    {
        return getString("bEBankAddress");
    }
    public void setBEBankAddress(String item)
    {
        setString("bEBankAddress", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("244581A5");
    }
}