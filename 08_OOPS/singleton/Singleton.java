public class Singleton {

    // when one object is what you need Singleton Class
    private Singleton(){

    }


    private static Singleton instance;

    public static Singleton getInstance() {
        // check whether 1 obj only is created or not
        if (instance == null) {
            instance = new Singleton();
        }
    
        return instance;
    }
}