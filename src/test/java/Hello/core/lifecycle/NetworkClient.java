package Hello.core.lifecycle;


import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Getter
@Setter
public class NetworkClient {
    private String url;
    public NetworkClient(){
        System.out.println("생성자 호출  URL = " + url);
        connect();
        call("초기화 연결 메세지");
    }
    public void connect(){
        System.out.println("Connect" + url);
    }
    public void call(String message){
        System.out.println("call" + url + "/" + message);
    }

    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    public void disconnect(){
        System.out.println("Close !!!" + url);
    }

    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
