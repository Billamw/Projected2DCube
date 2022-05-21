package MathStuff.MatMxM;

import MathStuff.dynamic2DArray;

public class MatN {

    public float[][] M;
    //public int row = M.length;
    //public int column = M[0].length;

    public MatN () {}
    public MatN (int row, int column) {
        this.M = new float[row][column];
    }
    public MatN(float[][] arr) {
        this.M = arr;
    }

    //private static MatN Mbuffer = new MatN();

    public String size() {
        int row = this.M.length;
        int column = this.M[0].length;
        String size = row + "x" + column;
        return size;
    }

    public MatN clone(MatN M) {
        for (int i = 0; i < this.M.length; i++) {
            for (int j = 0; j < this.M[i].length; j++) {
                this.M[i][j] = M.M[i][j];
            }
        }
        return this;
    }

    public MatN fill(float[][] arr) {
        for (int i = 0; i < this.M.length; i++) {
            for (int j = 0; j < this.M.length; j++) {
                this.M[i][j] = arr[i][j];
            }
        }
        return this;
    }

    public MatN round(int places) {
        float fac = (float) Math.pow(10, places);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.M[i][j] = Math.round(this.M[i][j]*fac)/fac;
            }
        }
        return this; 
    }

    public float determinante() {
        
        if(this.M.length!= this.M[0].length) System.err.println("There is no Derterminante");

        return determinLaplace(this);
    }

    private static float determinLaplace(MatN M) {
        float det = 0;
        if(M.M.length==1) return M.M[0][0];
        if(M.M.length==2) return M.M[0][0]*M.M[1][1]-M.M[0][1]*M.M[1][0];

        int plusMinus = 1;
        MatN detMat = new MatN(M.M.length-1, M.M[0].length-1);
        
            for (int i = 0; i < M.M.length; i++) {
                dynamic2DArray arrBuffer = new dynamic2DArray(M.M);
                
                if(i%2!=0) plusMinus = -1;
                else plusMinus=1;

                detMat.M = arrBuffer.removeArrayRow(0).removeArrayColumn(i).arr;
                detMat.show();

                det += plusMinus * M.M[0][i] * determinLaplace(detMat);                    
            }
        return det;
    }


    public MatN add(MatN Mright){
        if(!this.size().equals(Mright.size())) System.err.println("Cannot add these Matrixes!");

        for (int i = 0; i < this.M.length; i++) {
            for (int j = 0; j < this.M[0].length; j++) {
                this.M[i][j] += Mright.M[i][j];
            }
        }
        return this;
    }

    public MatN sub(MatN Mright){
        if(!this.size().equals(Mright.size())) System.err.println("Cannot sub these Matrixes!");

        for (int i = 0; i < this.M.length; i++) {
            for (int j = 0; j < this.M[0].length; j++) {
                this.M[i][j] -= Mright.M[i][j];
            }
        }
        return this;
    }

    public MatN mul(float val){

        for (int i = 0; i < this.M.length; i++) {
            for (int j = 0; j < this.M[0].length; j++) {
                this.M[i][j] *= val;
            }
        }
        return this;
    }

    public MatN mul(MatN Mright) {
        if(this.M[0].length!= Mright.M.length) System.err.println("Cannot multiply these Matrixes!");

       MatN result = new MatN(this.M.length, Mright.M[0].length);
        for (int i = 0; i < this.M.length; i++) {
            for (int j = 0; j < Mright.M[0].length; j++) {
                for (int j2 = 0; j2 < this.M[0].length; j2++) {
                    result.M[i][j] += this.M[i][j2] * Mright.M[j2][j];
                }
            }
        }

        return result;
    }

    public void show(){
        for (int i = 0; i < this.M.length; i++) {
            for (int j = 0; j < this.M[0].length; j++) {
                if(j< M[0].length-1) System.out.print(this.M[i][j] + ", ");
                else System.out.print(this.M[i][j]);
            }
            System.out.println();   
        }
        System.out.println();
    }
    public static void main(String[] args) {
        //1, 2, 1, 1, 1, 3, 1, 4, 2)
        //(2f, 0f, -1f, -0.2f, -0.2f, 0.4f, -0.6f, 0.4f, 0.2f);
        float[][] efill = new float[3][3];
        efill[0][0]=1;     efill[0][1]=2;     efill[0][2]=1;
        efill[1][0]=1;     efill[1][1]=1;     efill[1][2]=3;
        efill[2][0]=1;     efill[2][1]=4;     efill[2][2]=2;

        float[][] testFill = {
            {1, 2, 1},
            {1, 3, 1},
            {1, 4, 2}
        };
        testFill.clone();
        
        float[][] zfill = new float[3][3];
        zfill[0][0]=2;     zfill[0][1]=0;     zfill[0][2]=-1;
        zfill[1][0]=-0.2f; zfill[1][1]=-0.2f; zfill[1][2]=0.4f;
        zfill[2][0]=-0.6f; zfill[2][1]=0.4f;  zfill[2][2]=0.2f;

        float[][] unitfill = new float[3][3];
        unitfill[0][0]=1;     unitfill[0][1]=0;     unitfill[0][2]=0;
        unitfill[1][0]=0;     unitfill[1][1]=1;     unitfill[1][2]=0;
        unitfill[2][0]=0;     unitfill[2][1]=0;     unitfill[2][2]=1;
        
        MatN erste = new MatN(3, 3);
        MatN zweite = new MatN(3, 3);


        erste.fill(efill); zweite.fill(zfill);
        //erste.show();
        //zweite.show();
        //erste.mul(zweite).round(2).show();

        //plusMinus.determinante();

        float[][] detFill = new float[4][4];
        detFill[0][0]=  3; detFill[0][1]= 1; detFill[0][2]=  5; detFill[0][3]=  1;
        detFill[1][0]= -1; detFill[1][1]= 0; detFill[1][2]= -2; detFill[1][3]=  0;
        detFill[2][0]=  0; detFill[2][1]= 0; detFill[2][2]=  1; detFill[2][3]= -1;
        detFill[3][0]=  4; detFill[3][1]= 0; detFill[3][2]=  4; detFill[3][3]=  1;

        MatN detTry = new MatN(detFill);
        detTry.show();
        float det = detTry.determinante();
        System.out.println(det);
        
    }
}