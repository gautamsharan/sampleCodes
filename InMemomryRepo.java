package com.example.generateinvoices.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryRepoImpl implements Repository {

   private Map<Long, List<String>> storage = new HashMap<>();

   public String save(String data) {
      long key = data.getKey();
      if (storage.containsKey(key)) {
         storage.get(key).add(data);
      }
      else {
         List<String> dataList = new ArrayList<>();
         dataList.add(data);
         storage.put(key, dataList);
      }
      return data;
   }

   public List<String> findDataByKey(long key) {
      return storage.getOrDefault(key, new ArrayList<>());
   }
}
