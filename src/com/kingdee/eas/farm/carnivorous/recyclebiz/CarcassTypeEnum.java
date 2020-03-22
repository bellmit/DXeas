/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class CarcassTypeEnum extends StringEnum
{
    public static final String CARCASS_VALUE = "1";//alias=ëØÌå
    public static final String COMPENSATE_VALUE = "2";//alias=²¹ÖØ
    public static final String DISABILITY_VALUE = "3";//alias=²ÐÑ¼
    public static final String HIGNTEMP_VALUE = "4";//alias=¸ßÎÂ

    public static final CarcassTypeEnum Carcass = new CarcassTypeEnum("Carcass", CARCASS_VALUE);
    public static final CarcassTypeEnum Compensate = new CarcassTypeEnum("Compensate", COMPENSATE_VALUE);
    public static final CarcassTypeEnum Disability = new CarcassTypeEnum("Disability", DISABILITY_VALUE);
    public static final CarcassTypeEnum HignTemp = new CarcassTypeEnum("HignTemp", HIGNTEMP_VALUE);

    /**
     * construct function
     * @param String carcassTypeEnum
     */
    private CarcassTypeEnum(String name, String carcassTypeEnum)
    {
        super(name, carcassTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static CarcassTypeEnum getEnum(String carcassTypeEnum)
    {
        return (CarcassTypeEnum)getEnum(CarcassTypeEnum.class, carcassTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(CarcassTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(CarcassTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(CarcassTypeEnum.class);
    }
}