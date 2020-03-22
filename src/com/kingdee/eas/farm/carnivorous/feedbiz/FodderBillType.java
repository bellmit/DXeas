/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class FodderBillType extends StringEnum
{
    public static final String COMM_VALUE = "1";//alias=普通领用
    public static final String LOST_VALUE = "2";//alias=丢料
    public static final String RETURN_VALUE = "3";//alias=退料
    public static final String EXCHANGE_VALUE = "4";//alias=调料
    public static final String COST_VALUE = "6";//alias=成本调整

    public static final FodderBillType Comm = new FodderBillType("Comm", COMM_VALUE);
    public static final FodderBillType Lost = new FodderBillType("Lost", LOST_VALUE);
    public static final FodderBillType Return = new FodderBillType("Return", RETURN_VALUE);
    public static final FodderBillType Exchange = new FodderBillType("Exchange", EXCHANGE_VALUE);
    public static final FodderBillType Cost = new FodderBillType("Cost", COST_VALUE);

    /**
     * construct function
     * @param String fodderBillType
     */
    private FodderBillType(String name, String fodderBillType)
    {
        super(name, fodderBillType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FodderBillType getEnum(String fodderBillType)
    {
        return (FodderBillType)getEnum(FodderBillType.class, fodderBillType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FodderBillType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FodderBillType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FodderBillType.class);
    }
}