package oops;

class AshishException extends Exception{
    public AshishException(String s){
        super(s);
    }
}

// throws is used after methods for the methods which can throw exception and this is then handled by the parent method
// which calls the methods

class ThrowsException{
    public void show() throws ClassNotFoundException{
        Class.forName("Jingalalahu");
    }
}

public class ExceptionHandling {
    public static void main(String[] args){
        int i = 2;
        int j = 0;

        try{
            if(j==0)
                throw new AshishException("You are messing up. Inder lodu hai.");
            int result = i/j;
        } catch (AshishException e) {
            System.out.println(e);
        }
        System.out.println();
        ThrowsException th = new ThrowsException();
        try {
            th.show();
        } catch (ClassNotFoundException e){
            System.out.println(e);
        }
    }
}
