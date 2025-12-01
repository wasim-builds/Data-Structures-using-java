package OOps;
//21mis7125
interface MathOperation {
    static int add(int a, int b) {
        return a + b;
    }
}

class Calculator implements MathOperation {
    public int add(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        
        int result1 = MathOperation.add(5, 3);
        System.out.println("Using interface static method: " + result1);

        Calculator calc = new Calculator();
        int result2 = calc.add(10, 7);
        System.out.println("Using class method: " + result2);
    }
}
