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
public class billStates extends StringEnum
{
    public static final String PURCHASE_VALUE = "1";//alias=£¨¹ºÂò£©
    public static final String CONTACT_VALUE = "2";//alias=£¨ºÏÍ¬£©
    public static final String PAYMENT_VALUE = "3";//alias=£¨¸¶¿î£©

    public static final billStates purchase = new billStates("purchase", PURCHASE_VALUE);
    public static final billStates contact = new billStates("contact", CONTACT_VALUE);
    public static final billStates payment = new billStates("payment", PAYMENT_VALUE);

    /**
     * construct function
     * @param String billStates
     */
    private billStates(String name, String billStates)
    {
        super(name, billStates);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static billStates getEnum(String billStates)
    {
        return (billStates)getEnum(billStates.class, billStates);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(billStates.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(billStates.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(billStates.class);
    }
}