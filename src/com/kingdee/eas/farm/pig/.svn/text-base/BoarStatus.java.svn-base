/**
 * output package name
 */
package com.kingdee.eas.farm.pig;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class BoarStatus extends StringEnum
{
    public static final String RESERVE_VALUE = "1";//alias=后备
    public static final String FIRSTBREEDING_VALUE = "2";//alias=初配
    public static final String NORMAL_VALUE = "3";//alias=取精
    public static final String UNUSED_VALUE = "4";//alias=休情

    public static final BoarStatus Reserve = new BoarStatus("Reserve", RESERVE_VALUE);
    public static final BoarStatus FirstBreeding = new BoarStatus("FirstBreeding", FIRSTBREEDING_VALUE);
    public static final BoarStatus Normal = new BoarStatus("Normal", NORMAL_VALUE);
    public static final BoarStatus UnUsed = new BoarStatus("UnUsed", UNUSED_VALUE);

    /**
     * construct function
     * @param String boarStatus
     */
    private BoarStatus(String name, String boarStatus)
    {
        super(name, boarStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BoarStatus getEnum(String boarStatus)
    {
        return (BoarStatus)getEnum(BoarStatus.class, boarStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BoarStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BoarStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BoarStatus.class);
    }
}