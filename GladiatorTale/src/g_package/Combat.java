package g_package;

import java.util.Scanner;

public class Combat {//�÷��̾� ���� �θ�� ����.
	
	int button;				//����Ʈ ��ư
	boolean combatloop = true; //���� ��Ŀ����
	boolean actSwitch = true;	//��Ʈ ����ġ
	boolean potionloop = true;	//���� ������ ����
	boolean endingSwitch=false; //���� ����ġ
	int round=1;                //����
	int enemyHp = 10;     
	//�� ü��
	int enemyDamage;            //�� �����
	int enemySp;                //�� ����
	int playerSP;               //�÷��̾� ����
	int turn;                   //�ϼ� ǥ�⸦ ���Ѻ���
	static int playerMaxHp;     //�÷��̾� �ƽ� hp
	static final int playerMaxSp = 3;  //�÷��̾� �ƽ� ����
	String enemyName;          //���̸�
	
	int returnMoney=0;      //���� �Ӵ�
	int reward=0;            
	
	String playerArmor;   //�÷��̾� ��
	String playerWeapon;   //�÷��̾� ����
	int playermoney;      //�÷��̾� ��
	int spPotion;       //��������
	int hpPotion;        //ü�� ����

	
//Ÿ Ŭ���������� ���� �ޱ����� �����ڸ� �������ش�.---------------------------------------------------------------------------------------------------------------------------------
	Combat(String playerArmor, String playerWeapon, int playermoney, int spPotion, int hpPotion){ 
		
		this.playerArmor = playerArmor;
		this.playerWeapon = playerWeapon;
		this.playermoney = playermoney;
		this.spPotion = spPotion;
		this.hpPotion = hpPotion;
		
	}
	
//��üȭ ����----------------------------------------------------------------------------------------------------------------------------------------------------------
	Item item = new Item();
	Player player = new Player();
	Scanner scan = new Scanner(System.in);


//�� ������ ���� �޼ҵ�-------------------------------------------------------------------------------------------------------------
	void enemySet(int round) {
		
		switch(round) {//���带 �Ű��� ������ ���尡 ����ɼ��� ���� �ٳ�
		
		
		case 1 :  //���尡 1�Ͻ�
			
			this.enemyHp =1000;
			this.enemyName = "��ì��";
			this.reward = 5000;
			enemySp=3;
			break;
			
		case 2 : //���尡 2�Ͻ�
			
			this.enemyHp =5000;
			this.enemyName = "�ݷμ��� �ٹ���";
			this.reward = 10000;
			enemySp=3;
			break;
			
		case 3 : //���尡 3�Ͻ�
			
			this.enemyHp =10000;
			this.enemyName = "è�Ǿ�";
			this.reward = 10000000;//è�Ǿ� ������� ���߿� ������ ��
			enemySp=3;
			break;
			
		}
		//����ó�� ����غ� ��	
	}
	//--------------------------------------------------------------------------------------------------------
	void getSetPlayer() {//������Ʈ�� �� �÷��̾��� ü���� �����ϴ� ��
		
		playerSP = playerMaxSp;//�÷��̾� ��ų����Ʈ �ʱⰪ
		player.playerHP=2000;//�÷��̾� ü���� �ʱⰪ���� �����մϴ�.
		item.armorSet(playerArmor);//������ Ŭ���� �ʵ尪�� ���� �÷��̾ �����ϰ� �ִ� �ɼ����� �ٲߴϴ�.
		item.setPotion("red");
		item.setPotion("blue");
		player.playerHP +=item.armorHp;  //������ ������ �Ƹ� ü���� �߰��ϱ�.
		playerMaxHp = player.playerHP;//�ƽ�ü�� ����
		
	}
	//������Ʈ�� �޼ҵ�---------------------------------------------------------------------------------------------
	void combatIntro() {
		System.out.println("");
		System.out.println("");
		if(round==1) { //���尡 1�϶�
		System.out.println(">>����忡 �Լ��߽��ϴ�..");
		}else { //�׿��� ���(���尡 ����Ǿ�����)
		System.out.println(">>����� ���� ���� ���� ���ư��ϴ�.. ");
		}
		enemySet(round);//�� ����...(���忡 ������ �޴´�)
		turn=0;//�ϼ� �ʱ�ȭ
		if(round==1) {
			getSetPlayer();//���� 1�϶� �÷��̾� ü���ʱ⼳����. �� ���帶�� ü���� ȸ���ǰ� �Ϸ���  ���� ������ �����ּ���.
		}
		System.out.println("system : round "+round+"!"+ "����� ���� "+enemyName+"�Դϴ�!");//���带 ����ϰ� ���� �˷��ݴϴ�.
		System.out.println("system : ������ ���!");
		System.out.println("");
		System.out.println("");
		combatloop=true;
		
		
	}
	
	
	
	//������Ŀ����-------------------------------------------------------------------------------------------------------------
	void combatInterface() {
		
		do{//���� ��Ŀ���� ��ȯ����
			++turn;  //���� �����մϴ�.
			do {//��Ʈ����ġ�� �������������� �������� ��� �����ݴϴ�.
			System.out.println("                         Round:"+round+"                    �� ��:"+turn);
			System.out.println("                         <"+enemyName+">                        ");
			System.out.println("- - - - - - - - - - - �� ü��: "+enemyHp+"- - - - - - - - - - - - - ");
			System.out.println(); 
			System.out.println("       1. ����               |      2. ��ų             |      3. ����ǰ             "); //�����ư�� �ʿ���ٸ� ���ֵ� ��.
			System.out.println();
			System.out.println("- - - - - - - - - - �÷��̾� ü��: "+player.playerHP+"- - - - - - - - - - - - ");
			System.out.println("                                       ��ų ��� ���� Ƚ�� :"+playerSP+"             ");
			System.out.println("");
			System.out.print("������� ������ �ұ�?   >");
			button = scan.nextInt();//��ư ��ĵ �ޱ�
			System.out.println("");
			switch(button) {//��ư������ �������� �ٸ��� ���ֱ� ���ؼ� ����ġ ���̽� ������ ���ش�.
			
			
			case 1: { //1���� ��������
				
				combatDamage();
				
				break;
			}
			
			case 2:{
				
				skillUse();
				//��ų ��� �޼ҵ� �۵�. �� ü�¿��� ��������ŭ ������.

				break;
			}
			
			case 3:{
				selectPotion();//���� ������
				break;
				
			}

			default : {
				System.out.println("�������� �ʴ� �������Դϴ�.");
			}
			
			}//����ġ ����
		}while(actSwitch);//��Ʈ����ġ�� �������������� ��� ���ϴ�.
			
			enemyHpCheck(enemyHp);//�� ü�� üũ����. �¸��б���. ���� ��������� ���� �÷��̾ ����.
			
			ifPlayerDead();//�÷��̾� ü��üũ����. �й�б���.
			
			actSwitch=true; //��Ʈ ����ġ �ʱ�ȭ
			
			}while(combatloop);	//���� ��Ŀ���� ��ȯ����
		
		
	}//�޼ҵ� ������
	
	
	//�÷��̾ ���� ��---------------------------------------------------------------------------------------------------------------------------
	void combatDamage() {

		System.out.println("system : �����簡 "+playerWeapon+" ��(��) �ֵѷ� ���ظ� �����ϴ�.");
		item.weaponSet(playerWeapon);//������ ������(�ʵ尪)�� ������.
				
		if(enemyHp<item.damage) { //�����κи��� ������
			enemyHp=0;//���� ü���� -���� �ȵǵ��� ����� ��
		}else {
			enemyHp-=item.damage;//���� ü���� ���� ü�¿��� ������Ŭ������ �������ŭ �پ���.
		}
		
		System.out.println(enemyName+ "(��)�� "+item.damage+"��ŭ ���ظ� �Խ��ϴ�.");
		System.out.println(enemyName+" : ���ƾ�!");
		System.out.println("");
		System.out.println("");
		
		actSwitch=false;	//��Ʈ ����ġ ��Ȱ��ȭ.(�ൿ ��)
		
	}
	
	
	//�÷��̾ ��ų�� �� ��------------------------------------------------------------------------------------------------------------------------
	void skillUse() {
		if(playerSP>0) { //������ 0���� ũ�ٸ�

		System.out.println("system : �����簡 "+playerWeapon+"�� ��ų ���!"); // ��ų�̸��� ����� ��� ��¹޾Ƽ� ����ϸ� ��.
		System.out.println("�ʻ� ���� �ø���. ���� �ֵθ���!");
		item.weaponSet(playerWeapon);
		
		if(enemyHp<item.skill) {  //�����κи��� ������
			enemyHp=0;  //���� ü���� -���� �ȵǵ��� ����� ��
		}else {
			enemyHp-=item.skill;//���� ü���� ���� ü�¿��� ������Ŭ������ �������ŭ �پ���.
		}
		
		System.out.println("system : ��"+enemyName+"���� "+item.skill+"��ŭ�� ��ų �������� �������ϴ�.");
		System.out.println(enemyName+" : ����ض�... ");
		System.out.println("");
		System.out.println("");
		playerSP--;//��ų�� �� ������ ������ �ϳ��� �پ��
		
		actSwitch=false;//��Ʈ ����ġ ��Ȱ��ȭ.(�ൿ ��)
		
		}else{//������ ���ٸ�(������ 0���� ũ�� �ʴٸ�)
			
			System.out.println("��ų����Ʈ�� 0�̶� ��ų�� ����� �� �����ϴ�.");
		}
		
		
	}
	
	
	//�ǰ� �޼ҵ�---------------------------------------------------------------------------------------------------
	void getHit() {
		
		double enemyskillCase; //��ų������ ������� ���� ������� �����ִ� ��
		
		System.out.println("system : �� "+enemyName+"(��)�� ����� �����մϴ�.");
		
		int enemySkillchance =(int)(Math.random()*4+1);//��ų�ߵ�Ȯ�� 25����.(1~4������ �������ڸ� �̴´�)
		
		switch(round) {
		
		
		case 1:
			
			this.enemyDamage = (int)(Math.random()*30+1)+50;  //30~50�� ���ڸ� �� ������� �����Ѵ�
			enemyskillCase = 1.5;                             //���� ��ų�� ����Ҷ� �Ϲݴ������ �����ٰ�
			
			Damaged(enemySkillchance,enemyskillCase);         //��������� �Լ��� �ҷ��´�(�ؿ� ����)
			
			break;
			
		case 2:
			
			this.enemyDamage = (int)(Math.random()*50+1)+300;  
			enemyskillCase = 1.7;
			
			Damaged(enemySkillchance,enemyskillCase);
			
			break;
			
		case 3:
			this.enemyDamage = (int)(Math.random()*100+1)+600;
			enemyskillCase = 2.0;
			
			Damaged(enemySkillchance,enemyskillCase);
			
			break;
		}
		
		
	}
	
	void ifPlayerDead() {     //�÷��̾� ü�� üũ�Լ�
		if(player.playerHP==0) {        //���� �÷��̾ ü���� 0�� �ȴٸ�
		
			//���ӿ��� �Լ�. �ܺ� ��ü�� �����ؾ� �մϴ�.
			System.out.println("<GAME OVER?>");
			System.out.println("");
			System.out.println(enemyName+": ũ����! �� �������� �Ͷ�, �ּ���!");
			System.out.println("����� ��⿡�� �����ϴ�.. ��¥ �ݷμ��� ������ �����ϴٸ�, ���� �ں�� ������� �������ϴ�.");
			System.out.println("");
			System.out.println("");
			
			combatloop=false;          //����ȭ�� �ݺ����� ����
		}
	}
	
	
	
	
	void Damaged(int enemySkillchance, double enemyskillCase) {     //����� �Լ�(����ų Ȯ��(1/4Ȯ��), �� ��ų�����(�Ϲݴ������ ������ ��)�� �Ű��� �޴´�)
		
		if (enemySkillchance==4&&enemySp>0) { //���� ���� ����(1~4������ ��������) �߿� 4�� ������ ������ 0���� ���ٸ�
			
			int skillDamage =(int)(this.enemyDamage*enemyskillCase);     //��ų������� ��������� ���� ���� �����־� ������� ����Ѵ�
			
			if(skillDamage>player.playerHP) {     //���� �� ��ų ������� �÷��̾� ü�º��� ���ٸ�
				 
				player.playerHP=Player.playerMinHP;   //�÷��̾� ü���� �÷��̾��� �ּ� ü��( 0 )�� �ȴ�.
			}
			else{                             //������ ��쿡��(��ų������� �÷��̾� ü�º��� ���ٸ�)
				
				player.playerHP-=skillDamage;   //�÷��̾� ü���� �÷��̾� ü�¿��� ��ų������� �A��
				
				}
			enemySp--;   //������ �ϳ� �پ���.
			if(round==3) {
				System.out.println("");
				System.out.println("���� �ֺ��� �θ��� �Ÿ��鼭 ���� ǰ�� ���ܵ� ���� �����ϴ�. ");
				System.out.println("������ �Ⱥ� ƴ��Ÿ�� ��ų�� ����մϴ�.");
				System.out.println("'������...����...'");
			}
			else {
				System.out.println("");
				System.out.println("'�޾ƶ�!!'");
				
			}
			System.out.println("system : ���� ��ų�� ����մϴ�..."+skillDamage+"��ŭ�� ���ظ� �Ծ����ϴ�.");
			System.out.println("");
			System.out.println("");
			//System.out.println("���� ���� ��ų ��� Ƚ�� :"+enemySp);
			
		}else {  //��ųȮ�� (1~4�� ���� �����߿� 4�� ���ð��)�� �� ������ ��쿡��
			if(this.enemyDamage>player.playerHP) {   //���� ��������� �÷��̾� ü�º��� ���ٸ� 
				
				player.playerHP=Player.playerMinHP; //�÷��̾� ü���� 0���� �����մϴ�.
				
			}
			else {   //��������� ü�º��� ���ٸ�
				
			player.playerHP-=this.enemyDamage; //�÷��̾� ü���� ü�¿��� ��������� �A���� �����Ѵ�.
			
			}
			System.out.println("system : �̷�! ������� "+this.enemyDamage+"��ŭ�� �λ��� �Ծ���!");
			System.out.println("");
			System.out.println("");
		}
		
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	void reCombatInterface() { //���� ����Ʈ���� �� ȭ��
		
		boolean re =true;       //�ݺ����� ���������� �� ���� �ش�.
		
		do{
		System.out.println();
		System.out.println();
		System.out.println("��Ⱑ �������ϴ�. �κ�� ���ư����?");
		System.out.println("- - - - - - - - - - - - - - - - - - - - ");
		System.out.println("1. ���� ���� ����    | 2. �ݷμ��� �κ�� ���ư��� ");
		System.out.println("- - - - - - - - - - - - - - - - - - - - ");
		System.out.print(">");
		button =scan.nextInt();
	
		switch(button) {
		
		
		case 1: {    //1���� �������� (�������� ����)

			round++; //���带 ������Ű�� ���� �ٽ� ��ȯ�Ѵ�.
			
			re=false;    //�ݺ����� �����Ű�� ���� ���������ش�.
			
			combatIntro();   //������Ʈ�θ� ��ȯ
			
			break;    
		}
		
		case 2:{    //2���� �������� (�κ�� ���ư���)
			System.out.println("�ݷμ��� �κ�� ���ư��ϴ�.");
			re=false; //�ݺ��� ���Ḧ ���� �������� �ش�.
			combatloop=false;  //���� �ݺ����� ���Ḧ �����ֱ����� �������� �ش�.
			break;
		}
		default : {   //������ Ű�� �������� 
			
			System.out.println("�������� �ʴ� ��ư�Դϴ�.");
			
		}
		
		}
			
		}while(re);
		
	}
	

	//---------------------------------------------------------------------------------------------
	void enemyHpCheck(int enemyHp) { //��ü�� Ȯ���� ���� �Լ�(�� ü���� �Ű��� �޴´�/)
		
		if(enemyHp<=0) { //�� ü���� 0���� �۰ų� ������
			System.out.println("�¸�!");
			
			System.out.println(enemyName+"��(��) ���������ϴ�!");
			

			
			if(round==3) {  //���� 3���� �϶�(���� ������ �������)
				System.out.println();
				System.out.println();
				System.out.println("������ ���� ����� è�Ǿ� �ڸ��� ���Ѿҽ��ϴ�!");
				System.out.println("�� �ڸ����� �� �����翡�� �����ο� è�Ǿ� ��Ʈ�� �־����ϴ�.");
				System.out.println("������� ������ �߰������� �ݷμ����� �����ϴ�. �װ� ������ �ڸ����� ������ �η����� ���ҽ��ϴ�.");
				System.out.println("�¸��� �Բ� �ݷμ����� ���� ��Ų �����縦 ���� ������� ���� Ī���� ���Դϴ�.");
				System.out.println();
				System.out.println();
				//ending credit �Լ� �ߵ�. ���⸻�� ��Ʈ�η� �ұ�?
				endingSwitch=true; //�����ݺ����� �� ������ �ش� 
				combatloop=false; //���� �ݺ��� ���Ḧ ���� ������
			
			}
			else{  //������ ��� (���������� �ƴ� ������ ������ ����� ���)
				
				System.out.println(this.reward+"��ŭ �ڱ��� ����ϴ�.");//�÷��̾�Լ� �Ӵϸ� ���޽��ϴ�.
				//�뵷 �ް� ���� ����
				returnMoney += reward; //�÷��̾�� ���� ����ġ�� ���� ����� �߰��� ���� �˴ϴ�.
				
				reCombatInterface();//�κ�� ���� �������� ���� �����Ҽ��ִ� �ݺ��Լ� ��ȯ
			}
			
		}else {
			
			getHit();//���� ü���� 0�� �ƴҶ� �ǰ� �޼ҵ� �ߵ�
			
		}
		
	}
	
	void selectPotion() { //����� ����
		
		do { //���Ƿ������ ������ ���� �ݺ���
		System.out.println("~~~~~����� ������ �������ּ���. ��Ҵ� (3) ~~~~~");
		System.out.println("(1)������ : "+hpPotion+"�� ����");
		System.out.println("(2)�Ķ��� : "+spPotion+"�� ����");
		System.out.println("(3)���");
		System.out.print(">");
		button = scan.nextInt();
		
		switch(button) { //��ĵ���� ��ư�� �Ű���
		
		case 1 :
			usePotion("red");
			potionloop=false; //�������� ����ϸ� ��ݺ� ����
			actSwitch =false; //�ൿ���� �ݺ��� ����
			
			break;
		case 2 :
			usePotion("blue");
			potionloop=false; //�Ķ����� ����ϸ� ��ݺ� ����
			actSwitch=false; //�ൿ���� �ݺ��� ����
			
			break;
		
		case 3 :
			
			System.out.println("�ൿ ������ ȭ������ ���ư��ϴ�."); 
			potionloop=false;//��Ҹ� ������ ����ݺ� ����
			break;
			
		default :
			System.out.println("�������� �ʴ� ��ư�Դϴ�."); //������ ��ư�� ��������
			break;
			
		}
		
		}while(potionloop);
		
	}
	//-------------------------------------------------------------------------------------
	void usePotion(String color) {//�� ��� ����
		
		switch(color) {
		
		case "red" :{ //�������� ����Ұ��
			if(hpPotion>0) {  //�������� 1�� �̻��� ���
				if(player.playerHP+item.hpHeal>=playerMaxHp) {//�� ��뷮�� �ִ�ü��ġ�� �ʰ��� ��
					
					player.playerHP = playerMaxHp; //�÷��̾� �ִ�ü���� �ִ�ü��
					hpPotion--;                     //���� �ϳ� ���
					System.out.println("�������� ����մϴ�. �¸����� ���� ��ģ��!");
					
				}
				else {  //������ ����ؼ� ü���� ä������ �ִ� ü���� �ƴ� ���
					
					player.playerHP+=item.hpHeal; //�÷��̾� ü���� �÷��̾� ü�� ���ϱ� �� ȸ������ �ȴ�
					hpPotion--;   //�������� �ϳ� ���ȴ�.
					System.out.println("�������� ����մϴ�. " +item.hpHeal+ "��ŭ ȸ���Ǿ���!");
				}
		}else{  //�������� 1���� ������
			System.out.println("����� ������ �����ϴ�.");
		}
			System.out.println();
			System.out.println();
			break;}
			
			
		case "blue" :{//�Ķ����� ����Ҷ�
			
			if(spPotion>0) {//�Ķ����� �ϳ��̻��� ���
				
			if(this.playerSP+item.spHeal>=playerMaxSp) {//���� ��뷮�� �ִ�spġ�� �ʰ��� ��
				this.playerSP = playerMaxSp;  //������ �ִ� ������ �ȴ�.
				spPotion--;        //�Ķ��� �ϳ� ����
				System.out.println("�Ķ����� ����մϴ�. ��ȸ�� �븱 �� ���� �� ����!");
			}else {
				
				playerSP += item.spHeal; //������ �������ϱ� ����ȸ���� �� �ȴ�.
			spPotion--;     //�Ķ����ϳ� ����
				System.out.println("�Ķ����� ����մϴ�. " +item.spHeal+ "��ŭ ����� ȸ���Ǿ���!");
				
			}
			}
			else { //�Ķ����� ������
				System.out.println("����� ������ �����ϴ�.");
				}
			System.out.println();
			System.out.println();
			break;}
		}
		
		
	}
	}
	
	

