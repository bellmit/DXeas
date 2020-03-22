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
public class HybridizationType extends StringEnum
{
    public static final String NATURAL_VALUE = "1";//alias=本交
    public static final String ALL_VALUE = "2";//alias=混精
    public static final String AIFRESH_VALUE = "3";//alias=人工鲜精
    public static final String AIFROZEN_VALUE = "4";//alias=人工冻精

    public static final HybridizationType Natural = new HybridizationType("Natural", NATURAL_VALUE);
    public static final HybridizationType All = new HybridizationType("All", ALL_VALUE);
    public static final HybridizationType AIFresh = new HybridizationType("AIFresh", AIFRESH_VALUE);
    public static final HybridizationType AIFrozen = new HybridizationType("AIFrozen", AIFROZEN_VALUE);

    /**
     * construct function
     * @param String hybridizationType
     */
    private HybridizationType(String name, String hybridizationType)
    {
        super(name, hybridizationType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static HybridizationType getEnum(String hybridizationType)
    {
        return (HybridizationType)getEnum(HybridizationType.class, hybridizationType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(HybridizationType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(HybridizationType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(HybridizationType.class);
    }
}