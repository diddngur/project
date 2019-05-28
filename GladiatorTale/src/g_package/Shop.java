package g_package;

import java.util.Scanner;

public class Shop extends Item {
	Scanner shopScan = new Scanner(System.in);// 스케너

	int choice; // 입력값 변수
	boolean shoprun = true; // 상점전체반복문을 위한 변수
	boolean shoprun2; // 선택을 위한 반복문
	boolean shoprun3; // 2번째 선택화면 반복문을 위한 변수

	String playerArmor;    //플레이어의 방어구(아이템에서 설정한 방어구들을 대입시키기위해 존재)
	String playerWeapon;   //플레이어의 무기 (아이템에서 설정한 무기들을 대입시켜주기 위해 존재) 
	int playerMoney;       //플레이어 머니 (여기 저기에서 입력받은 돈을 저장하기 위한 변수)
	int spPotion;          //마나물약
	int hpPotion;          //체력 물약
	
	//변수들을 생성자로 지정해서 다중 클래스에서 입력받은값을 바로바로 저장할 수 있도록 해준다.
	Shop(String playerArmor, String playerWeapon, int playerMoney, int spPotion, int hpPotion) {
		this.playerArmor = playerArmor; // 방어구
		this.playerWeapon = playerWeapon; // 무기
		this.playerMoney = playerMoney; // 돈
		this.spPotion = spPotion; // 파란약
		this.hpPotion = hpPotion; // 빨간약
	}

	Item it = new Item(); // 아이템 클래스를 객체화

//------------------------------------------------------------------------------------------------------------------	
//상점에 들어왔을떄 문구 	
	void comingShop() {
		System.out.println("당신은 짤랑거리는 금화주머니를 만지작 거리며 낡아보이는 상점에 들어갑니다. ");
		while (shoprun) {//1반복 
			System.out.println("");
			System.out.println("$$$$$$$$$$$$$$$'상점에 온것을 환영합니다. 맘에드는 물건을 골라보세요.'$$$$$$$$$$$$$$$");
			System.out.println("$$               $$                $$               $$            $$");
			System.out.println("$$ 1 무기를 둘러본다. $$ 2 방어구를 둘러본다. $$ 3 물약을 둘러본다. $$  4 상점나가기. $$");
			System.out.println("$$               $$                $$               $$            $$");
			System.out.println("$$$$$$$$$$$$$$$$$상점주인이 당신의 금화주머니를 뚫어저라 처다본다.$$$$$$$$$$$$$$$$$$$");
			System.out.println("\t---현재 당신이 소유한 골드 : " + playerMoney + " GOLD---");
			System.out.print("선택 : ");
			choice = shopScan.nextInt();// 초이스 값을 스캔받아서 선택받기
			shoprun2 = true; // 다시 2번째 반복문으로 돌아왔을때 false값을 트루로 바꿔주기 위해서있다.
			while (shoprun2) { // 무기나, 방어구, 물약들의 목록을 보여주기위해서 반복문을 사용
				shoprun3 = true; // 다시 반복문에서부터 돌아왔을때 false값을 트루로 바꿔주기 위해서있다.

				switch (choice) {  //초이스값으로부터 가는 방향을 나눠주기 위해서 나누어줌
				case 1: { // 1번을 눌렀을때
					while (shoprun3) {   //무기목록을 지속적으로 보여주며 선택을 하더라도 나가기를 선택하지 않는이상 목록을 계속 보여줌
						weaponCall(); // 무기목록을 보여주는 메소드
						System.out.print("선택 : ");
						choice = shopScan.nextInt(); //무기선택 스캔
						weaponBuy(); // 무시사는 메소드
					}
					break;//빠져나가기

				}
				case 2: { //2번을 눌렀을때
					while (shoprun3) { //방어구목록을 지속적으로 보여주며 선택을 하더라도 나가기를 선택하지 않는이상 목록을 계속 보여줌
						armorCall();// 방어구 목록을 보여줌
						System.out.print("선택 : ");
						choice = shopScan.nextInt();//방어구 선택 스캔
						armorBuy();// 방어구 사는 메소드
					}
					break; //빠져나가기

				}
				case 3: {//3번을 눌렀을때
					while (shoprun3) {//물약목록을 지속적으로 보여주며 선택을 하더라도 나가기를 선택하지 않는이상 목록을 계속 보여줌
						potionCall();//물약목록을 보여줌
						System.out.print("선택 : ");
						choice = shopScan.nextInt(); //물약선택 스캔
						postionBuy();  //물약사기
					}
					break;//빠져나가기
				}
				case 4: {//4번을 눌렀을때
					outShop();//상점 나가기 메소드
					break;//빠져나가기
				}
				default: {//그외 나머지 경우
					System.out.println("'으응? 잘못누른거 아닌가? 그런거는 없다네.'");
					System.out.println("'다시 선택해 보시게.'");
					shoprun2 = false; //다시 선택화면으로 돌아가게 해줌(목록을 보여주는 반복문의 조건을 거짓으로 만들어 실행시키지 않음)
					break;
				}
				}
			}
		}

	}
//------------------------------------------------------------------------------------------------------------------------------

	// 웨폰콜
	void weaponCall() {
		System.out.println("\t\t $ 무기를 둘러본다. $");
		for (int i = 0; i < it.weapon.length; i++) {//  for반복문과 출력문을 이용해서 아이템클래스의 무기 이름, 무기 공격력,무기가격들을 보여준다.
			System.out.println(
					(i + 1) + ". " + it.weapon[i] + "  공격력 :" + it.weaponD[i] + "\t\t 가격 : " + it.weaponPay[i] + " G");
		}
		System.out.println("4.나가기");
		System.out.println("---현재 당신이 소유한 골드 : " + playerMoney + " GOLD---");
	}

//-------------------------------------------------------------------------------------------------------------------------------	
	// 아머콜
	void armorCall() {
		System.out.println("\t\t $ 방어구를 둘러본다. $");
		for (int i = 0; i < it.weapon.length; i++) {  //for반복문과 출력문을 이용해서 아이템클래스의 방어구 이름, 방어구 효능,방어구 가격들을 보여준다.
			System.out.println(
					(i + 1) + ". " + it.armor[i] + "  체력 : " + it.armorH[i] + "\t\t\t 가격 : " + it.armorPay[i] + " G");
		}
		System.out.println("4.나가기");
		System.out.println("---현재 당신이 소유한 골드 : " + playerMoney + " GOLD---");
	}

//---------------------------------------------------------------------------------------------------------------------------------
	// 포션콜
	void potionCall() {
		System.out.println("\t\t $ 물약을 둘러본다. $");
		for (int i = 0; i < it.potion.length; i++) { //for반복문과 출력문을 이용해서 아이템클래스의 물약 이름, 물약효과,물약 가격들을 보여준다.
			System.out.println(
					(i + 1) + ". " + it.potion[i] + "  효과 : " + it.potionH[i] + "	   가격 : " + it.potionPay[i] + " G");
		}
		System.out.println("3.나가기");
		System.out.println("---현재 당신이 소유한 골드 : " + playerMoney + " GOLD---");
	}

//---------------------------------------------------------------------------------------------------------------------------------
	// 상점나가기
	void outShop() {
		System.out.println("\t $ 볼일을 끝마쳤다. 이제나가보자. $");
		System.out.println("'다음에 또 오세요~.' 상점주인이 만족스러운 표정으로 바라본다.");
		shoprun2 = false; //목록을 보여주는 반복문을 거짓값으로 만들어 중단시킴
		shoprun = false;  //상점전체의 반복문을 중단시켜줌
	}

//---------------------------------------------------------------------------------------------------------------------------------
	// 무기buy함수
	int weaponBuy() {// 무기를 사는 메소드로 리턴값이 있어야 하므로 인트로 줌
		switch (choice) {
		case 1: { // 단검을 살때
			if (playerMoney >= it.weaponPay[0]) { //플레이어 머니가 아이템 클라스의 웨폰가격 보다 높거나 같다면
				playerWeapon = it.weapon[0];       //플레이어무기에 아이템클래스의 무기이름을 대입시켜준다
				playerMoney = playerMoney - it.weaponPay[0]; //플레이어 머니에  플레이어 머니에서 아이템클래스의 무기가격을 뺀것을 대입 시킨다 
				System.out.println("단검을 구매하였다! 짧다.");
				System.out.println("( " + it.weapon[0] + " 을 곧바로 사용합니다.)");
			} else {//만약 돈이없을시(플레이어 머니가 아이템 클라스의 웨폰가격 보다 높거나 같지 않다면)
				System.out.println("'돈이없는걸? 내가 자선사업가로 보이나?'");
				System.out.println("(잔액이 부족합니다.)");
			}
			break;//빠져나오고
		}
		case 2: { // 장검을 살때
			if (playerMoney >= it.weaponPay[1]) { 
				playerWeapon = weapon[1];      
				playerMoney = playerMoney - it.weaponPay[1];
				System.out.println("장검을 구매하였다! 길다.");
				System.out.println("( " + it.weapon[1] + " 을 곧바로 사용합니다.)");
			} else {
				System.out.println("'자네 주머니가 가벼워 보이는걸? 돈은 있나?'");
				System.out.println("(잔액이 부족합니다.)");
			}
			break;

		}
		case 3: { // 짱쎈검을 살때
			if (playerMoney >= it.weaponPay[2]) {
				playerWeapon = weapon[2];
				playerMoney = playerMoney - it.weaponPay[2];
				System.out.println("짱쎈검을 구매하였다! 온우주의 힘이 느껴지는 기분이든다.");
				System.out.println("( " + it.weapon[2] + " 을 곧바로 사용합니다.)");
			} else {
				System.out.println("'이 검은 엄청 비싼거라구~!'");
				System.out.println("(잔액이 부족합니다.)");
			}
			break;
		}
		case 4: { // 상점 맨처음으로 돌아간다
			System.out.println("돌아간다.");
			shoprun2 = false; //무기목록들을 보여주는 선택창을 종료
			shoprun3 = false; //무기목록 지속 반복을 보여주는 선택창을 종료
			break;//빠져나가기
		}
		default: { // 나머지 값을 입력했을때
			System.out.println("'어엇! 우리상점에는 그런거는 없는데?!!'");
			System.out.println("'다시 선택해 보시게.'");

			break;//빠져나가기
		}
		}
		return playerMoney; //플레이어머니에 리턴값을 돌려줌
	}

//---------------------------------------------------------------------------------------------------------------------------------
	// 방어구buy함수
	int armorBuy() {// 방어구를 사는 메소드로 리턴값을 주기위해 인트로 설정한다
		switch (choice) { //초이스의 값에따라 선택
		case 1: { // 천쪼가리를 사는 보이드
			if (playerMoney >= it.armorPay[0]) { //플레이어 머니가 아이템 클라스의 방어구가격 보다 높거나 같다면
				playerArmor = armor[0];         //플레이어 아머는 아머가 된다.
				playerMoney = playerMoney - it.armorPay[0];
				System.out.println("천쪼가리를 구매하였다! 비가오면 위험할 것 같다.");
				System.out.println("( " + armor[0] + " 을 곧바로 사용합니다.)");
			} else {
				System.out.println("당신이 돈이 없다는것을 알아차린 상점주인이 당신을 째려봅니다.");
				System.out.println("(잔액이 부족합니다.)");
			}
			break;
		}
		case 2: { // 철쪼가리를 사는 보이드
			if (playerMoney >= it.armorPay[1]) {
				playerArmor = armor[1];
				playerMoney = playerMoney - it.armorPay[1];
				System.out.println("철쪼가리를 구매하였다! 간신히 가릴수 있을것 같다.");
				System.out.println("( " + armor[1] + " 을 곧바로 사용합니다.)");
			} else {
				System.out.println("'주머니에 넣은손에~ 잡히는게 없는데...'");
				System.out.println("(잔액이 부족합니다.)");
			}
			break;
		}
		case 3: { // 왕의 갑옷을 사는 보이드
			if (playerMoney >= it.armorPay[2]) {
				playerArmor = armor[2];
				playerMoney = playerMoney - it.armorPay[2];
				System.out.println("왕의 갑옷을 구매하였다! 마치내가 왕이 된것만 같은 느낌이 든다.");
				System.out.println("( " + armor[2] + " 을 곧바로 사용합니다.)");
			} else {
				System.out.println("'이 방어구는 진짜 비싼거야. 할인 못해줘!'");
				System.out.println("(잔액이 부족합니다.)");
			}
			break;
		}
		case 4: { // 나가는 보이드
			System.out.println("돌아간다.");
			shoprun2 = false;
			shoprun3 = false;
			break;
		}
		default: { // 잘못 눌렀을때
			System.out.println("'어엇! 우리상점에는 그런거는 없는데?!!'");
			System.out.println("'다시 선택해 보시게.'");

			break;
		}
		}
		return playerMoney;
	}

//---------------------------------------------------------------------------------------------------------------------------------
	// 물약buy
	int postionBuy() { //물약 구매 메소드. 리턴값을 받기위해 인트로 설정
		switch (choice) {
		case 1: {
			System.out.println(it.potion[0] + "을 선택하셨습니다. 몇개나 구매하시겠습니까?");
			System.out.print("빨간약 구매갯수 : ");
			int potionNum = shopScan.nextInt();  //물약갯수를 입력받는 변수 선언
			if (playerMoney >= it.potionPay[0]*potionNum) {   //만약 머니가  포션값x갯수 보다 클때
				playerMoney = playerMoney - (it.potionPay[0] * potionNum); //플레이어 머니에서  포션값x갯수를 뺴준다. 그리고 그값을 머니에 저장
				System.out.println("빨간약을" + potionNum + " 개 구매하였다! 상처에 발라보쟈.");
				hpPotion += potionNum;
			} else {
				System.out.println("'이봐이봐 돈이 부족하다구.'");
				System.out.println("(잔액이 부족합니다.)");
			}
			break;
		}
		case 2: {
			System.out.println(it.potion[1] + "을 선택하셨습니다. 몇개나 구매하시겠습니까?");
			System.out.print("파란약 구매갯수 : ");
			int potionNum = shopScan.nextInt();
			if (playerMoney >= it.potionPay[1] * potionNum) {
				playerMoney = playerMoney - (it.potionPay[1] * potionNum);
				System.out.println("파란약을" + potionNum + " 개 구매하였다! 먹어도 되는걸까?");
				spPotion += potionNum;
			} else {
				System.out.println("'5252돈이 부족한게 아닌가?'");
				System.out.println("(잔액이 부족합니다.)");
			}
			break;
		}
		case 3: {
			System.out.println("돌아간다.");
			shoprun2 = false;
			shoprun3 = false;
			break;
		}
		default: {
			System.out.println("'어엇! 우리상점에는 그런거는 없는데?!!'");
			System.out.println("'다시 선택해 보시게.'");

			break;
		}
		}
		return playerMoney;
	}

}
