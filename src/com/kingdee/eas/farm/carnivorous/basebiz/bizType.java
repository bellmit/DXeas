/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basebiz;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class bizType extends StringEnum
{
    public static final String RECEIVE_VALUE = "1";//alias=收保证金
    public static final String RETURNBACK_VALUE = "2";//alias=退保证金

    public static final bizType receive = new bizType("receive", RECEIVE_VALUE);
    public static final bizType returnBack = new bizType("returnBack", RETURNBACK_VALUE);

    /**
     * construct function
     * @param String bizType
     */
    private bizType(String name, String bizType)
    {
        super(name, bizType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static bizType getEnum(String bizType)
    {
        return (bizType)getEnum(bizType.class, bizType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(bizType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(bizType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(bizType.class);
    }
}