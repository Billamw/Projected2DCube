package Math.MatMxM;

import Math.VecM.Vec3;

public class Mat3 {

    public float m00, m01, m02,
                 m10, m11, m12,
                 m20, m21, m22;

    public Vec3 I   = new Vec3(m00, m01, m02);
    public Vec3 II  = new Vec3(m10, m11, m12);
    public Vec3 III = new Vec3(m20, m21, m12);
  

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
        double a = alpha, b = beta, y = gamma;
        return new Mat3((float)(Math.cos(b)*Math.cos(y)), (float)(Math.sin(a)*Math.sin(b)*Math.cos(y)-Math.cos(a)*Math.sin(y)), (float)(Math.cos(a)*Math.sin(b)*Math.cos(y)+Math.sin(a)*Math.sin(y)),
                        (float)(Math.cos(b)*Math.cos(y)), (float)(Math.sin(a)*Math.sin(b)*Math.cos(y)+Math.cos(a)*Math.sin(y)), (float)(Math.cos(a)*Math.sin(b)*Math.cos(y)-Math.sin(a)*Math.sin(y)),
                             (float)-Math.sin(b),                     (float)(Math.sin(a)*Math.cos(b)),                                     (float)(Math.cos(a)*Math.cos(b))                       );
    }


    
    public void clone(Mat3 M) {
        this.m00= M.m00; this.m01= M.m01; this.m02=M.m02;
        this.m10= M.m10; this.m11= M.m11; this.m12=M.m12;
        this.m20= M.m20; this.m21= M.m21; this.m22=M.m22;
    }

    private static Mat3 M = new Mat3();
    
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

    public Vec3 mul(Vec3 vec) {
        Vec3 result = new Vec3();
        M.m00 = vec.x;
        M.m10 = vec.y;
        M.m20 = vec.z;

        this.mul(M);
        result.x = this.m00;
        result.y = this.m10;
        result.z = this.m20;

        return result;
    }

    private static Mat3 tmp = new Mat3();
	public Mat3 mulBen(Mat3 right) {
		tmp.clone(this);

		this.m00 = tmp.m00 * right.m00 + tmp.m01 * right.m10 + tmp.m02 * right.m20;
		this.m01 = tmp.m00 * right.m01 + tmp.m01 * right.m11 + tmp.m02 * right.m21;
		this.m02 = tmp.m00 * right.m02 + tmp.m01 * right.m12 + tmp.m02 * right.m22;

		this.m10 = tmp.m10 * right.m00 + tmp.m11 * right.m10 + tmp.m12 * right.m20;
		this.m11 = tmp.m10 * right.m01 + tmp.m11 * right.m11 + tmp.m12 * right.m21;
		this.m12 = tmp.m10 * right.m02 + tmp.m11 * right.m12 + tmp.m12 * right.m22;

		this.m20 = tmp.m20 * right.m00 + tmp.m21 * right.m10 + tmp.m22 * right.m20;
		this.m21 = tmp.m20 * right.m01 + tmp.m21 * right.m11 + tmp.m22 * right.m21;
		this.m22 = tmp.m20 * right.m02 + tmp.m21 * right.m12 + tmp.m22 * right.m22;

		return this;
	}

    public Mat3 mul(float val) {
        Mat3 M = this;
        M.m00= this.m00*val; M.m01= this.m01*val; M.m02= this.m02*val; 
        M.m10= this.m10*val; M.m11= this.m11*val; M.m12= this.m12*val; 
        M.m20= this.m20*val; M.m21= this.m21*val; M.m22= this.m22*val; 
        this.clone(M);
        return this;
    }

    public float determinante() {
        return m00*m11*m22+m01*m12*m20+m02*m10*m21-m20*m11*m02-m21*m12*m00-m22*m10*m01;
    }

    public Mat3 inverse() {
        Mat3 Me = new Mat3("e");
        //Me.II.set(Me.I.mul(this.m10).sub(Me.II.mul(this.m00)));
        Me.changeRow(1, Me.I.mul(this.m10).sub(Me.II.mul(this.m00)));

        this.changeRow(1, this.I.mul(this.m10).sub(this.II.mul(this.m00)));

        //Me.III.set(Me.I.mul(this.m20).sub(Me.III.mul(this.m00)));
        Me.changeRow(2, Me.I.mul(this.m20).sub(Me.III.mul(this.m00)));
        
        this.changeRow(2, this.I.mul(this.m20).sub(this.III.mul(this.m00)));

        //Me.III.set(Me.I.mul(this.m21).sub(Me.III.mul(this.m01)));
        Me.changeRow(2, Me.I.mul(this.m21).sub(Me.III.mul(this.m01)));
        
        this.changeRow(2, this.I.mul(this.m21).sub(this.III.mul(this.m01)));

        //Me.I.set(Me.III.mul(this.m02).sub(Me.I.mul(this.m22)));
        Me.changeRow(0, Me.III.mul(this.m02).sub(Me.I.mul(this.m22)));
        
        this.changeRow(0, this.III.mul(this.m02).sub(this.I.mul(this.m22)));

        //Me.II.set(Me.III.mul(this.m12).sub(Me.II.mul(this.m22)));
        Me.changeRow(1, Me.III.mul(this.m12).sub(Me.II.mul(this.m22)));

        this.changeRow(1, this.III.mul(this.m12).sub(this.II.mul(this.m22)));

        //Me.I.set(Me.II.mul(this.m01).sub(Me.I.mul(this.m11)));
        Me.changeRow(0, Me.II.mul(this.m01).sub(Me.I.mul(this.m11)));

        this.changeRow(0, this.II.mul(this.m01).sub(this.I.mul(this.m11)));

        return this;
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

    public Mat3 round(int places) {
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


    private Mat3 changeRow (int row, Vec3 vec) {
        if(row>2) System.err.println("Row not existing.");
        
        if(row == 0) {
            this.m00 = vec.x;
            this.m01 = vec.y;
            this.m02 = vec.z;
        }
        if(row == 1) {
            this.m10 = vec.x;
            this.m11 = vec.y;
            this.m12 = vec.z;
        }
        if(row == 2) {
            this.m20 = vec.x;
            this.m21 = vec.y;
            this.m22 = vec.z;
        }
        return this;
    }


    public void show() {
        System.out.println(this.m00 + " " + this.m01 + " " + this.m02);
        System.out.println(this.m10 + " " + this.m11 + " " + this.m12);
        System.out.println(this.m20 + " " + this.m21 + " " + this.m22);
        System.out.println();
    }

    public static void main(String[] args) {
        
        Mat3 erste = new Mat3(1, 2, 1,
                              1, 1, 3,
                              1, 4, 2);

        Mat3 zweite = new Mat3(2f,    0f,      -1f,
                                 -0.2f,     -0.2f, 0.4f, 
                                 -0.6f, 0.4f, 0.2f);
        Mat3 Me = new Mat3("e");
        erste.toUnderTriangle();
        erste.show();

    }   

}
