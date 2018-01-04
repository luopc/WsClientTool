package cn.gov.shunde.data;

public class DataQueryServiceProxy implements cn.gov.shunde.data.DataQueryService {
  private String _endpoint = null;
  private cn.gov.shunde.data.DataQueryService dataQueryService = null;
  
  public DataQueryServiceProxy() {
    _initDataQueryServiceProxy();
  }
  
  public DataQueryServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initDataQueryServiceProxy();
  }
  
  private void _initDataQueryServiceProxy() {
    try {
      dataQueryService = (new cn.gov.shunde.data.impl.DataQueryserviceImplServiceLocator()).getDataQueryserviceImplPort();
      if (dataQueryService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dataQueryService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dataQueryService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dataQueryService != null)
      ((javax.xml.rpc.Stub)dataQueryService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.gov.shunde.data.DataQueryService getDataQueryService() {
    if (dataQueryService == null)
      _initDataQueryServiceProxy();
    return dataQueryService;
  }
  
  public java.lang.String query(java.lang.String sId, java.lang.String type, java.lang.String requestJson) throws java.rmi.RemoteException{
    if (dataQueryService == null)
      _initDataQueryServiceProxy();
    return dataQueryService.query(sId, type, requestJson);
  }
  
  public java.lang.String fileList(java.lang.String sId) throws java.rmi.RemoteException{
    if (dataQueryService == null)
      _initDataQueryServiceProxy();
    return dataQueryService.fileList(sId);
  }
  
  
}