/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.sale;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class dealStatus extends StringEnum
{
    public static final String DEALBEGIN_VALUE = "0";//alias=未接受处理
    public static final String DEALING_VALUE = "1";//alias=处理中
    public static final String DEALED_VALUE = "2";//alias=处理结束
    public static final String NODEAL_VALUE = "3";//alias=不作处理

    public static final dealStatus dealBegin = new dealStatus("dealBegin", DEALBEGIN_VALUE);
    public static final dealStatus dealing = new dealStatus("dealing", DEALING_VALUE);
    public static final dealStatus dealed = new dealStatus("dealed", DEALED_VALUE);
    public static final dealStatus noDeal = new dealStatus("noDeal", NODEAL_VALUE);

    /**
     * construct function
     * @param String dealStatus
     */
    private dealStatus(String name, String dealStatus)
    {
        super(name, dealStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static dealStatus getEnum(String dealStatus)
    {
        return (dealStatus)getEnum(dealStatus.class, dealStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(dealStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(dealStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(dealStatus.class);
    }
}