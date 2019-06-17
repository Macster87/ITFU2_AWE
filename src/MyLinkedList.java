class MyLinkedList {

    private Container head;
    private Container tail;

    MyLinkedList() {

    }

    void add(String eins) {
        //TODO: Implement
        Container newContainer = new Container(eins);
        if(head == null && tail == null) {
            newContainer.setSuccessor(newContainer);
            newContainer.setPredecessor(newContainer);
        } else {
            newContainer = new Container(eins);
        }

        head.setPredecessor(newContainer);
        tail.setSuccessor(newContainer);
        tail = newContainer;
        //TODO: Implement
    }

    void add(int i, String einsA) {
        //TODO: Implement
    }

    int size() {
        //TODO: Implement
        int i = 0;
        Container position = head;

        while(position.getSuccessor() != head) {
            i++;
            position = position.getSuccessor();
        }

        return i;
    }

    String get(int i) {
        //TODO: Implement
        int j = 0;
        Container position = head;

        while(position.getSuccessor() != head || i == j) {
            position = position.getSuccessor();
            j++;
        }
        return position.getContent();
    }

    boolean contains(String eins) {
        //TODO: Implement
        return true;
    }

    String remove(int i) {
        //TODO: Implement
        return "";
    }

    boolean remove(String zwei) {
        //TODO: Implement
        return true;
    }

    void clear() {
        //TODO: Implement

    }

    String set(int i, String zweiNeu) {
        if(i > size()) {
            throw new IndexOutOfBoundsException("Soviele Stellen hat die Linked List nicht.");
        }
        //TODO: Implement
        return "";
    }

    int lastIndexOf(String eins) {
        //TODO: Implement
        return 0;
    }

    int indexOf(String drei) {
        //TODO: Implement
        return 0;
    }
}
