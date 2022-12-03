/**
 * Composition Connection Class
 * @author John Angkahan
 * @author Sing
 * @author Abraham
 * @version 1.0
 * Has connection properties
 */

public class compositionCon {
    //private int x1,x2,y1,y2;
    Box boxOne, boxTwo;
    // private double ax,ay,by,cy, angle1, beta;
    private double AB, AC, BC, x1A;



    public compositionCon(Box boxOne, Box boxTwo) {
        this.boxOne = boxOne;
        this.boxTwo = boxTwo;


        int x1 = boxOne.getX();
        int y1 = boxOne.getY();
        int x2 = boxTwo.getX();
        int y2 = boxTwo.getY();

        //this.bx = x2;
        //this.by = y2;

        //this.AB = 10 * Math.cos(30);
        //this.AC = 10 * Math.sin(30);
        //this.BC = 10;

        //this.angle1 = (double) Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        //this.x1A = Math.sqrt(Math.pow(Math.abs(y1-y2),2) + Math.pow((Math.abs(x1-x2)),2));
        //this.ax = Math.cos(angle1) * x1A;
        //this.ay = Math.sin(angle1) * x1A;

//        this.alpha = 60 + angle1;
//        this.cy = 10 * Math.sin(alpha) + y2;
//        this.cx = 10 * Math.cos(alpha) + x2;
//
//        this.beta = 60 - angle1;
//        this.by = 10 * Math.sin(beta) + y2;
//        this.bx = 10 * Math.cos(beta) + x2;
//
//        if (y1 < y2) {
//            this.alpha = 60 + angle1;
//            this.cy = 10 * Math.sin(alpha) + y2;
//            this.cx = 10 * Math.cos(alpha) + x2;
//
//            this.beta = 60 - angle1;
//            this.by = 10 * Math.sin(beta) + y2;
//            this.bx = 10 * Math.cos(beta) + x2;
//        } else {
//            this.angle1 = angle1 * -1;
//            this.alpha = 60 + angle1;
//            this.cy = 10 * Math.sin(alpha) + y2;
//            this.cx = 10 * Math.cos(alpha) + x2;
//
//            this.beta = 60 - angle1;
//            this.by = 10 * Math.sin(beta) + y2;
//            this.bx = 10 * Math.cos(beta) + x2;
//        }

    }



    public int getX1() {
        return boxOne.getX();
    }

    public int getY2() {
        return boxTwo.getY();
    }

    public int getY1() {
        return boxOne.getY();
    }

    public int getX2() {
        return boxTwo.getX();
    }

    public double getCx() {
        double angle1 = (double) Math.toDegrees(Math.atan2(boxTwo.getY() - boxOne.getY(), boxTwo.getX() - boxOne.getX()));
        if (boxOne.getY() < boxTwo.getY()) {
            double alpha = 60 + angle1;
            return 10 * Math.cos(alpha) + boxTwo.getX();
        } else {
            angle1 = angle1 * -1;
            double alpha = 60 + angle1;
            return 10 * Math.cos(alpha) + boxTwo.getX();
        }
    }

    public double getCy() {
        double angle1 = (double) Math.toDegrees(Math.atan2(boxTwo.getY() - boxOne.getY(), boxTwo.getX() - boxOne.getX()));
        if (boxOne.getY() < boxTwo.getY()) {
            double alpha = 60 + angle1;
            return 10 * Math.cos(alpha) + boxTwo.getY();
        } else {
            angle1 = angle1 * -1;
            double alpha = 60 + angle1;
            return 10 * Math.cos(alpha) + boxTwo.getY();
        }

    }

    public double getBx() {
        double angle1 = (double) Math.toDegrees(Math.atan2(boxTwo.getY() - boxOne.getY(), boxTwo.getX() - boxOne.getX()));
        if (boxOne.getY() < boxTwo.getY()) {
            double beta = 60 - angle1;
            // this.bx = 10 * Math.cos(beta) + x2;
            return 10 * Math.cos(beta) + boxTwo.getX();
        } else {
            angle1 = angle1 * -1;
            double beta = 60 - angle1;
            //this.bx = 10 * Math.cos(beta) + x2;
            return 10 * Math.cos(beta) + boxTwo.getX();
        }
    }

    public double getBy() {
        double angle1 = (double) Math.toDegrees(Math.atan2(boxTwo.getY() - boxOne.getY(), boxTwo.getX() - boxOne.getX()));
        if (boxOne.getY() < boxTwo.getY()) {
            double beta = 60 - angle1;
            return 10 * Math.sin(beta) + boxTwo.getY();
        } else {
            angle1 = angle1 * -1;
            double beta = 60 - angle1;
            return 10 * Math.sin(beta) + boxTwo.getY();
        }
    }


    public double getDx() {
        double angle1 = (double) Math.toDegrees(Math.atan2(boxTwo.getY() - boxOne.getY(), boxTwo.getX() - boxOne.getX()));
        if (boxOne.getY() < boxTwo.getY()) { //second box clicked is lower than first

            return 20 * Math.cos(angle1) + boxOne.getX();
        } else {
            angle1 = angle1 * -1;
            return 20 * Math.cos(angle1) + boxTwo.getX();
        }
    }

    public double getDy() {
        double angle1 = (double) Math.toDegrees(Math.atan2(boxTwo.getY() - boxOne.getY(), boxTwo.getX() - boxOne.getX()));
        if (boxOne.getY() < boxTwo.getY()) { //second box clicked is lower than first

            return 20 * Math.sin(angle1) +boxTwo.getY();
        } else {
            angle1 = angle1 * -1;

            return 20 * Math.sin(angle1) +boxTwo.getY();
        }
    }

    public int[] getXcoords() {
        int x[] = {boxTwo.getX(), (int)getBx(), (int)getDx(), (int)getCx()};
        return x;
    }
    public int[] getYcoords() {
        int y[] = {boxTwo.getY(), (int)getBy(), (int)getDy(), (int)getCy()};
        return y;
    }
}