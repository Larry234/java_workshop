/**
 * 
 */
package java_workshop.teacher.projects.flash_cards.trials.use_two_arrays;

import java.io.IOException;

import java_workshop.api.lang.NSystem;

/**
 * @author ganrqunx 使用兩個arrays放置前面跟背面的結果 未來再加入載入array的方法：檔案、設定檔
 *         使用Math.random()取得在0~array lenth- 1之間的亂數 以front 詢問 back 檢查結果 正確：恭喜、下一題
 *         錯誤：再問一次or 換題 先簡化邏輯： 正確：恭喜、繼續問 錯誤：你錯了、繼續問 輸入為空字串、詢問是否離開？ 空字串, 離開，其他繼續
 *
 */
public class FlashCards {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 建立矩陣
		String[] fronts = { "A", "B", "C", "D", "E" };
		String[] backs = { "a", "b", "c", "d", "e" };
		int cardCnt = fronts.length;
		// 歡迎詞及遊戲方式
		NSystem.readLine("歡迎使用記憶卡功能，按任一鍵繼續……");
// * 先簡化邏輯：
		// 先建立一個無限迴圈
		while (true) {
			// 問問題
//			/*
//			 * 得到亂數值
			int id = getRandomId(cardCnt);
//			 * 取得front
			String front = fronts[id];
			String back = backs[id];
//			 * 詢問
			String ans = NSystem.readLine("正面為" + front + "，請問背面為何？離開請直接按enter……");
//			 * 檢查
			if (ans == null || ans.equals("")) {
				ans = NSystem.readLine("如要離開請按enter，否則按其他鍵……");
				if (ans == null || ans.equals("")) {
					System.out.println("謝謝使用本功能！！");
					break;
				}else {
					//繼續程式
					continue;
				}
			}
			boolean isCorrect = ans.equals(back);
//			 */
// * 正確：恭喜、繼續問
			if (isCorrect) {
				System.out.println("恭喜答對了，下一題……");
				continue;
// * 錯誤：你錯了、繼續問
			} else {
				System.out.println("抱歉你答錯了，下一題……");
				continue;
				
			}

		}

	}

	/*
	 * 傳入記憶卡張數
	 * 回傳0-cardCnt - 1 之間的隨機整數
	 * 演算法：0 ~ 1的隨機double * cardCnt , 取整數部位(trunc)
	 */
	private static int getRandomId(int cardCnt) {
		double dblRandom = cardCnt* Math.random();
		int randomId = (int)Math.floor(dblRandom);
		return randomId;
	}

}
