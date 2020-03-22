/**
 * output package name
 */
package com.kingdee.eas.weighbridge;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class Parity extends StringEnum
{
    public static final String PARITY_NONE_VALUE = "0";//alias=PARITY_NONE
    public static final String PARITY_ODD_VALUE = "1";//alias=PARITY_ODD
    public static final String PARITY_EVEN_VALUE = "2";//alias=PARITY_EVEN
    public static final String PARITY_MARK_VALUE = "3";//alias=PARITY_MARK
    public static final String PARITY_SPACE_VALUE = "4";//alias=PARITY_SPACE

    public static final Parity PARITY_NONE = new Parity("PARITY_NONE", PARITY_NONE_VALUE);
    public static final Parity PARITY_ODD = new Parity("PARITY_ODD", PARITY_ODD_VALUE);
    public static final Parity PARITY_EVEN = new Parity("PARITY_EVEN", PARITY_EVEN_VALUE);
    public static final Parity PARITY_MARK = new Parity("PARITY_MARK", PARITY_MARK_VALUE);
    public static final Parity PARITY_SPACE = new Parity("PARITY_SPACE", PARITY_SPACE_VALUE);

    /**
     * construct function
     * @param String parity
     */
    private Parity(String name, String parity)
    {
        super(name, parity);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static Parity getEnum(String parity)
    {
        return (Parity)getEnum(Parity.class, parity);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(Parity.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(Parity.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(Parity.class);
    }
}