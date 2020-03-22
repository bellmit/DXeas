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
public class WeighBizType extends StringEnum
{
    public static final String SALE_VALUE = "1";//alias=销售过磅
    public static final String PUR_VALUE = "2";//alias=采购过磅
    public static final String TRANSOUT_VALUE = "3";//alias=调拨出过磅
    public static final String TRANSIN_VALUE = "4";//alias=调拨入过磅
    public static final String GROUPSALE_VALUE = "5";//alias=集团内销售
    public static final String GROUPPUR_VALUE = "6";//alias=集团内采购
    public static final String OTHER_VALUE = "7";//alias=其他过磅
    public static final String WASTESALE_VALUE = "8";//alias=废物销售
    public static final String RECCK_VALUE = "9";//alias=其他
    public static final String CHICKEN_VALUE = "10";//alias=毛鸡过磅
    public static final String LOCALPUR_VALUE = "11";//alias=收购过磅

    public static final WeighBizType Sale = new WeighBizType("Sale", SALE_VALUE);
    public static final WeighBizType Pur = new WeighBizType("Pur", PUR_VALUE);
    public static final WeighBizType TransOut = new WeighBizType("TransOut", TRANSOUT_VALUE);
    public static final WeighBizType TransIn = new WeighBizType("TransIn", TRANSIN_VALUE);
    public static final WeighBizType GroupSale = new WeighBizType("GroupSale", GROUPSALE_VALUE);
    public static final WeighBizType GroupPur = new WeighBizType("GroupPur", GROUPPUR_VALUE);
    public static final WeighBizType Other = new WeighBizType("Other", OTHER_VALUE);
    public static final WeighBizType WasteSale = new WeighBizType("WasteSale", WASTESALE_VALUE);
    public static final WeighBizType RecCK = new WeighBizType("RecCK", RECCK_VALUE);
    public static final WeighBizType Chicken = new WeighBizType("Chicken", CHICKEN_VALUE);
    public static final WeighBizType localPur = new WeighBizType("localPur", LOCALPUR_VALUE);

    /**
     * construct function
     * @param String weighBizType
     */
    private WeighBizType(String name, String weighBizType)
    {
        super(name, weighBizType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static WeighBizType getEnum(String weighBizType)
    {
        return (WeighBizType)getEnum(WeighBizType.class, weighBizType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(WeighBizType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(WeighBizType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(WeighBizType.class);
    }
}