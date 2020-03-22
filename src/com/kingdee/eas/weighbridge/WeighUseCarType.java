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
public class WeighUseCarType extends StringEnum
{
    public static final String OWNCAR_VALUE = "1";//alias=自有车辆
    public static final String OTHERCAR_VALUE = "2";//alias=其他车辆

    public static final WeighUseCarType ownCar = new WeighUseCarType("ownCar", OWNCAR_VALUE);
    public static final WeighUseCarType otherCar = new WeighUseCarType("otherCar", OTHERCAR_VALUE);

    /**
     * construct function
     * @param String weighUseCarType
     */
    private WeighUseCarType(String name, String weighUseCarType)
    {
        super(name, weighUseCarType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static WeighUseCarType getEnum(String weighUseCarType)
    {
        return (WeighUseCarType)getEnum(WeighUseCarType.class, weighUseCarType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(WeighUseCarType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(WeighUseCarType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(WeighUseCarType.class);
    }
}