package Body;

import MathStuff.VecM.Vec2;
import MathStuff.VecM.Vec3;

public interface Body {

    //public Vec3[] points = new Vec3[100];
    public abstract Vec3[] getPoints();
    public abstract void scale();
    public abstract void connectPoints(Vec3[] points);
    public abstract void connectPoints(Vec2[] points);
    
}
