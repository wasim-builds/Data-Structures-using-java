package Matrix;
class A{
    static int b=100;
}
public class Apps {
    static int a=100;
    public static void main(String args[]){
        System.out.println(a);
        System.out.println(A.b);
        A ob = new A();
        System.out.println(ob.b);
    }
    
}
