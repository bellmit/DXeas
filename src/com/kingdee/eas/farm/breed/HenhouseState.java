/**
 * output package name
 */
package com.kingdee.eas.farm.breed;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class HenhouseState extends StringEnum
{


    /**
     * construct function
     * @param String henhouseState
     */
    private HenhouseState(String name, String henhouseState)
    {
        super(name, henhouseState);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static HenhouseState getEnum(String henhouseState)
    {
        return (HenhouseState)getEnum(HenhouseState.class, henhouseState);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(HenhouseState.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(HenhouseState.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(HenhouseState.class);
    }
}