/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.rpt;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class StockingDailyOrderTypeEnum extends IntEnum
{
    public static final int AREAAGEDESC_VALUE = 1;//alias=Æ¬Çø+ÈÕÁä½µÐò
    public static final int AREALAYRATEDESC_VALUE = 2;//alias=Æ¬Çø+²úµ°ÂÊ½µÐò
    public static final int AGEDESC_VALUE = 3;//alias=ÈÕÁä½µÐò
    public static final int LAYRATEDESC_VALUE = 4;//alias=²úµ°ÂÊ½µÐò

    public static final StockingDailyOrderTypeEnum AreaAgeDesc = new StockingDailyOrderTypeEnum("AreaAgeDesc", AREAAGEDESC_VALUE);
    public static final StockingDailyOrderTypeEnum AreaLayRateDesc = new StockingDailyOrderTypeEnum("AreaLayRateDesc", AREALAYRATEDESC_VALUE);
    public static final StockingDailyOrderTypeEnum AgeDesc = new StockingDailyOrderTypeEnum("AgeDesc", AGEDESC_VALUE);
    public static final StockingDailyOrderTypeEnum LayRateDesc = new StockingDailyOrderTypeEnum("LayRateDesc", LAYRATEDESC_VALUE);

    /**
     * construct function
     * @param integer stockingDailyOrderTypeEnum
     */
    private StockingDailyOrderTypeEnum(String name, int stockingDailyOrderTypeEnum)
    {
        super(name, stockingDailyOrderTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static StockingDailyOrderTypeEnum getEnum(String stockingDailyOrderTypeEnum)
    {
        return (StockingDailyOrderTypeEnum)getEnum(StockingDailyOrderTypeEnum.class, stockingDailyOrderTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static StockingDailyOrderTypeEnum getEnum(int stockingDailyOrderTypeEnum)
    {
        return (StockingDailyOrderTypeEnum)getEnum(StockingDailyOrderTypeEnum.class, stockingDailyOrderTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(StockingDailyOrderTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(StockingDailyOrderTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(StockingDailyOrderTypeEnum.class);
    }
}