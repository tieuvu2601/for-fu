
public class AppTest {
    private static TestProcess instance = null;

    public static void main(String[] args) {
        getInstance().run();
    }

    public static TestProcess getInstance(){
        if(instance == null){
            instance = new TestProcess();
        }
        return instance;
    }
}
