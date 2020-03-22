/**
 * output package name
 */
package com.kingdee.eas.farm.pig;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class DeliveryStatus extends StringEnum
{
    public static final String NORMAL_VALUE = "1";//alias=Ë³²ú
    public static final String HARD_VALUE = "2";//alias=ÄÑ²ú

    public static final DeliveryStatus Normal = new DeliveryStatus("Normal", NORMAL_VALUE);
    public static final DeliveryStatus Hard = new DeliveryStatus("Hard", HARD_VALUE);

    /**
     * construct function
     * @param String deliveryStatus
     */
    private DeliveryStatus(String name, String deliveryStatus)
    {
        super(name, deliveryStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static DeliveryStatus getEnum(String deliveryStatus)
    {
        return (DeliveryStatus)getEnum(DeliveryStatus.class, deliveryStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(DeliveryStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(DeliveryStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(DeliveryStatus.class);
    }
}