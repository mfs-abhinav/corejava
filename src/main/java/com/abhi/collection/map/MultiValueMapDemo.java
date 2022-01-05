package com.abhi.collection.map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;


// by default there is no library to support multiple value though it can be implemented by own
// There are 3rd-party library like apache-commons, guva also spring5 support this.
public class MultiValueMapDemo {
    public static void main(String[] args) {

        // using apache-commons
        MultiValuedMap<Integer, String> mapApache = new ArrayListValuedHashMap<>();
        mapApache.put(1, "Abhinav");
        mapApache.put(1, "Banti");
        mapApache.put(1, "Singh");

        System.out.println(mapApache.get(1));

        // using guava
        ListMultimap<Integer, String> mapGuava = ArrayListMultimap.create();
        mapGuava.put(1, "Abhinav");
        mapGuava.put(1, "Banti");
        mapGuava.put(1, "Singh");

        System.out.println(mapGuava.get(1));
    }
}
