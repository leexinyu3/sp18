public class LinkedListDeque<T> implements Deque<T>{
    private class Node {
        public T item;
        public Node pre;
        public Node next;

        /**
         * constructor
         */
        public Node(T i) {
            item = i;
        }
        /**
         * DLList - Doubly Linked List
         */
        public Node(T i, Node p, Node n) {
            item = i;
            pre = p;
            next = n;
        }

        /***help method recursive***/
        private T get(int index){
            if (index ==0)
                return item;
            if (this == sentinel)
                return null;
            return next.get(index-1);

        }


    }

/***help method recursive***/
    public T getRecursive(int index){
        Node First = sentinel.next ;
        return First.get(index);

    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
    @Override
    public int size(){
        return size;
    }





    private Node sentinel;/** Circular Sentinel */
    private int size;

    /** Empty Deque */
    public LinkedListDeque() {
        sentinel = new Node(null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    /** add node */
    @Override
    public void addFirst(T x) {
        Node p;
        p = new Node(x,sentinel,sentinel.next);
        sentinel.next = p;
        p.next.pre = p;
        size +=1;

    }
    @Override
    public void addLast(T x){
        Node p;
        Node lastnode = sentinel.pre;
        p = new Node(x,lastnode,sentinel);
        lastnode.next = p;
        sentinel.pre = p;
        size +=1;


    }

    /** delete node */
    @Override
    public T removeFirst() {
        if (isEmpty()){
            return null;
        }
        Node removedNode = sentinel.next;
        sentinel.next = removedNode.next;
        sentinel.next.pre.next = null;
        sentinel.next.pre.pre = null;
        sentinel.next.pre = sentinel;
        size -=1;
        return removedNode.item;
    }
    @Override
    public T removeLast(){
        if (isEmpty()) {
            return null;
        }
        Node removedNode = sentinel.pre;
        sentinel.pre = removedNode.pre;
        removedNode.pre.next = sentinel;
        size -=1;
    return removedNode.item;
    }

    /** print node */
    @Override
    public void printDeque(){
        Node p = sentinel.next;
        int count = 0;
        while( count < size){
            String separator = (count < size - 1) ? " " : "";
            System.out.print(p.item + separator);
            p = p.next;
            count +=1;
        }

    }

    /** get node -iteration */
    @Override
    public T get(int index){
        int i = 0;
        Node n = sentinel;
        while( i < index + 1) {
            n = n.next;
            i += 1;
        }
        return n.item;
    }
    private int getLength(){
        Node n = sentinel.next;
        int count = 0;
        while( n!=sentinel){
            n = n.next;
            count +=1;
        }
        return count;
    }

}
