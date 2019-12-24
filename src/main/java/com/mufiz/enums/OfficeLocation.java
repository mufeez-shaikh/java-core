package com.core.enums;

public enum OfficeLocation{
  GOOGLE(12.5665, 67.587), APPLE(31.235, 48.894), MICROSOFT(98.537, 67.587);

  private double latitude;
  private double longitutde;

  private OfficeLocation(double latitude, double longitutde){
    this.latitude = latitude;
    this.longitutde = longitutde;
  }

}
