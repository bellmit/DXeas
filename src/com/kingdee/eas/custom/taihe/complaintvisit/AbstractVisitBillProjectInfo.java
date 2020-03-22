package com.kingdee.eas.custom.taihe.complaintvisit;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractVisitBillProjectInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractVisitBillProjectInfo()
    {
        this("id");
    }
    protected AbstractVisitBillProjectInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 项目详情 's null property 
     */
    public com.kingdee.eas.custom.taihe.complaintvisit.VisitBillInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.complaintvisit.VisitBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.complaintvisit.VisitBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:项目详情's 项目内容property 
     */
    public String getProjectContent()
    {
        return getString("projectContent");
    }
    public void setProjectContent(String item)
    {
        setString("projectContent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BF35B1F5");
    }
}