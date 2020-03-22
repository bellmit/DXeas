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
public class WeighBillType extends StringEnum
{
    public static final String INSTORAGE_VALUE = "1";//alias=入库过榜单
    public static final String OUTSTORAGE_VALUE = "2";//alias=出库过榜单
    public static final String CKWEIGHTBILL_VALUE = "3";//alias=结算过磅

    public static final WeighBillType inStorage = new WeighBillType("inStorage", INSTORAGE_VALUE);
    public static final WeighBillType outStorage = new WeighBillType("outStorage", OUTSTORAGE_VALUE);
    public static final WeighBillType ckWeightBill = new WeighBillType("ckWeightBill", CKWEIGHTBILL_VALUE);

    /**
     * construct function
     * @param String weighBillType
     */
    private WeighBillType(String name, String weighBillType)
    {
        super(name, weighBillType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static WeighBillType getEnum(String weighBillType)
    {
        return (WeighBillType)getEnum(WeighBillType.class, weighBillType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(WeighBillType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(WeighBillType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(WeighBillType.class);
    }
}