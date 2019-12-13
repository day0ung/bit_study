package types;

import bomb.Bomb;
import weapon.Weapon;

public interface AbstractItem {
	public Weapon creatWeapon(); //웨폰으로 리턴해줌
	public Bomb createBomb(); //범으로 리턴해줌
}
