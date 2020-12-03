

public class Planet {

    public double xxPos;
    public double yyPos; //Its current y position
    public double xxVel;//Its current velocity in the x direction
    public double yyVel; //Its current velocity in the y direction
    public double mass; //Its mass
    public String imgFileName;


    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName =p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        double r = Math.hypot(dx, dy);//返回所有参数的平方和的平方根
        return r;
    }
    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        double F = 6.67e-11*this.mass*p.mass/(r*r);
        return F;
    }


    public double calcForceExertedByX(Planet p) {
        double Fx = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
        return Fx;
    }

    public double calcForceExertedByY(Planet p) {
        double Fy = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
        return Fy;
    }


    public double calcNetForceExertedByX(Planet[] p){
        double Fnetx = 0;
        for (int i = 0;i<p.length;i++){
                if(this.equals(p[i]))
                    continue;
                else{
                  Fnetx += this.calcForceExertedByX(p[i]);
            }
        }
        return Fnetx;
    }
//

    public double calcNetForceExertedByY(Planet[] p){
        double Fnety = 0;
        for (int i = 0;i<p.length;i++){
            if(this.equals(p[i]))
                continue;
            else{
                Fnety += this.calcForceExertedByY(p[i]);
            }
        }
        return Fnety;
    }

    public void update(double dt, double fX, double fY){
        double ax =  fX/this.mass;
        double ay = fY/this.mass;
        this.xxVel = this.xxVel + dt * ax;
        this.yyVel = this.yyVel + dt * ay;
        this.xxPos = this.xxPos + dt *  this.xxVel;
        this.yyPos = this.yyPos + dt *  this.yyVel;

    }

    /**
     * Draw the picture of the Body according to its position
     * 用draw.picture方法
     */
    public void draw() {

        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);


    }


    }
