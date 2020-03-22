/**
 * Ctr_LedSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.kingdee.eas.custom.wsclient;

public interface Ctr_LedSoap extends java.rmi.Remote {
    public java.lang.String testPort(java.lang.String port, java.lang.String baudRate) throws java.rmi.RemoteException;
    public java.lang.String lighten(java.lang.String port, java.lang.String baudRate, int ledNo) throws java.rmi.RemoteException;
    public java.lang.String extinguish(java.lang.String port, java.lang.String baudRate, int ledNo) throws java.rmi.RemoteException;
    public java.lang.String allOut(java.lang.String port, java.lang.String baudRate) throws java.rmi.RemoteException;
}
