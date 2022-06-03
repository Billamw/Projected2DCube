package Body;

import Main.Draw;
import MathStuff.VecM.Vec2;
import MathStuff.VecM.Vec3;

public class Pyramide implements Body {

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

    public void connectPoints(Vec3[] points) {
        Draw.line(new Vec2(points[0]), new Vec2(points[1]));
        Draw.line(new Vec2(points[1]), new Vec2(points[2]));
        Draw.line(new Vec2(points[2]), new Vec2(points[3]));
        Draw.line(new Vec2(points[3]), new Vec2(points[0]));
        Draw.line(new Vec2(points[0]), new Vec2(points[4]));
        Draw.line(new Vec2(points[1]), new Vec2(points[4]));
        Draw.line(new Vec2(points[2]), new Vec2(points[4]));
        Draw.line(new Vec2(points[3]), new Vec2(points[4]));
    }

    public void connectPoints(Vec2[] points) {
        Draw.line(points[0], points[1]);
        Draw.line(points[1], points[2]);
        Draw.line(points[2], points[3]);
        Draw.line(points[3], points[0]);
        Draw.line(points[0], points[4]);
        Draw.line(points[1], points[4]);
        Draw.line(points[2], points[4]);
        Draw.line(points[3], points[4]);
    }
    

}
