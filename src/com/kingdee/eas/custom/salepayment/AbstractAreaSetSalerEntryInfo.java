package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAreaSetSalerEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAreaSetSalerEntryInfo()
    {
        this("id");
    }
    protected AbstractAreaSetSalerEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 销售员明细 's null property 
     */
    public com.kingdee.eas.custom.salepayment.AreaSetInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.AreaSetInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.AreaSetInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 销售员明细 's 业务经理 property 
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
     * Object:销售员明细's 负责区域property 
     */
    public String getArea()
    {
        return getString("area");
    }
    public void setArea(String item)
    {
        setString("area", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B53C2828");
    }
}