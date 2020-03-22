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
public class MaleOrFemaleEnum extends IntEnum
{
    public static final int MALE_VALUE = 1;//alias=¹«
    public static final int FEMALE_VALUE = 2;//alias=Ä¸

    public static final MaleOrFemaleEnum male = new MaleOrFemaleEnum("male", MALE_VALUE);
    public static final MaleOrFemaleEnum female = new MaleOrFemaleEnum("female", FEMALE_VALUE);

    /**
     * construct function
     * @param integer maleOrFemaleEnum
     */
    private MaleOrFemaleEnum(String name, int maleOrFemaleEnum)
    {
        super(name, maleOrFemaleEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static MaleOrFemaleEnum getEnum(String maleOrFemaleEnum)
    {
        return (MaleOrFemaleEnum)getEnum(MaleOrFemaleEnum.class, maleOrFemaleEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static MaleOrFemaleEnum getEnum(int maleOrFemaleEnum)
    {
        return (MaleOrFemaleEnum)getEnum(MaleOrFemaleEnum.class, maleOrFemaleEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(MaleOrFemaleEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(MaleOrFemaleEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(MaleOrFemaleEnum.class);
    }
}