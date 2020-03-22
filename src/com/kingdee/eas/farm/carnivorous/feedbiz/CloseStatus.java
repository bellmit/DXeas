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
public class CloseStatus extends StringEnum
{
    public static final String NOCLOSE_VALUE = "0";//alias=Î´¹Ø±Õ
    public static final String CLOSED_VALUE = "1";//alias=ÒÑ¹Ø±Õ

    public static final CloseStatus NoClose = new CloseStatus("NoClose", NOCLOSE_VALUE);
    public static final CloseStatus Closed = new CloseStatus("Closed", CLOSED_VALUE);

    /**
     * construct function
     * @param String closeStatus
     */
    private CloseStatus(String name, String closeStatus)
    {
        super(name, closeStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static CloseStatus getEnum(String closeStatus)
    {
        return (CloseStatus)getEnum(CloseStatus.class, closeStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(CloseStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(CloseStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(CloseStatus.class);
    }
}