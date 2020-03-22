/**
 * output package name
 */
package com.kingdee.eas.custom.wages;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class ClaimMethod extends StringEnum
{
    public static final String COMPANY_VALUE = "0";//alias=公司赔付
    public static final String PERSON_VALUE = "1";//alias=个人赔付

    public static final ClaimMethod company = new ClaimMethod("company", COMPANY_VALUE);
    public static final ClaimMethod person = new ClaimMethod("person", PERSON_VALUE);

    /**
     * construct function
     * @param String claimMethod
     */
    private ClaimMethod(String name, String claimMethod)
    {
        super(name, claimMethod);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ClaimMethod getEnum(String claimMethod)
    {
        return (ClaimMethod)getEnum(ClaimMethod.class, claimMethod);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ClaimMethod.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ClaimMethod.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ClaimMethod.class);
    }
}