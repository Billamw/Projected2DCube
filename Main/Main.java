package Main;

import Body.Cube;
import MathStuff.MatMxM.*;
import MathStuff.VecM.*;
public class Main {
    public static void main(String[] args) {
        
        Cube cube1 = new Cube(new Vec3(40,40,40), 50);
        MatN orthProject = new MatN(2,3);
        float[][] fill = { {1,0,0},
                           {0,1,0} };
        orthProject.fill(fill);

        cube1.a.mul(Mat3.rotationX(5));
        for (int i = 0; i < cube1.toArray().length; i++) {
            cube1.toArray()[0].mul(5);
            
        }

    }
}
