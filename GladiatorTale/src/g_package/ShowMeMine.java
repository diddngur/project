package g_package;



public class ShowMeMine {

	String playerArmor;  //�÷��̾� ��
	String playerWeapon;  //����
	int playermoney; //��
	int spPotion;  //������
	int hpPotion;   //�Ķ���
	
	//�ٸ� Ŭ���������� �޾ƿ��� ���� �����ڸ� ����
	ShowMeMine(String playerArmor, String playerWeapon, int playermoney, int spPotion, int hpPotion){
		
		this.playerArmor = playerArmor;
		this.playerWeapon = playerWeapon;
		this.playermoney = playermoney;
		this.spPotion = spPotion;
		this.hpPotion = hpPotion;
		}
	

	//�κ��丮�� �����ش�
	void showPlayer(){
		
		System.out.println("- - - - - - - - - - - - -(����ǰ)- - - - - - - - - - - - - - -");
		System.out.println();
		System.out.println("   ����:"+playerWeapon+"  |  ����:"+playerArmor+"  |  �Ķ��� :"+spPotion+"  |  ������:"+hpPotion+"    "); //�����ư�� �ʿ���ٸ� ���ֵ� ��.
		System.out.println();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("�ڱ�  :"+playermoney);
	
	}
	
	
}
