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
public class BreedStage extends StringEnum
{
    public static final String NULL_VALUE_VALUE = "0";//alias=¿Õ
    public static final String BROOD_VALUE = "2";//alias=Óý³É
    public static final String EGG_VALUE = "4";//alias=ÖÖµ°

    public static final BreedStage null_value = new BreedStage("null_value", NULL_VALUE_VALUE);
    public static final BreedStage Brood = new BreedStage("Brood", BROOD_VALUE);
    public static final BreedStage egg = new BreedStage("egg", EGG_VALUE);

    /**
     * construct function
     * @param String breedStage
     */
    private BreedStage(String name, String breedStage)
    {
        super(name, breedStage);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BreedStage getEnum(String breedStage)
    {
        return (BreedStage)getEnum(BreedStage.class, breedStage);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BreedStage.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BreedStage.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BreedStage.class);
    }
}