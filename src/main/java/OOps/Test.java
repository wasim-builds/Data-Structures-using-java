package OOps;
interface printable{
    void print();
}
interface danced{
    void dance();
}


public class Test implements printable,danced {
    print void print();
    System.out.println("print");
    
}
print void dance();
System.out.println("dance");

public static void main(String args[]){
    Test t=new Test();
    t.print();
    t.dance();
}
