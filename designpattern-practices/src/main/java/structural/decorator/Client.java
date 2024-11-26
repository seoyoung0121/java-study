package structural.decorator;

public class Client {

	public static void main(String[] args) {
		System.out.println(new ConcreteComponent("HelloWorld").operation());
		System.out.println(new ParenthesesDecorator(new ConcreteComponent("HelloWorld")).operation());
		System.out.println(new BraceDecorator(new ConcreteComponent("HelloWorld")).operation());
		System.out.println(new BraceDecorator(new ParenthesesDecorator(new ConcreteComponent("HelloWorld"))).operation());
		
//		Component c1= new ConcreteComponent("HelloWorld");
//		Component c2 = new ParenthesesDecorator(c1);
//		Component c3 = new BraceDecorator(c2);
//		System.out.println(c3.operation());
		
		// decorator가 보조 스트림
		// concrete가 주 스트림
		
	}

}
