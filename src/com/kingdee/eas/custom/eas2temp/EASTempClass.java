/**
 * output package name
 */
package com.kingdee.eas.custom.eas2temp;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class EASTempClass extends StringEnum
{
    public static final String ONE_VALUE = "一班";//alias=一班
    public static final String TWO_VALUE = "二班";//alias=二班

    public static final EASTempClass one = new EASTempClass("one", ONE_VALUE);
    public static final EASTempClass two = new EASTempClass("two", TWO_VALUE);

    /**
     * construct function
     * @param String eASTempClass
     */
    private EASTempClass(String name, String eASTempClass)
    {
        super(name, eASTempClass);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static EASTempClass getEnum(String eASTempClass)
    {
        return (EASTempClass)getEnum(EASTempClass.class, eASTempClass);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(EASTempClass.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(EASTempClass.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(EASTempClass.class);
    }
}