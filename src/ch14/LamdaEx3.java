package ch14;

@FunctionalInterface
interface MyFuntion3{
	void myMethod();
}

class Outer{
	int val = 10;	//Outer.this.val
	
	class Inner{
		int val = 20;	//this.val
		
		//람다식내에서 참조하는 지역변수는 final이 붙지 않았어도 상수로 간주된다.
		void method(int i) { //		void method(final int i)
			int val = 30;	//final int val = 30;
//			i = 10;		에러 : 상수값은 변경할 수 없다.
			
			MyFuntion3 f = () -> {		//(i) -> 에러 발생함 외부 지역변수와 중복된 이름 사용 불가
				System.out.println("i : "+i);
				System.out.println("val : "+val);
				System.out.println("this.val : "+ ++this.val);
				System.out.println("Outer.this.val : "+ ++Outer.this.val);
			};
			f.myMethod();
		}
	}
}

public class LamdaEx3 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method(100);
	}

}
