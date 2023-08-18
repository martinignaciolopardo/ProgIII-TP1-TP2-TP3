package org.example;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info, null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size += 1;
    }

    public T extractFront() {
        this.first = this.first.getNext();
        this.size -= 1;
        return this.first.getInfo();
    }

    public boolean isEmpty() {
        return (this.first == null);
    }

    public T get(int index) {
        int aux = 0;
        Node<T> nodeAux = new Node<>();
        if (index < this.size()) {
            while (aux != index) {
                Node<T> nodoSiguiente = this.first.getNext();
                nodeAux = nodoSiguiente;
                aux++;
            }
            return nodeAux.getNext().getInfo();
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        if (this.first != null) {
            String response = "";
            Node<T> temp = this.first;
            while (temp.getNext() != null) {
                response += temp.getInfo() + " - ";
                temp = temp.getNext();
            }
            response += temp.getInfo();
            return response;
        }
        return "Lista vacia";
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(this.first);
    }

    public int indexOf(T info) {
        Node<T> temp = this.first;
        for (int i = 0; i < this.size(); i++) {
            if (temp.getInfo() == info) {
                return i;
            } else {
                temp = temp.getNext();
            }
        }
        return -1;
    }

    public static <T> MySimpleLinkedList<T> findCommonElements(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2) {
        MySimpleLinkedList<T> commonList = new MySimpleLinkedList<>();

        for (T element : list1) {
            if (list2.contains(element)) {
                commonList.insertFront(element);
            }
        }

        return commonList;
    }

    // 2 3 7 9
    // 7 9 11 15
    public boolean contains(T element) {
        Node<T> current = this.first;
        while (current != null) {
            if (current.getInfo().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public <T extends Comparable<T>> MySimpleLinkedList<T> mergeCommonElements(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2) {
        MySimpleLinkedList<T> commonList = new MySimpleLinkedList<>();

        Iterator<T> iterator1 = list1.iterator();
        Iterator<T> iterator2 = list2.iterator();

        T element1 = null;
        T element2 = null;

        if (iterator1.hasNext()) {
            element1 = iterator1.next();
        }

        if (iterator2.hasNext()) {
            element2 = iterator2.next();
        }
        // 2 3 7 9
        // 7 9 11 15
        while (element1 != null && element2 != null) {
            int comparison = element1.compareTo(element2);

            if (comparison == 0) {
                commonList.insertFront(element1);
                element1 = iterator1.hasNext() ? iterator1.next() : null;
                element2 = iterator2.hasNext() ? iterator2.next() : null;
            } else if (comparison < 0) {
                element1 = iterator1.hasNext() ? iterator1.next() : null;
            } else {
                element2 = iterator2.hasNext() ? iterator2.next() : null;
            }
        }

        return commonList;
    }

    public static <T> MySimpleLinkedList<T> findDifferentElements(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2) {
        MySimpleLinkedList<T> resultList = new MySimpleLinkedList<>();

        for (T element : list1) {
            if (list2.notContains(element)) {
                resultList.insertFront(element);
            }
        }

        return resultList;
    }

    // 2 3 7 9
    // 7 9 11 15
    public boolean notContains(T element) {
        Node<T> current = this.first;
        while (current != null) {
            if (current.getInfo().equals(element)) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }


}
