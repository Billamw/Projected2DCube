package Main;

import Body.Body;
import Body.Cube;
import Body.Pyramide;
import MathStuff.MatMxM.*;
import MathStuff.VecM.*;
import Main.Draw;
public class Main {
    public static void main(String[] args) {

        int width = 500, height = 500;

        Vec3 pos = new Vec3(250,250,250);
        Vec3 pos1 = new Vec3(250,250,0);
        
        Cube cube1 = new Cube(pos, 200);
        Pyramide pyr = new Pyramide(pos1, 200);
        
        init(width, height);
        

        float mouseAngleX = (float)Math.toRadians(30);
        float mouseAngleY = (float)Math.toRadians(30);

        float mouseAngleZ = 0;

        float currentY = 0, oldY = 0;
        float currentX = 0, oldX = 0;
        float lastangleX = 0;
        float lastangleY = 0;
        float m = 0;
        Vec3 moveVecX = new Vec3(8, 0, 0);
        Vec3 moveVecY = new Vec3(0, 8, 0);
        Vec3 moveBuff = new Vec3();
        Vec3 up = new Vec3(0, 1, 0);
        Vec3 right = new Vec3(1, 0, 0);
        Vec3 eye = new Vec3(1000, 250, -100);

        Mat4 P, T, X, Y, Z, V, M = new Mat4();
        Mat4 MVP = new Mat4();

        while(true) {

            P = Mat4.projectionMatrix(width); // muss noch in die draw rein
            T = Mat4.translationMatrix(pos);    
            X = new Mat4(Mat3.rotationX(mouseAngleY));
            Y = new Mat4(Mat3.rotationY(mouseAngleX));
            Z = new Mat4(Mat3.rotationZ(mouseAngleZ));
            V = Mat4.lookAt(eye, pos, up);
            

            
            M = T.mul(X).mul(Y);
            MVP = P.mul(V).mul(M); // funktioniert gerade nur verkehrt herum
            
            


            draw(cube1, MVP);

            draw(pyr, MVP);
                

            if(Draw.getLastPressedKey() == 0x44) { //d key
                eye.x += 30;
            }
            if(Draw.getLastPressedKey() == 0x41) { // a key
                eye.x -= 30;
            }
            if(Draw.getLastPressedKey() == 0x57) { // w key
                eye.y -= 30;
            }
            if(Draw.getLastPressedKey() == 0x53) { // s key
                eye.y += 30;
            }

            if(Draw.getLastPressedKey() == 0x27 ) { //left key
                pos.x += 20;
            }

            if(Draw.getLastPressedKey() == 0x25) { // right key
                pos.x -= 20;
            }

            if(Draw.getLastPressedKey() == 0x26) { // up key
                pos.y -= 20;
            }

            if(Draw.getLastPressedKey() == 0x28) { // down key
                pos.y += 20;
            }


            if(Draw.isLeftMouseButtonPressed()) {
                mouseAngleX = (float)Math.toRadians((Draw.getMouseY() - 0) * (180 - (-180)) / (  0   - height) -180);
                mouseAngleY = (float)Math.toRadians((Draw.getMouseX() - 0) * (180 - (-180)) / (width -   0   ) -180);

                currentY = Draw.getMouseY();
                currentX = Draw.getMouseX();
                m = (currentY - oldY) / (currentX - oldX); // möchte mit strg einfügen, dass es eine achse fix nimmt. Und um zu bestimmen welche er fix nehmen soll, bestimme ich m.
                oldX = currentX;
                oldY = currentY;

            }

            if(Draw.isLeftMouseButtonPressed() && Draw.getLastPressedKey() == 0x11) { // pribere Z achse zu fixen hier
                mouseAngleZ += Math.toRadians(2);
            }

            Draw.syncToFrameRate();
            Draw.clearScreen();
                
        }
            
            
    }

        public static void init(int width, int height) {
            Draw.setBackgroundColor(50, 50, 50);
            Draw.init(width,height);
            Draw.setColor(255, 255, 255);  
            Draw.setFps(30);
        }
        
        public static void draw(Body body, Mat4 a) {
            Vec2[] newPoints = new Vec2[8];
            body.scale();
            
            for (int i = 0; i < body.getPoints().length; i++) {
                Vec4 buff = new Vec4(body.getPoints()[i]);
                buff.mul(a);
                newPoints[i] = new Vec2(buff);    
            }
            body.connectPoints(newPoints);
        }
    }