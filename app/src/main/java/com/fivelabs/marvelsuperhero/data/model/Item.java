package com.fivelabs.marvelsuperhero.data.model;

/**
 * Created by breogangf on 6/8/16.
 */
public class Item {

  private String resourceURI;
  private String name;
  private String role;

  public String getResourceURI() {
    return resourceURI;
  }

  public void setResourceURI(String resourceURI) {
    this.resourceURI = resourceURI;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}