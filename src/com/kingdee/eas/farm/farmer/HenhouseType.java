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
public class HenhouseType extends StringEnum
{
    public static final String STANDARD_VALUE = "1";//alias=±ê×¼Åï
    public static final String SIMPLE_VALUE = "2";//alias=¼òÒ×Åï

    public static final HenhouseType Standard = new HenhouseType("Standard", STANDARD_VALUE);
    public static final HenhouseType Simple = new HenhouseType("Simple", SIMPLE_VALUE);

    /**
     * construct function
     * @param String henhouseType
     */
    private HenhouseType(String name, String henhouseType)
    {
        super(name, henhouseType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static HenhouseType getEnum(String henhouseType)
    {
        return (HenhouseType)getEnum(HenhouseType.class, henhouseType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(HenhouseType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(HenhouseType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(HenhouseType.class);
    }
}