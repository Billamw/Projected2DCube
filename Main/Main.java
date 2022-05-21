package Main;

import Body.Cube;
import MathStuff.MatMxM.*;
import MathStuff.VecM.*;
import Main.Draw;
public class Main {
    public static void main(String[] args) {

        Vec3 pos = new Vec3(80,80,80);
        
        Cube cube1 = new Cube(pos, 50);
        float[][] fill = { {1,0,0},
                           {0,1,0} };
        MatN orthProject = new MatN(fill);
        
        

        Mat4 T = new Mat4(1,0,0,pos.x,
                          0,1,0,pos.y,
                          0,0,1,pos.z,
                          0,0,0,1);
        float alpha = 5f;


        Mat3 r = Mat3.rotation(alpha, alpha, alpha);

        Mat4 R = new Mat4(r.m00, r.m01, r.m02, 0, 
                          r.m10, r.m11, r.m12, 0,
                          r.m20, r.m21, r.m22, 0, 
                          0, 0, 0, 1);

        Mat4 TMin = new Mat4(1,0,0,-pos.x,
                             0,1,0,-pos.y,
                             0,0,1,-pos.z,
                             0,0,0,1);

        R.mul(TMin);


        for (int i = 0; i < cube1.toArray().length; i++) {
            cube1.toArray()[i].mul(Mat3.rotationX(alpha));    
           // cube1.toArray()[i].mul(Mat3.rotationZ(alpha));
        }
        Draw.setBackgroundColor(0, 0, 0);
        Draw.init(500,500);

        Draw.setColor(255, 255, 255);    
        for (int i = 0; i < cube1.toArray().length; i++) {
            cube1.toArray()[i].showHor();  
            Draw.filledEllipse(cube1.toArray()[i].mul(orthProject), 5, 5);
        }
    }

}