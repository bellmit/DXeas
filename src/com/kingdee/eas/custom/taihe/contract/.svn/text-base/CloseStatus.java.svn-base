/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class CloseStatus extends StringEnum
{
    public static final String NOCLOSE_VALUE = "0";//alias=未关闭
    public static final String MANUALCLOSE_VALUE = "1";//alias=手动关闭

    public static final CloseStatus NoClose = new CloseStatus("NoClose", NOCLOSE_VALUE);
    public static final CloseStatus ManualClose = new CloseStatus("ManualClose", MANUALCLOSE_VALUE);

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