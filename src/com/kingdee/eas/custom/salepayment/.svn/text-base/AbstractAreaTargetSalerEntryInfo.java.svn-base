package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAreaTargetSalerEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAreaTargetSalerEntryInfo()
    {
        this("id");
    }
    protected AbstractAreaTargetSalerEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 销售员指标 's null property 
     */
    public com.kingdee.eas.custom.salepayment.AreaTargetInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.AreaTargetInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.AreaTargetInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 销售员指标 's 业务经理 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSaler()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("saler");
    }
    public void setSaler(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("saler", item);
    }
    /**
     * Object:销售员指标's 业务经理姓名property 
     */
    public String getSalerName()
    {
        return getString("salerName");
    }
    public void setSalerName(String item)
    {
        setString("salerName", item);
    }
    /**
     * Object:销售员指标's 损益指标（元）property 
     */
    public int getProfitTarget()
    {
        return getInt("profitTarget");
    }
    public void setProfitTarget(int item)
    {
        setInt("profitTarget", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8DAFB239");
    }
}