/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class RandPScope extends StringEnum
{
    public static final String FORQC_VALUE = "0";//alias=÷ ºÏ
    public static final String FORSETTLE_VALUE = "1";//alias=Ω·À„

    public static final RandPScope forQC = new RandPScope("forQC", FORQC_VALUE);
    public static final RandPScope forSettle = new RandPScope("forSettle", FORSETTLE_VALUE);

    /**
     * construct function
     * @param String randPScope
     */
    private RandPScope(String name, String randPScope)
    {
        super(name, randPScope);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static RandPScope getEnum(String randPScope)
    {
        return (RandPScope)getEnum(RandPScope.class, randPScope);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(RandPScope.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(RandPScope.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(RandPScope.class);
    }
}