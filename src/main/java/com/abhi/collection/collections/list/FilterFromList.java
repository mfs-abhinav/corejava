package com.abhi.collection.collections.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Patient {
    private String id;
    private Date date;

    public Patient(String id, Date date) {
        this.id = id;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", date=" + date +
                '}';
    }
}

public class FilterFromList {
    public static void main(String[] args) {
//        List<Patient> presSearch = IntStream.range(0, 15).mapToObj(i -> new Patient("pat" + i, new Date())).collect(Collectors.toList());

//        Comparator<Patient> by = Comparator.comparing(p -> {
//            boolean val = presSearch.stream().anyMatch(pat -> p.getId().equals(pat.getId()));
//            if (val) {
//                return 0;
//            } else {
//                return 1;
//            }
//        });

//        List<Patient> currSearch = IntStream.range(10, 60).mapToObj(i -> new Patient("pat" + i, new Date()))
//                .sorted(by)
//                .collect(Collectors.toList());
//        List<Patient> currSearch = IntStream.range(10, 60).mapToObj(i -> new Patient("pat" + i, new Date())).collect(Collectors.toList());
//        List<Patient> filterSearch = currSearch.stream()
//                .filter(p -> {
//                    return presSearch.stream().anyMatch(pat -> p.getId().equals(pat.getId()));
//                })
//                .collect(Collectors.toList());
//        System.out.println(filterSearch);

        List<String> list1 = Arrays.asList("a", "b", "c", "d", "e");
        List<String> list2 = Arrays.asList("x", "y", "m", "c", "l", "a", "r", "b", "s");

        List<String> filterList1 = list2.stream().filter(list1::contains).collect(Collectors.toList());
        List<String> filterList2 = list2.stream().filter(i -> !list1.contains(i)).collect(Collectors.toList());

        List<String> sortFilterList1 = filterList1.stream().sorted(Comparator.comparing(list1::indexOf)).collect(Collectors.toList());
        sortFilterList1.addAll(filterList2);

        System.out.println(sortFilterList1);

    }
}
