package g_package;

import java.util.Scanner;

public class Combat {//플레이어 란을 부모로 설정.
	
	int button;				//셀렉트 버튼
	boolean combatloop = true; //전투 매커니즘
	boolean actSwitch = true;	//액트 스위치
	boolean potionloop = true;	//포션 선택지 루프
	boolean endingSwitch=false; //엔딩 스위치
	int round=1;                //라운드
	int enemyHp = 10;     
	//적 체력
	int enemyDamage;            //적 대미지
	int enemySp;                //적 마나
	int playerSP;               //플레이어 마나
	int turn;                   //턴수 표기를 위한변수
	static int playerMaxHp;     //플레이어 맥스 hp
	static final int playerMaxSp = 3;  //플레이어 맥스 마나
	String enemyName;          //적이름
	
	int returnMoney=0;      //리턴 머니
	int reward=0;            
	
	String playerArmor;   //플레이어 방어구
	String playerWeapon;   //플레이어 무기
	int playermoney;      //플레이어 돈
	int spPotion;       //마난물약
	int hpPotion;        //체력 물약

	
//타 클래스에서도 값을 받기위해 생성자를 생성해준다.---------------------------------------------------------------------------------------------------------------------------------
	Combat(String playerArmor, String playerWeapon, int playermoney, int spPotion, int hpPotion){ 
		
		this.playerArmor = playerArmor;
		this.playerWeapon = playerWeapon;
		this.playermoney = playermoney;
		this.spPotion = spPotion;
		this.hpPotion = hpPotion;
		
	}
	
//객체화 선언----------------------------------------------------------------------------------------------------------------------------------------------------------
	Item item = new Item();
	Player player = new Player();
	Scanner scan = new Scanner(System.in);


//적 세팅을 위한 메소드-------------------------------------------------------------------------------------------------------------
	void enemySet(int round) {
		
		switch(round) {//라운드를 매개로 설정해 라운드가 진행될수록 적이 바낌
		
		
		case 1 :  //라운드가 1일시
			
			this.enemyHp =1000;
			this.enemyName = "잔챙이";
			this.reward = 5000;
			enemySp=3;
			break;
			
		case 2 : //라운드가 2일시
			
			this.enemyHp =5000;
			this.enemyName = "콜로세움 붙박이";
			this.reward = 10000;
			enemySp=3;
			break;
			
		case 3 : //라운드가 3일시
			
			this.enemyHp =10000;
			this.enemyName = "챔피언";
			this.reward = 10000000;//챔피언 리워드는 나중에 생각할 것
			enemySp=3;
			break;
			
		}
		//예외처리 고려해볼 것	
	}
	//--------------------------------------------------------------------------------------------------------
	void getSetPlayer() {//전투인트로 때 플레이어의 체력을 설정하는 것
		
		playerSP = playerMaxSp;//플레이어 스킬포인트 초기값
		player.playerHP=2000;//플레이어 체력을 초기값으로 설정합니다.
		item.armorSet(playerArmor);//아이템 클라스의 필드값을 현재 플레이어가 착용하고 있는 옵션으로 바꿉니다.
		item.setPotion("red");
		item.setPotion("blue");
		player.playerHP +=item.armorHp;  //착용한 갑옷의 아머 체력을 추가하기.
		playerMaxHp = player.playerHP;//맥스체력 설정
		
	}
	//전투인트로 메소드---------------------------------------------------------------------------------------------
	void combatIntro() {
		System.out.println("");
		System.out.println("");
		if(round==1) { //라운드가 1일때
		System.out.println(">>경기장에 입성했습니다..");
		}else { //그외의 경우(라운드가 진행되었을때)
		System.out.println(">>당신은 다음 적을 향해 나아갑니다.. ");
		}
		enemySet(round);//적 세팅...(라운드에 영향을 받는다)
		turn=0;//턴수 초기화
		if(round==1) {
			getSetPlayer();//라운드 1일때 플레이어 체력초기설정값. 매 라운드마다 체력이 회복되게 하려면  이프 구문을 지워주세요.
		}
		System.out.println("system : round "+round+"!"+ "당신의 적은 "+enemyName+"입니다!");//라운드를 출력하고 적을 알려줍니다.
		System.out.println("system : 검투사 출격!");
		System.out.println("");
		System.out.println("");
		combatloop=true;
		
		
	}
	
	
	
	//전투메커니즘-------------------------------------------------------------------------------------------------------------
	void combatInterface() {
		
		do{//전투 매커니즘 순환구문
			++turn;  //턴이 증가합니다.
			do {//액트스위치가 켜져있을때에는 선택지를 계속 보여줍니다.
			System.out.println("                         Round:"+round+"                    턴 수:"+turn);
			System.out.println("                         <"+enemyName+">                        ");
			System.out.println("- - - - - - - - - - - 적 체력: "+enemyHp+"- - - - - - - - - - - - - ");
			System.out.println(); 
			System.out.println("       1. 공격               |      2. 스킬             |      3. 소지품             "); //종료버튼은 필요없다면 없애도 됨.
			System.out.println();
			System.out.println("- - - - - - - - - - 플레이어 체력: "+player.playerHP+"- - - - - - - - - - - - ");
			System.out.println("                                       스킬 사용 가능 횟수 :"+playerSP+"             ");
			System.out.println("");
			System.out.print("검투사는 무엇을 할까?   >");
			button = scan.nextInt();//버튼 스캔 받기
			System.out.println("");
			switch(button) {//버튼에따라 선택지를 다르게 해주기 위해서 스위치 케이스 구문을 써준다.
			
			
			case 1: { //1번을 눌렀을때
				
				combatDamage();
				
				break;
			}
			
			case 2:{
				
				skillUse();
				//스킬 사용 메소드 작동. 적 체력에서 데미지만큼 차감됨.

				break;
			}
			
			case 3:{
				selectPotion();//물약 선택지
				break;
				
			}

			default : {
				System.out.println("존재하지 않는 선택지입니다.");
			}
			
			}//스위치 구문
		}while(actSwitch);//액트스위치가 켜져있을때에는 계속 돕니다.
			
			enemyHpCheck(enemyHp);//적 체력 체크구문. 승리분기점. 적이 살아있으면 적이 플레이어를 때림.
			
			ifPlayerDead();//플레이어 체력체크구문. 패배분기점.
			
			actSwitch=true; //액트 스위치 초기화
			
			}while(combatloop);	//전투 매커니즘 순환구문
		
		
	}//메소드 껍데기
	
	
	//플레이어가 때릴 때---------------------------------------------------------------------------------------------------------------------------
	void combatDamage() {

		System.out.println("system : 검투사가 "+playerWeapon+" 을(를) 휘둘러 피해를 입힙니다.");
		item.weaponSet(playerWeapon);//아이템 데미지(필드값)을 갱신함.
				
		if(enemyHp<item.damage) { //엘스부분먼저 봐주자
			enemyHp=0;//적의 체력이 -값이 안되도록 만드는 것
		}else {
			enemyHp-=item.damage;//적의 체력은 적의 체력에서 아이템클래스의 대미지만큼 줄어든다.
		}
		
		System.out.println(enemyName+ "(이)가 "+item.damage+"만큼 피해를 입습니다.");
		System.out.println(enemyName+" : 으아악!");
		System.out.println("");
		System.out.println("");
		
		actSwitch=false;	//액트 스위치 비활성화.(행동 끝)
		
	}
	
	
	//플레이어가 스킬을 쓸 때------------------------------------------------------------------------------------------------------------------------
	void skillUse() {
		if(playerSP>0) { //마나가 0보다 크다면

		System.out.println("system : 검투사가 "+playerWeapon+"의 스킬 사용!"); // 스킬이름을 사용할 경우 계승받아서 출력하면 됨.
		System.out.println("필살 진심 시리즈. 진심 휘두르기!");
		item.weaponSet(playerWeapon);
		
		if(enemyHp<item.skill) {  //엘스부분먼저 봐주자
			enemyHp=0;  //적의 체력이 -값이 안되도록 만드는 것
		}else {
			enemyHp-=item.skill;//적의 체력은 적의 체력에서 아이템클래스의 대미지만큼 줄어든다.
		}
		
		System.out.println("system : 적"+enemyName+"에게 "+item.skill+"만큼의 스킬 데미지를 입혔습니다.");
		System.out.println(enemyName+" : 살살해라... ");
		System.out.println("");
		System.out.println("");
		playerSP--;//스킬을 쓸 때마나 마나가 하나씩 줄어듬
		
		actSwitch=false;//액트 스위치 비활성화.(행동 끝)
		
		}else{//마나가 없다면(마나가 0보다 크지 않다면)
			
			System.out.println("스킬포인트가 0이라 스킬을 사용할 수 없습니다.");
		}
		
		
	}
	
	
	//피격 메소드---------------------------------------------------------------------------------------------------
	void getHit() {
		
		double enemyskillCase; //스킬을쓸떄 대미지를 위해 대미지에 곱해주는 값
		
		System.out.println("system : 적 "+enemyName+"(이)가 당신을 공격합니다.");
		
		int enemySkillchance =(int)(Math.random()*4+1);//스킬발동확률 25프로.(1~4까지의 랜덤숫자를 뽑는다)
		
		switch(round) {
		
		
		case 1:
			
			this.enemyDamage = (int)(Math.random()*30+1)+50;  //30~50의 숫자를 적 대미지에 대입한다
			enemyskillCase = 1.5;                             //적이 스킬을 사용할때 일반대미지에 곱해줄값
			
			Damaged(enemySkillchance,enemyskillCase);         //대미지드라는 함수를 불러온다(밑에 설명)
			
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
	
	void ifPlayerDead() {     //플레이어 체력 체크함수
		if(player.playerHP==0) {        //만약 플레이어가 체력이 0이 된다면
		
			//게임오버 함수. 외부 객체를 참조해야 합니다.
			System.out.println("<GAME OVER?>");
			System.out.println("");
			System.out.println(enemyName+": 크하학! 더 강해져서 와라, 애송이!");
			System.out.println("당신은 경기에서 졌습니다.. 진짜 콜로세움에 다음은 없습니다만, 적의 자비로 목숨만은 건졌습니다.");
			System.out.println("");
			System.out.println("");
			
			combatloop=false;          //전투화면 반복문을 종료
		}
	}
	
	
	
	
	void Damaged(int enemySkillchance, double enemyskillCase) {     //대미지 함수(적스킬 확률(1/4확률), 적 스킬대미지(일반대미지에 곱해줄 값)을 매개로 받는다)
		
		if (enemySkillchance==4&&enemySp>0) { //만약 랜덤 숫자(1~4까지의 랜덤숫자) 중에 4가 나오고 마나가 0보다 많다면
			
			int skillDamage =(int)(this.enemyDamage*enemyskillCase);     //스킬대미지는 적대미지에 일정 수를 곱해주어 대미지를 계산한다
			
			if(skillDamage>player.playerHP) {     //만약 적 스킬 대미지가 플레이어 체력보다 높다면
				 
				player.playerHP=Player.playerMinHP;   //플레이어 체력은 플레이어의 최소 체력( 0 )이 된다.
			}
			else{                             //나머지 경우에는(스킬대미지가 플레이어 체력보다 낮다면)
				
				player.playerHP-=skillDamage;   //플레이어 체력은 플레이어 체력에서 스킬대미지를 뺸다
				
				}
			enemySp--;   //마나가 하나 줄어든다.
			if(round==3) {
				System.out.println("");
				System.out.println("적이 주변을 두리번 거리면서 몰래 품에 숨겨둔 총을 꺼냅니다. ");
				System.out.println("심판이 안본 틈을타서 스킬을 사용합니다.");
				System.out.println("'석양이...진다...'");
			}
			else {
				System.out.println("");
				System.out.println("'받아랏!!'");
				
			}
			System.out.println("system : 적이 스킬을 사용합니다..."+skillDamage+"만큼의 피해를 입었습니다.");
			System.out.println("");
			System.out.println("");
			//System.out.println("적의 남은 스킬 사용 횟수 :"+enemySp);
			
		}else {  //스킬확률 (1~4의 랜덤 숫자중에 4가 나올경우)를 뺀 나머지 경우에는
			if(this.enemyDamage>player.playerHP) {   //만약 적대미지가 플레이어 체력보다 높다면 
				
				player.playerHP=Player.playerMinHP; //플레이어 체력을 0으로 설정합니다.
				
			}
			else {   //적대미지가 체력보다 낮다면
				
			player.playerHP-=this.enemyDamage; //플레이어 체력은 체력에서 적대미지를 뺸것을 적용한다.
			
			}
			System.out.println("system : 이런! 검투사는 "+this.enemyDamage+"만큼의 부상을 입었다!");
			System.out.println("");
			System.out.println("");
		}
		
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	void reCombatInterface() { //적을 쓰러트리고 난 화면
		
		boolean re =true;       //반복문을 돌리기위해 참 값을 준다.
		
		do{
		System.out.println();
		System.out.println();
		System.out.println("경기가 끝났습니다. 로비로 돌아갈까요?");
		System.out.println("- - - - - - - - - - - - - - - - - - - - ");
		System.out.println("1. 다음 상대와 결투    | 2. 콜로세움 로비로 돌아가기 ");
		System.out.println("- - - - - - - - - - - - - - - - - - - - ");
		System.out.print(">");
		button =scan.nextInt();
	
		switch(button) {
		
		
		case 1: {    //1번을 눌렀을때 (다음라운드 진행)

			round++; //라운드를 증가시키고 적을 다시 소환한다.
			
			re=false;    //반복문을 종료시키기 위해 거짓값을준다.
			
			combatIntro();   //전투인트로를 소환
			
			break;    
		}
		
		case 2:{    //2번을 눌렀을때 (로비로 돌아갈때)
			System.out.println("콜로세움 로비로 돌아갑니다.");
			re=false; //반복문 종료를 위해 거짓값을 준다.
			combatloop=false;  //전투 반복문도 종료를 시켜주기위해 거짓값을 준다.
			break;
		}
		default : {   //나머지 키를 눌렀을때 
			
			System.out.println("존재하지 않는 버튼입니다.");
			
		}
		
		}
			
		}while(re);
		
	}
	

	//---------------------------------------------------------------------------------------------
	void enemyHpCheck(int enemyHp) { //적체력 확인을 위한 함수(적 체력을 매개로 받는다/)
		
		if(enemyHp<=0) { //적 체력이 0보다 작거나 같을때
			System.out.println("승리!");
			
			System.out.println(enemyName+"이(가) 쓰러졌습니다!");
			

			
			if(round==3) {  //만약 3라운드 일때(최종 보스를 잡았을때)
				System.out.println();
				System.out.println();
				System.out.println("총으로 얻은 비겁한 챔피언 자리를 빼앗았습니다!");
				System.out.println("이 자리까지 온 검투사에게 영예로운 챔피언 벨트가 주어집니다.");
				System.out.println("검투사는 가벼운 발걸음으로 콜로세움을 떠납니다. 그가 지나간 자리에는 적들의 두려움만이 남았습니다.");
				System.out.println("승리와 함께 콜로세움의 위상도 지킨 검투사를 마을 사람들이 길이 칭송할 것입니다.");
				System.out.println();
				System.out.println();
				//ending credit 함수 발동. 여기말고 인트로로 할까?
				endingSwitch=true; //엔딩반복문을 참 값으로 준다 
				combatloop=false; //전투 반복문 종료를 위해 거짓값
			
			}
			else{  //나머지 경우 (최종보스가 아닌 나머지 적들을 잡았을 경우)
				
				System.out.println(this.reward+"만큼 자금을 얻습니다.");//플레이어에게서 머니를 배당받습니다.
				//용돈 받고 라운드 종료
				returnMoney += reward; //플레이어돈은 적을 물리치고 얻은 상금을 추가한 돈이 됩니다.
				
				reCombatInterface();//로비로 갈지 다음라운드 갈지 선택할수있는 반복함수 소환
			}
			
		}else {
			
			getHit();//적의 체력이 0이 아닐때 피격 메소드 발동
			
		}
		
	}
	
	void selectPotion() { //약고르는 변수
		
		do { //포션루프라는 조건을 통해 반복됨
		System.out.println("~~~~~사용할 물약을 선택해주세요. 취소는 (3) ~~~~~");
		System.out.println("(1)빨간약 : "+hpPotion+"개 보유");
		System.out.println("(2)파란약 : "+spPotion+"개 보유");
		System.out.println("(3)취소");
		System.out.print(">");
		button = scan.nextInt();
		
		switch(button) { //스캔받은 버튼을 매개로
		
		case 1 :
			usePotion("red");
			potionloop=false; //빨간약을 사용하면 약반복 종료
			actSwitch =false; //행동선택 반복문 종료
			
			break;
		case 2 :
			usePotion("blue");
			potionloop=false; //파란약을 사용하면 약반복 종료
			actSwitch=false; //행동선택 반복문 종료
			
			break;
		
		case 3 :
			
			System.out.println("행동 선택지 화면으로 돌아갑니다."); 
			potionloop=false;//취소를 누르면 물약반복 종료
			break;
			
		default :
			System.out.println("존재하지 않는 버튼입니다."); //나머지 버튼을 눌렸을때
			break;
			
		}
		
		}while(potionloop);
		
	}
	//-------------------------------------------------------------------------------------
	void usePotion(String color) {//약 사용 구현
		
		switch(color) {
		
		case "red" :{ //빨강약을 사용할경우
			if(hpPotion>0) {  //빨강약이 1개 이상일 경우
				if(player.playerHP+item.hpHeal>=playerMaxHp) {//약 사용량이 최대체력치를 초과할 때
					
					player.playerHP = playerMaxHp; //플레이어 최대체력은 최대체력
					hpPotion--;                     //약은 하나 사용
					System.out.println("빨간약을 사용합니다. 온몸에서 힘이 넘친다!");
					
				}
				else {  //물약을 사용해서 체력을 채웠을때 최대 체력이 아닌 경우
					
					player.playerHP+=item.hpHeal; //플레이어 체력은 플레이어 체력 더하기 약 회복량이 된다
					hpPotion--;   //빨간약은 하나 사용된다.
					System.out.println("빨간약을 사용합니다. " +item.hpHeal+ "만큼 회복되었다!");
				}
		}else{  //빨간약이 1개도 없을때
			System.out.println("사용할 물약이 없습니다.");
		}
			System.out.println();
			System.out.println();
			break;}
			
			
		case "blue" :{//파랑약을 사용할때
			
			if(spPotion>0) {//파랑약이 하나이상일 경우
				
			if(this.playerSP+item.spHeal>=playerMaxSp) {//물약 사용량이 최대sp치를 초과할 때
				this.playerSP = playerMaxSp;  //마나는 최대 마나가 된다.
				spPotion--;        //파랑약 하나 감소
				System.out.println("파란약을 사용합니다. 기회를 노릴 수 있을 것 같다!");
			}else {
				
				playerSP += item.spHeal; //마나는 마나더하기 마나회복량 이 된다.
			spPotion--;     //파랑약하나 감소
				System.out.println("파란약을 사용합니다. " +item.spHeal+ "만큼 기력이 회복되었다!");
				
			}
			}
			else { //파랑약이 없을때
				System.out.println("사용할 물약이 없습니다.");
				}
			System.out.println();
			System.out.println();
			break;}
		}
		
		
	}
	}
	
	

