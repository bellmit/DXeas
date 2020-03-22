/**
 * output package name
 */
package com.kingdee.eas.publicdata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class dbType extends StringEnum
{
    public static final String ACCESS_VALUE = "1";//alias=ACCESS
    public static final String MYSQL_VALUE = "2";//alias=MySql
    public static final String SQLSERVER_VALUE = "3";//alias=SqlServer2000
    public static final String SQLSERVER2005PLUS_VALUE = "4";//alias=SqlServer2005/2008
    public static final String ORACLE_VALUE = "5";//alias=Oracle

    public static final dbType access = new dbType("access", ACCESS_VALUE);
    public static final dbType mysql = new dbType("mysql", MYSQL_VALUE);
    public static final dbType sqlServer = new dbType("sqlServer", SQLSERVER_VALUE);
    public static final dbType sqlServer2005Plus = new dbType("sqlServer2005Plus", SQLSERVER2005PLUS_VALUE);
    public static final dbType oracle = new dbType("oracle", ORACLE_VALUE);

    /**
     * construct function
     * @param String dbType
     */
    private dbType(String name, String dbType)
    {
        super(name, dbType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static dbType getEnum(String dbType)
    {
        return (dbType)getEnum(dbType.class, dbType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(dbType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(dbType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(dbType.class);
    }
}