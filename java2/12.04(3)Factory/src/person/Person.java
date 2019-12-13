package person;

import bomb.Bomb;
import types.AbstractItem;
import weapon.Weapon;

public class Person { //팩토리
	public Weapon m_Weapon; //밖에서 바로 접근할 수 있도록 public원래 게터세터만들어야
	public Bomb m_Bomb;
	
	public void create(AbstractItem aw) {
		m_Weapon = aw.creatWeapon();
		m_Bomb = aw.createBomb(); //생성되서 멤버변수까지 들어감
	}

	public Weapon getM_Weapon() {
		return m_Weapon;
	}

	public Bomb getM_Bomb() {
		return m_Bomb;
	}
	
}
