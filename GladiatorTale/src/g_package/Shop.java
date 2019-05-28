package g_package;

import java.util.Scanner;

public class Shop extends Item {
	Scanner shopScan = new Scanner(System.in);// ���ɳ�

	int choice; // �Է°� ����
	boolean shoprun = true; // ������ü�ݺ����� ���� ����
	boolean shoprun2; // ������ ���� �ݺ���
	boolean shoprun3; // 2��° ����ȭ�� �ݺ����� ���� ����

	String playerArmor;    //�÷��̾��� ��(�����ۿ��� ������ ������ ���Խ�Ű������ ����)
	String playerWeapon;   //�÷��̾��� ���� (�����ۿ��� ������ ������� ���Խ����ֱ� ���� ����) 
	int playerMoney;       //�÷��̾� �Ӵ� (���� ���⿡�� �Է¹��� ���� �����ϱ� ���� ����)
	int spPotion;          //��������
	int hpPotion;          //ü�� ����
	
	//�������� �����ڷ� �����ؼ� ���� Ŭ�������� �Է¹������� �ٷιٷ� ������ �� �ֵ��� ���ش�.
	Shop(String playerArmor, String playerWeapon, int playerMoney, int spPotion, int hpPotion) {
		this.playerArmor = playerArmor; // ��
		this.playerWeapon = playerWeapon; // ����
		this.playerMoney = playerMoney; // ��
		this.spPotion = spPotion; // �Ķ���
		this.hpPotion = hpPotion; // ������
	}

	Item it = new Item(); // ������ Ŭ������ ��üȭ

//------------------------------------------------------------------------------------------------------------------	
//������ �������� ���� 	
	void comingShop() {
		System.out.println("����� ©���Ÿ��� ��ȭ�ָӴϸ� ������ �Ÿ��� ���ƺ��̴� ������ ���ϴ�. ");
		while (shoprun) {//1�ݺ� 
			System.out.println("");
			System.out.println("$$$$$$$$$$$$$$$'������ �°��� ȯ���մϴ�. ������� ������ ��󺸼���.'$$$$$$$$$$$$$$$");
			System.out.println("$$               $$                $$               $$            $$");
			System.out.println("$$ 1 ���⸦ �ѷ�����. $$ 2 ���� �ѷ�����. $$ 3 ������ �ѷ�����. $$  4 ����������. $$");
			System.out.println("$$               $$                $$               $$            $$");
			System.out.println("$$$$$$$$$$$$$$$$$���������� ����� ��ȭ�ָӴϸ� �վ����� ó�ٺ���.$$$$$$$$$$$$$$$$$$$");
			System.out.println("\t---���� ����� ������ ��� : " + playerMoney + " GOLD---");
			System.out.print("���� : ");
			choice = shopScan.nextInt();// ���̽� ���� ��ĵ�޾Ƽ� ���ùޱ�
			shoprun2 = true; // �ٽ� 2��° �ݺ������� ���ƿ����� false���� Ʈ��� �ٲ��ֱ� ���ؼ��ִ�.
			while (shoprun2) { // ���⳪, ��, ������� ����� �����ֱ����ؼ� �ݺ����� ���
				shoprun3 = true; // �ٽ� �ݺ����������� ���ƿ����� false���� Ʈ��� �ٲ��ֱ� ���ؼ��ִ�.

				switch (choice) {  //���̽������κ��� ���� ������ �����ֱ� ���ؼ� ��������
				case 1: { // 1���� ��������
					while (shoprun3) {   //�������� ���������� �����ָ� ������ �ϴ��� �����⸦ �������� �ʴ��̻� ����� ��� ������
						weaponCall(); // �������� �����ִ� �޼ҵ�
						System.out.print("���� : ");
						choice = shopScan.nextInt(); //���⼱�� ��ĵ
						weaponBuy(); // ���û�� �޼ҵ�
					}
					break;//����������

				}
				case 2: { //2���� ��������
					while (shoprun3) { //������� ���������� �����ָ� ������ �ϴ��� �����⸦ �������� �ʴ��̻� ����� ��� ������
						armorCall();// �� ����� ������
						System.out.print("���� : ");
						choice = shopScan.nextInt();//�� ���� ��ĵ
						armorBuy();// �� ��� �޼ҵ�
					}
					break; //����������

				}
				case 3: {//3���� ��������
					while (shoprun3) {//�������� ���������� �����ָ� ������ �ϴ��� �����⸦ �������� �ʴ��̻� ����� ��� ������
						potionCall();//�������� ������
						System.out.print("���� : ");
						choice = shopScan.nextInt(); //���༱�� ��ĵ
						postionBuy();  //������
					}
					break;//����������
				}
				case 4: {//4���� ��������
					outShop();//���� ������ �޼ҵ�
					break;//����������
				}
				default: {//�׿� ������ ���
					System.out.println("'����? �߸������� �ƴѰ�? �׷��Ŵ� ���ٳ�.'");
					System.out.println("'�ٽ� ������ ���ð�.'");
					shoprun2 = false; //�ٽ� ����ȭ������ ���ư��� ����(����� �����ִ� �ݺ����� ������ �������� ����� �����Ű�� ����)
					break;
				}
				}
			}
		}

	}
//------------------------------------------------------------------------------------------------------------------------------

	// ������
	void weaponCall() {
		System.out.println("\t\t $ ���⸦ �ѷ�����. $");
		for (int i = 0; i < it.weapon.length; i++) {//  for�ݺ����� ��¹��� �̿��ؼ� ������Ŭ������ ���� �̸�, ���� ���ݷ�,���Ⱑ�ݵ��� �����ش�.
			System.out.println(
					(i + 1) + ". " + it.weapon[i] + "  ���ݷ� :" + it.weaponD[i] + "\t\t ���� : " + it.weaponPay[i] + " G");
		}
		System.out.println("4.������");
		System.out.println("---���� ����� ������ ��� : " + playerMoney + " GOLD---");
	}

//-------------------------------------------------------------------------------------------------------------------------------	
	// �Ƹ���
	void armorCall() {
		System.out.println("\t\t $ ���� �ѷ�����. $");
		for (int i = 0; i < it.weapon.length; i++) {  //for�ݺ����� ��¹��� �̿��ؼ� ������Ŭ������ �� �̸�, �� ȿ��,�� ���ݵ��� �����ش�.
			System.out.println(
					(i + 1) + ". " + it.armor[i] + "  ü�� : " + it.armorH[i] + "\t\t\t ���� : " + it.armorPay[i] + " G");
		}
		System.out.println("4.������");
		System.out.println("---���� ����� ������ ��� : " + playerMoney + " GOLD---");
	}

//---------------------------------------------------------------------------------------------------------------------------------
	// ������
	void potionCall() {
		System.out.println("\t\t $ ������ �ѷ�����. $");
		for (int i = 0; i < it.potion.length; i++) { //for�ݺ����� ��¹��� �̿��ؼ� ������Ŭ������ ���� �̸�, ����ȿ��,���� ���ݵ��� �����ش�.
			System.out.println(
					(i + 1) + ". " + it.potion[i] + "  ȿ�� : " + it.potionH[i] + "	   ���� : " + it.potionPay[i] + " G");
		}
		System.out.println("3.������");
		System.out.println("---���� ����� ������ ��� : " + playerMoney + " GOLD---");
	}

//---------------------------------------------------------------------------------------------------------------------------------
	// ����������
	void outShop() {
		System.out.println("\t $ ������ �����ƴ�. ������������. $");
		System.out.println("'������ �� ������~.' ���������� ���������� ǥ������ �ٶ󺻴�.");
		shoprun2 = false; //����� �����ִ� �ݺ����� ���������� ����� �ߴܽ�Ŵ
		shoprun = false;  //������ü�� �ݺ����� �ߴܽ�����
	}

//---------------------------------------------------------------------------------------------------------------------------------
	// ����buy�Լ�
	int weaponBuy() {// ���⸦ ��� �޼ҵ�� ���ϰ��� �־�� �ϹǷ� ��Ʈ�� ��
		switch (choice) {
		case 1: { // �ܰ��� �춧
			if (playerMoney >= it.weaponPay[0]) { //�÷��̾� �Ӵϰ� ������ Ŭ���� �������� ���� ���ų� ���ٸ�
				playerWeapon = it.weapon[0];       //�÷��̾�⿡ ������Ŭ������ �����̸��� ���Խ����ش�
				playerMoney = playerMoney - it.weaponPay[0]; //�÷��̾� �ӴϿ�  �÷��̾� �ӴϿ��� ������Ŭ������ ���Ⱑ���� ������ ���� ��Ų�� 
				System.out.println("�ܰ��� �����Ͽ���! ª��.");
				System.out.println("( " + it.weapon[0] + " �� ��ٷ� ����մϴ�.)");
			} else {//���� ���̾�����(�÷��̾� �Ӵϰ� ������ Ŭ���� �������� ���� ���ų� ���� �ʴٸ�)
				System.out.println("'���̾��°�? ���� �ڼ�������� ���̳�?'");
				System.out.println("(�ܾ��� �����մϴ�.)");
			}
			break;//����������
		}
		case 2: { // ����� �춧
			if (playerMoney >= it.weaponPay[1]) { 
				playerWeapon = weapon[1];      
				playerMoney = playerMoney - it.weaponPay[1];
				System.out.println("����� �����Ͽ���! ���.");
				System.out.println("( " + it.weapon[1] + " �� ��ٷ� ����մϴ�.)");
			} else {
				System.out.println("'�ڳ� �ָӴϰ� ������ ���̴°�? ���� �ֳ�?'");
				System.out.println("(�ܾ��� �����մϴ�.)");
			}
			break;

		}
		case 3: { // ¯����� �춧
			if (playerMoney >= it.weaponPay[2]) {
				playerWeapon = weapon[2];
				playerMoney = playerMoney - it.weaponPay[2];
				System.out.println("¯����� �����Ͽ���! �¿����� ���� �������� ����̵��.");
				System.out.println("( " + it.weapon[2] + " �� ��ٷ� ����մϴ�.)");
			} else {
				System.out.println("'�� ���� ��û ��ѰŶ�~!'");
				System.out.println("(�ܾ��� �����մϴ�.)");
			}
			break;
		}
		case 4: { // ���� ��ó������ ���ư���
			System.out.println("���ư���.");
			shoprun2 = false; //�����ϵ��� �����ִ� ����â�� ����
			shoprun3 = false; //������ ���� �ݺ��� �����ִ� ����â�� ����
			break;//����������
		}
		default: { // ������ ���� �Է�������
			System.out.println("'���! �츮�������� �׷��Ŵ� ���µ�?!!'");
			System.out.println("'�ٽ� ������ ���ð�.'");

			break;//����������
		}
		}
		return playerMoney; //�÷��̾�ӴϿ� ���ϰ��� ������
	}

//---------------------------------------------------------------------------------------------------------------------------------
	// ��buy�Լ�
	int armorBuy() {// ���� ��� �޼ҵ�� ���ϰ��� �ֱ����� ��Ʈ�� �����Ѵ�
		switch (choice) { //���̽��� �������� ����
		case 1: { // õ�ɰ����� ��� ���̵�
			if (playerMoney >= it.armorPay[0]) { //�÷��̾� �Ӵϰ� ������ Ŭ���� ������ ���� ���ų� ���ٸ�
				playerArmor = armor[0];         //�÷��̾� �ƸӴ� �ƸӰ� �ȴ�.
				playerMoney = playerMoney - it.armorPay[0];
				System.out.println("õ�ɰ����� �����Ͽ���! �񰡿��� ������ �� ����.");
				System.out.println("( " + armor[0] + " �� ��ٷ� ����մϴ�.)");
			} else {
				System.out.println("����� ���� ���ٴ°��� �˾����� ���������� ����� °�����ϴ�.");
				System.out.println("(�ܾ��� �����մϴ�.)");
			}
			break;
		}
		case 2: { // ö�ɰ����� ��� ���̵�
			if (playerMoney >= it.armorPay[1]) {
				playerArmor = armor[1];
				playerMoney = playerMoney - it.armorPay[1];
				System.out.println("ö�ɰ����� �����Ͽ���! ������ ������ ������ ����.");
				System.out.println("( " + armor[1] + " �� ��ٷ� ����մϴ�.)");
			} else {
				System.out.println("'�ָӴϿ� �����տ�~ �����°� ���µ�...'");
				System.out.println("(�ܾ��� �����մϴ�.)");
			}
			break;
		}
		case 3: { // ���� ������ ��� ���̵�
			if (playerMoney >= it.armorPay[2]) {
				playerArmor = armor[2];
				playerMoney = playerMoney - it.armorPay[2];
				System.out.println("���� ������ �����Ͽ���! ��ġ���� ���� �Ȱ͸� ���� ������ ���.");
				System.out.println("( " + armor[2] + " �� ��ٷ� ����մϴ�.)");
			} else {
				System.out.println("'�� ���� ��¥ ��Ѱž�. ���� ������!'");
				System.out.println("(�ܾ��� �����մϴ�.)");
			}
			break;
		}
		case 4: { // ������ ���̵�
			System.out.println("���ư���.");
			shoprun2 = false;
			shoprun3 = false;
			break;
		}
		default: { // �߸� ��������
			System.out.println("'���! �츮�������� �׷��Ŵ� ���µ�?!!'");
			System.out.println("'�ٽ� ������ ���ð�.'");

			break;
		}
		}
		return playerMoney;
	}

//---------------------------------------------------------------------------------------------------------------------------------
	// ����buy
	int postionBuy() { //���� ���� �޼ҵ�. ���ϰ��� �ޱ����� ��Ʈ�� ����
		switch (choice) {
		case 1: {
			System.out.println(it.potion[0] + "�� �����ϼ̽��ϴ�. ��� �����Ͻðڽ��ϱ�?");
			System.out.print("������ ���Ű��� : ");
			int potionNum = shopScan.nextInt();  //���హ���� �Է¹޴� ���� ����
			if (playerMoney >= it.potionPay[0]*potionNum) {   //���� �Ӵϰ�  ���ǰ�x���� ���� Ŭ��
				playerMoney = playerMoney - (it.potionPay[0] * potionNum); //�÷��̾� �ӴϿ���  ���ǰ�x������ ���ش�. �׸��� �װ��� �ӴϿ� ����
				System.out.println("��������" + potionNum + " �� �����Ͽ���! ��ó�� �߶���.");
				hpPotion += potionNum;
			} else {
				System.out.println("'�̺��̺� ���� �����ϴٱ�.'");
				System.out.println("(�ܾ��� �����մϴ�.)");
			}
			break;
		}
		case 2: {
			System.out.println(it.potion[1] + "�� �����ϼ̽��ϴ�. ��� �����Ͻðڽ��ϱ�?");
			System.out.print("�Ķ��� ���Ű��� : ");
			int potionNum = shopScan.nextInt();
			if (playerMoney >= it.potionPay[1] * potionNum) {
				playerMoney = playerMoney - (it.potionPay[1] * potionNum);
				System.out.println("�Ķ�����" + potionNum + " �� �����Ͽ���! �Ծ �Ǵ°ɱ�?");
				spPotion += potionNum;
			} else {
				System.out.println("'5252���� �����Ѱ� �ƴѰ�?'");
				System.out.println("(�ܾ��� �����մϴ�.)");
			}
			break;
		}
		case 3: {
			System.out.println("���ư���.");
			shoprun2 = false;
			shoprun3 = false;
			break;
		}
		default: {
			System.out.println("'���! �츮�������� �׷��Ŵ� ���µ�?!!'");
			System.out.println("'�ٽ� ������ ���ð�.'");

			break;
		}
		}
		return playerMoney;
	}

}
