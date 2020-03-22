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
public class FieldType extends StringEnum
{
    public static final String BILLHEADER_VALUE = "1";//alias=单据头
    public static final String BILLENTRY_VALUE = "2";//alias=单据体

    public static final FieldType BillHeader = new FieldType("BillHeader", BILLHEADER_VALUE);
    public static final FieldType BillEntry = new FieldType("BillEntry", BILLENTRY_VALUE);

    /**
     * construct function
     * @param String fieldType
     */
    private FieldType(String name, String fieldType)
    {
        super(name, fieldType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FieldType getEnum(String fieldType)
    {
        return (FieldType)getEnum(FieldType.class, fieldType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FieldType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FieldType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FieldType.class);
    }
}