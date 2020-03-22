package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOverPayInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractOverPayInfo()
    {
        this("id");
    }
    protected AbstractOverPayInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.signwasthetable.OverPayEntryCollection());
    }
    /**
     * Object: 超额付款 's 分录 property 
     */
    public com.kingdee.eas.custom.signwasthetable.OverPayEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.signwasthetable.OverPayEntryCollection)get("entrys");
    }
    /**
     * Object:超额付款's 是否生成凭证property 
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
     * Object:超额付款's 原始合同idproperty 
     */
    public String getContractSrcId()
    {
        return getString("ContractSrcId");
    }
    public void setContractSrcId(String item)
    {
        setString("ContractSrcId", item);
    }
    /**
     * Object:超额付款's 单据状态property 
     */
    public com.kingdee.eas.custom.signwasthetable.billStatus getBillStatus()
    {
        return com.kingdee.eas.custom.signwasthetable.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.signwasthetable.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object:超额付款's 合同金额property 
     */
    public java.math.BigDecimal getAmt()
    {
        return getBigDecimal("Amt");
    }
    public void setAmt(java.math.BigDecimal item)
    {
        setBigDecimal("Amt", item);
    }
    /**
     * Object:超额付款's 合同编号property 
     */
    public String getContractNumber()
    {
        return getString("contractNumber");
    }
    public void setContractNumber(String item)
    {
        setString("contractNumber", item);
    }
    /**
     * Object: 超额付款 's 原始合同类型 property 
     */
    public com.kingdee.eas.custom.signwasthetable.ContractTypeInfo getSrcBillType()
    {
        return (com.kingdee.eas.custom.signwasthetable.ContractTypeInfo)get("srcBillType");
    }
    public void setSrcBillType(com.kingdee.eas.custom.signwasthetable.ContractTypeInfo item)
    {
        put("srcBillType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("930300EA");
    }
}