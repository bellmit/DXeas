/**
 * output package name
 */
package com.kingdee.eas.farm.feedfactory;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class QCResult extends StringEnum
{
    public static final String PASS_VALUE = "1";//alias=合格
    public static final String UNPASS_VALUE = "-1";//alias=不合格
    public static final String UNKNOWN_VALUE = "0";//alias=未知

    public static final QCResult Pass = new QCResult("Pass", PASS_VALUE);
    public static final QCResult UnPass = new QCResult("UnPass", UNPASS_VALUE);
    public static final QCResult UnKnown = new QCResult("UnKnown", UNKNOWN_VALUE);

    /**
     * construct function
     * @param String qCResult
     */
    private QCResult(String name, String qCResult)
    {
        super(name, qCResult);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static QCResult getEnum(String qCResult)
    {
        return (QCResult)getEnum(QCResult.class, qCResult);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(QCResult.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(QCResult.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(QCResult.class);
    }
}