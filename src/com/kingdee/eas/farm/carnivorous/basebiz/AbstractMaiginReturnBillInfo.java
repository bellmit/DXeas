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
     * Object:��֤���˻���'s �Ƿ�����ƾ֤property 
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
     * Object:��֤���˻���'s �ɷѽ��property 
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
     * Object:��֤���˻���'s ���ʱ��property 
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
     * Object:��֤���˻���'s �������property 
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
     * Object:��֤���˻���'s ����״̬property 
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
     * Object:��֤���˻���'s ҵ������property 
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
     * Object: ��֤���˻��� 's ��ֳ�� property 
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
     * Object: ��֤���˻��� 's ��˾ property 
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
     * Object:��֤���˻���'s ��֤���ܶ�property 
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
     * Object:��֤���˻���'s ���ñ�֤��property 
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
     * Object:��֤���˻���'s ռ�ñ�֤��property 
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
     * Object: ��֤���˻��� 's ƾ֤�� property 
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
     * Object:��֤���˻���'s ���֤����property 
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
     * Object:��֤���˻���'s �����˺�property 
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
     * Object:��֤���˻���'s �ֻ���property 
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
     * Object: ��֤���˻��� 's ����Ա property 
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
     * Object:��֤���˻���'s ������Դproperty 
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
     * Object:��֤���˻���'s �Ƿ������տproperty 
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
     * Object:��֤���˻���'s �Ƿ����ɸ��property 
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
     * Object: ��֤���˻��� 's �������� property 
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
     * Object:��֤���˻���'s ������ַproperty 
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