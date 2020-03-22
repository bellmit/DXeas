/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class FarmTypeEnum extends StringEnum
{
    public static final String THIRTYKM_VALUE = "0";//alias=0-30Km
    public static final String SIXTYKM_VALUE = "1";//alias=31-60Km
    public static final String NINETYKM_VALUE = "2";//alias=61-90Km
    public static final String HUNDREDTWENTYKM_VALUE = "3";//alias=91-120Km
    public static final String BELOWHUNDREDTWENTYKM_VALUE = "4";//alias=120Km“‘…œ

    public static final FarmTypeEnum thirtyKm = new FarmTypeEnum("thirtyKm", THIRTYKM_VALUE);
    public static final FarmTypeEnum sixtyKm = new FarmTypeEnum("sixtyKm", SIXTYKM_VALUE);
    public static final FarmTypeEnum ninetyKm = new FarmTypeEnum("ninetyKm", NINETYKM_VALUE);
    public static final FarmTypeEnum HundredTwentyKm = new FarmTypeEnum("HundredTwentyKm", HUNDREDTWENTYKM_VALUE);
    public static final FarmTypeEnum belowHundredTwentyKm = new FarmTypeEnum("belowHundredTwentyKm", BELOWHUNDREDTWENTYKM_VALUE);

    /**
     * construct function
     * @param String farmTypeEnum
     */
    private FarmTypeEnum(String name, String farmTypeEnum)
    {
        super(name, farmTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FarmTypeEnum getEnum(String farmTypeEnum)
    {
        return (FarmTypeEnum)getEnum(FarmTypeEnum.class, farmTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FarmTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FarmTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FarmTypeEnum.class);
    }
}