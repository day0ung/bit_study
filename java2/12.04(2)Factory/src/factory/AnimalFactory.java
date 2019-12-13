package factory;

import animal.Animal;
import animal.Cat;
import animal.Cow;
import animal.Dog;

public class AnimalFactory {
	//클래스를 생성안하고 직접부르는게편함 그럴땐 static
	
	public static Animal creat (String animalName) { //부모 인터페이스가 리턴값임
		
		if(animalName.equals("")) {
			System.out.println("생성할 클래스가 없습니다.");
		}
		
		if(animalName.equals("냥이")) {
			return new Cat();
		}
		else if(animalName.equals("댕댕이")){
			return new Dog();
		}
		else if(animalName.equals("황소")) {
			return new Cow();
		}
		return null;
		
	}
}
