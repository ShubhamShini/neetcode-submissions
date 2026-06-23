class DynamicArray {

    private int[] arr;
    private int capacity;
    private int size;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i]= n;
    }

    public void pushback(int n) {
        if(size == capacity) {
            resize();
        }
        arr[size] = n;
        size++;
    }

    public int popback() {
        if(size == 0) 
            throw new RuntimeException("Array is empty");
        int val = arr[size-1];
        size--;
        return val;
    }

    private void resize() {
        capacity = capacity*2;

        int newarr[] = new int[capacity];

        for(int i =0;i<size;i++) {
            newarr[i] = arr[i];
        }
        arr = newarr;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
