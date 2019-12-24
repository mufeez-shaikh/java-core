package com.core.enums;

public class EnumExample {

  public enum Company {
    GOOGLE("SAN FRANCISCO", 100), APPLE("CUPERTINO", 200),
    ACCENTURE("DUBLIN", 300);
    private String headquarter;
    private int noOfEmployees;

    private Company(String headquarter, int noOfEmployees) {
      this.headquarter = headquarter;
      this.noOfEmployees = noOfEmployees;
    }
  }

  public static void main(String[] args) {

    for (Company company : Company.values()) {
      System.out.println("company: " + company + ", headquarter: " + company.headquarter
          + ", employee count: " + company.noOfEmployees);
    }

  }
}
