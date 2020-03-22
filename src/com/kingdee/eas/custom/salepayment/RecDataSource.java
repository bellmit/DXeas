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
public class RecDataSource extends StringEnum
{
    public static final String VERIFYLOG_VALUE = "1";//alias=系统核销记录
    public static final String MANUALDATA_VALUE = "2";//alias=手工录入数据

    public static final RecDataSource VerifyLog = new RecDataSource("VerifyLog", VERIFYLOG_VALUE);
    public static final RecDataSource ManualData = new RecDataSource("ManualData", MANUALDATA_VALUE);

    /**
     * construct function
     * @param String recDataSource
     */
    private RecDataSource(String name, String recDataSource)
    {
        super(name, recDataSource);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static RecDataSource getEnum(String recDataSource)
    {
        return (RecDataSource)getEnum(RecDataSource.class, recDataSource);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(RecDataSource.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(RecDataSource.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(RecDataSource.class);
    }
}