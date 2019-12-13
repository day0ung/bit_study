
public class GenericClass {
	public static void main(String[] args) {
		/*
		 *  Generic == template
		 *  
		 */
		
		//<> 안에 wrapperClass 를 넣어야함 일반자료형을 안됨
		Box<Integer> box = new Box<Integer>(234);
		System.out.println(box.getTemp());
		
		Box<String> sbox = new Box<String>("my world");
		System.out.println(sbox.getTemp());
		
		BoxMap<Integer, String> bm 
		  			= new BoxMap<Integer,String>(123, "hi hello");
		System.out.println(bm.getKey());
		System.out.println(bm.getValue());
		
	}

}

// Generic == 자료형의 변수
//자료형을여러개써야하는데 무엇을넣을지 모를때 <>씀 결정을 나중에내려줌
class Box<T>{
	T temp;
	
	//생성자 
	//T ==다 Integer가 된것임
	public Box(T temp) {
		this.temp = temp;
	}

	public T getTemp() {
		return temp;
	}

	public void setTemp(T temp) { 
		this.temp = temp;
	}

}

class BoxMap<K, V>{
	K key;
	V value;

	
	//생성자
	public BoxMap(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}


	public K getKey() {
		return key;
	}


	public void setKey(K key) {
		this.key = key;
	}


	public V getValue() {
		return value;
	}


	public void setValue(V value) {
		this.value = value;
	}
	
	
	
}