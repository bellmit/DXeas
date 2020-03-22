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
     * Object: ����� 's ��¼ property 
     */
    public com.kingdee.eas.custom.signwasthetable.OverPayEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.signwasthetable.OverPayEntryCollection)get("entrys");
    }
    /**
     * Object:�����'s �Ƿ�����ƾ֤property 
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
     * Object:�����'s ԭʼ��ͬidproperty 
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
     * Object:�����'s ����״̬property 
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
     * Object:�����'s ��ͬ���property 
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
     * Object:�����'s ��ͬ���property 
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
     * Object: ����� 's ԭʼ��ͬ���� property 
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