package org.example.List;

import java.util.Comparator;

public class sortByNameAsc implements Comparator<Phone> {
    public int compare(Phone o1, Phone o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
