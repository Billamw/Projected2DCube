package MathStuff.MatMxM;

import MathStuff.VecM.Vec3;

public class Mat3 {

    public static void main(String[] args) {
        
        //Mat3 inverseTest = new Mat3(2,0,1,3,2, -4,1,0,3);
        Mat3 inverseTest = new Mat3(-3,2,1,4,1,0,-1,6,2);
        Mat3 inverseTest2 = new Mat3(1, 0, 0, 0, 1, 9, 0, 0, 1);
       
        //inverseTest.show();
        long timeStart = System.nanoTime();
        inverseTest.inverse();
        long timeEnd = System.nanoTime();
        System.out.println("Inverse");
        inverseTest.show();

        //System.out.println((timeEnd-timeStart));
    }

    public float m00, m01, m02,
                 m10, m11, m12,
                 m20, m21, m22;

    public Mat3() {}
    
    /**
     * Insert "e" or "unit" to get unit Matrix
     */
    public Mat3(String unitMatrix) {
        this.m00= 1; this.m01= 0; this.m02= 0;
        this.m10= 0; this.m11= 1; this.m12= 0;
        this.m20= 0; this.m21= 0; this.m22= 1;
    }
    public Mat3(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        this.m00= m00; this.m01= m01; this.m02= m02;
        this.m10= m10; this.m11= m11; this.m12= m12;
        this.m20= m20; this.m21= m21; this.m22= m22;
    }

    public Mat3(float[][] arr) {
        this.m00 = arr[0][0]; this.m01 = arr[0][1]; this.m02 = arr[0][2];
        this.m10 = arr[1][0]; this.m11 = arr[1][1]; this.m12 = arr[1][2];
        this.m20 = arr[2][0]; this.m21 = arr[2][1]; this.m22 = arr[2][2];
    }

    public static Mat3 rotationX(double alpha) {
        double a = alpha;
        return new Mat3(1,     0,            0,
                        0,(float)Math.cos(a), (float)-Math.sin(a),
                        0,(float)Math.sin(a), (float) Math.cos(a));
    }

    public static Mat3 rotationY(double alpha) {
        double a = alpha;
        return new Mat3((float) Math.cos(a), 0, (float)Math.sin(a), 
                              0,         1,     0,
                        (float)-Math.sin(a), 0, (float)Math.cos(a));
    }

    public static Mat3 rotationZ(double alpha) {
        double a = alpha;
        return new Mat3((float)Math.cos(a), (float)-Math.sin(a), 0,
                        (float)Math.sin(a), (float) Math.cos(a), 0,
                              0,               0,       1);
    }

    public static Mat3 rotation(double alpha, double beta, double gamma) {
        return new Mat3((float)(Math.cos(beta)*Math.cos(gamma)), (float)(Math.sin(alpha)*Math.sin(beta)*Math.cos(gamma)-Math.cos(alpha)*Math.sin(gamma)), (float)(Math.cos(alpha)*Math.sin(beta)*Math.cos(gamma)+Math.sin(alpha)*Math.sin(gamma)),
                        (float)(Math.cos(beta)*Math.cos(gamma)), (float)(Math.sin(alpha)*Math.sin(beta)*Math.cos(gamma)+Math.cos(alpha)*Math.sin(gamma)), (float)(Math.cos(alpha)*Math.sin(beta)*Math.cos(gamma)-Math.sin(alpha)*Math.sin(gamma)),
                             (float)-Math.sin(beta),                     (float)(Math.sin(alpha)*Math.cos(beta)),                                     (float)(Math.cos(alpha)*Math.cos(beta))                       );
    }
    
    public void clone(Mat3 M) {
        this.m00= M.m00; this.m01= M.m01; this.m02=M.m02;
        this.m10= M.m10; this.m11= M.m11; this.m12=M.m12;
        this.m20= M.m20; this.m21= M.m21; this.m22=M.m22;
    }

    private static Mat3 M = new Mat3();
    private static Mat3 Buffer = new Mat3();
    
    public Mat3 add(Mat3 B) {

        this.m00 += B.m00; this.m01 += B.m01; this.m02 += B.m02;
        this.m10 += B.m10; this.m11 += B.m11; this.m12 += B.m12;
        this.m20 += B.m20; this.m21 += B.m21; this.m22 += B.m22;
        return this;
    }

    public Mat3 sub(Mat3 B) {
        this.m00 -= B.m00; this.m01 -= B.m01; this.m02 -= B.m02;
        this.m10 -= B.m10; this.m11 -= B.m11; this.m12 -= B.m12;
        this.m20 -= B.m20; this.m21 -= B.m21; this.m22 -= B.m22;
        return this;
    }
    /**
     * REMINDER!
     * Matrixs are multiplyed from right to left NOT left to right!
     * @param B
     */
    public Mat3 mul(Mat3 B) {
        M.clone(this);
        this.m00= M.m00*B.m00+M.m01*B.m10+M.m02*B.m20; 
        this.m01= M.m00*B.m01+M.m01*B.m11+M.m02*B.m21; 
        this.m02= M.m00*B.m02+M.m01*B.m12+M.m02*B.m22;

        this.m10= M.m10*B.m00+M.m11*B.m10+M.m12*B.m20; 
        this.m11= M.m10*B.m01+M.m11*B.m11+M.m12*B.m21; 
        this.m12= M.m10*B.m02+M.m11*B.m12+M.m12*B.m22;

        this.m20= M.m20*B.m00+M.m21*B.m10+M.m22*B.m20; 
        this.m21= M.m20*B.m01+M.m21*B.m11+M.m22*B.m21; 
        this.m22= M.m20*B.m02+M.m21*B.m12+M.m22*B.m22;
        return this;
    }

    public Mat3 mul(float val) {
        this.m00*=val; this.m01*=val; this.m02*=val; 
        this.m10*=val; this.m11*=val; this.m12*=val; 
        this.m20*=val; this.m21*=val; this.m22*=val; 
        return this;
    }

    public Mat3 transpose() {
        Buffer.clone(this);
        this.m01 = Buffer.m10;
        this.m02 = Buffer.m20;
        
        this.m10 = Buffer.m01;
        this.m12 = Buffer.m21;

        this.m20 = Buffer.m02;
        this.m21 = Buffer.m12;
        return this;
    }

    

    public Mat3 cofactor() {
        M.clone(this);
        // this.m00 =  new Mat2(M.m11, M.m12, M.m21, M.m22).determinante();
        // this.m01 = -new Mat2(M.m10, M.m12, M.m20, M.m22).determinante();
        // this.m02 =  new Mat2(M.m10, M.m11, M.m20, M.m21).determinante();
        
        // this.m10 = -new Mat2(M.m01, M.m02, M.m21, M.m22).determinante();
        // this.m11 =  new Mat2(M.m00, M.m02, M.m20, M.m22).determinante();
        // this.m12 = -new Mat2(M.m00, M.m01, M.m20, M.m21).determinante();
        
        // this.m20 =  new Mat2(M.m01, M.m02, M.m11, M.m12).determinante();
        // this.m21 = -new Mat2(M.m00, M.m02, M.m10, M.m12).determinante();
        // this.m22 =  new Mat2(M.m00, M.m01, M.m10, M.m11).determinante();

        this.m00 =  M.m11*M.m22-M.m12*M.m21;
        this.m01 = -(M.m10*M.m22-M.m12*M.m20);
        this.m02 =  M.m10*M.m21-M.m11*M.m20;

        this.m10 = -(M.m01*M.m22-M.m02*M.m21);
        this.m11 =  M.m00*M.m22-M.m02*M.m20;
        this.m12 = -(M.m00*M.m21-M.m01*M.m20);

        this.m20 =  M.m01*M.m12-M.m02*M.m11;
        this.m21 = -(M.m00*M.m12-M.m02*M.m10);
        this.m22 =  M.m00*M.m11-M.m01*M.m10;
        return this;
    }

    public Mat3 adjuncte() {
        this.cofactor();
        this.transpose();
        return this;
    }

    public Mat3 inverse() {
        return this.adjuncte().mul(1/M.determinante()).round(3);
    }

    public float determinante() {
        return this.m00*this.m11*this.m22+this.m01*this.m12*this.m20+this.m02*this.m10*this.m21-this.m20*this.m11*this.m02-this.m21*this.m12*this.m00-this.m22*this.m10*this.m01;
    }

    public Mat3 toUnderTriangle() {
        float row1 = this.m00, row2 = this.m10, row3 = this.m20;
        this.m10 = -row2 * this.m00 + row1 * this.m10;
        this.m11 = -row2 * this.m01 + row1 * this.m11;
        this.m12 = -row2 * this.m02 + row1 * this.m12;

        this.m20 = -row3 * this.m00 + row1 * this.m20;
        this.m21 = -row3 * this.m01 + row1 * this.m21;
        this.m22 = -row2 * this.m02 + row1 * this.m22;

        row2 = this.m11; row3 = this.m21;
        this.m21 = 0;
        this.m22 = -row3 * this.m12 + row2 * this.m22; 


        return this;
    }
    public float[][] toArray() {
        float[][] r = new float[3][3];
        r[0][0]= this.m00; r[0][1]= this.m01; r[0][2]= this.m02;
        r[1][0]= this.m10; r[1][1]= this.m11; r[1][2]= this.m12;
        r[2][0]= this.m20; r[2][1]= this.m21; r[2][2]= this.m22;
        return r;
    }

    private Mat3 round(int places) {
        float[][] arr = this.toArray();
        float fac = (float) Math.pow(10, places);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                arr[i][j] = Math.round(arr[i][j]*fac)/fac;
            }
        }
        return this.toMatrix(arr); 
    }
    private Mat3 toMatrix(float[][] arr) {
        this.m00= arr[0][0]; this.m01= arr[0][1]; this.m02= arr[0][2];
        this.m10= arr[1][0]; this.m11= arr[1][1]; this.m12= arr[1][2];
        this.m20= arr[2][0]; this.m21= arr[2][1]; this.m22= arr[2][2];
        return this;
    }

    public void show() {
        System.out.println(this.m00 + " " + this.m01 + " " + this.m02);
        System.out.println(this.m10 + " " + this.m11 + " " + this.m12);
        System.out.println(this.m20 + " " + this.m21 + " " + this.m22);
        System.out.println();
    }
}
