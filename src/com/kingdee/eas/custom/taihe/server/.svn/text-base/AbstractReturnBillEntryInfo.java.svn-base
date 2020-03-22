package com.kingdee.eas.custom.taihe.server;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractReturnBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractReturnBillEntryInfo()
    {
        this("id");
    }
    protected AbstractReturnBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.taihe.server.ReturnBillInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.server.ReturnBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.server.ReturnBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 项目序号property 
     */
    public int getItemSeq()
    {
        return getInt("itemSeq");
    }
    public void setItemSeq(int item)
    {
        setInt("itemSeq", item);
    }
    /**
     * Object:分录's 项目内容property 
     */
    public String getItemContent()
    {
        return getString("itemContent");
    }
    public void setItemContent(String item)
    {
        setString("itemContent", item);
    }
    /**
     * Object:分录's 项目评分property 
     */
    public java.math.BigDecimal getItemGrade()
    {
        return getBigDecimal("itemGrade");
    }
    public void setItemGrade(java.math.BigDecimal item)
    {
        setBigDecimal("itemGrade", item);
    }
    /**
     * Object:分录's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4B3259B0");
    }
}