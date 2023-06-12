// this is why we need interface to solve the problem od=f a cll of method depend on the what you pass in the method

class Desktop {
    public void appDev() {
        System.out.println("code, compile, run fster");
    }
}
class Laptop {
    public void code(){
        System.out.println("code, compile, run");
    }
}

class Developer{
    public void appDev(Laptop lap){
        lap.code();

        //System.out.println("code...");
    }
}

public class InterfaceExample {
     public static void main(String[] args) {
     
     Desktop desk = new Desktop();
     Laptop lap = new Laptop();
     Developer dev = new Developer();
     dev.appDev(lap);

     //dev.appDev(lap); for this to work you need to pass the Desktop object in the developer class method 

     
     

    }
}
