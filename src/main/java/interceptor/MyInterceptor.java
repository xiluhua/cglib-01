package interceptor;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * 原作者：haodong1024 
 * 来源：CSDN 
 * 原文：https://blog.csdn.net/zhangsweet1991/article/details/83860330 
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 * @author Administrator
 *
 */
public class MyInterceptor implements MethodInterceptor {

	public Object getProxy(Class<?> clzss) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clzss);
		// 设置回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("method: "+method.getName());
		System.out.println("事务开始。。。");
//		Object result = method.invoke(object, args); //死循环，内存溢出
//		Object result = methodProxy.invoke(object, args);//死循环，内存溢出
		Object result = methodProxy.invokeSuper(object, args);
		System.out.println("事务结束。。。");
		return result;
	}
}