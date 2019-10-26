/**
 * 打算：改成：java_classes => java_workshop
 * java_workshop.api.lang
 * java.workshop.teacher
 * by lessons, unit, chapter
 * by subjects
 * organize in the final phase
 * java.workshop.student
 */
package java_workshop.api.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ganrqunx 本Class目的為於提供一個可以在Eclipse除錯模式下執行的命令列文字輸入功能
 *         模仿：System.out.println(...), template: syso => NSystem.in.readLine(),
 *         template: sysi 只有一個in public static final InputStream in
 *
 */
public class NSystem {
	private static BufferedReader br;

	public static String readLine(String prompt) throws IOException {
		System.out.println(prompt);
		return readLine();

	}
	public static String readLine() throws IOException {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		return br.readLine();
	}

	public static void main(String[] args) throws IOException {
		/*
		 * use this to test readLine
		 */
		System.out.println("You can test readLine() for five times...");
		for (int id = 0; id < 5; id++) {
			System.out.println("Please enter somthing...");
			String ans = readLine();
			System.out.println("What you enter is: **"+ans+"**...");

		}

	}

}
