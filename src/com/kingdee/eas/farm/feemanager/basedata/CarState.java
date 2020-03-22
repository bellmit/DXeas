/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class CarState extends StringEnum
{
    public static final String SENT_VALUE = "1";//alias=“—≈…
    public static final String NOSENT_VALUE = "2";//alias=Œ¥≈…
    public static final String LEAVE_VALUE = "3";//alias=«ÎºŸ
    public static final String OTHER_VALUE = "4";//alias=∆‰À˚

    public static final CarState Sent = new CarState("Sent", SENT_VALUE);
    public static final CarState NoSent = new CarState("NoSent", NOSENT_VALUE);
    public static final CarState Leave = new CarState("Leave", LEAVE_VALUE);
    public static final CarState Other = new CarState("Other", OTHER_VALUE);

    /**
     * construct function
     * @param String carState
     */
    private CarState(String name, String carState)
    {
        super(name, carState);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static CarState getEnum(String carState)
    {
        return (CarState)getEnum(CarState.class, carState);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(CarState.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(CarState.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(CarState.class);
    }
}