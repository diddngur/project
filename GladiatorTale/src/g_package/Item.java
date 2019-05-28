package g_package;

public class Item {// ����� ������ �÷��̾�� �ְ�, �ڽ� Ŭ������ ����������, �θ� Ŭ������ �÷��̾�� �Ѵ�.
	// ����
	int damage;    //�����
	String weaponName;   //���� �̸�
	String armorName;    //�� �̸�
	double skill;        //��ų �����
	int armorHp;         //�� ����
	String potionName;   //�����̸�
	int hpHeal,spHeal;    //�������� ȸ����ų ü�°� ���� ����
	
	
	// ���� ���������� ���� �Ϸ��� ���� �� �Լ��� �ߵ���ų ����
	// ����( �����̸��� �����,����, ���̸��� �� ����ġ��,����, ���� �̸��� ȿ��, ������ �迭�� �̿��ؼ� ȣ���ϱ� ���� �����. )

	String[] weapon = { "�ܰ�", "���", "¯���" };
	String[] weaponD= {"200~240","300~360","500~600"};
	int[] weaponPay= {10000,20000,30000};
	String[] armor = { "õ �ɰ���", "ö �ɰ���", "���� ����" };
	String[] armorH = {"4000","5000","7000",""};
	int[] armorPay= {10000,18000,25000};
	String[] potion = { "������", "�Ķ���" };
	String[] potionH = {"ü�� 1000 ȸ��","��ų���Ƚ�� +1"};
	int[] potionPay= {1000,1000};

	//�������̶�� ���̵尪 �޼ҵ带 ����
	//�������� ��ų �������� ����.  �Ŀ� �ۿ��Ҽ� �ֵ��� �Ѵ�.

	void weaponSet(String weaponName) {
		switch (weaponName) {
		case "�⺻(���ָ�)": {
			damage = ((int) (Math.random() * 120) + 1) + 80;
			skill = damage + (damage * 0.5);
			break;
		}
		case "�ܰ�": {
			damage = ((int) (Math.random() * 240) + 1) + 200;
			skill = damage + (damage * 0.7);
			break;
		}
		case "���": {
			damage = ((int) (Math.random() * 360) + 1) + 300;
			skill = damage + (damage * 0.8);
			break;
		}
		case "¯���": {
			damage = ((int) (Math.random() * 600) + 1) + 500;
			skill = damage + (damage * 1);
			break;
		}
		}

	}

	// �� ������
	//�� ���� ���������� �̸��� ������ �Ŀ� ���Խ�ų �� �ֵ��� �Ѵ�.
	void armorSet(String armorName) {
		switch (armorName) {
		case "�⺻(���Ǻ�)": {
			armorHp = 0;
			break;
		}
		case "õ �ɰ���": {
			armorHp = 4000;
			break;
		}
		case "ö �ɰ���": {
			armorHp = 5000;
			
			break;
		}
		case "���� ����": {
			armorHp = 7000;
			break;
		}
		}
	}

	// ���� ������ 
	//����ȿ���� �Ŀ� �����ϱ� ���� ����� �ش�.
	void setPotion(String potionName) {
		switch (potionName) {
		case "red": {
			hpHeal = 1000;
			// �ִ�ä���� ���ѱ�� �ؾ���
			break;
		}
		case "blue": {
			spHeal = 1;
			// ��ų�ִ���Ƚ���� ���ѱ�� �ؾ���
			break;
		}
		}
	}

}
