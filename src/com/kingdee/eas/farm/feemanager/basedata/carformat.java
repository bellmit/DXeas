/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class carformat extends StringEnum
{
    public static final String SMALL_VALUE = "4.2";//alias=小型
    public static final String MEDIUM_VALUE = "4.8";//alias=中型
    public static final String BIG_VALUE = "5.2";//alias=大型

    public static final carformat small = new carformat("small", SMALL_VALUE);
    public static final carformat medium = new carformat("medium", MEDIUM_VALUE);
    public static final carformat big = new carformat("big", BIG_VALUE);

    /**
     * construct function
     * @param String carformat
     */
    private carformat(String name, String carformat)
    {
        super(name, carformat);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static carformat getEnum(String carformat)
    {
        return (carformat)getEnum(carformat.class, carformat);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(carformat.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(carformat.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(carformat.class);
    }
}