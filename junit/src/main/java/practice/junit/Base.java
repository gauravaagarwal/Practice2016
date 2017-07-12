package practice.junit;

public abstract class Base {

	public Base() {
		print();
	}

	public abstract void print();
	
	public static void main(String[] args) {

		/*Base base = new Derived();
		base.print();*/
		
		int number=4;
		int x = (int) Math.sqrt(number);
		StringBuilder sb = new StringBuilder();
		for (Integer i=number ;i>0;i--){
			sb.insert(0,i);
			if (i%x==1) {
				System.out.println(sb.toString());
				sb = new StringBuilder();
			}
		}

	}
}

class Derived extends Base {

	int intvariable = 10;

	public Derived() {
	}

	public void print() {
		System.out.println(intvariable);
	}

	
}
