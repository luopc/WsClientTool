/**
 * DataQueryService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.gov.shunde.data;

public interface DataQueryService extends java.rmi.Remote {
    public java.lang.String query(java.lang.String sId, java.lang.String type, java.lang.String requestJson) throws java.rmi.RemoteException;
    public java.lang.String fileList(java.lang.String sId) throws java.rmi.RemoteException;
}
