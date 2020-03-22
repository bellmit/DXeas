/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.weight;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class CarcassType extends StringEnum
{
    public static final String CHICK_VALUE = "1";//alias=Ð¡¼¦
    public static final String CJ_VALUE = "2";//alias=²Ð¼¦

    public static final CarcassType chick = new CarcassType("chick", CHICK_VALUE);
    public static final CarcassType cj = new CarcassType("cj", CJ_VALUE);

    /**
     * construct function
     * @param String carcassType
     */
    private CarcassType(String name, String carcassType)
    {
        super(name, carcassType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static CarcassType getEnum(String carcassType)
    {
        return (CarcassType)getEnum(CarcassType.class, carcassType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(CarcassType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(CarcassType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(CarcassType.class);
    }
}