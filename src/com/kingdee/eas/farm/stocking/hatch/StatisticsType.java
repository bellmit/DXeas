/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.hatch;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class StatisticsType extends IntEnum
{
    public static final int NUMQTY_VALUE = 1;//alias=枚数
    public static final int ALLWIGHT_VALUE = 2;//alias=总重
    public static final int AVGWEIGHT_VALUE = 3;//alias=平均重量

    public static final StatisticsType NumQty = new StatisticsType("NumQty", NUMQTY_VALUE);
    public static final StatisticsType AllWight = new StatisticsType("AllWight", ALLWIGHT_VALUE);
    public static final StatisticsType AvgWeight = new StatisticsType("AvgWeight", AVGWEIGHT_VALUE);

    /**
     * construct function
     * @param integer statisticsType
     */
    private StatisticsType(String name, int statisticsType)
    {
        super(name, statisticsType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static StatisticsType getEnum(String statisticsType)
    {
        return (StatisticsType)getEnum(StatisticsType.class, statisticsType);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static StatisticsType getEnum(int statisticsType)
    {
        return (StatisticsType)getEnum(StatisticsType.class, statisticsType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(StatisticsType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(StatisticsType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(StatisticsType.class);
    }
}