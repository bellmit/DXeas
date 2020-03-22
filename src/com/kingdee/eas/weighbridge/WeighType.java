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
public class WeighType extends StringEnum
{
    public static final String TARE2GROSS_VALUE = "1";//alias=皮重-毛重
    public static final String GROSS2TARE_VALUE = "2";//alias=毛重-皮重
    public static final String TARE2GROSS2TARE_VALUE = "3";//alias=皮重-毛重-皮重

    public static final WeighType Tare2Gross = new WeighType("Tare2Gross", TARE2GROSS_VALUE);
    public static final WeighType Gross2Tare = new WeighType("Gross2Tare", GROSS2TARE_VALUE);
    public static final WeighType Tare2Gross2Tare = new WeighType("Tare2Gross2Tare", TARE2GROSS2TARE_VALUE);

    /**
     * construct function
     * @param String weighType
     */
    private WeighType(String name, String weighType)
    {
        super(name, weighType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static WeighType getEnum(String weighType)
    {
        return (WeighType)getEnum(WeighType.class, weighType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(WeighType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(WeighType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(WeighType.class);
    }
}