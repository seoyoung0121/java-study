package creational.singleton;

public class Singleton {
	private Singleton() { //바깥에서 new 못
	}
	private static Singleton instance = null;
	   

   public static Singleton getInstance() {
      if(instance == null) {
         instance = new Singleton();
      }
      return instance;
   }
}
