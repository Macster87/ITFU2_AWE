public class MyLinkedList {

    private Container head;
    private Container tail;

    public MyLinkedList() {
        Container newContainer = new Container("");
        newContainer.setPredecessor(newContainer);
        newContainer.setSuccessor(newContainer);
        head = newContainer;
        tail = newContainer;
    }

    public Container getHead() {
        return head;
    }

    public void setHead(Container head) {
        this.head = head;
    }

    public Container getTail() {
        return tail;
    }

    public void setTail(Container tail) {
        this.tail = tail;
    }

    public String get(int target) {
        Container position = head;
        int i = 0;

        while(i < target) {
            i++;
            position = position.getSuccessor();
        }

        return position.getContent();
    }

    public void add(String inhalt) {
        // Neuen Container erstellen
        Container newContainer = new Container(inhalt, tail, head);

        // Alten Tail merken
        Container oldTail = tail;

        // Betroffene Container umhängen
        oldTail.setSuccessor(newContainer);
        head.setPredecessor(newContainer);
        newContainer.setSuccessor(head);
        newContainer.setPredecessor(oldTail);
        tail = newContainer;
    }

    public void remove(Container target) {
        if(target == head) {
            return;
        }

        if(target == tail) {
            tail = target.getPredecessor();
        }

        target.getPredecessor().setSuccessor(target.getSuccessor());
        target.getSuccessor().setPredecessor(target.getPredecessor());
        target.setSuccessor(null);
        target.setPredecessor(null);
    }

    public boolean contains(String content) {
        // Sucht einen Container anhand des Content-Strings.
        // Wenn keiner gefunden wird, wird der Head zurückgegeben (der standardmäßig einen leeren Content hat)
        Container position = head.getSuccessor();
        int i = 0;
        while(position != head) {
            if(position.getContent().equals(content)) {
                return true;
            }
            position = position.getSuccessor();
            i++;
        }
        return false;
    }

    public Container indexOf(String content) {
        // Sucht einen Container anhand des Content-Strings.
        // Wenn keiner gefunden wird, wird der Head zurückgegeben (der standardmäßig einen leeren Content hat)
        Container position = head.getSuccessor();
        int i = 0;
        while(position != head) {
            if(position.getContent().equals(content)) {
                return position;
            }
            position = position.getSuccessor();
            i++;
        }
        return null;
    }

    public int size() {
        Container position = head.getSuccessor();
        int i = 0;
        while(!position.getContent().equals("")) {
            position = position.getSuccessor();
            i++;
        }
        return i;
    }

    public void printTrain() {
        if(head == tail) {
            System.out.println(head.toString());
        } else {
            Container position = head.getSuccessor();
            System.out.print(head.toString());
            do {
                System.out.print(position.toString());
                position = position.getSuccessor();
            } while (position != head);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyLinkedList test = new MyLinkedList();
        test.add("eins");
        test.add("zwei");
        test.add("drei");
        test.remove(test.getTail().getPredecessor());
        test.printTrain();
        System.out.println("Länge des Zuges: " + test.size());
        //System.out.print(test.getHead().toString());
        //System.out.print(test.getHead().getSuccessor().toString());
        //System.out.println(test.getHead().getSuccessor().toString());
        //System.out.println(test.getTail().toString());
    }
}
