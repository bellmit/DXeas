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
public class Sex extends StringEnum
{
    public static final String MALE_VALUE = "1";//alias=¹«
    public static final String FEMALE_VALUE = "2";//alias=Ä¸

    public static final Sex Male = new Sex("Male", MALE_VALUE);
    public static final Sex Female = new Sex("Female", FEMALE_VALUE);

    /**
     * construct function
     * @param String sex
     */
    private Sex(String name, String sex)
    {
        super(name, sex);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static Sex getEnum(String sex)
    {
        return (Sex)getEnum(Sex.class, sex);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(Sex.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(Sex.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(Sex.class);
    }
}