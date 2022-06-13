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

    public Vec3(Vec2 H) {
        this.x = H.x;
        this.y = H.y;
        this.z =  1 ;
    }

    public Vec3(Vec4 H) {
        this.x = H.x;
        this.y = H.y;
        this.z = H.z;
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

    // public Vec3 negative() {
    //     this.x = -this.x;
    //     this.y = -this.y;
    //     this.z = -this.z;
    //     return this;
    // }

    public static Vec3 add(Vec3 a, Vec3 b) {
        return new Vec3(a.x+b.x, a.y+b.y, a.z+b.z);
    }

    public Vec3 add (Vec3 vecRight) {
        this.x += vecRight.x;
        this.y += vecRight.y;
        this.z += vecRight.z;
        return this;
    }

    public static Vec3 sub(Vec3 vecLeft, Vec3 vecRight) {
        return new Vec3(vecLeft.x-vecRight.x, vecLeft.y-vecRight.y, vecLeft.z-vecRight.z);
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

    public Vec3 normalize() {
        float pythagoras = (float) Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
        this.x /= pythagoras;
        this.y /= pythagoras;
        this.z /= pythagoras;
        return this;
    }

    /**
     * Multyply a Vec3 wit a 2x3 Matrix
     * @param B
     * @return Vec2
     */

    Vec2 Buff = new Vec2();
    public Vec2 mul(MatN B) {
        if(B.hasCollumns() != 3) throw new Error("Error lol");
        Buff.x = B.M[0][0]*this.x+B.M[0][1]*this.y+B.M[0][2]*this.z;
        Buff.y = B.M[1][0]*this.x+B.M[1][1]*this.y+B.M[1][2]*this.z;
        return Buff;
    }


    public float length() {
        return (float) Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y, 2)+Math.pow(this.z, 2));
    }
    
    public float scalar(Vec3 vecRight) {
        return this.x * vecRight.x + this.y * vecRight.y + this.z * vecRight.z;
    }
    public float dot(Vec3 vecRight) {
        return this.x * vecRight.x + this.y * vecRight.y + this.z * vecRight.z;
    }

    public float angleBetween(Vec3 vecRight) {
        return (float) Math.acos( this.scalar(vecRight)/(this.length()*vecRight.length()) );
    }

    public static Vec3 cross (Vec3 vecLeft,Vec3 vecRight) {
        Vec3 Vres = new Vec3();
        Vres.x = vecLeft.y*vecRight.z - vecLeft.z*vecRight.y;
        Vres.y = vecLeft.z*vecRight.x - vecLeft.x*vecRight.z;
        Vres.z = vecLeft.x*vecRight.y - vecLeft.y*vecRight.x;
        return Vres;
    }

    public void showHor() {
        System.out.println(x + ", " + y + ", " + z);
    }


}
