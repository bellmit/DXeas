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
public class StockingFarmTypeEnum extends IntEnum
{
    public static final int STOCKING_VALUE = 3;//alias=养户放养
    public static final int COMPANY_VALUE = 1;//alias=公司自养
    public static final int INVESTOR_VALUE = 2;//alias=股东自养

    public static final StockingFarmTypeEnum stocking = new StockingFarmTypeEnum("stocking", STOCKING_VALUE);
    public static final StockingFarmTypeEnum company = new StockingFarmTypeEnum("company", COMPANY_VALUE);
    public static final StockingFarmTypeEnum investor = new StockingFarmTypeEnum("investor", INVESTOR_VALUE);

    /**
     * construct function
     * @param integer stockingFarmTypeEnum
     */
    private StockingFarmTypeEnum(String name, int stockingFarmTypeEnum)
    {
        super(name, stockingFarmTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static StockingFarmTypeEnum getEnum(String stockingFarmTypeEnum)
    {
        return (StockingFarmTypeEnum)getEnum(StockingFarmTypeEnum.class, stockingFarmTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static StockingFarmTypeEnum getEnum(int stockingFarmTypeEnum)
    {
        return (StockingFarmTypeEnum)getEnum(StockingFarmTypeEnum.class, stockingFarmTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(StockingFarmTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(StockingFarmTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(StockingFarmTypeEnum.class);
    }
}