package com.mufiz.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TraverseMap {

  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("k1", "v1");
    map.put("k2", "v2");

    // using keyset: returns set of keys
    for (String key : map.keySet()) {
//            System.out.println("key: "+key + " value: " +map.get(key));
    }

    // using entryset: returns set of entry
    for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() +" -> "+entry.getValue());
    }

    // using iterator: this is nothing but using set iterator
    Iterator<Map.Entry<String, String>> mapIterator = map.entrySet().iterator();
    while (mapIterator.hasNext()) {
      Map.Entry<String, String> entry = mapIterator.next();
//            System.out.println(entry.getKey() + " -> "+ entry.getValue());
    }
    map.forEach((k, v) -> System.out.println(k + " -> " + v));
  }
}
