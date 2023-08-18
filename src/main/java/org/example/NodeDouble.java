package org.example;

public class NodeDouble<T> {
    private T info;
    private NodeDouble<T> next;
    private NodeDouble<T> prev;

    public NodeDouble() {
        this.info = null;
        this.next = null;
        this.prev = null;
    }

    public NodeDouble(T info, NodeDouble<T> next, NodeDouble<T> prev) {
        this.setInfo(info);
        this.setNext(next);
        this.setPrev(prev);
    }

    public NodeDouble<T> getNext() {
        return next;
    }

    public void setNext(NodeDouble<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodeDouble<T> getPrev() {
        return prev;
    }

    public void setPrev(NodeDouble<T> prev) {
        this.prev = prev;
    }
}
