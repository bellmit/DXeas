/**
 * output package name
 */
package com.kingdee.eas.farm.breed;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class FodderTypeCode extends StringEnum
{
    public static final String ONE_VALUE = "1";//alias=一号料
    public static final String TWO_VALUE = "2";//alias=二号料
    public static final String THREE_VALUE = "3";//alias=三号料

    public static final FodderTypeCode ONE = new FodderTypeCode("ONE", ONE_VALUE);
    public static final FodderTypeCode TWO = new FodderTypeCode("TWO", TWO_VALUE);
    public static final FodderTypeCode THREE = new FodderTypeCode("THREE", THREE_VALUE);

    /**
     * construct function
     * @param String fodderTypeCode
     */
    private FodderTypeCode(String name, String fodderTypeCode)
    {
        super(name, fodderTypeCode);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FodderTypeCode getEnum(String fodderTypeCode)
    {
        return (FodderTypeCode)getEnum(FodderTypeCode.class, fodderTypeCode);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FodderTypeCode.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FodderTypeCode.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FodderTypeCode.class);
    }
}