/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class billType extends StringEnum
{
    public static final String PURCHASE_VALUE = "1";//alias=¹ºÂò
    public static final String CONTRACT_VALUE = "2";//alias=ºÏÍ¬Ç©¶©
    public static final String PAYMENT_VALUE = "3";//alias=¸¶¿î

    public static final billType purchase = new billType("purchase", PURCHASE_VALUE);
    public static final billType contract = new billType("contract", CONTRACT_VALUE);
    public static final billType payment = new billType("payment", PAYMENT_VALUE);

    /**
     * construct function
     * @param String billType
     */
    private billType(String name, String billType)
    {
        super(name, billType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static billType getEnum(String billType)
    {
        return (billType)getEnum(billType.class, billType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(billType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(billType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(billType.class);
    }
}