/**
 * output package name
 */
package com.kingdee.eas.custom.lhsm;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class billType extends StringEnum
{
    public static final String SALEORDER_VALUE = "1";//alias=销售订单
    public static final String SALESOUTLET_VALUE = "2";//alias=销售出库单
    public static final String SALESFORECAST_VALUE = "3";//alias=销售预报单

    public static final billType saleOrder = new billType("saleOrder", SALEORDER_VALUE);
    public static final billType salesOutlet = new billType("salesOutlet", SALESOUTLET_VALUE);
    public static final billType salesForecast = new billType("salesForecast", SALESFORECAST_VALUE);

    /**
     * construct function
     * @param String billType
     */
    private billType(String name, String billType)
    {
        super(name, billType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static billType getEnum(String billType)
    {
        return (billType)getEnum(billType.class, billType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(billType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(billType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(billType.class);
    }
}