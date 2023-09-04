
package Main;

import MathStuff.MatMxM.*;

public class test {
    public static void main(String[] args) {
        Mat4 a = new Mat4(0, -1, 0, 1,
                          1, 0, 0, 0,
                          0, 0, 1, 2,
                          0, 0, 0, 1);
        a.inverse();

        a.show();
    }
}
