package practice.junit;

public class Singleton implements Cloneable{
	
	public static void main(String[] args) {
		Singleton1.getInstance();
	}

}
class Singleton1 {
	private static Singleton1 instance;
	public static synchronized Singleton1 getInstance(){
		if (instance==null){
			instance=new Singleton1();
		}
		return instance;
	}
	
	public static  Singleton1 getInstanceDoubleCheck(){
		if (instance==null){
			//two threads can come here, one waiting one executing
			synchronized(Singleton1.class){
				if (instance==null) {
					instance=new Singleton1();
				}
			}
		}
		return instance;
	}
	
	private static class SingletonHelper {
		private static final Singleton1 instance = new Singleton1();
		public static Singleton1 getInstance(){
			return instance;
		}
	}
	public static Singleton1 getInstanceInnerClass(){
		return SingletonHelper.getInstance();
	}
	private Object readResolve(){
		return getInstance();
	}
	
	public Object clone(){
		try {
			super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
 enum EnumSingleton {

    INSTANCE;
    
    public static void doSomething(){
        //do something
    }
}