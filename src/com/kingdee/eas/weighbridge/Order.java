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
public class Order extends StringEnum
{
    public static final String LEFT_VALUE = "1";//alias=×ó
    public static final String RIGHT_VALUE = "0";//alias=ÓÒ

    public static final Order left = new Order("left", LEFT_VALUE);
    public static final Order right = new Order("right", RIGHT_VALUE);

    /**
     * construct function
     * @param String order
     */
    private Order(String name, String order)
    {
        super(name, order);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static Order getEnum(String order)
    {
        return (Order)getEnum(Order.class, order);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(Order.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(Order.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(Order.class);
    }
}