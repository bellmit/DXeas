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
public class TruckState extends StringEnum
{
    public static final String AVAILABLE_VALUE = "1";//alias=可用
    public static final String DISABLE_VALUE = "0";//alias=不可用

    public static final TruckState Available = new TruckState("Available", AVAILABLE_VALUE);
    public static final TruckState Disable = new TruckState("Disable", DISABLE_VALUE);

    /**
     * construct function
     * @param String truckState
     */
    private TruckState(String name, String truckState)
    {
        super(name, truckState);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static TruckState getEnum(String truckState)
    {
        return (TruckState)getEnum(TruckState.class, truckState);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(TruckState.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(TruckState.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(TruckState.class);
    }
}