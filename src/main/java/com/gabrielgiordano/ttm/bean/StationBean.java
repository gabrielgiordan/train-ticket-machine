package com.gabrielgiordano.ttm.bean;

import com.opencsv.bean.CsvBindByName;

/**
 * The Bean Station class to organize the CSV data into a bean.
 * 
 * @author Gabriel Giordano
 */
public class StationBean implements java.io.Serializable {

  private static final long serialVersionUID = -1726706026157497644L;

  /** The name binded by the OpenCSV annotation. */
  @CsvBindByName
  private String name;

  /** The display name binded by the OpenCSV annotation. */
  @CsvBindByName
  private String displayName;

  /**
   * Instantiates a new Station bean.
   */
  public StationBean() {}

  /**
   * Gets the station name.
   *
   * @return the station name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the station name.
   *
   * @param name the new station name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the station display name.
   *
   * @return the station display name
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * Sets the station display name.
   *
   * @param displayName the new station display name
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  @Override
  public String toString() {
    return this.name;
  }

}
