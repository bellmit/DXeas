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
public class PublicPraise extends StringEnum
{
    public static final String POOR_VALUE = "1";//alias=½Ï²î
    public static final String NORMAL_VALUE = "2";//alias=Ò»°ã
    public static final String WELL_VALUE = "3";//alias=Á¼ºÃ

    public static final PublicPraise Poor = new PublicPraise("Poor", POOR_VALUE);
    public static final PublicPraise Normal = new PublicPraise("Normal", NORMAL_VALUE);
    public static final PublicPraise Well = new PublicPraise("Well", WELL_VALUE);

    /**
     * construct function
     * @param String publicPraise
     */
    private PublicPraise(String name, String publicPraise)
    {
        super(name, publicPraise);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static PublicPraise getEnum(String publicPraise)
    {
        return (PublicPraise)getEnum(PublicPraise.class, publicPraise);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(PublicPraise.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(PublicPraise.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(PublicPraise.class);
    }
}