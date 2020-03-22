package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRandPPolicyPolicyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractRandPPolicyPolicyEntryInfo()
    {
        this("id");
    }
    protected AbstractRandPPolicyPolicyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���߷�¼ 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.RandPPolicyInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.RandPPolicyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.RandPPolicyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:���߷�¼'s ����property 
     */
    public java.math.BigDecimal getFloor()
    {
        return getBigDecimal("floor");
    }
    public void setFloor(java.math.BigDecimal item)
    {
        setBigDecimal("floor", item);
    }
    /**
     * Object:���߷�¼'s ����property 
     */
    public java.math.BigDecimal getUpper()
    {
        return getBigDecimal("upper");
    }
    public void setUpper(java.math.BigDecimal item)
    {
        setBigDecimal("upper", item);
    }
    /**
     * Object:���߷�¼'s ����ֵproperty 
     */
    public java.math.BigDecimal getDiff()
    {
        return getBigDecimal("diff");
    }
    public void setDiff(java.math.BigDecimal item)
    {
        setBigDecimal("diff", item);
    }
    /**
     * Object:���߷�¼'s ʵ�ʼ۸�property 
     */
    public java.math.BigDecimal getCalValue()
    {
        return getBigDecimal("calValue");
    }
    public void setCalValue(java.math.BigDecimal item)
    {
        setBigDecimal("calValue", item);
    }
    /**
     * Object:���߷�¼'s �䶯ϵ��property 
     */
    public java.math.BigDecimal getDiffCoeff()
    {
        return getBigDecimal("diffCoeff");
    }
    public void setDiffCoeff(java.math.BigDecimal item)
    {
        setBigDecimal("diffCoeff", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8F1DB465");
    }
}