package com.abhi.collection.collections.list;

import com.abhi.exception.ConcurrentModificationExce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayDemo {
    public static void main(String[] args) {
//        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(6, 7, 8, 2, 5));
//        System.out.println(list);
//        Iterator<Integer> it1 = list.listIterator();
//        Iterator<Integer> it2 = list.listIterator();
//        while (it1.hasNext()) {
//            if (it1.next() == 8) {
////                it1.remove();  // will throw unsupported exception in case of copyonwriteArray.
//                list.remove(0);
//            }
//        }
//        System.out.println(list);
//        while (it2.hasNext()) {
//            if (it2.next() == 2) {
//                list.remove(1);
//            }
//        }
//        System.out.println(list);

        List<Integer> list2 = new ArrayList<>(Arrays.asList(6, 7, 8, 2, 5));
        System.out.println(list2);
        list2.stream().forEach(i -> {
            if (i == 2) {
                list2.remove(2);
            }
        });
        System.out.println(list2);

    }
}
