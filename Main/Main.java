package Main;

import Body.Cube;
import MathStuff.MatMxM.*;
import MathStuff.VecM.*;
public class Main {
    public static void main(String[] args) {
        
        Cube cube1 = new Cube(new Vec3(40,40,40), 50);
        float[][] fill = { {1,0,0},
                           {0,1,0} };
        MatN orthProject = new MatN(fill);
        

        float alpha = 5f;

       //cube1.a.mul(Mat3.rotationX(5));


        for (int i = 0; i < cube1.toArray().length; i++) {
            cube1.toArray()[i].mul(Mat3.rotationX(alpha));  
        }
        for (int i = 0; i < cube1.toArray().length; i++) {
            cube1.toArray()[i].showHor();  
             
        }
    }

}
