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
public class BreedAbility extends StringEnum
{
    public static final String POOR_VALUE = "1";//alias=½Ï²î
    public static final String NORMAL_VALUE = "2";//alias=Ò»°ã
    public static final String WELL_VALUE = "3";//alias=Á¼ºÃ

    public static final BreedAbility Poor = new BreedAbility("Poor", POOR_VALUE);
    public static final BreedAbility Normal = new BreedAbility("Normal", NORMAL_VALUE);
    public static final BreedAbility Well = new BreedAbility("Well", WELL_VALUE);

    /**
     * construct function
     * @param String breedAbility
     */
    private BreedAbility(String name, String breedAbility)
    {
        super(name, breedAbility);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BreedAbility getEnum(String breedAbility)
    {
        return (BreedAbility)getEnum(BreedAbility.class, breedAbility);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BreedAbility.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BreedAbility.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BreedAbility.class);
    }
}