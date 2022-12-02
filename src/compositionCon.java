/**
 * Composition Connection Class
 * @author John Angkahan
 * @version 1.0
 * Has connection properties
 */

public class compositionCon {
    private int x1,x2,y1,y2;
    private double ax,ay, bx,by,cx,cy, angle1, alpha, beta, dx,dy;
    private double AB, AC, BC, x1A;



    public compositionCon(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        this.angle1 = (double) Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));

        this.alpha = 60 + angle1;
        this.cy = 10 * Math.sin(alpha) + y2;
        this.cx = 10 * Math.cos(alpha) + x2;

        this.beta = 60 - angle1;
        this.by = 10 * Math.sin(beta) + y2;
        this.bx = 10 * Math.cos(beta) + x2;

        double d = 20;
        System.out.println(d);
        if (y1 < y2) { //second box clicked is lower than first
            this.alpha = 60 + angle1;
            this.cy = 10 * Math.sin(alpha) + y2;
            this.cx = 10 * Math.cos(alpha) + x2;

            this.beta = 60 - angle1;
            this.by = 10 * Math.sin(beta) + y2;
            this.bx = 10 * Math.cos(beta) + x2;

            this.dy = d * Math.sin(angle1) +y2;
            this.dx = d * Math.cos(angle1) +x2;
        } else {
            this.angle1 = angle1 * -1;
            this.alpha = 60 + angle1;
            this.cy = 10 * Math.sin(alpha) + y2;
            this.cx = 10 * Math.cos(alpha) + x2;

            this.beta = 60 - angle1;
            this.by = 10 * Math.sin(beta) + y2;
            this.bx = 10 * Math.cos(beta) + x2;

            this.dy = d * Math.sin(angle1) +y2;
            this.dx = d * Math.cos(angle1) +x2;
        }




    }

    public int getX1() {
        return x1;
    }

    public int getY2() {
        return y2;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public double getCx() {
        return cx;
    }

    public double getCy() {
        return cy;
    }

    public double getBx() {
        return bx;
    }

    public double getBy() {
        return by;
    }

    public int[] getXcoords() {
        int x[] = {x2, (int)bx, (int)dx, (int)cx};
        return x;
    }
    public int[] getYcoords() {
        int y[] = {y2, (int)by, (int)dy, (int)cy};
        return y;
    }
}
