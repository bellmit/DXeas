package com.kingdee.eas.farm.stocking.assistfunction;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleBillPrintCountInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSettleBillPrintCountInfo()
    {
        this("id");
    }
    protected AbstractSettleBillPrintCountInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:结算单打印记录's 是否生成凭证property 
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
     * Object:结算单打印记录's 身份证号property 
     */
    public String getIdentityID()
    {
        return getString("identityID");
    }
    public void setIdentityID(String item)
    {
        setString("identityID", item);
    }
    /**
     * Object:结算单打印记录's 员工姓名property 
     */
    public String getPersonName()
    {
        return getString("personName");
    }
    public void setPersonName(String item)
    {
        setString("personName", item);
    }
    /**
     * Object:结算单打印记录's 作废property 
     */
    public boolean isIsCancel()
    {
        return getBoolean("isCancel");
    }
    public void setIsCancel(boolean item)
    {
        setBoolean("isCancel", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E79C877F");
    }
}