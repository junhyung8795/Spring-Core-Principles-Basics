package hello.core.singleton;

public class SingletonService {
    //자기 자신을 내부에 static으로 클래스 레벨에 딱 하나만 존재하게끔 한다.
    private static final SingletonService instance = new SingletonService();
    public static SingletonService getInstance() {
        return instance;
    }
    private SingletonService() {
    }

    public void login(){
        System.out.println("싱글톤 로직 호출");
    }
}
