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
public class SpermColor extends StringEnum
{
    public static final String LIGHTWHITE_VALUE = "1";//alias=浅白色
    public static final String LIGHTGRAY_VALUE = "2";//alias=浅灰色
    public static final String LIGHTGREEN_VALUE = "3";//alias=浅绿色
    public static final String BLOODRED_VALUE = "4";//alias=血红色
    public static final String GREEN_VALUE = "5";//alias=绿色
    public static final String OTHER_VALUE = "6";//alias=其他颜色

    public static final SpermColor LightWhite = new SpermColor("LightWhite", LIGHTWHITE_VALUE);
    public static final SpermColor LightGray = new SpermColor("LightGray", LIGHTGRAY_VALUE);
    public static final SpermColor LightGreen = new SpermColor("LightGreen", LIGHTGREEN_VALUE);
    public static final SpermColor BloodRed = new SpermColor("BloodRed", BLOODRED_VALUE);
    public static final SpermColor Green = new SpermColor("Green", GREEN_VALUE);
    public static final SpermColor Other = new SpermColor("Other", OTHER_VALUE);

    /**
     * construct function
     * @param String spermColor
     */
    private SpermColor(String name, String spermColor)
    {
        super(name, spermColor);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static SpermColor getEnum(String spermColor)
    {
        return (SpermColor)getEnum(SpermColor.class, spermColor);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(SpermColor.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(SpermColor.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(SpermColor.class);
    }
}