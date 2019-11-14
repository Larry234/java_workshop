package java_worksho.student.projects.flash_cards;

import java.io.IOException;

import java_workshop.api.lang.NSystem;;

public class Flash_Cards {
	private static String[] E_cards = {"Apple", "Banana", "Cat", "Dog", "Egg", "Fire", "Ginger", "Hamlet", "Idol", "Joke"};
	private static String[] C_cards = {"蘋果", "香蕉", "貓", "狗", "蛋", "火", "薑", "安全帽", "偶像", "玩笑"};
	
	public static int generateInteger(int range) {
		return (int)(Math.random()*range);
	}
	
	public static boolean pickCard(int version, int index) {
		/* 顯示題目並判斷答案是否正確，正確回傳true，錯誤則回傳false */
		if(version == 1) {
			try {
				String answer = NSystem.readLine("請寫出 " + E_cards[index] + " 的中文:");
				if(answer.equals(C_cards[index])) {
					System.out.println("答對了 恭喜");
					return true;
				}
				else {
					System.out.println("答錯了 繼續努力");
					return false;
				}
				
			}
			catch(IOException ex) {
				System.err.println(ex.getMessage());
				return false;
			}
			
		}
		else {
			try {
				String answer = NSystem.readLine("請寫出 " + C_cards[index] + " 的英文(第一個字須大寫):");
				if(answer.equals(E_cards[index])) {
					System.out.println("答對了 恭喜");
					return true;
				}
				else {
					System.out.println("答錯了 繼續努力");
					return false;
				}
			}
			catch(IOException ex) {
				System.err.println(ex.getMessage());
				return false;
			}
		}
	}
	
	public static void game() throws IOException{
		/*  整個遊戲的執行  */
		boolean game_continue = true;
		System.out.println("歡迎來到flash_cards遊戲~~~");
		while(game_continue) {
			int version = Integer.parseInt(NSystem.readLine("請選擇要玩的模式: 1.給英文猜中文 2.給中文猜英文"));
			for (int i = 0; i < 3; i++) {
				pickCard(version, generateInteger(10));
			}
			String continued = NSystem.readLine("要繼續玩嗎？ (y/n)");
			if (continued.equals("n")) {
				System.out.println("謝謝遊玩!!");
				game_continue = false;
			} else
				game_continue = true;
		}
	}
	
	public static void main(String[] args) {
		try {
			game();
		}
		catch(IOException ex) {
			System.err.println(ex.getMessage());
			System.out.println("謝謝遊玩!!");
		}
	}

	

}
