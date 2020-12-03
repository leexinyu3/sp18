public class NBody {


    public static void main(String[] args) {
        double  T =  Double.parseDouble(args[0]);
        double  dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double Radius = NBody.readRadius(filename);
        Planet[] p = NBody.readPlanets(filename);
    /**
     * Draw the background
    **/
        StdDraw.setScale(-Radius, Radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        /**
         * Draw the planet
         **/
        for (Planet var : p) {
            var.draw();
        }

        StdDraw.enableDoubleBuffering();
        double t = 0;
        while (t <= T){
            Double[] Fnetx = new Double[p.length];
            Double[] Fnety = new Double[p.length];
            for (int i =0;i<p.length;i++){
                Fnetx[i] = p[i].calcNetForceExertedByX(p);
                Fnety[i] = p[i].calcNetForceExertedByY(p);
            }
        //update
            for (int i =0;i<p.length;i++) {
                p[i].update(dt, Fnetx[i], Fnety[i]);
            }
            for (int i =0;i<p.length;i++)
                p[i].draw();
            StdDraw.show();
            StdDraw.pause(10);
            t +=dt;

            }

/**
 * Print out the final state of the universe when time reaches T
 */
        StdOut.printf("%d\n", p.length);
        StdOut.printf("%.2e\n", Radius);
        for (int i = 0; i < p.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    p[i].xxPos, p[i].yyPos, p[i].xxVel,
                    p[i].yyVel, p[i].mass, p[i].imgFileName);
        }

        }


        public static double readRadius(String fileName) {
        In in = new In(fileName);
        int count = 0;
        double Radius = 0;
        while (count < 2) {
            /* Each line has the rank of a country, then its
             * name, then its production in metric tons, and
             * finally the fraction of world salt output it produces. */
            count += 1;
            Radius = in.readDouble();
        }
        return Radius;
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);

        int count = in.readInt();
        double radius = in.readDouble();
        Planet[] p= new Planet[count];
        for (int i = 0; i < count; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            p[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return p;
    }


}

