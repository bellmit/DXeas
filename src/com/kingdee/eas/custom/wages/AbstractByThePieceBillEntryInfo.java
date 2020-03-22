package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractByThePieceBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractByThePieceBillEntryInfo()
    {
        this("id");
    }
    protected AbstractByThePieceBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 计件工资分录 's null property 
     */
    public com.kingdee.eas.custom.wages.ByThePieceBillInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.ByThePieceBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.ByThePieceBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 计件工资分录 's 员工编码 property 
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
     * Object:计件工资分录's 员工名称property 
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
     * Object:计件工资分录's 计件项目property 
     */
    public String getPieceType()
    {
        return getString("pieceType");
    }
    public void setPieceType(String item)
    {
        setString("pieceType", item);
    }
    /**
     * Object:计件工资分录's 计件单位property 
     */
    public com.kingdee.eas.custom.wages.byThePieceUnit getPieceUnit()
    {
        return com.kingdee.eas.custom.wages.byThePieceUnit.getEnum(getString("pieceUnit"));
    }
    public void setPieceUnit(com.kingdee.eas.custom.wages.byThePieceUnit item)
    {
		if (item != null) {
        setString("pieceUnit", item.getValue());
		}
    }
    /**
     * Object:计件工资分录's 计件量property 
     */
    public java.math.BigDecimal getPieceAmount()
    {
        return getBigDecimal("pieceAmount");
    }
    public void setPieceAmount(java.math.BigDecimal item)
    {
        setBigDecimal("pieceAmount", item);
    }
    /**
     * Object:计件工资分录's 计件单价(元)property 
     */
    public java.math.BigDecimal getPieceUnitPrice()
    {
        return getBigDecimal("pieceUnitPrice");
    }
    public void setPieceUnitPrice(java.math.BigDecimal item)
    {
        setBigDecimal("pieceUnitPrice", item);
    }
    /**
     * Object:计件工资分录's 计件金额property 
     */
    public java.math.BigDecimal getPieceMoney()
    {
        return getBigDecimal("pieceMoney");
    }
    public void setPieceMoney(java.math.BigDecimal item)
    {
        setBigDecimal("pieceMoney", item);
    }
    /**
     * Object: 计件工资分录 's 员工岗位 property 
     */
    public com.kingdee.eas.custom.wages.BasicPostInfo getPersonPost()
    {
        return (com.kingdee.eas.custom.wages.BasicPostInfo)get("personPost");
    }
    public void setPersonPost(com.kingdee.eas.custom.wages.BasicPostInfo item)
    {
        put("personPost", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EE32378F");
    }
}