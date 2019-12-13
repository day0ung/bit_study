package observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer{
//마이클래스에 변화가 생기면 마이클래스메소드의 노티피옵저버스를 통해서 이곳에 변화가 옴

	@Override
	public void update(Observable o, Object arg) {
		String str = (String)arg;
		System.out.println("감시자 A입니다 통지를 받았음: "+ str);
		
	} //감시자

}
