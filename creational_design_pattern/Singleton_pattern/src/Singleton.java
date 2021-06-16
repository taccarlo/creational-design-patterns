class uniqueObject {
    private static uniqueObject  instance = null;
    private uniqueObject(){ }
    public static synchronized uniqueObject getUniqueObject(){
        if(instance == null) {
            System.out.println("First uniqueObject construction.");
            instance = new uniqueObject();
        }
        else{
            System.out.println("uniqueObject construction passing instance already existing.");
        }
        return instance;
    }
}
/**
 *  Ensure a class has only one instance, and provide a global point of access to it.
 *  In this example I create the object a lot of times, in the first the getUniqueObject() call the constructor and
 *  in the next ones getUniqueObject() use the past used instance.
 */
public class Singleton {
    public static void main(String[] args) {
        uniqueObject.getUniqueObject();
        uniqueObject.getUniqueObject();
        uniqueObject.getUniqueObject();

    }
}