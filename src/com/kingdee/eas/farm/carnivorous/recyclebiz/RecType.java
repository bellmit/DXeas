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
public class RecType extends StringEnum
{
    public static final String INNER_VALUE = "0";//alias=Ð¡¼¦
    public static final String OUT_VALUE = "1";//alias=Ã«¼¦

    public static final RecType inner = new RecType("inner", INNER_VALUE);
    public static final RecType out = new RecType("out", OUT_VALUE);

    /**
     * construct function
     * @param String recType
     */
    private RecType(String name, String recType)
    {
        super(name, recType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static RecType getEnum(String recType)
    {
        return (RecType)getEnum(RecType.class, recType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(RecType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(RecType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(RecType.class);
    }
}