package com.pluang.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private long searchItem;

    public long getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(long searchItem) {
        this.searchItem = searchItem;
    }
}
