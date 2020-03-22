/**
 * output package name
 */
package com.kingdee.eas.farm.food;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class orderEnum extends IntEnum
{
    public static final int ZERO_VALUE = 0;//alias=0
    public static final int ONE_VALUE = 1;//alias=1
    public static final int TWO_VALUE = 2;//alias=2
    public static final int THREE_VALUE = 3;//alias=3
    public static final int FOUR_VALUE = 4;//alias=4
    public static final int FIVE_VALUE = 5;//alias=5
    public static final int SIX_VALUE = 6;//alias=6
    public static final int SEVEN_VALUE = 7;//alias=7

    public static final orderEnum zero = new orderEnum("zero", ZERO_VALUE);
    public static final orderEnum one = new orderEnum("one", ONE_VALUE);
    public static final orderEnum two = new orderEnum("two", TWO_VALUE);
    public static final orderEnum three = new orderEnum("three", THREE_VALUE);
    public static final orderEnum four = new orderEnum("four", FOUR_VALUE);
    public static final orderEnum five = new orderEnum("five", FIVE_VALUE);
    public static final orderEnum six = new orderEnum("six", SIX_VALUE);
    public static final orderEnum seven = new orderEnum("seven", SEVEN_VALUE);

    /**
     * construct function
     * @param integer orderEnum
     */
    private orderEnum(String name, int orderEnum)
    {
        super(name, orderEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static orderEnum getEnum(String orderEnum)
    {
        return (orderEnum)getEnum(orderEnum.class, orderEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static orderEnum getEnum(int orderEnum)
    {
        return (orderEnum)getEnum(orderEnum.class, orderEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(orderEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(orderEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(orderEnum.class);
    }
}