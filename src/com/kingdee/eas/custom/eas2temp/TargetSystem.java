/**
 * output package name
 */
package com.kingdee.eas.custom.eas2temp;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class TargetSystem extends IntEnum
{
    public static final int MUYANGSYSTEM_VALUE = 2;//alias=中控系统
    public static final int BARSYSTEM_VALUE = 1;//alias=备份系统

    public static final TargetSystem muyangSystem = new TargetSystem("muyangSystem", MUYANGSYSTEM_VALUE);
    public static final TargetSystem barSystem = new TargetSystem("barSystem", BARSYSTEM_VALUE);

    /**
     * construct function
     * @param integer targetSystem
     */
    private TargetSystem(String name, int targetSystem)
    {
        super(name, targetSystem);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static TargetSystem getEnum(String targetSystem)
    {
        return (TargetSystem)getEnum(TargetSystem.class, targetSystem);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static TargetSystem getEnum(int targetSystem)
    {
        return (TargetSystem)getEnum(TargetSystem.class, targetSystem);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(TargetSystem.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(TargetSystem.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(TargetSystem.class);
    }
}