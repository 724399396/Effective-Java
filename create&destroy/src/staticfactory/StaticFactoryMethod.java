package staticfactory;

public class StaticFactoryMethod {
	public static Boolean valueOf(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
	}
	
	public static void main(String[] args) {
		System.out.println((valueOf(true).getClass()));
	}
}
