package com.mufiz.parentchild;

public class Parent {

    public String name ="Parent name";

  static{
      Integer integeObj;
      int intValue = 0;
      integeObj = intValue; // boxing;
      intValue = integeObj; // unboxing;
  }

//    public Parent(){
//        System.out.println("parent called");
////        throw new AssertionError();
//    }

    public Parent(String name){
      this.name = name;
    }
}
