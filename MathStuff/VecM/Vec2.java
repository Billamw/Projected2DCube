package MathStuff.VecM;

public class Vec2 {

    public static void main(String[] args) {
        
    }

    public float x;
    public float y;

    public Vec2(){}

    public Vec2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vec2(Vec3 H) {
        this.x = H.x;
        this.y = H.y;
    }

    public Vec2(Vec4 H) {
        this.x = H.x;
        this.y = H.y;
    }

    public Vec2 add(Vec2 vRight) {
        this.x += vRight.x;
        this.y += vRight.y;
        return this;
    }

    public Vec2 sub(Vec2 vRight) {
        this.x -= vRight.x;
        this.y -= vRight.y;
        return this;
    }
    
    public Vec2 mul(float val) {
        this.x *= val;
        this.y *= val;
        return this;
    }

    public float scalar(Vec2 vRight) {
        return this.x*vRight.y-vRight.x*this.y;
    }

    

}
