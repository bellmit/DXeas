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
public class DateRelate extends StringEnum
{
    public static final String INDATE_VALUE = "0";//alias=½ø³û
    public static final String RECDATE_VALUE = "1";//alias=»ØÊÕ

    public static final DateRelate inDate = new DateRelate("inDate", INDATE_VALUE);
    public static final DateRelate recDate = new DateRelate("recDate", RECDATE_VALUE);

    /**
     * construct function
     * @param String dateRelate
     */
    private DateRelate(String name, String dateRelate)
    {
        super(name, dateRelate);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static DateRelate getEnum(String dateRelate)
    {
        return (DateRelate)getEnum(DateRelate.class, dateRelate);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(DateRelate.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(DateRelate.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(DateRelate.class);
    }
}