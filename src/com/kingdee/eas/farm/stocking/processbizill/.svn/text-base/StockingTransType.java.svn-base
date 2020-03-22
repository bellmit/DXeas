/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class StockingTransType extends IntEnum
{
    public static final int TRANSIN_VALUE = 1;//alias=转入
    public static final int TRANSOUT_VALUE = 2;//alias=转出

    public static final StockingTransType transIn = new StockingTransType("transIn", TRANSIN_VALUE);
    public static final StockingTransType transOut = new StockingTransType("transOut", TRANSOUT_VALUE);

    /**
     * construct function
     * @param integer stockingTransType
     */
    private StockingTransType(String name, int stockingTransType)
    {
        super(name, stockingTransType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static StockingTransType getEnum(String stockingTransType)
    {
        return (StockingTransType)getEnum(StockingTransType.class, stockingTransType);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static StockingTransType getEnum(int stockingTransType)
    {
        return (StockingTransType)getEnum(StockingTransType.class, stockingTransType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(StockingTransType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(StockingTransType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(StockingTransType.class);
    }
}