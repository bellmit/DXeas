/**
 * output package name
 */
package com.kingdee.eas.custom.salepayment;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class Quarter extends StringEnum
{
    public static final String ONE_VALUE = "1";//alias=一季度
    public static final String TWO_VALUE = "2";//alias=二季度
    public static final String THREE_VALUE = "3";//alias=三季度
    public static final String FOUR_VALUE = "4";//alias=四季度
    public static final String WHOLEYEAR_VALUE = "0";//alias=全年

    public static final Quarter One = new Quarter("One", ONE_VALUE);
    public static final Quarter Two = new Quarter("Two", TWO_VALUE);
    public static final Quarter Three = new Quarter("Three", THREE_VALUE);
    public static final Quarter Four = new Quarter("Four", FOUR_VALUE);
    public static final Quarter WholeYear = new Quarter("WholeYear", WHOLEYEAR_VALUE);

    /**
     * construct function
     * @param String quarter
     */
    private Quarter(String name, String quarter)
    {
        super(name, quarter);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static Quarter getEnum(String quarter)
    {
        return (Quarter)getEnum(Quarter.class, quarter);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(Quarter.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(Quarter.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(Quarter.class);
    }
}