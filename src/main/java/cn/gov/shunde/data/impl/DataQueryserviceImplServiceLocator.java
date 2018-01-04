/**
 * DataQueryserviceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.gov.shunde.data.impl;

public class DataQueryserviceImplServiceLocator extends org.apache.axis.client.Service implements cn.gov.shunde.data.impl.DataQueryserviceImplService {

    public DataQueryserviceImplServiceLocator() {
    }


    public DataQueryserviceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DataQueryserviceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DataQueryserviceImplPort
    private java.lang.String DataQueryserviceImplPort_address = "http://localhost/webservice/server/web-query";

    public java.lang.String getDataQueryserviceImplPortAddress() {
        return DataQueryserviceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DataQueryserviceImplPortWSDDServiceName = "DataQueryserviceImplPort";

    public java.lang.String getDataQueryserviceImplPortWSDDServiceName() {
        return DataQueryserviceImplPortWSDDServiceName;
    }

    public void setDataQueryserviceImplPortWSDDServiceName(java.lang.String name) {
        DataQueryserviceImplPortWSDDServiceName = name;
    }

    public cn.gov.shunde.data.DataQueryService getDataQueryserviceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DataQueryserviceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDataQueryserviceImplPort(endpoint);
    }

    public cn.gov.shunde.data.DataQueryService getDataQueryserviceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.gov.shunde.data.impl.DataQueryserviceImplServiceSoapBindingStub _stub = new cn.gov.shunde.data.impl.DataQueryserviceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getDataQueryserviceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDataQueryserviceImplPortEndpointAddress(java.lang.String address) {
        DataQueryserviceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.gov.shunde.data.DataQueryService.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.gov.shunde.data.impl.DataQueryserviceImplServiceSoapBindingStub _stub = new cn.gov.shunde.data.impl.DataQueryserviceImplServiceSoapBindingStub(new java.net.URL(DataQueryserviceImplPort_address), this);
                _stub.setPortName(getDataQueryserviceImplPortWSDDServiceName());
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
        if ("DataQueryserviceImplPort".equals(inputPortName)) {
            return getDataQueryserviceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.data.shunde.gov.cn/", "DataQueryserviceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.data.shunde.gov.cn/", "DataQueryserviceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DataQueryserviceImplPort".equals(portName)) {
            setDataQueryserviceImplPortEndpointAddress(address);
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
