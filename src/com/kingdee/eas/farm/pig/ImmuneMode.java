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
public class ImmuneMode extends StringEnum
{
    public static final String INTRAUSCULAR_VALUE = "1";//alias=肌注
    public static final String BYWATER_VALUE = "2";//alias=饮水
    public static final String HOUHAI_VALUE = "3";//alias=后海穴
    public static final String OTHERWAY_VALUE = "9";//alias=其他

    public static final ImmuneMode Intrauscular = new ImmuneMode("Intrauscular", INTRAUSCULAR_VALUE);
    public static final ImmuneMode ByWater = new ImmuneMode("ByWater", BYWATER_VALUE);
    public static final ImmuneMode Houhai = new ImmuneMode("Houhai", HOUHAI_VALUE);
    public static final ImmuneMode OtherWay = new ImmuneMode("OtherWay", OTHERWAY_VALUE);

    /**
     * construct function
     * @param String immuneMode
     */
    private ImmuneMode(String name, String immuneMode)
    {
        super(name, immuneMode);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ImmuneMode getEnum(String immuneMode)
    {
        return (ImmuneMode)getEnum(ImmuneMode.class, immuneMode);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ImmuneMode.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ImmuneMode.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ImmuneMode.class);
    }
}