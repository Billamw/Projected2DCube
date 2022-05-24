package Body;

import MathStuff.MatMxM.*;
import MathStuff.VecM.*;

public class Cube {

    public Vec3 a,b,c,d,e,f,g,h;
    public Vec3[] points = {a,b,c,d,e,f,g,h};
    public Vec3 pos;
    public int size = 1;
    private int size2;

    public Cube(Vec3 pos, int size) {
        this.pos = pos;
        this.size2 = size;

        this.a = new Vec3(-1,1,1);
        //this.a.add(pos);
        this.b = new Vec3(1,1,1);
        //this.b.add(pos);
        this.c = new Vec3(1,1,-1);
        //this.c.add(pos);
        this.d = new Vec3(-1,1,-1);
        //this.d.add(pos);
        this.e = new Vec3(-1,-1,1);
        //this.e.add(pos);
        this.f = new Vec3(1,-1,1);
        //this.f.add(pos);
        this.g = new Vec3(1,-1,-1);
        //this.g.add(pos);
        this.h = new Vec3(-1,-1,-1);
        //this.h.add(pos);
        points[0] = a;
        points[1] = b;
        points[2] = c;
        points[3] = d;
        points[4] = e;
        points[5] = f;
        points[6] = g;
        points[7] = h;
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
        this.f.mul(size);
        this.g.mul(size);
        this.h.mul(size);
    }

    public void connectPoints() {

    }


}