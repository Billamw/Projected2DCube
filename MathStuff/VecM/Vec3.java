package MathStuff.VecM;

import MathStuff.MatMxM.*;

public class Vec3 {

    public float x;
    public float y;
    public float z;

    public Vec3() {}

    public Vec3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(float x, float y, float z){
        this.x = x; this.y = y; this.z = z;
    }
    public Vec3 set(Vec3 vec){
        this.x = vec.x; this.y = vec.y; this.z = vec.z;
        return this;
    }
    public float[] toArray() {
        float[] result = new float[3];
        result[0] = this.x;
        result[1] = this.y;
        result[2] = this.z;
        return result;
    }

    public Vec3 add (Vec3 vecRight) {
        this.x += vecRight.x;
        this.y += vecRight.y;
        this.z += vecRight.z;
        return this;
    }

    public Vec3 sub (Vec3 vecRight) {
        this.x -= vecRight.x;
        this.y -= vecRight.y;
        this.z -= vecRight.z;
        return this;
    }
    public Vec3 mul(float value) {
        this.x*=value;
        this.y*=value;
        this.z*=value;
        return this;
    }

    public Vec3 mul(Mat3 B) {
        Vec3 Buff= this;
        this.x=B.m00*Buff.x+B.m01*Buff.y+B.m02*Buff.z;
        this.y=B.m10*Buff.x+B.m11*Buff.y+B.m12*Buff.z;
        this.z=B.m20*Buff.x+B.m21*Buff.y+B.m22*Buff.z;
        return this;
    }

    public Vec3 mul(MatN B) {
        
        return this;
    }


    public float length() {
        return (float) Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y, 2)+Math.pow(this.z, 2));
    }
    
    public float scalar(Vec3 vecRight) {
        return this.x * vecRight.x + this.y * vecRight.y + this.z * vecRight.z;
    }

    public float angleBetween(Vec3 vecRight) {
        return (float) Math.acos( this.scalar(vecRight)/(this.length()*vecRight.length()) );
    }

    public Vec3 cross (Vec3 vecRight) {
        Vec3 Vres = new Vec3();
        Vres.x = this.y*vecRight.z - this.z*vecRight.y;
        Vres.y = this.z*vecRight.x - this.x*vecRight.z;
        Vres.z = this.x*vecRight.y - this.y*vecRight.x;
        return Vres;
    }

    public void showHor() {
        System.out.println(x + ", " + y + ", " + z);
    }


}
