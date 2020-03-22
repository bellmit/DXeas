/**
 * output package name
 */
package com.kingdee.eas.publicdata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class CarType extends StringEnum
{
    public static final String OWNCAR_VALUE = "1";//alias=自有车辆
    public static final String OTHERCAR_VALUE = "2";//alias=外部车辆

    public static final CarType ownCar = new CarType("ownCar", OWNCAR_VALUE);
    public static final CarType otherCar = new CarType("otherCar", OTHERCAR_VALUE);

    /**
     * construct function
     * @param String carType
     */
    private CarType(String name, String carType)
    {
        super(name, carType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static CarType getEnum(String carType)
    {
        return (CarType)getEnum(CarType.class, carType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(CarType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(CarType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(CarType.class);
    }
}