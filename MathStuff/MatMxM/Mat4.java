package MathStuff.MatMxM;

import MathStuff.VecM.Vec3;
import MathStuff.VecM.Vec4;

public class Mat4 {

    public static void main(String[] args) {

        Mat4 detTest = new Mat4(3, 1, 5, 1, -1, 0, -2, 0, 0, 0, 1, -1, 4, 0, 4, 1);
        System.out.println(detTest.determinante()); //Sollte -3 sein

        Mat4 inversTest = new Mat4(-1, 0, 0, 0, 2, 2, 0, 0, 1, 3, 1, 0, 4, 1, 2, -0.5f);
        Mat4 inversTest2 = new Mat4(1, 0, 0, 0,
                                    0, 1, 0, 0,
                                    0, 0, 1, 9,
                                    0, 0, 0, 1);
        inversTest2.inverse();
        inversTest2.show(); // stimmt noch nicht
        
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

    public static Mat4 ViewMatrix(float near, float far, float with, float height) {
        return new Mat4((2*near)/with,         0f,                 0f,           0f,
                               0f,     (2*near)/height,            0f,           0f,
                               0f,        0f,            (far+near)/(near-far),     -1f,
                               0f,        0f,          (2*far*near)/(near-far),  0f );
    }

    public static Mat4 projectionMatrix(float d) {
        return new Mat4(1, 0, 0, 0,
                        0, 1, 0, 0,
                        0, 0, 0, 0,
                        0, 0,   1/d, 0);
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

    private static Mat4 M = new Mat4();
    private static Mat4 Buffer = new Mat4();
    
    public Mat4 mul(Mat4 B) { 
        M.clone(this);
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

    public Mat4 transpose() {
        Buffer.clone(this);
        this.m01 = Buffer.m10;
        this.m02 = Buffer.m20;
        this.m03 = Buffer.m30;
        
        this.m12 = Buffer.m21;
        this.m13 = Buffer.m31;

        this.m23 = Buffer.m32;

        this.m10 = Buffer.m01;
        
        this.m20 = Buffer.m02;
        this.m21 = Buffer.m12;

        this.m30 = Buffer.m03;
        this.m31 = Buffer.m13;
        this.m32 = Buffer.m23;


        return this;
    }

    public float determinante() {
        return this.m00*(this.m11*this.m22*this.m33 + this.m12*this.m23*this.m31 + this.m13*this.m21*this.m32 - this.m31*this.m22*this.m13 - this.m32*this.m23*this.m11 - this.m33*this.m21*this.m12)
             - this.m10*(this.m01*this.m22*this.m33 + this.m02*this.m23*this.m31 + this.m03*this.m21*this.m32 - this.m31*this.m22*this.m03 - this.m32*this.m23*this.m01 - this.m33*this.m21*this.m02)
             + this.m20*(this.m01*this.m12*this.m33 + this.m02*this.m13*this.m31 + this.m03*this.m11*this.m32 - this.m31*this.m12*this.m03 - this.m32*this.m13*this.m01 - this.m33*this.m11*this.m02)
             - this.m30*(this.m01*this.m12*this.m23 + this.m02*this.m13*this.m21 + this.m03*this.m11*this.m22 - this.m21*this.m12*this.m03 - this.m22*this.m13*this.m01 - this.m23*this.m11*this.m02);
    }

    public Mat4 cofactor() {
        M.clone(this);
        this.m00 =   M.m11*M.m22*M.m33 + M.m12*M.m23*M.m31 + M.m13*M.m21*M.m32 - M.m31*M.m22*M.m13 - M.m32*M.m23*M.m11 - M.m33*M.m21*M.m12 ;
        this.m01 = -(M.m10*M.m22*M.m33 + M.m12*M.m23*M.m30 + M.m13*M.m20*M.m32 - M.m30*M.m22*M.m13 - M.m32*M.m23*M.m10 - M.m33*M.m20*M.m12);
        this.m02 =   M.m10*M.m21*M.m33 + M.m11*M.m23*M.m30 + M.m13*M.m20*M.m31 - M.m30*M.m21*M.m13 - M.m31*M.m23*M.m10 - M.m33*M.m20*M.m11 ;
        this.m03 = -(M.m10*M.m21*M.m32 + M.m11*M.m22*M.m30 + M.m12*M.m20*M.m31 - M.m30*M.m21*M.m12 - M.m31*M.m22*M.m10 - M.m32*M.m20*M.m11);

        this.m10 = -(M.m01*M.m22*M.m33 + M.m02*M.m23*M.m31 + M.m03*M.m21*M.m32 - M.m31*M.m22*M.m03 - M.m32*M.m23*M.m01 - M.m33*M.m21*M.m02);
        this.m11 =   M.m00*M.m22*M.m33 + M.m02*M.m23*M.m30 + M.m03*M.m20*M.m32 - M.m30*M.m22*M.m03 - M.m32*M.m23*M.m00 - M.m33*M.m20*M.m02 ;
        this.m12 = -(M.m00*M.m21*M.m33 + M.m01*M.m23*M.m30 + M.m03*M.m20*M.m31 - M.m30*M.m21*M.m03 - M.m31*M.m23*M.m00 - M.m33*M.m20*M.m01);
        this.m13 =   M.m00*M.m21*M.m32 + M.m01*M.m22*M.m30 + M.m02*M.m20*M.m31 - M.m30*M.m21*M.m02 - M.m31*M.m22*M.m00 - M.m32*M.m20*M.m01 ;

        this.m20 =   M.m01*M.m12*M.m33 + M.m02*M.m13*M.m31 + M.m03*M.m11*M.m32 - M.m31*M.m12*M.m03 - M.m32*M.m13*M.m01 - M.m33*M.m11*M.m02 ;
        this.m21 = -(M.m00*M.m12*M.m33 + M.m02*M.m13*M.m30 + M.m03*M.m10*M.m32 - M.m30*M.m12*M.m03 - M.m32*M.m13*M.m00 - M.m33*M.m10*M.m02);
        this.m22 =   M.m00*M.m11*M.m33 + M.m01*M.m13*M.m30 + M.m03*M.m10*M.m31 - M.m30*M.m11*M.m03 - M.m31*M.m13*M.m00 - M.m33*M.m10*M.m01 ;
        this.m23 = -(M.m00*M.m11*M.m32 + M.m01*M.m12*M.m30 + M.m02*M.m10*M.m31 - M.m30*M.m11*M.m02 - M.m31*M.m12*M.m00 - M.m32*M.m10*M.m01);

        this.m30 = -(M.m01*M.m12*M.m23 + M.m02*M.m13*M.m21 + M.m03*M.m11*M.m22 - M.m21*M.m12*M.m03 - M.m22*M.m13*M.m01 - M.m23*M.m11*M.m02);
        this.m31 =   M.m00*M.m12*M.m23 + M.m02*M.m13*M.m20 + M.m03*M.m10*M.m22 - M.m20*M.m12*M.m03 - M.m22*M.m13*M.m00 - M.m23*M.m10*M.m02 ;
        this.m32 = -(M.m00*M.m11*M.m23 + M.m01*M.m13*M.m20 + M.m03*M.m10*M.m21 - M.m20*M.m11*M.m03 - M.m21*M.m13*M.m00 - M.m23*M.m10*M.m01);
        this.m33 =   M.m00*M.m11*M.m22 + M.m01*M.m12*M.m20 + M.m02*M.m10*M.m21 - M.m20*M.m11*M.m02 - M.m21*M.m12*M.m00 - M.m22*M.m10*M.m01 ;
        
        return this;
    }

    public Mat4 cofactor2() {
        M.clone(this);
        this.m00 =  new Mat3(M.m11, M.m12, M.m13, M.m21, M.m22, M.m23, M.m31, M.m32, M.m33).determinante();
        this.m01 = -new Mat3(M.m10, M.m12, M.m13, M.m20, M.m22, M.m23, M.m30, M.m32, M.m33).determinante();
        this.m02 =  new Mat3(M.m10, M.m11, M.m13, M.m20, M.m21, M.m23, M.m30, M.m31, M.m33).determinante();
        this.m03 = -new Mat3(M.m10, M.m11, M.m12, M.m20, M.m21, M.m22, M.m30, M.m31, M.m32).determinante();

        this.m10 = -new Mat3(M.m01, M.m02, M.m03, M.m21, M.m22, M.m23, M.m31, M.m32, M.m33).determinante();
        this.m11 =  new Mat3(M.m00, M.m02, M.m03, M.m20, M.m22, M.m23, M.m30, M.m32, M.m33).determinante();
        this.m12 = -new Mat3(M.m00, M.m01, M.m03, M.m20, M.m21, M.m23, M.m30, M.m13, M.m33).determinante();
        this.m13 =  new Mat3(M.m00, M.m01, M.m02, M.m20, M.m21, M.m22, M.m30, M.m31, M.m32).determinante();

        this.m20 =  new Mat3(M.m01, M.m02, M.m03, M.m11, M.m12, M.m13, M.m31, M.m32, M.m33).determinante();
        this.m21 = -new Mat3(M.m00, M.m02, M.m03, M.m10, M.m12, M.m13, M.m30, M.m32, M.m33).determinante();
        this.m22 =  new Mat3(M.m00, M.m01, M.m03, M.m10, M.m11, M.m13, M.m30, M.m31, M.m33).determinante();
        this.m23 = -new Mat3(M.m00, M.m01, M.m02, M.m10, M.m11, M.m12, M.m30, M.m31, M.m32).determinante();

        this.m30 = -new Mat3(M.m01, M.m02, M.m03, M.m11, M.m12, M.m13, M.m21, M.m22, M.m23).determinante();
        this.m31 =  new Mat3(M.m00, M.m02, M.m03, M.m10, M.m12, M.m13, M.m20, M.m22, M.m23).determinante();
        this.m32 = -new Mat3(M.m00, M.m01, M.m03, M.m10, M.m11, M.m13, M.m20, M.m21, M.m23).determinante();
        this.m33 =  new Mat3(M.m00, M.m01, M.m02, M.m10, M.m11, M.m12, M.m20, M.m21, M.m22).determinante();
        
        return this;
    }

    public Mat4 adjuncte() {
        this.cofactor();
        this.transpose();
        return this;
    }

    public Mat4 inverse() {
        return this.adjuncte().mul(1/M.determinante());
    }
    
    public void show() {
        System.out.println(m00 + " " + m01 + " " + m02 + " " + m03);
        System.out.println(m10 + " " + m11 + " " + m12 + " " + m13);
        System.out.println(m20 + " " + m21 + " " + m22 + " " + m23);
        System.out.println(m30 + " " + m31 + " " + m32 + " " + m33);
    }
}
