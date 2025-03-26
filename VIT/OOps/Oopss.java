package OOps;

class Pen{
    String color;
    String type;
    public void write(){
        System.out.println("writing something");
    }
    public void printColor(){
        System.out.println(this.color);
    }
}

public class Oopss {
    public static void main(String[] args) {
        Pen pen1 = new Pen();
        pen1.color = "blue";
        pen1.type="gel";
        pen1.write();
        
        Pen pen2 = new Pen();
        pen2.color="black";
        pen2.type="ballpoint";
        pen1.printColor();
        pen2.printColor();
    }
    
}
