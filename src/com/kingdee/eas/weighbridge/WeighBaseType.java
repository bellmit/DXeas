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
public class WeighBaseType extends StringEnum
{
    public static final String TARE2GROSS_VALUE = "1";//alias=皮重-毛重
    public static final String GROSS2TARE_VALUE = "2";//alias=毛重-皮重
    public static final String TARE2GROSS2TARE_VALUE = "3";//alias=皮重-毛重-皮重

    public static final WeighBaseType Tare2Gross = new WeighBaseType("Tare2Gross", TARE2GROSS_VALUE);
    public static final WeighBaseType Gross2Tare = new WeighBaseType("Gross2Tare", GROSS2TARE_VALUE);
    public static final WeighBaseType Tare2Gross2Tare = new WeighBaseType("Tare2Gross2Tare", TARE2GROSS2TARE_VALUE);

    /**
     * construct function
     * @param String weighBaseType
     */
    private WeighBaseType(String name, String weighBaseType)
    {
        super(name, weighBaseType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static WeighBaseType getEnum(String weighBaseType)
    {
        return (WeighBaseType)getEnum(WeighBaseType.class, weighBaseType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(WeighBaseType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(WeighBaseType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(WeighBaseType.class);
    }
}