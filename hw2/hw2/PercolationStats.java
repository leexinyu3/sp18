package hw2;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;



public class PercolationStats {

        private  double sum=0;
        private Percolation []p;
        private double[] x;

        public PercolationStats(int N, int T, PercolationFactory pf){
                if (N <= 0 || T <= 0){
                        throw new IllegalArgumentException("java.lang.IllegalArgumentException");
                }
                p = new Percolation[T];
                x = new double[T];
                for(int i = 0; i<T; i++){
                        p[i] = pf.make(N);
                        while(!p[i].percolates()){
                                int a = StdRandom.uniform(0, N);
                                int b = StdRandom.uniform(0, N);
                                p[i].open(a,b);
                        }
                        x[i] = ((double)p[i].numberOfOpenSites())/(N*N);
                        sum = sum + x[i];
                }

        } // perform T independent experiments on an N-by-N grid
        public double mean() {

                return sum/x.length;

        } // sample mean of percolation threshold
        public double stddev()  {
                double mean = mean();
                double res= 0;
                for(double xi :x){
                       res+=(xi-mean)* (xi-mean);
                }

                return Math.sqrt(res/(x.length-1));
        }// sample standard deviation of percolation threshold
        public double confidenceLow(){
               return this.mean() - 1.96 * (this.stddev() / Math.sqrt(x.length));

        } // low endpoint of 95% confidence interval
        public double confidenceHigh()  {
                return this.mean() + 1.96 * (this.stddev() / Math.sqrt(x.length));

        } // high endpoint of 95% confidence interval

//       public static void main(String[] args){
//        PercolationStats temp = new PercolationStats(20, 10, new PercolationFactory());
//        System.out.println(temp.mean());
//        System.out.println(temp.stddev());
//        System.out.println(temp.mean() - 1.96 * temp.stddev() / Math.sqrt(10));
//        System.out.println(temp.mean() + 1.96 * temp.stddev() / Math.sqrt(10));
//        System.out.println(temp.confidenceLow());
//        System.out.println(temp.confidenceHigh());
//        }

}
