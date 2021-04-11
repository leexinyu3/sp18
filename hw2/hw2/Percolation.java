package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] arr;
    private  int[][] arr1;
    private WeightedQuickUnionUF QU;
    private int count = 0;


    public Percolation(int N) {
        if (N<=0)
            throw new java.lang.IllegalArgumentException();
       arr = new boolean[N][N];
       arr1 = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                arr[i][j] = false;
                arr1[i][j] = i*N+j;
            }
        }
        QU = new WeightedQuickUnionUF(N * N + 2);

        for(int j = 0;j<N;j++){
            QU.union(arr1[0][j] , N*N);
            QU.union(arr1[N-1][j] , N*N+1);
        }

    }


    public boolean isOpen(int row, int col){
        if (row < 0 || row >= arr.length || col < 0 || col >= arr.length){
            return false;
        }
        return arr[row][col];
    }
    public void open(int row, int col){
        if (isOpen(row,col)) return ;

        else{
            arr[row][col] = true;
            count+=1;
        if (isOpen(row-1,col)){
            QU.union((row-1)*arr.length+col,arr1[row][col]);
        }
        if (isOpen(row+1,col)){
            QU.union((row+1)*arr.length+col,arr1[row][col]);
        }
        if (isOpen(row,col-1)){
            QU.union(row*arr.length+col-1,arr1[row][col]);
        }
        if (isOpen(row,col+1)){
            QU.union(row*arr.length+col+1,arr1[row][col]);
        }


        }


    }
    public boolean isFull(int row, int col) {
        if (!isOpen(row,col)){
            return false;
        }
        return QU.connected(arr1[row][col], arr.length* arr.length);
    }
    // number of open sites
    public int numberOfOpenSites(){
        return count;
    }

    public boolean percolates() {
        if(arr.length == 1){
            if(!isOpen(0,0)) return false;
        }

        return QU.connected(arr.length*arr.length, arr.length* arr.length+1);
    }


    public static void main(String[] args)   {
        Percolation universe = new Percolation(2);
        universe.open(0,0);
        universe.open(1,0);
        System.out.println(universe. percolates() );

    }
}


