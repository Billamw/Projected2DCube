package MathStuff.MatMxM;

import MathStuff.VecM.Vec3;
import MathStuff.VecM.Vec4;

public class Mat4 {

    public static void main(String[] args) {
        
    }

    public float m00, m01, m02, m03;
    public float m10, m11, m12, m13;
    public float m20, m21, m22, m23;
    public float m30, m31, m32, m33;

    public Mat4() {}

    public Mat4(float m00,float m01,float m02,float m03, 
                float m10,float m11,float m12,float m13,
                float m20,float m21,float m22,float m23,
                float m30,float m31,float m32,float m33) {
                    this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03;
                    this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13;
                    this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23;
                    this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33;
                }
            
    public Mat4(Vec4 I, Vec4 II, Vec4 III, Vec4 IV) {
        this.m00 = I.x; this.m01 = II.x; this.m02 = III.x; this.m03 = IV.x;
        this.m10 = I.y; this.m01 = II.y; this.m02 = III.y; this.m03 = IV.y;
        this.m20 = I.z; this.m01 = II.z; this.m02 = III.z; this.m03 = IV.z;
        this.m30 = I.w; this.m01 = II.w; this.m02 = III.w; this.m03 = IV.w;
    }

    public Mat4 (float[] arr) {
        this.m00 = arr[0] ; this.m01 = arr[1] ; this.m02 = arr[2];  this.m03 = arr[3];
        this.m10 = arr[4] ; this.m01 = arr[5] ; this.m02 = arr[6];  this.m03 = arr[7];
        this.m20 = arr[8] ; this.m01 = arr[9] ; this.m02 = arr[10]; this.m03 = arr[11];
        this.m30 = arr[12]; this.m01 = arr[13]; this.m02 = arr[14]; this.m03 = arr[15];
    }

    public Mat4(Mat3 B) {
        this.m00 = B.m00; this.m01 = B.m01; this.m02 = B.m02; this.m03 =   0  ;
        this.m10 = B.m10; this.m11 = B.m11; this.m12 = B.m12; this.m13 =   0  ;
        this.m20 = B.m20; this.m21 = B.m21; this.m22 = B.m22; this.m23 =   0  ;
        this.m30 =   0  ; this.m31 =   0  ; this.m32 =   0  ; this.m33 =   1  ;
    }
    /**
     * moves Vecor to Vector t
     * Caution! diagonals = 1;
     * @param t
     * @return
     */
    public static Mat4 moveMatrix(Vec3 t) {
        return new Mat4(1,0,0, t.x, 
                        0,1,0, t.y,
                        0,0,1, t.z,
                        0,0,0,1);
    }

    public Mat4 add(Mat4 B) {
        this.m00 += B.m00; this.m01 += B.m01; this.m02 += B.m02; this.m03 += B.m03;
        this.m10 += B.m10; this.m11 += B.m11; this.m12 += B.m12; this.m13 += B.m13;
        this.m20 += B.m20; this.m21 += B.m21; this.m22 += B.m22; this.m23 += B.m23;
        this.m30 += B.m30; this.m31 += B.m31; this.m32 += B.m32; this.m33 += B.m33;
        return this;
    }

    public Mat4 sub(Mat4 B) {
        this.m00 -= B.m00; this.m01 -= B.m01; this.m02 -= B.m02; this.m03 -= B.m03;
        this.m10 -= B.m10; this.m11 -= B.m11; this.m12 -= B.m12; this.m13 -= B.m13;
        this.m20 -= B.m20; this.m21 -= B.m21; this.m22 -= B.m22; this.m23 -= B.m23;
        this.m30 -= B.m30; this.m31 -= B.m31; this.m32 -= B.m32; this.m33 -= B.m33;
        return this;
    }

    public Mat4 mul(float val) {
        this.m00 *= val; this.m01 *= val; this.m02 *= val; this.m03 *= val;
        this.m10 *= val; this.m11 *= val; this.m12 *= val; this.m13 *= val;
        this.m20 *= val; this.m21 *= val; this.m22 *= val; this.m23 *= val;
        this.m30 *= val; this.m31 *= val; this.m32 *= val; this.m33 *= val;
        return this;
    }

    public void clone(Mat4 M) {
        this.m00 = M.m00; this.m01 = M.m01; this.m02 = M.m02; this.m03 = M.m03;
        this.m10 = M.m10; this.m11 = M.m11; this.m12 = M.m12; this.m13 = M.m13;
        this.m20 = M.m20; this.m21 = M.m21; this.m22 = M.m22; this.m23 = M.m23;
        this.m30 = M.m30; this.m31 = M.m31; this.m32 = M.m32; this.m33 = M.m33;
    }

    private static Mat4 Mbuffer = new Mat4();
    
    public Mat4 mul(Mat4 B) { 
        Mbuffer.clone(this);
        Mat4 M = Mbuffer;
        this.m00= M.m00*B.m00 + M.m01*B.m10 + M.m02*B.m20 + M.m03*B.m30;
        this.m01= M.m00*B.m01 + M.m01*B.m11 + M.m02*B.m21 + M.m03*B.m31;
        this.m02= M.m00*B.m02 + M.m01*B.m12 + M.m02*B.m22 + M.m03*B.m32;
        this.m03= M.m00*B.m03 + M.m01*B.m13 + M.m02*B.m23 + M.m03*B.m33;
        
        this.m10= M.m10*B.m00 + M.m11*B.m10 + M.m12*B.m20 + M.m13*B.m30;
        this.m11= M.m10*B.m01 + M.m11*B.m11 + M.m12*B.m21 + M.m13*B.m31;
        this.m12= M.m10*B.m02 + M.m11*B.m12 + M.m12*B.m22 + M.m13*B.m32;
        this.m13= M.m10*B.m03 + M.m11*B.m13 + M.m12*B.m23 + M.m13*B.m33;
        
        this.m20= M.m20*B.m00 + M.m21*B.m10 + M.m22*B.m20 + M.m23*B.m30;
        this.m21= M.m20*B.m01 + M.m21*B.m11 + M.m22*B.m21 + M.m23*B.m31;
        this.m22= M.m20*B.m02 + M.m21*B.m12 + M.m22*B.m22 + M.m23*B.m32;
        this.m23= M.m20*B.m03 + M.m21*B.m13 + M.m22*B.m23 + M.m23*B.m33;
        
        this.m30= M.m30*B.m00 + M.m31*B.m10 + M.m32*B.m20 + M.m33*B.m30;
        this.m31= M.m30*B.m01 + M.m31*B.m11 + M.m32*B.m21 + M.m33*B.m31;
        this.m32= M.m30*B.m02 + M.m31*B.m12 + M.m32*B.m22 + M.m33*B.m32;
        this.m33= M.m30*B.m03 + M.m31*B.m13 + M.m32*B.m23 + M.m33*B.m33;

        return this;
    }
    
}
