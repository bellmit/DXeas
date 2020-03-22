package com.kingdee.eas.spray;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCustomerSprayInvEntryEntryDetailInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCustomerSprayInvEntryEntryDetailInfo()
    {
        this("id");
    }
    protected AbstractCustomerSprayInvEntryEntryDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 使用明细 's null property 
     */
    public com.kingdee.eas.spray.CustomerSprayInvEntryInfo getParent1()
    {
        return (com.kingdee.eas.spray.CustomerSprayInvEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.spray.CustomerSprayInvEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object: 使用明细 's 物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:使用明细's 物料名称property 
     */
    public String getMaterialName()
    {
        return getString("materialName");
    }
    public void setMaterialName(String item)
    {
        setString("materialName", item);
    }
    /**
     * Object:使用明细's 规格型号property 
     */
    public String getModel()
    {
        return getString("model");
    }
    public void setModel(String item)
    {
        setString("model", item);
    }
    /**
     * Object:使用明细's 发生数量property 
     */
    public java.math.BigDecimal getOccurQty()
    {
        return getBigDecimal("occurQty");
    }
    public void setOccurQty(java.math.BigDecimal item)
    {
        setBigDecimal("occurQty", item);
    }
    /**
     * Object:使用明细's 开始时间余量property 
     */
    public java.math.BigDecimal getBeginTime()
    {
        return getBigDecimal("beginTime");
    }
    public void setBeginTime(java.math.BigDecimal item)
    {
        setBigDecimal("beginTime", item);
    }
    /**
     * Object:使用明细's 结束时间余量property 
     */
    public java.math.BigDecimal getEndTime()
    {
        return getBigDecimal("endTime");
    }
    public void setEndTime(java.math.BigDecimal item)
    {
        setBigDecimal("endTime", item);
    }
    /**
     * Object:使用明细's 开始数量余量property 
     */
    public java.math.BigDecimal getBeginQty()
    {
        return getBigDecimal("beginQty");
    }
    public void setBeginQty(java.math.BigDecimal item)
    {
        setBigDecimal("beginQty", item);
    }
    /**
     * Object:使用明细's 结束数量余量property 
     */
    public java.math.BigDecimal getEndQty()
    {
        return getBigDecimal("endQty");
    }
    public void setEndQty(java.math.BigDecimal item)
    {
        setBigDecimal("endQty", item);
    }
    /**
     * Object:使用明细's 发生时间量property 
     */
    public java.math.BigDecimal getOccurTime()
    {
        return getBigDecimal("occurTime");
    }
    public void setOccurTime(java.math.BigDecimal item)
    {
        setBigDecimal("occurTime", item);
    }
    /**
     * Object: 使用明细 's 操作人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getUser()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("user");
    }
    public void setUser(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("user", item);
    }
    /**
     * Object:使用明细's 发生日期property 
     */
    public java.util.Date getDate()
    {
        return getDate("date");
    }
    public void setDate(java.util.Date item)
    {
        setDate("date", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B39D9DA6");
    }
}