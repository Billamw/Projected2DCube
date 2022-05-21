package Body;

import MathStuff.MatMxM.*;
import MathStuff.VecM.*;

public class Cube {

    public Vec3 a,b,c,d,e,f,g,h;
    public Vec3 pos;
    public int size;

    public Cube(Vec3 pos, int size) {
        this.pos = pos;
        this.size = size;

        this.a = new Vec3(-1,1,1);
        this.a.add(pos);
        this.b = new Vec3(1,1,1);
        this.b.add(pos);
        this.c = new Vec3(1,1,-1);
        this.c.add(pos);
        this.d = new Vec3(-1,1,-1);
        this.d.add(pos);
        this.e = new Vec3(-1,-1,1);
        this.e.add(pos);
        this.f = new Vec3(1,-1,1);
        this.f.add(pos);
        this.g = new Vec3(1,-1,-1);
        this.g.add(pos);
        this.h = new Vec3(-1,-1,-1);
        this.h.add(pos);
    }

    public Vec3[] toArray() {
        Vec3[] r = {a,b,c,d,e,f,g,h};
        return r;
    }
}