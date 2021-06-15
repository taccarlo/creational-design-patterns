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
public class Singleton {
    public static void main(String[] args) {
        uniqueObject.getUniqueObject();
        uniqueObject.getUniqueObject();
        uniqueObject.getUniqueObject();

    }
}