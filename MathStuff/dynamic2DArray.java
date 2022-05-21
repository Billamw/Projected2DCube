package MathStuff;

public class dynamic2DArray {

    public float[][] arr;

    public dynamic2DArray() {}

    public dynamic2DArray(float[][] arr){
        this.arr = arr;
    }

    public dynamic2DArray toDynamicArray() {
        dynamic2DArray array = new dynamic2DArray(this.arr);
        return array;
    }
    private static dynamic2DArray arrayBuffer = new dynamic2DArray();

    private dynamic2DArray clone(dynamic2DArray Array) {
        this.arr = Array.arr;
        return this;
    }
    /**
     * Counting starts by 0;
     */
    public dynamic2DArray removeArrayRow(int row) {
        if ( row > this.arr.length-1) {
        System.err.println("Row is not existing!");
        return this;
        }

        arrayBuffer.arr = this.arr;
        this.arr = new float[arrayBuffer.arr.length-1][arrayBuffer.arr[0].length];
        //float[][] result = new float[this.arr.length-1][this.arr[0].length];
        for (int i = 0; i < arrayBuffer.arr.length-1; i++) {
            if(i<row)   this.arr[i] = arrayBuffer.arr[i];
            else        this.arr[i] = arrayBuffer.arr[i+1];
            
        }       
        
        return this;
    }

    public dynamic2DArray removeArrayRowBuff(int row) {
        if ( row > this.arr.length-1) {
        System.err.println("Row is not existing!");
        return this;
        }

        arrayBuffer.arr = new float[this.arr.length-1][this.arr[0].length];
        //float[][] result = new float[this.arr.length-1][this.arr[0].length];
        for (int i = 0; i < arrayBuffer.arr.length-1; i++) {
            if(i<row)   arrayBuffer.arr[i] = this.arr[i];
            else        arrayBuffer.arr[i] = this.arr[i+1];
            
        }       
        
        return arrayBuffer;
    }


    public dynamic2DArray removeArrayColumn(int columm) {
        if ( columm > this.arr[0].length-1) {
            System.err.println("Column is not existing!");
            return this;
        }

        arrayBuffer.clone(this);
        this.arr = new float[arrayBuffer.arr.length][arrayBuffer.arr[0].length-1];
        //float[][] result = new float[this.arr.length-1][this.arr[0].length];
        for (int i = 0; i < arrayBuffer.arr[0].length-1; i++) {
            for (int j = 0; j < arrayBuffer.arr.length; j++) {
                
            if(i<columm)   this.arr[j][i] = arrayBuffer.arr[j][i];
            else           this.arr[j][i] = arrayBuffer.arr[j][i+1];
            
            }
        }    
        
        return this;
    }

    public dynamic2DArray removeArrayColumnBuff(int columm) {
        if ( columm > this.arr[0].length-1) {
            System.err.println("Column is not existing!");
            return this;
        }

        arrayBuffer.arr = new float[this.arr.length][this.arr[0].length-1];
        //float[][] result = new float[this.arr.length-1][this.arr[0].length];
        for (int i = 0; i < this.arr[0].length-1; i++) {
            for (int j = 0; j < this.arr.length; j++) {
                
            if(i<columm)   arrayBuffer.arr[j][i] = this.arr[j][i];
            else           arrayBuffer.arr[j][i] = this.arr[j][i+1];
            
            }
        }    
        
        return arrayBuffer;
    }

    public void show() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        float[][] test = new float[4][4];
        float[] one = {3, 5 ,6 ,8};
        float[] two = {2, 4 ,9 ,0};
        float[] three = {5, 7 ,4 ,3};
        float[] four = {7, 1 ,2 ,9};

        test[0] = one;
        test[1] = two;
        test[2] = three;
        test[3] = four;


        dynamic2DArray erste = new dynamic2DArray(test);
        erste.show();
        //erste.removeArrayColumn(0).show();

    }
}
