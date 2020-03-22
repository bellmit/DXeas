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
public class QCReturn extends StringEnum
{
    public static final String PASS_VALUE = "0";//alias=合格接收
    public static final String COMPROMISE_VALUE = "1";//alias=让步接收
    public static final String REJECTION_VALUE = "2";//alias=拒收接收

    public static final QCReturn Pass = new QCReturn("Pass", PASS_VALUE);
    public static final QCReturn Compromise = new QCReturn("Compromise", COMPROMISE_VALUE);
    public static final QCReturn Rejection = new QCReturn("Rejection", REJECTION_VALUE);

    /**
     * construct function
     * @param String qCReturn
     */
    private QCReturn(String name, String qCReturn)
    {
        super(name, qCReturn);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static QCReturn getEnum(String qCReturn)
    {
        return (QCReturn)getEnum(QCReturn.class, qCReturn);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(QCReturn.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(QCReturn.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(QCReturn.class);
    }
}