package Main;

import Body.Cube;
import Body.Pyramide;
import MathStuff.MatMxM.*;
import MathStuff.VecM.*;
import Main.Draw;
public class Main {
    public static void main(String[] args) {

        Vec3 pos = new Vec3(250,250,180);
        Vec3 pos1 = new Vec3(400,300,90);
        
        Cube cube1 = new Cube(pos, 200);
        Pyramide pyr = new Pyramide(pos1, 200);
        float[][] fill = { {1,0,0},
                           {0,1,0} };
        MatN orthProject = new MatN(fill);
        
        
        float alpha = (float)Math.toRadians(0);
        float beta = (float)Math.toRadians(0);
        
        
        Vec2[] test = new Vec2[8];
        

        Draw.setBackgroundColor(50, 50, 50);
        Draw.init(500,500);
        Draw.setColor(255, 255, 255);  
        Draw.setFps(30);
        
        //Draw.enableDoubleBuffering(true);
        while(true) {
            
            Mat4 V = Mat4.ViewMatrix(250, 0, 500, 500);
            Mat4 T = Mat4.moveMatrix(cube1.pos);
            Mat3 r = Mat3.rotationX(alpha);
            Mat3 y = Mat3.rotationY(beta);
            Mat3 z = Mat3.rotationZ(alpha);
            
            Mat4 X = new Mat4(r);
            Mat4 Y = new Mat4(y);
            Mat4 Z = new Mat4(z);
            Y.mul(X);
            //Z.mul(Y);
            T.mul(Y);
            V.mul(T);
            // X.mul(Y);
            // T.mul(X);

            cube1.scale();

            for (int i = 0; i < cube1.points.length; i++) {
                Vec4 buff = new Vec4(cube1.points[i]);
                buff.mul(V);
                test[i] = new Vec2(buff);
            
                Draw.filledEllipse(test[i], 1, 1);    
            }   
            cube1.connectPoints(test);

            T = Mat4.moveMatrix(cube1.pos);
            Y.mul(X);
            //Z.mul(Y);
            T.mul(Y);
            
                
            // pyr.scale();
            // for (int i = 0; i < pyr.points.length; i++) {
            //     Vec4 buff = new Vec4(pyr.points[i]);
            //     buff.mul(V);
            //     test[i] = new Vec2(buff);

            //     Draw.filledEllipse(test[i], 1, 1);   
            // }   
            // pyr.connectPoints(test);


            alpha += Math.toRadians(3);
            beta += Math.toRadians(6);
            
            Draw.syncToFrameRate();
            Draw.clearScreen();
        
    }
    

    }

}