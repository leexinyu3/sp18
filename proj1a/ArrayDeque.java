public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int header;
    private int tail;

    //创建新的circular array
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        header = tail = 4;



    }

    private void resize(int cap) {
        T[] a = (T []) new Object[cap];

        if (tail - header == (items.length - 1))
            System.arraycopy(items, header, a, 0, size);
        if (tail + 1 ==header){
            System.arraycopy(items, header, a, 0, items.length-header);
            System.arraycopy(items, 0, a, items.length-header, tail + 1 );}
        items = a;
        header = 0;
        tail = size - 1;
    }


    public boolean isEmpty() {
        return (size == 0);
    }

    public int size(){
        return size;
    }



    public void addFirst(T x) {
        if (x== null){
            throw new NullPointerException();
        }


        if (items[header] == null&&tail ==header){
            header = header;
        }
        else if(header == 0){
            header = items.length - 1;
        }
        else{
           header -= 1;
        }
        items[header] = x;
        size = size + 1;
        if (tail + 1 == header)
            resize(size * 2);
        else if (tail - header == (items.length - 1)) {
            resize(size * 2);
        }
    }


    public void addLast(T x) {
        if (x == null)
            throw new NullPointerException();

        if (items[tail] == null && tail ==header){
           tail = tail;
        }
        else
            tail = (tail +1) % items.length;
        items[tail] = x;
        size = size +1;
        if (tail + 1 ==header)
            resize(size *2);
        else if (tail - header == (items.length-1)){
            resize(size *2);
        }

    }



    public T removeLast() {
        if (this.isEmpty()) throw new java.util.NoSuchElementException();

        T returnItem = items[tail];
        items[tail] = null;

       if(tail == 0){
           tail = items.length - 1;
        }
        else{
           tail -= 1;
        }
        size = size -1;



        return returnItem;
    }

    public T removeFirst() {
        if (this.isEmpty()) throw new java.util.NoSuchElementException();

        T returnItem = items[header];
        items[header] = null;
        header = (header +1) % items.length;
        size = size -1;



        return returnItem;
    }

    public T get(int i) {

        i = header + i;
        if (i> items.length - 1) {
            i -= items.length;
        }
        return items[i];
    }

 


    private int getLength() {
        return items.length;
    }


//    note should print the deque not the array.
    public void printDeque(){

        int pointer =header % (items.length) ;
        while( pointer <= items.length - 1){
            System.out.print(items[pointer] + " ");
            pointer += 1;

            }
        pointer = 0;
        while( pointer < header ){
            System.out.print(items[pointer] + " ");
            pointer += 1;
        }

    }

}
