package g_package;

public class Item {// 대미지 변수는 플레이어에게 넣고, 자식 클래스를 아이템으로, 부모 클래스를 플레이어로 한다.
	// 무기
	int damage;    //대미지
	String weaponName;   //무기 이름
	String armorName;    //방어구 이름
	double skill;        //스킬 대미지
	int armorHp;         //방어구 성능
	String potionName;   //포션이름
	int hpHeal,spHeal;    //포션으로 회복시킬 체력과 마나 설정
	
	
	// 상점 페이지에서 구매 완료후 웨폰 셋 함수를 발동시킬 것임
	// 무기( 무기이름과 대미지,가격, 방어구이름과 방어구 에이치피,가격, 포션 이름과 효과, 가격을 배열을 이용해서 호출하기 쉽게 만든다. )

	String[] weapon = { "단검", "장검", "짱쎈검" };
	String[] weaponD= {"200~240","300~360","500~600"};
	int[] weaponPay= {10000,20000,30000};
	String[] armor = { "천 쪼가리", "철 쪼가리", "왕의 갑옷" };
	String[] armorH = {"4000","5000","7000",""};
	int[] armorPay= {10000,18000,25000};
	String[] potion = { "빨간약", "파란약" };
	String[] potionH = {"체력 1000 회복","스킬사용횟수 +1"};
	int[] potionPay= {1000,1000};

	//웨폰셋이라는 보이드값 메소드를 만들어서
	//데미지와 스킬 데미지를 설정.  후에 작용할수 있도록 한다.

	void weaponSet(String weaponName) {
		switch (weaponName) {
		case "기본(맨주먹)": {
			damage = ((int) (Math.random() * 120) + 1) + 80;
			skill = damage + (damage * 0.5);
			break;
		}
		case "단검": {
			damage = ((int) (Math.random() * 240) + 1) + 200;
			skill = damage + (damage * 0.7);
			break;
		}
		case "장검": {
			damage = ((int) (Math.random() * 360) + 1) + 300;
			skill = damage + (damage * 0.8);
			break;
		}
		case "짱쎈검": {
			damage = ((int) (Math.random() * 600) + 1) + 500;
			skill = damage + (damage * 1);
			break;
		}
		}

	}

	// 방어구 셋으로
	//방어구 또한 마찬가지로 이름과 성능을 후에 대입시킬 수 있도록 한다.
	void armorSet(String armorName) {
		switch (armorName) {
		case "기본(맨피부)": {
			armorHp = 0;
			break;
		}
		case "천 쪼가리": {
			armorHp = 4000;
			break;
		}
		case "철 쪼가리": {
			armorHp = 5000;
			
			break;
		}
		case "왕의 갑옷": {
			armorHp = 7000;
			break;
		}
		}
	}

	// 물약 셋으로 
	//물약효과를 후에 적용하기 쉽게 만들어 준다.
	void setPotion(String potionName) {
		switch (potionName) {
		case "red": {
			hpHeal = 1000;
			// 최대채력을 못넘기게 해야함
			break;
		}
		case "blue": {
			spHeal = 1;
			// 스킬최대사용횟수를 못넘기게 해야함
			break;
		}
		}
	}

}
