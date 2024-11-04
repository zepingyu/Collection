package proxy;

import proxy.runtimeProxy.LogHandler;
import proxy.staticExample.UserManagerImplProxy;

import java.util.concurrent.CountDownLatch;

public class ProxyTest {
    public static void main(String[] args) {
//        CountDownLatch
        //静态代理
        UserManager userManager = new UserManagerImplProxy(new UserMangerImpl());
        userManager.addUser("1111", "张三");

        //动态代理
        LogHandler logHandler = new LogHandler();
       // UserManager userManager = (UserManager)logHandler.newProxyInstance(new UserMangerImpl());
        userManager.addUser("1111", "张三");
    }
}
