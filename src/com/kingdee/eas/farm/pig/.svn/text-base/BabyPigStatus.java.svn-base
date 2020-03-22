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
public class BabyPigStatus extends StringEnum
{
    public static final String UPTOSTANDARD_VALUE = "1";//alias=ºÏ¸ñ
    public static final String WEAK_VALUE = "2";//alias=Èõ×Ð
    public static final String MALFORMATION_VALUE = "3";//alias=»ûÐÎ
    public static final String MUMMY_VALUE = "4";//alias=Ä¾ÄËÒÁ
    public static final String DEATH_VALUE = "5";//alias=ËÀÌ¥
    public static final String INPERFECT_VALUE = "6";//alias=²Ð´Î

    public static final BabyPigStatus UpToStandard = new BabyPigStatus("UpToStandard", UPTOSTANDARD_VALUE);
    public static final BabyPigStatus Weak = new BabyPigStatus("Weak", WEAK_VALUE);
    public static final BabyPigStatus Malformation = new BabyPigStatus("Malformation", MALFORMATION_VALUE);
    public static final BabyPigStatus Mummy = new BabyPigStatus("Mummy", MUMMY_VALUE);
    public static final BabyPigStatus Death = new BabyPigStatus("Death", DEATH_VALUE);
    public static final BabyPigStatus Inperfect = new BabyPigStatus("Inperfect", INPERFECT_VALUE);

    /**
     * construct function
     * @param String babyPigStatus
     */
    private BabyPigStatus(String name, String babyPigStatus)
    {
        super(name, babyPigStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BabyPigStatus getEnum(String babyPigStatus)
    {
        return (BabyPigStatus)getEnum(BabyPigStatus.class, babyPigStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BabyPigStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BabyPigStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BabyPigStatus.class);
    }
}