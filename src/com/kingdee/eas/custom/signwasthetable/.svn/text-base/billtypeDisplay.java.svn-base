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
public class billtypeDisplay extends StringEnum
{
    public static final String PURCHASE_VALUE = "1";//alias=¹ºÂò
    public static final String CONTACT_VALUE = "2";//alias=ºÏÍ¬
    public static final String PAYMENT_VALUE = "2";//alias=¸¶¿î

    public static final billtypeDisplay purchase = new billtypeDisplay("purchase", PURCHASE_VALUE);
    public static final billtypeDisplay contact = new billtypeDisplay("contact", CONTACT_VALUE);
    public static final billtypeDisplay payment = new billtypeDisplay("payment", PAYMENT_VALUE);

    /**
     * construct function
     * @param String billtypeDisplay
     */
    private billtypeDisplay(String name, String billtypeDisplay)
    {
        super(name, billtypeDisplay);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static billtypeDisplay getEnum(String billtypeDisplay)
    {
        return (billtypeDisplay)getEnum(billtypeDisplay.class, billtypeDisplay);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(billtypeDisplay.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(billtypeDisplay.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(billtypeDisplay.class);
    }
}