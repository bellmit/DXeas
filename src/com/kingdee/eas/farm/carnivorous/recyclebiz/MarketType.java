/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class MarketType extends StringEnum
{
    public static final String OUTER_VALUE = "1";//alias=自收市场
    public static final String INNERCOMP_VALUE = "2";//alias=内部公司

    public static final MarketType Outer = new MarketType("Outer", OUTER_VALUE);
    public static final MarketType InnerComp = new MarketType("InnerComp", INNERCOMP_VALUE);

    /**
     * construct function
     * @param String marketType
     */
    private MarketType(String name, String marketType)
    {
        super(name, marketType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static MarketType getEnum(String marketType)
    {
        return (MarketType)getEnum(MarketType.class, marketType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(MarketType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(MarketType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(MarketType.class);
    }
}