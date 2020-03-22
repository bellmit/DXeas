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
public class casetype extends StringEnum
{
    public static final String HAVEING_VALUE = "0";//alias=进行中
    public static final String STOP_VALUE = "1";//alias=完结

    public static final casetype Haveing = new casetype("Haveing", HAVEING_VALUE);
    public static final casetype stop = new casetype("stop", STOP_VALUE);

    /**
     * construct function
     * @param String casetype
     */
    private casetype(String name, String casetype)
    {
        super(name, casetype);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static casetype getEnum(String casetype)
    {
        return (casetype)getEnum(casetype.class, casetype);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(casetype.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(casetype.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(casetype.class);
    }
}