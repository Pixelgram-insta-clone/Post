package com.cognizant.Post.model;

import java.util.List;
import java.util.Objects;

public class PageOfItems<T> {

    private List<T> items;

    private boolean hasNext;

    private int totalElements;

    public PageOfItems() {
    }

    public PageOfItems(List<T> items, boolean hasNext, int totalElements) {
        this.items = items;
        this.hasNext = hasNext;
        this.totalElements = totalElements;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageOfItems<?> that = (PageOfItems<?>) o;
        return hasNext == that.hasNext && totalElements == that.totalElements && Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, hasNext, totalElements);
    }

    @Override
    public String toString() {
        return "PageOfItems{" +
                "items=" + items +
                ", hasNext=" + hasNext +
                ", totalElements=" + totalElements +
                '}';
    }
}
