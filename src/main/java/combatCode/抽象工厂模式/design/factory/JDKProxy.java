package combatCode.抽象工厂模式.design.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author xbhog
 * @describe:完成代理类，同时对于使用哪个集群有外部通过入参进行传递
 * @date 2022/9/3
 */
public  class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass,ICacheAdapter cacheAdapter) throws Exception{
        //将方法调用分派到的调用处理程序，这里指传递的EGMCacheAdapter/IIRCacheAdapter
        InvocationHandler handler = new JDKInvoicationHandler(cacheAdapter);
        //获得类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //获取对象的类或者接口
        Class<?>[] classes = interfaceClass.getInterfaces();
        Class<?> currentClass = classes[0];
        return (T) Proxy.newProxyInstance(classLoader,new Class[]{currentClass},handler);
    }
}
