package Main;

import Body.Cube;
import MathStuff.MatMxM.*;
import MathStuff.VecM.*;
import Main.Draw;
public class Main {
    public static void main(String[] args) {

        Vec3 pos = new Vec3(250,250,0);
        
        Cube cube1 = new Cube(pos, 50);
        float[][] fill = { {1,0,0},
                           {0,1,0} };
        MatN orthProject = new MatN(fill);
        
        
        cube1.scale(50);
        float alpha = (float)Math.toRadians(45);

        Mat4 T = Mat4.moveMatrix(cube1.pos);
        T.m00 = 0;
        T.m11 = 0;
        T.m22 = 0;

        
        Mat3 r = Mat3.rotationX(alpha);

        Mat4 R = new Mat4(r.m00, r.m01, r.m02, 0, 
                          r.m10, r.m11, r.m12, 0,
                          r.m20, r.m21, r.m22, 0, 
                          0, 0, 0, 1);


        T.add(R);
        Draw.setBackgroundColor(50, 50, 50);
        Draw.init(500,500);
        Draw.setColor(255, 255, 255);  

            
        while(true) {

                for (int i = 0; i < cube1.toArray().length; i++) {
                    Vec4 buff = new Vec4(cube1.toArray()[i]);
                    buff.mul(T);
                    cube1.toArray()[i] = new Vec3(buff);
                    Draw.filledEllipse(cube1.toArray()[i].mul(orthProject), 5, 5);
                    cube1.toArray()[i].showHor();  
            }   

        }
        

    }

}