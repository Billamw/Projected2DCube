package Body;

import MathStuff.VecM.Vec3;

public class Pyramide {

    public Vec3 a,b,c,d,e;
    public Vec3[] points = new Vec3[5];
    public Vec3 pos;
    public int size = 1;
    private int size2;

    public Pyramide(Vec3 pos, int size) {
        this.pos = pos;
        this.size2 = size;
        this.a = new Vec3((float)(-1/Math.sqrt(2)), 0.25f, (float)( 1/Math.sqrt(2)));
        this.b = new Vec3((float)( 1/Math.sqrt(2)), 0.25f, (float)( 1/Math.sqrt(2)));
        this.c = new Vec3((float)( 1/Math.sqrt(2)), 0.25f, (float)(-1/Math.sqrt(2)));
        this.d = new Vec3((float)(-1/Math.sqrt(2)), 0.25f, (float)(-1/Math.sqrt(2)));
        this.e = new Vec3(0, -0.75f, 0);

        points[0] = a;
        points[1] = b;
        points[2] = c;
        points[3] = d;
        points[4] = e;
    }

    public void scale() {
        if(this.size<1 || this.size>1) return;       
        this.size = size2;
        size /=2;
        this.a.mul(size);
        this.b.mul(size);
        this.c.mul(size);
        this.d.mul(size);
        this.e.mul(size);
    }


}
