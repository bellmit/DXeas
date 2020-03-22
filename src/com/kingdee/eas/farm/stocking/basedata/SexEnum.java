/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class SexEnum extends IntEnum
{
    public static final int MALE_VALUE = 1;//alias=ÄÐ
    public static final int FEMALE_VALUE = 2;//alias=Å®

    public static final SexEnum male = new SexEnum("male", MALE_VALUE);
    public static final SexEnum female = new SexEnum("female", FEMALE_VALUE);

    /**
     * construct function
     * @param integer sexEnum
     */
    private SexEnum(String name, int sexEnum)
    {
        super(name, sexEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static SexEnum getEnum(String sexEnum)
    {
        return (SexEnum)getEnum(SexEnum.class, sexEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static SexEnum getEnum(int sexEnum)
    {
        return (SexEnum)getEnum(SexEnum.class, sexEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(SexEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(SexEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(SexEnum.class);
    }
}