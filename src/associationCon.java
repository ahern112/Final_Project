public class associationCon {
    private int x1,x2,y1,y2;
    private double ax,ay, bx,by,cx,cy, angle1;
    private double AB, AC, BC, x1A;



    public associationCon(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        this.bx = x2;
        this.by = y2;

        this.AB = 2;
        this.AC = 2*Math.tan(30);
        this.BC = 2/Math.cos(30);

        this.angle1 = Math.toDegrees(Math.asin(Math.abs(y1-y2)));
        this.x1A = Math.sqrt(Math.pow(Math.abs(y1-y2),2) + Math.pow((Math.abs(x1-x2)),2));
        this.ax = Math.cos(angle1) * x1A;
        this.ay = Math.sin(angle1) * x1A;

        this.cy = (Math.pow(AB, 2) + Math.pow(AC, 2) - Math.pow(BC, 2)) / ( 2 * AB);
        this.cx = Math.sqrt(Math.pow(AC, 2) - Math.pow(cy, 2));
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
}
