package g_package;

import java.util.Scanner;

public class Intro {

//출력할 메인 인트로
	//글래디에이터 스토리
	//타이틀 화면 출력하고
	//메인화면 띄우기
	
	String playerArmor="기본(맨피부)";
	String playerWeapon="기본(맨주먹)";
	int playermoney=0;
	int spPotion=0;
	int hpPotion=0;
	
	boolean mainloop = true;
	int button;
	

	
	Scanner scan = new Scanner(System.in);

	
	
	void Prologue() {//프롤로그 택스트
		System.out.println("\t세상은 더이상 육체노동을 반기지 않고 모든 육체노동은 로봇이 대신하게 되었으며 ");
		System.out.println("\t\t사람들은 오로지 머리로만 먹고 살아야하는 5G시대가 왔습니다.");
		System.out.println("머리만쓰느라 육체를 쓰는일이 없어지고 이로인해 넘치는 건강미를 분출하지 못한 사람들로 부터 점점 범죄가 늘었습니다.");
		System.out.println("정부는 이를 보완하고자 콜로세움을 만들어서 서로의 강함을 겨루고 강자들에게 명예와 막대한 상금을 지급하는 대회를 개최하였고 ");
		System.out.println("\t\t      이에 참가하는 사람들은 검투사라고 불렸습니다. ");
		System.out.println("\t  당신또한 부와 명예..원피ㅅ….를 차지하기 위하여 이 대회에 참가하게 되었습니다.");
		System.out.println("\t부디 해적와..ㅇ… 아니 챔피온이 되어 명예와 막대한 부를 가져가시기를 바랍니다.");
		System.out.println("");
		System.out.println("");
		System.out.println("\t\t\t-<검투사의 모험>-");
		System.out.println("");
	}
	void sadEnding() { //세드엔딩 택스트
		System.out.println(" 막상 전투에 참가하려니 당신은 겁에 질려 다시 고향으로 내려가서 열심히 교육을 들으며");
		System.out.println("\t허튼생각않고 5G시대의 훌륭한 두뇌가 되기를 다짐합니다.");
		System.out.println("\t     -----sadEnding-----");
		
	}
	
	void happyEnding() {//해피엔딩 택스트
		System.out.println("<제작자의 말>"
				
				+ "축하합니다!!\r\n" + 
				"당신은 모든 강자를 무찌르고 당당히 해적와..ㅇ...이아닌 챔피온이 되었습니다!! \r\n" + 
				"플레이해주셔서 감사합니다.\r\n" + 
				"앞으로 다른 프로젝트에서도 열심히 하는모습 보여드리도록 하겠습니다.\r\n" + 
				"\r\n" + 
				" 제작자 : 이소현   (농협은행 352-0696-6775-53)\r\n" + 
				"               양우혁   (신한은행 110-400-743560) \r\n" + 
				"  후원은 제작자에게 큰 힘이 됩니다. \r\n" + 
				"");
	}
	
	
	void MainInterface() {
		
		//콜로세움에 들어가게 되는데...
		
		//결투하기 상점가기 소지품
		
		do{ //두 와일문으로 반복해줌
			
		Combat combat = new Combat(playerArmor, playerWeapon, playermoney, spPotion, hpPotion);
		ShowMeMine show = new ShowMeMine(playerArmor, playerWeapon,playermoney,spPotion,hpPotion);
		Shop shop = new Shop(playerArmor, playerWeapon,playermoney,spPotion,hpPotion);
		
		System.out.println("");
		System.out.println("");
		System.out.println("@=============@==========[(콜로세움 로비)]==========@===============@ ");
		System.out.println("||           ||                ||              ||              || ");
		System.out.println("||  1. 결투하기  ||    2. 상점              ||   3. 소지품         ||  4. 게임 종료       || "); //종료버튼은 필요없다면 없애도 됨.
		System.out.println("||           ||                ||              ||              || ");
		System.out.println("@=============@================@================@===============@");
		System.out.println("자금  :"+playermoney);
		//스캔 받기
		System.out.print(">");
		button = scan.nextInt();
		
		switch(button) {
		
		
		case 1: {
			
			//무기 상태 넘겨주고
			//갑옷 상태 넘겨주고
			combat.round=1; //라운드값 초기화
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
			
			//메인의 플레이어 머니를 가지고 상점으로 넘어감
			shop.comingShop();
			//상점에서도 리턴머니값 / 메인에 장비 변경사항 전해주세요.
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
			
			mainloop = false; //빠져나오고 종료
			sadEnding();
			System.out.println("\t-검투사의 모험- 을 종료합니다. 다음에 또 만나요!");
			
			break;
		}
		default : {
			
			System.out.println("존재하지 않는 선택지입니다.");
		}
		
		}
		
		}while(mainloop);
		
	}
	
	
}
