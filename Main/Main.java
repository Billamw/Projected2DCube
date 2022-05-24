package Main;

import Body.Cube;
import MathStuff.MatMxM.*;
import MathStuff.VecM.*;
import Main.Draw;
public class Main {
    public static void main(String[] args) {

        Vec3 pos = new Vec3(250,250,40);
        
        Cube cube1 = new Cube(pos, 200);
        float[][] fill = { {1,0,0},
                           {0,1,0} };
        MatN orthProject = new MatN(fill);
        
        
        float alpha = (float)Math.toRadians(33);
        
        
        Vec3[] test = new Vec3[8];
        

        Draw.setBackgroundColor(50, 50, 50);
        Draw.init(500,500);
        Draw.setColor(255, 255, 255);  
        Draw.setFps(30);
        
        //Draw.enableDoubleBuffering(true);
        while(true) {
            Mat4 T = Mat4.moveMatrix(cube1.pos);
            Mat3 r = Mat3.rotationX(alpha);
            Mat3 y = Mat3.rotationY(alpha);
            Mat3 z = Mat3.rotationZ(alpha);
            
            Mat4 X = new Mat4(r);
            Mat4 Y = new Mat4(y);
            Mat4 Z = new Mat4(z);
            Y.mul(X);
            //Z.mul(Y);
            T.mul(Y);
            //T.mul(X);
            cube1.scale();

            for (int i = 0; i < cube1.points.length; i++) {
                Vec4 buff = new Vec4(cube1.points[i]);
                buff.mul(T);
                //buff.showHor();
                test[i] = new Vec3(buff);
                //cube1.points[i] = new Vec3(buff);
                // test[i].x/=test[i].z;
                // test[i].y/=test[i].z;

                Draw.filledEllipse(test[i].mul(orthProject), 1, 1);  
                //Draw.filledEllipse(cube1.points[i].mul(orthProject), 5, 5);  
            }   
            Draw.line(new Vec2(test[0]),new Vec2(test[1]));
            Draw.line(new Vec2(test[1]),new Vec2(test[2]));
            Draw.line(new Vec2(test[2]),new Vec2(test[3]));
            Draw.line(new Vec2(test[3]),new Vec2(test[0]));

            Draw.line(new Vec2(test[4]),new Vec2(test[5]));
            Draw.line(new Vec2(test[5]),new Vec2(test[6]));
            Draw.line(new Vec2(test[6]),new Vec2(test[7]));
            Draw.line(new Vec2(test[7]),new Vec2(test[4]));

            Draw.line(new Vec2(test[0]),new Vec2(test[4]));
            Draw.line(new Vec2(test[1]),new Vec2(test[5]));
            Draw.line(new Vec2(test[2]),new Vec2(test[6]));
            Draw.line(new Vec2(test[3]),new Vec2(test[7]));
            alpha += Math.toRadians(3);
        
        Draw.syncToFrameRate();
        Draw.clearScreen();
        
    }
    

    }

}