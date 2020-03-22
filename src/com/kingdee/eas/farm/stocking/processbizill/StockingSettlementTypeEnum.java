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
public class StockingSettlementTypeEnum extends IntEnum
{
    public static final int BYBATCH_VALUE = 1;//alias=批次结算
    public static final int BYFARM_VALUE = 2;//alias=养殖场结算

    public static final StockingSettlementTypeEnum byBatch = new StockingSettlementTypeEnum("byBatch", BYBATCH_VALUE);
    public static final StockingSettlementTypeEnum byFarm = new StockingSettlementTypeEnum("byFarm", BYFARM_VALUE);

    /**
     * construct function
     * @param integer stockingSettlementTypeEnum
     */
    private StockingSettlementTypeEnum(String name, int stockingSettlementTypeEnum)
    {
        super(name, stockingSettlementTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static StockingSettlementTypeEnum getEnum(String stockingSettlementTypeEnum)
    {
        return (StockingSettlementTypeEnum)getEnum(StockingSettlementTypeEnum.class, stockingSettlementTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static StockingSettlementTypeEnum getEnum(int stockingSettlementTypeEnum)
    {
        return (StockingSettlementTypeEnum)getEnum(StockingSettlementTypeEnum.class, stockingSettlementTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(StockingSettlementTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(StockingSettlementTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(StockingSettlementTypeEnum.class);
    }
}