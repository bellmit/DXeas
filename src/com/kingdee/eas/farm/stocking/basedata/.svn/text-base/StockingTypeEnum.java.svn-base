/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class StockingTypeEnum extends IntEnum
{
    public static final int PARENTAL_VALUE = 1;//alias=父母代
    public static final int BUSINESS_VALUE = 2;//alias=商品代

    public static final StockingTypeEnum Parental = new StockingTypeEnum("Parental", PARENTAL_VALUE);
    public static final StockingTypeEnum Business = new StockingTypeEnum("Business", BUSINESS_VALUE);

    /**
     * construct function
     * @param integer stockingTypeEnum
     */
    private StockingTypeEnum(String name, int stockingTypeEnum)
    {
        super(name, stockingTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static StockingTypeEnum getEnum(String stockingTypeEnum)
    {
        return (StockingTypeEnum)getEnum(StockingTypeEnum.class, stockingTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static StockingTypeEnum getEnum(int stockingTypeEnum)
    {
        return (StockingTypeEnum)getEnum(StockingTypeEnum.class, stockingTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(StockingTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(StockingTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(StockingTypeEnum.class);
    }
}