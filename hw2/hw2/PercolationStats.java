package hw2;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Random;

public class PercolationStats {
        private Random RANDDOM  = new Random(565);
        private  double sum=0;
        Percolation []p;
        private double[] x;

        public PercolationStats(int N, int T, PercolationFactory pf){
                if (N <= 0 || T <= 0){
                        throw new IllegalArgumentException("java.lang.IllegalArgumentException");
                }
                p = new Percolation[T];
                x = new double[T];
                for(int i = 0;i<T;i++){
                        p[i] = pf.make(N);
                        while(!p[i].percolates()){
                                int a = RANDDOM.nextInt(N);
                                int b = RANDDOM.nextInt(N);
                               p[i].open(a,b);
                        }
                        x[i] = ((double)p[i].numberOfOpenSites())/(N*N);
                        sum = sum + x[i];
                }

        } // perform T independent experiments on an N-by-N grid
        public double mean() {
                return sum/=x.length;

        } // sample mean of percolation threshold
        public double stddev()  {
                double mean = mean();
                double res= 0;
                for(double xi :x){
                       res+=(xi-mean)* (xi-mean);
                }

                return Math.sqrt(res);
        }// sample standard deviation of percolation threshold
        public double confidenceLow(){
               return mean()-1.96*stddev()/Math.sqrt(x.length);

        } // low endpoint of 95% confidence interval
        public double confidenceHigh()  {
                return mean()+1.96*stddev()/Math.sqrt(x.length);

        } // high endpoint of 95% confidence interval

        public static void main(String[] args){
                PercolationFactory pf = new PercolationFactory();
                PercolationStats ps = new PercolationStats(80,100,pf);
                System.out.println(ps.mean());
                System.out.println(ps.stddev());
                System.out.println(ps.confidenceLow());
                System.out.println(ps.confidenceHigh());
        }

}
