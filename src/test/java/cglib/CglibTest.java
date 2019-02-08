package cglib;
import interceptor.MyInterceptor;
import service.Shop;

public class CglibTest {

	public static void main(String[] args) {
		
		MyInterceptor interceptor = new MyInterceptor();
		Shop shop = (Shop) interceptor.getProxy(Shop.class);
		
		
		
		shop.buy();
	}


}
