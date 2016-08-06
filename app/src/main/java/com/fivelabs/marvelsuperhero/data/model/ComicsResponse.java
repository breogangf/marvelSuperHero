package com.fivelabs.marvelsuperhero.data.model;

/**
 * Created by breogangf on 6/8/16.
 */
public class ComicsResponse {

  private int code;
  private String status;
  private Data data;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Data getData() {
    return data;
  }

  public void setData(Data data) {
    this.data = data;
  }
}
