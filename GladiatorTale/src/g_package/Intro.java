package g_package;

import java.util.Scanner;

public class Intro {

//����� ���� ��Ʈ��
	//�۷������� ���丮
	//Ÿ��Ʋ ȭ�� ����ϰ�
	//����ȭ�� ����
	
	String playerArmor="�⺻(���Ǻ�)";
	String playerWeapon="�⺻(���ָ�)";
	int playermoney=0;
	int spPotion=0;
	int hpPotion=0;
	
	boolean mainloop = true;
	int button;
	

	
	Scanner scan = new Scanner(System.in);

	
	
	void Prologue() {//���ѷα� �ý�Ʈ
		System.out.println("\t������ ���̻� ��ü�뵿�� �ݱ��� �ʰ� ��� ��ü�뵿�� �κ��� ����ϰ� �Ǿ����� ");
		System.out.println("\t\t������� ������ �Ӹ��θ� �԰� ��ƾ��ϴ� 5G�ô밡 �Խ��ϴ�.");
		System.out.println("�Ӹ��������� ��ü�� �������� �������� �̷����� ��ġ�� �ǰ��̸� �������� ���� ������ ���� ���� ���˰� �þ����ϴ�.");
		System.out.println("���δ� �̸� �����ϰ��� �ݷμ����� ���� ������ ������ �ܷ�� ���ڵ鿡�� ���� ������ ����� �����ϴ� ��ȸ�� �����Ͽ��� ");
		System.out.println("\t\t      �̿� �����ϴ� ������� �������� �ҷȽ��ϴ�. ");
		System.out.println("\t  ��Ŷ��� �ο� ��..���Ǥ���.�� �����ϱ� ���Ͽ� �� ��ȸ�� �����ϰ� �Ǿ����ϴ�.");
		System.out.println("\t�ε� ������..���� �ƴ� è�ǿ��� �Ǿ� ���� ������ �θ� �������ñ⸦ �ٶ��ϴ�.");
		System.out.println("");
		System.out.println("");
		System.out.println("\t\t\t-<�������� ����>-");
		System.out.println("");
	}
	void sadEnding() { //���忣�� �ý�Ʈ
		System.out.println(" ���� ������ �����Ϸ��� ����� �̿� ���� �ٽ� �������� �������� ������ ������ ������");
		System.out.println("\t��ư�����ʰ� 5G�ô��� �Ǹ��� �γ��� �Ǳ⸦ �����մϴ�.");
		System.out.println("\t     -----sadEnding-----");
		
	}
	
	void happyEnding() {//���ǿ��� �ý�Ʈ
		System.out.println("<�������� ��>"
				
				+ "�����մϴ�!!\r\n" + 
				"����� ��� ���ڸ� ����� ����� ������..��...�̾ƴ� è�ǿ��� �Ǿ����ϴ�!! \r\n" + 
				"�÷������ּż� �����մϴ�.\r\n" + 
				"������ �ٸ� ������Ʈ������ ������ �ϴ¸�� �����帮���� �ϰڽ��ϴ�.\r\n" + 
				"\r\n" + 
				" ������ : �̼���   (�������� 352-0696-6775-53)\r\n" + 
				"               �����   (�������� 110-400-743560) \r\n" + 
				"  �Ŀ��� �����ڿ��� ū ���� �˴ϴ�. \r\n" + 
				"");
	}
	
	
	void MainInterface() {
		
		//�ݷμ��� ���� �Ǵµ�...
		
		//�����ϱ� �������� ����ǰ
		
		do{ //�� ���Ϲ����� �ݺ�����
			
		Combat combat = new Combat(playerArmor, playerWeapon, playermoney, spPotion, hpPotion);
		ShowMeMine show = new ShowMeMine(playerArmor, playerWeapon,playermoney,spPotion,hpPotion);
		Shop shop = new Shop(playerArmor, playerWeapon,playermoney,spPotion,hpPotion);
		
		System.out.println("");
		System.out.println("");
		System.out.println("@=============@==========[(�ݷμ��� �κ�)]==========@===============@ ");
		System.out.println("||           ||                ||              ||              || ");
		System.out.println("||  1. �����ϱ�  ||    2. ����              ||   3. ����ǰ         ||  4. ���� ����       || "); //�����ư�� �ʿ���ٸ� ���ֵ� ��.
		System.out.println("||           ||                ||              ||              || ");
		System.out.println("@=============@================@================@===============@");
		System.out.println("�ڱ�  :"+playermoney);
		//��ĵ �ޱ�
		System.out.print(">");
		button = scan.nextInt();
		
		switch(button) {
		
		
		case 1: {
			
			//���� ���� �Ѱ��ְ�
			//���� ���� �Ѱ��ְ�
			combat.round=1; //���尪 �ʱ�ȭ
			combat.combatIntro();
			combat.combatInterface();
			playermoney+=combat.returnMoney;
			this.spPotion=combat.spPotion;
			this.hpPotion=combat.hpPotion;
			
			if(combat.endingSwitch) {
				happyEnding();
				mainloop = false;
				
			}
			
			break;
		}
		
		case 2:{
			
			//������ �÷��̾� �Ӵϸ� ������ �������� �Ѿ
			shop.comingShop();
			//���������� ���ϸӴϰ� / ���ο� ��� ������� �����ּ���.
			this.playerArmor = shop.playerArmor;
			this.playerWeapon = shop.playerWeapon;
			this.playermoney=shop.playerMoney;
			this.spPotion=shop.spPotion;
			this.hpPotion=shop.hpPotion;
			
			
			break;
		}
		
		case 3:{
			
			show.showPlayer();
			
			
			break;
			
		}
		
		case 4:{ 
			
			mainloop = false; //���������� ����
			sadEnding();
			System.out.println("\t-�������� ����- �� �����մϴ�. ������ �� ������!");
			
			break;
		}
		default : {
			
			System.out.println("�������� �ʴ� �������Դϴ�.");
		}
		
		}
		
		}while(mainloop);
		
	}
	
	
}
