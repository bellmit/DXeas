/**
 * output package name
 */
package com.kingdee.eas.weighbridge;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class StopBits extends StringEnum
{
    public static final String ONE_VALUE = "1";//alias=1
    public static final String TWO_VALUE = "2";//alias=2

    public static final StopBits one = new StopBits("one", ONE_VALUE);
    public static final StopBits two = new StopBits("two", TWO_VALUE);

    /**
     * construct function
     * @param String stopBits
     */
    private StopBits(String name, String stopBits)
    {
        super(name, stopBits);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static StopBits getEnum(String stopBits)
    {
        return (StopBits)getEnum(StopBits.class, stopBits);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(StopBits.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(StopBits.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(StopBits.class);
    }
}