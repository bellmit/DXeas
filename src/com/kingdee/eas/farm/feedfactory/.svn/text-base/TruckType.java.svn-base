/**
 * output package name
 */
package com.kingdee.eas.farm.feedfactory;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class TruckType extends StringEnum
{
    public static final String CCTRUCK_VALUE = "1";//alias=商品鸡料车
    public static final String PARENTCK_VALUE = "2";//alias=种鸡料车

    public static final TruckType CCTruck = new TruckType("CCTruck", CCTRUCK_VALUE);
    public static final TruckType ParentCK = new TruckType("ParentCK", PARENTCK_VALUE);

    /**
     * construct function
     * @param String truckType
     */
    private TruckType(String name, String truckType)
    {
        super(name, truckType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static TruckType getEnum(String truckType)
    {
        return (TruckType)getEnum(TruckType.class, truckType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(TruckType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(TruckType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(TruckType.class);
    }
}