/**
 * output package name
 */
package com.kingdee.eas.custom.wages;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class Costtype extends StringEnum
{
    public static final String PAYONE_VALUE = "0";//alias=自行垫付
    public static final String PAYCOMPANY_VALUE = "1";//alias=公司借款

    public static final Costtype payone = new Costtype("payone", PAYONE_VALUE);
    public static final Costtype paycompany = new Costtype("paycompany", PAYCOMPANY_VALUE);

    /**
     * construct function
     * @param String costtype
     */
    private Costtype(String name, String costtype)
    {
        super(name, costtype);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static Costtype getEnum(String costtype)
    {
        return (Costtype)getEnum(Costtype.class, costtype);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(Costtype.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(Costtype.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(Costtype.class);
    }
}