/**
 * output package name
 */
package com.kingdee.eas.wlhlcomm;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class FieldDataType extends StringEnum
{
    public static final String BOOLEAN_VALUE = "1";//alias=Boolean型
    public static final String BIGDECIMAL_VALUE = "2";//alias=小数型
    public static final String INT_VALUE = "3";//alias=整型
    public static final String STRING_VALUE = "4";//alias=字符串
    public static final String ENUM_VALUE = "5";//alias=枚举
    public static final String F7_VALUE = "6";//alias=F7

    public static final FieldDataType Boolean = new FieldDataType("Boolean", BOOLEAN_VALUE);
    public static final FieldDataType BigDecimal = new FieldDataType("BigDecimal", BIGDECIMAL_VALUE);
    public static final FieldDataType Int = new FieldDataType("Int", INT_VALUE);
    public static final FieldDataType String = new FieldDataType("String", STRING_VALUE);
    public static final FieldDataType Enum = new FieldDataType("Enum", ENUM_VALUE);
    public static final FieldDataType F7 = new FieldDataType("F7", F7_VALUE);

    /**
     * construct function
     * @param String fieldDataType
     */
    private FieldDataType(String name, String fieldDataType)
    {
        super(name, fieldDataType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FieldDataType getEnum(String fieldDataType)
    {
        return (FieldDataType)getEnum(FieldDataType.class, fieldDataType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FieldDataType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FieldDataType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FieldDataType.class);
    }
}