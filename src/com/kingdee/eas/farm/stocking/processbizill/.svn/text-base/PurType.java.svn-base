/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class PurType extends StringEnum
{
    public static final String INPUT_VALUE = "1";//alias=制单
    public static final String EXCUTE_VALUE = "2";//alias=下达
    public static final String CLOSE_VALUE = "3";//alias=关闭

    public static final PurType Input = new PurType("Input", INPUT_VALUE);
    public static final PurType Excute = new PurType("Excute", EXCUTE_VALUE);
    public static final PurType Close = new PurType("Close", CLOSE_VALUE);

    /**
     * construct function
     * @param String purType
     */
    private PurType(String name, String purType)
    {
        super(name, purType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static PurType getEnum(String purType)
    {
        return (PurType)getEnum(PurType.class, purType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(PurType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(PurType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(PurType.class);
    }
}