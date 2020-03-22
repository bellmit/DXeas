/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class distributeType extends StringEnum
{
    public static final String PICKUPBYCUSTOMER_VALUE = "PickUpByCustomer";//alias=自提
    public static final String DISTRIBUTEBYCOMPANY_VALUE = "DistributeByCompany";//alias=公司配送
    public static final String DISTRIBUTEBUTNEEDPAY_VALUE = "DistributeButNeedPay";//alias=资费配送

    public static final distributeType pickUpByCustomer = new distributeType("pickUpByCustomer", PICKUPBYCUSTOMER_VALUE);
    public static final distributeType distributeByCompany = new distributeType("distributeByCompany", DISTRIBUTEBYCOMPANY_VALUE);
    public static final distributeType distributeButNeedPay = new distributeType("distributeButNeedPay", DISTRIBUTEBUTNEEDPAY_VALUE);

    /**
     * construct function
     * @param String distributeType
     */
    private distributeType(String name, String distributeType)
    {
        super(name, distributeType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static distributeType getEnum(String distributeType)
    {
        return (distributeType)getEnum(distributeType.class, distributeType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(distributeType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(distributeType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(distributeType.class);
    }
}