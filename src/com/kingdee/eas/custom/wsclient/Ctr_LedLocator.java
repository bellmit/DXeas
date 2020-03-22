/**
 * Ctr_LedLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.kingdee.eas.custom.wsclient;

public class Ctr_LedLocator extends org.apache.axis.client.Service implements com.kingdee.eas.custom.wsclient.Ctr_Led {

    public Ctr_LedLocator() {
    }


    public Ctr_LedLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Ctr_LedLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Ctr_LedSoap
    private java.lang.String Ctr_LedSoap_address = "http://192.168.1.153:8001/Ctr_Led.asmx";

    public java.lang.String getCtr_LedSoapAddress() {
        return Ctr_LedSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Ctr_LedSoapWSDDServiceName = "Ctr_LedSoap";

    public java.lang.String getCtr_LedSoapWSDDServiceName() {
        return Ctr_LedSoapWSDDServiceName;
    }

    public void setCtr_LedSoapWSDDServiceName(java.lang.String name) {
        Ctr_LedSoapWSDDServiceName = name;
    }

    public com.kingdee.eas.custom.wsclient.Ctr_LedSoap getCtr_LedSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Ctr_LedSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCtr_LedSoap(endpoint);
    }

    public com.kingdee.eas.custom.wsclient.Ctr_LedSoap getCtr_LedSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.kingdee.eas.custom.wsclient.Ctr_LedSoapStub _stub = new com.kingdee.eas.custom.wsclient.Ctr_LedSoapStub(portAddress, this);
            _stub.setPortName(getCtr_LedSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCtr_LedSoapEndpointAddress(java.lang.String address) {
        Ctr_LedSoap_address = address;
    }


    // Use to get a proxy class for Ctr_LedSoap12
    private java.lang.String Ctr_LedSoap12_address = "http://192.168.1.153:8001/Ctr_Led.asmx";

    public java.lang.String getCtr_LedSoap12Address() {
        return Ctr_LedSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Ctr_LedSoap12WSDDServiceName = "Ctr_LedSoap12";

    public java.lang.String getCtr_LedSoap12WSDDServiceName() {
        return Ctr_LedSoap12WSDDServiceName;
    }

    public void setCtr_LedSoap12WSDDServiceName(java.lang.String name) {
        Ctr_LedSoap12WSDDServiceName = name;
    }

    public com.kingdee.eas.custom.wsclient.Ctr_LedSoap getCtr_LedSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Ctr_LedSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCtr_LedSoap12(endpoint);
    }

    public com.kingdee.eas.custom.wsclient.Ctr_LedSoap getCtr_LedSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.kingdee.eas.custom.wsclient.Ctr_LedSoap12Stub _stub = new com.kingdee.eas.custom.wsclient.Ctr_LedSoap12Stub(portAddress, this);
            _stub.setPortName(getCtr_LedSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCtr_LedSoap12EndpointAddress(java.lang.String address) {
        Ctr_LedSoap12_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.kingdee.eas.custom.wsclient.Ctr_LedSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.kingdee.eas.custom.wsclient.Ctr_LedSoapStub _stub = new com.kingdee.eas.custom.wsclient.Ctr_LedSoapStub(new java.net.URL(Ctr_LedSoap_address), this);
                _stub.setPortName(getCtr_LedSoapWSDDServiceName());
                return _stub;
            }
            if (com.kingdee.eas.custom.wsclient.Ctr_LedSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.kingdee.eas.custom.wsclient.Ctr_LedSoap12Stub _stub = new com.kingdee.eas.custom.wsclient.Ctr_LedSoap12Stub(new java.net.URL(Ctr_LedSoap12_address), this);
                _stub.setPortName(getCtr_LedSoap12WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Ctr_LedSoap".equals(inputPortName)) {
            return getCtr_LedSoap();
        }
        else if ("Ctr_LedSoap12".equals(inputPortName)) {
            return getCtr_LedSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "Ctr_Led");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "Ctr_LedSoap"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "Ctr_LedSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Ctr_LedSoap".equals(portName)) {
            setCtr_LedSoapEndpointAddress(address);
        }
        else 
if ("Ctr_LedSoap12".equals(portName)) {
            setCtr_LedSoap12EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
