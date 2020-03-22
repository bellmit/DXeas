package com.kingdee.eas.custom.wsclient;

public class Ctr_LedSoapProxy implements com.kingdee.eas.custom.wsclient.Ctr_LedSoap {
  private String _endpoint = null;
  private com.kingdee.eas.custom.wsclient.Ctr_LedSoap ctr_LedSoap = null;
  
  public Ctr_LedSoapProxy() {
    _initCtr_LedSoapProxy();
  }
  
  private void _initCtr_LedSoapProxy() {
    try {
      ctr_LedSoap = (new com.kingdee.eas.custom.wsclient.Ctr_LedLocator()).getCtr_LedSoap();
      if (ctr_LedSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)ctr_LedSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)ctr_LedSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (ctr_LedSoap != null)
      ((javax.xml.rpc.Stub)ctr_LedSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.kingdee.eas.custom.wsclient.Ctr_LedSoap getCtr_LedSoap() {
    if (ctr_LedSoap == null)
      _initCtr_LedSoapProxy();
    return ctr_LedSoap;
  }
  
  public java.lang.String testPort(java.lang.String port, java.lang.String baudRate) throws java.rmi.RemoteException{
    if (ctr_LedSoap == null)
      _initCtr_LedSoapProxy();
    return ctr_LedSoap.testPort(port, baudRate);
  }
  
  public java.lang.String lighten(java.lang.String port, java.lang.String baudRate, int ledNo) throws java.rmi.RemoteException{
    if (ctr_LedSoap == null)
      _initCtr_LedSoapProxy();
    return ctr_LedSoap.lighten(port, baudRate, ledNo);
  }
  
  public java.lang.String extinguish(java.lang.String port, java.lang.String baudRate, int ledNo) throws java.rmi.RemoteException{
    if (ctr_LedSoap == null)
      _initCtr_LedSoapProxy();
    return ctr_LedSoap.extinguish(port, baudRate, ledNo);
  }
  
  public java.lang.String allOut(java.lang.String port, java.lang.String baudRate) throws java.rmi.RemoteException{
    if (ctr_LedSoap == null)
      _initCtr_LedSoapProxy();
    return ctr_LedSoap.allOut(port, baudRate);
  }
  
  
}