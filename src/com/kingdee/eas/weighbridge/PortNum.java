/**
 * output package name
 */
package com.kingdee.eas.weighbridge;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class PortNum extends StringEnum
{
    public static final String COM1_VALUE = "0";//alias=COM1
    public static final String COM2_VALUE = "1";//alias=COM2
    public static final String COM3_VALUE = "2";//alias=COM3
    public static final String COM4_VALUE = "3";//alias=COM4
    public static final String COM5_VALUE = "5";//alias=COM5
    public static final String COM6_VALUE = "6";//alias=COM6
    public static final String COM7_VALUE = "7";//alias=COM7
    public static final String COM8_VALUE = "8";//alias=COM8
    public static final String COM9_VALUE = "9";//alias=COM9
    public static final String COM10_VALUE = "10";//alias=COM10
    public static final String COM11_VALUE = "11";//alias=COM11
    public static final String COM12_VALUE = "12";//alias=COM12
    public static final String COM13_VALUE = "13";//alias=COM13

    public static final PortNum COM1 = new PortNum("COM1", COM1_VALUE);
    public static final PortNum COM2 = new PortNum("COM2", COM2_VALUE);
    public static final PortNum COM3 = new PortNum("COM3", COM3_VALUE);
    public static final PortNum COM4 = new PortNum("COM4", COM4_VALUE);
    public static final PortNum COM5 = new PortNum("COM5", COM5_VALUE);
    public static final PortNum COM6 = new PortNum("COM6", COM6_VALUE);
    public static final PortNum COM7 = new PortNum("COM7", COM7_VALUE);
    public static final PortNum COM8 = new PortNum("COM8", COM8_VALUE);
    public static final PortNum COM9 = new PortNum("COM9", COM9_VALUE);
    public static final PortNum COM10 = new PortNum("COM10", COM10_VALUE);
    public static final PortNum COM11 = new PortNum("COM11", COM11_VALUE);
    public static final PortNum COM12 = new PortNum("COM12", COM12_VALUE);
    public static final PortNum COM13 = new PortNum("COM13", COM13_VALUE);

    /**
     * construct function
     * @param String portNum
     */
    private PortNum(String name, String portNum)
    {
        super(name, portNum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static PortNum getEnum(String portNum)
    {
        return (PortNum)getEnum(PortNum.class, portNum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(PortNum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(PortNum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(PortNum.class);
    }
}