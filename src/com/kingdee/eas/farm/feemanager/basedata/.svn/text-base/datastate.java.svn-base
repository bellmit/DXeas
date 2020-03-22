/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class datastate extends StringEnum
{
    public static final String ADD_VALUE = "0";//alias=新增
    public static final String SAVE_VALUE = "1";//alias=保存
    public static final String REVIEW_VALUE = "2";//alias=核审
    public static final String ACTIVE_VALUE = "4";//alias=启用
    public static final String INACTIVE_VALUE = "5";//alias=禁用
    public static final String REVIEWBACK_VALUE = "3";//alias=反核审

    public static final datastate add = new datastate("add", ADD_VALUE);
    public static final datastate save = new datastate("save", SAVE_VALUE);
    public static final datastate review = new datastate("review", REVIEW_VALUE);
    public static final datastate active = new datastate("active", ACTIVE_VALUE);
    public static final datastate inactive = new datastate("inactive", INACTIVE_VALUE);
    public static final datastate reviewback = new datastate("reviewback", REVIEWBACK_VALUE);

    /**
     * construct function
     * @param String datastate
     */
    private datastate(String name, String datastate)
    {
        super(name, datastate);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static datastate getEnum(String datastate)
    {
        return (datastate)getEnum(datastate.class, datastate);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(datastate.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(datastate.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(datastate.class);
    }
}