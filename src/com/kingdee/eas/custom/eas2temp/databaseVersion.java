/**
 * output package name
 */
package com.kingdee.eas.custom.eas2temp;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class databaseVersion extends IntEnum
{
    public static final int SQLSERVER2000_VALUE = 1;//alias=SqlServer2000
    public static final int SQLSERVER2005_VALUE = 2;//alias=SqlServer2005º∞“‘…œ

    public static final databaseVersion SqlServer2000 = new databaseVersion("SqlServer2000", SQLSERVER2000_VALUE);
    public static final databaseVersion SqlServer2005 = new databaseVersion("SqlServer2005", SQLSERVER2005_VALUE);

    /**
     * construct function
     * @param integer databaseVersion
     */
    private databaseVersion(String name, int databaseVersion)
    {
        super(name, databaseVersion);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static databaseVersion getEnum(String databaseVersion)
    {
        return (databaseVersion)getEnum(databaseVersion.class, databaseVersion);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static databaseVersion getEnum(int databaseVersion)
    {
        return (databaseVersion)getEnum(databaseVersion.class, databaseVersion);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(databaseVersion.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(databaseVersion.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(databaseVersion.class);
    }
}