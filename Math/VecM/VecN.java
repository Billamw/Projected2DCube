package Math.VecM;

public class VecN {

    public float[] arr;

    public VecN() {}


    public VecN(float... arr ) {
        this.arr = arr;
    }

    public VecN(int size) {
        this.arr = new float[size];
    }

    public VecN add(VecN Vright) {
        if(this.arr.length != Vright.arr.length) System.err.println("Cannot add this two vectors.");

        for (int i = 0; i < arr.length; i++) {
            this.arr[i] += Vright.arr[i];
        }

        return this;
    }

    public VecN sub(VecN Vright) {
        if(this.arr.length != Vright.arr.length) System.err.println("Cannot sub this two vectors.");

        for (int i = 0; i < arr.length; i++) {
            this.arr[i] -= Vright.arr[i];
        }

        return this;
    }

    public static void main(String[] args) {
        float[] testArr = {1,2,4,6,3};
        VecN test = new VecN(testArr);
        test.add(test);
    }
    
}
