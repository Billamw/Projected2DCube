package Body;

import MathStuff.VecM.Vec3;

public interface Body {

    public abstract void scale();
    public abstract void connectPoints(Vec3[] points);
    
}
