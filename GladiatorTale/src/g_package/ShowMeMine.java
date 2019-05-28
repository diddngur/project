package g_package;



public class ShowMeMine {

	String playerArmor;  //플레이어 방어구
	String playerWeapon;  //무기
	int playermoney; //돈
	int spPotion;  //빨간약
	int hpPotion;   //파랑약
	
	//다른 클래스에서도 받아오기 위해 생성자를 선언
	ShowMeMine(String playerArmor, String playerWeapon, int playermoney, int spPotion, int hpPotion){
		
		this.playerArmor = playerArmor;
		this.playerWeapon = playerWeapon;
		this.playermoney = playermoney;
		this.spPotion = spPotion;
		this.hpPotion = hpPotion;
		}
	

	//인벤토리를 보여준다
	void showPlayer(){
		
		System.out.println("- - - - - - - - - - - - -(소지품)- - - - - - - - - - - - - - -");
		System.out.println();
		System.out.println("   무기:"+playerWeapon+"  |  갑옷:"+playerArmor+"  |  파란약 :"+spPotion+"  |  빨간약:"+hpPotion+"    "); //종료버튼은 필요없다면 없애도 됨.
		System.out.println();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("자금  :"+playermoney);
	
	}
	
	
}
