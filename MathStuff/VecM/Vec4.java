package MathStuff.VecM;

import MathStuff.MatMxM.Mat4;

public class Vec4 {
    public float x;
    public float y;
    public float z;
    public float w;
    
    public Vec4() {
        this.x = 1;
        this.y = 1;
        this.z = 1;
        this.w = 1;
    }
    
    public Vec4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vec4(Vec4 vec) {
        this.x = vec.x;
        this.y = vec.y;
        this.z = vec.z;
        this.w = vec.w;
    } 
    
    public Vec4(Vec3 H) {
        this.x = H.x;
        this.y = H.y;
        this.z = H.z;
        this.w =  1 ;
    }
    
    public Vec4(float[] arr) {
        this.x = arr[0];
        this.y = arr[1];
        this.z = arr[2];
        this.w = arr[3];
    }
    
    private static Vec4 Buff = new Vec4();
    public void set(float x, float y, float z, float w){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    public Vec4 set(Vec4 vec){
        this.x = vec.x;
        this.y = vec.y;
        this.z = vec.z;
        this.w = vec.w;
        return this;
    }
    public Vec4 clone() {
        return new Vec4(this);
    }
    public float[] toArray() {
        float[] arr = new float[4];
        arr[0] = this.x;
        arr[1] = this.y;
        arr[2] = this.z;
        arr[3] = this.w;
        return arr;
    }

    public Vec4 add (Vec4 vecRight) {
        this.x += vecRight.x;
        this.y += vecRight.y;
        this.z += vecRight.z;
        this.w += vecRight.w;
        return this;
    }

    public Vec4 sub (Vec4 vecRight) {
        this.x -= vecRight.x;
        this.y -= vecRight.y;
        this.z -= vecRight.z;
        this.w -= vecRight.w;
        return this;
    }

    public Vec4 normalize() {
        float pyth = (float)Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z + this.w*this.w);
        this.x /= pyth;
        this.y /= pyth;
        this.z /= pyth;
        this.w /= pyth;
        return this;
    }

    public Vec4 mul(float val) {
        this.x*=val;
        this.y*=val;
        this.z*=val;
        this.w*=val;
        return this;
    }
    public Vec4 mulBuff(float val) {
        Buff.set(this);
        Buff.x*=val;
        Buff.y*=val;
        Buff.z*=val;
        Buff.w*=val;
        return Buff;
    }
   
    /**
     * Multiplys Matrix with a Vector 
     * @param B
     * @return
     */
    public Vec4 mul(Mat4 B) {
        Buff.set(this);
        this.x=B.m00*Buff.x+B.m01*Buff.y+B.m02*Buff.z+B.m03*Buff.w;
        this.y=B.m10*Buff.x+B.m11*Buff.y+B.m12*Buff.z+B.m13*Buff.w;
        this.z=B.m20*Buff.x+B.m21*Buff.y+B.m22*Buff.z+B.m23*Buff.w;
        this.w=B.m30*Buff.x+B.m31*Buff.y+B.m32*Buff.z+B.m33*Buff.w;
        return this;
    }

    public void showHor() {
        System.out.println(x + ", " + y + ", " + z + ", " + w);
    }
    
    public static void main(String[] args) {
        Mat4 a = new Mat4(0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 3, 2, 1, 0);
        a.inverse();
        a.show();
        Vec4 k = new Vec4(0, 1, 0, 0);
        // k.showHor();
        k.mul(a);
        k.showHor();
    }
    
}
