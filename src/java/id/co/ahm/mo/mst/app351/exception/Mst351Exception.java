/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.mst.app351.exception;

import id.co.ahm.jxf.vo.VoMessageWorkspace;
import java.util.List;

/**
 *
 * @author patria
 */
public class Mst351Exception extends RuntimeException {
      private List<VoMessageWorkspace> errorList = null;
  
  public Mst351Exception(String message, List<VoMessageWorkspace> errorList) {
    super(message);
    this.errorList = errorList;
  }
  
  public Mst351Exception(String message) {
    super(message);
  }
  
  public List<VoMessageWorkspace> getErrorList() {
    return this.errorList;
  }
  
  public void setErrorList(List<VoMessageWorkspace> errorList) {
    this.errorList = errorList;
  }
    
}
