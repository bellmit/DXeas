/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.app;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class sex extends StringEnum
{
    public static final String MALE_VALUE = "1";//alias=¹«
    public static final String FEMALE_VALUE = "2";//alias=Ä¸
    public static final String BOTH_VALUE = "3";//alias=»ì

    public static final sex male = new sex("male", MALE_VALUE);
    public static final sex female = new sex("female", FEMALE_VALUE);
    public static final sex both = new sex("both", BOTH_VALUE);

    /**
     * construct function
     * @param String sex
     */
    private sex(String name, String sex)
    {
        super(name, sex);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static sex getEnum(String sex)
    {
        return (sex)getEnum(sex.class, sex);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(sex.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(sex.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(sex.class);
    }
}