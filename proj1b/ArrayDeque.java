public class ArrayDeque<T> implements Deque<T>{
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
        if (cap  > items.length) {

            if (tail - header == (items.length - 1))
                System.arraycopy(items, header, a, 0, size);
            if (tail + 1 == header) {
                System.arraycopy(items, header, a, 0, items.length - header);
                System.arraycopy(items, 0, a, items.length - header, tail + 1);
            }
        }
        else{
            if (tail >= header){
                System.arraycopy(items, header, a, 0, size);

            }

            else{
                System.arraycopy(items, header, a, 0, items.length - header);
                System.arraycopy(items, 0, a, items.length - header, tail + 1);
            }

        }

        items = a;
        header = 0;
        tail = size - 1;


    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
    @Override
    public int size(){
        return size;
    }


    @Override
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

    @Override
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


    @Override
    public T removeLast() {
        if (this.isEmpty()) return null;
        /** Resize down */

        T returnItem = items[tail];
        items[tail] = null;

       if(tail == 0){
           tail = items.length - 1;
        }
        else{
           tail -= 1;
        }
        size = size -1;
        if ((int) 0.25 * items.length > size && items.length >= 16) {
            resize((int) (0.5 * items.length));
        }
        return returnItem;
    }
    @Override
    public T removeFirst() {
        if (this.isEmpty()) return null;

        T returnItem = items[header];
        items[header] = null;
        header = (header +1) % items.length;
        size = size -1;
        if ((int) (0.25 * items.length) > size && items.length >= 16) {
            resize((int) (0.5 * items.length));
        }
        return returnItem;
    }


    @Override
    public T get(int i) {

        i = header + i;
        if (i> items.length - 1) {
            i -= items.length;
        }
        T getitem = items[i];
        return items[i];
    }




    private int getLength() {
        return items.length;
    }


//    note should print the deque not the array.
    @Override
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
