package com.gabrielgiordano.ttm.controller;

import java.util.Collection;

/**
 * The Interface for Station related controller and service implementations.
 *
 * @param <E> the station bean element type
 * @author Gabriel Giordano
 */
public interface StationInterface<E> {

  /**
   * Gets the all the stations.
   *
   * @return the stations
   */
  Collection<E> getStations();
}
