package combatCode.抽象工厂模式.design.factory;

import combatCode.抽象工厂模式.design.utils.ClassLoaderUtils;
import sun.misc.ClassLoaderUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xbhog
 * @describe:
 * @date 2022/9/3
 */
public class JDKInvoicationHandler implements InvocationHandler {
    private ICacheAdapter cacheAdapter;

    public JDKInvoicationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ICacheAdapter.class.
                getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args))
                .invoke(cacheAdapter,args);
    }
}
