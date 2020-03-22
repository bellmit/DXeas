/**
 * output package name
 */
package com.kingdee.eas.farm.farmer;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class HenhouseOwner extends StringEnum
{
    public static final String OWN_VALUE = "1";//alias=здга
    public static final String RENT_VALUE = "2";//alias=зтСо

    public static final HenhouseOwner Own = new HenhouseOwner("Own", OWN_VALUE);
    public static final HenhouseOwner Rent = new HenhouseOwner("Rent", RENT_VALUE);

    /**
     * construct function
     * @param String henhouseOwner
     */
    private HenhouseOwner(String name, String henhouseOwner)
    {
        super(name, henhouseOwner);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static HenhouseOwner getEnum(String henhouseOwner)
    {
        return (HenhouseOwner)getEnum(HenhouseOwner.class, henhouseOwner);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(HenhouseOwner.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(HenhouseOwner.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(HenhouseOwner.class);
    }
}