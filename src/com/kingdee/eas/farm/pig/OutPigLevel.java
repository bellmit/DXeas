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
public class OutPigLevel extends StringEnum
{
    public static final String GOOD_VALUE = "1";//alias=正品
    public static final String NOTGOOD_VALUE = "2";//alias=次品
    public static final String CULL_VALUE = "3";//alias=淘汰

    public static final OutPigLevel Good = new OutPigLevel("Good", GOOD_VALUE);
    public static final OutPigLevel NotGood = new OutPigLevel("NotGood", NOTGOOD_VALUE);
    public static final OutPigLevel Cull = new OutPigLevel("Cull", CULL_VALUE);

    /**
     * construct function
     * @param String outPigLevel
     */
    private OutPigLevel(String name, String outPigLevel)
    {
        super(name, outPigLevel);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static OutPigLevel getEnum(String outPigLevel)
    {
        return (OutPigLevel)getEnum(OutPigLevel.class, outPigLevel);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(OutPigLevel.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(OutPigLevel.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(OutPigLevel.class);
    }
}