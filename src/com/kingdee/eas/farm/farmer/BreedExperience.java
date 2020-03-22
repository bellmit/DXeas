/**
 * output package name
 */
package com.kingdee.eas.farm.farmer;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class BreedExperience extends StringEnum
{
    public static final String NO_VALUE = "0";//alias=无经验
    public static final String ONEYEAR_VALUE = "1";//alias=一年以内
    public static final String TWOYEAR_VALUE = "2";//alias=两年
    public static final String THREEYEAR_VALUE = "3";//alias=三年
    public static final String THREEMOREYEAR_VALUE = "4";//alias=三年以上

    public static final BreedExperience No = new BreedExperience("No", NO_VALUE);
    public static final BreedExperience OneYear = new BreedExperience("OneYear", ONEYEAR_VALUE);
    public static final BreedExperience TwoYear = new BreedExperience("TwoYear", TWOYEAR_VALUE);
    public static final BreedExperience ThreeYear = new BreedExperience("ThreeYear", THREEYEAR_VALUE);
    public static final BreedExperience ThreeMoreYear = new BreedExperience("ThreeMoreYear", THREEMOREYEAR_VALUE);

    /**
     * construct function
     * @param String breedExperience
     */
    private BreedExperience(String name, String breedExperience)
    {
        super(name, breedExperience);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BreedExperience getEnum(String breedExperience)
    {
        return (BreedExperience)getEnum(BreedExperience.class, breedExperience);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BreedExperience.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BreedExperience.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BreedExperience.class);
    }
}