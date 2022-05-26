package MathStuff.MatMxM;

public class Mat2 {

    public float m00, m01,
                 m10, m11;

    public Mat2(float m00, float m01, float m10, float m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }
    
    public float determinante() {
        return this.m00*this.m11-this.m10*this.m01;
    }
}
