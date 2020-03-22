/**
 * output package name
 */
package com.kingdee.eas.custom.salepayment;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class IndexType extends StringEnum
{
    public static final String QUARTER_VALUE = "2";//alias=¼¾¶È
    public static final String YEAR_VALUE = "3";//alias=Äê¶È

    public static final IndexType Quarter = new IndexType("Quarter", QUARTER_VALUE);
    public static final IndexType Year = new IndexType("Year", YEAR_VALUE);

    /**
     * construct function
     * @param String indexType
     */
    private IndexType(String name, String indexType)
    {
        super(name, indexType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static IndexType getEnum(String indexType)
    {
        return (IndexType)getEnum(IndexType.class, indexType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(IndexType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(IndexType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(IndexType.class);
    }
}