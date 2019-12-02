package src.main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseballGame {

	private static final int DIGITS = 3;
	private static final int EXIT = 2;
	private static final int START = 1;


	private int strike;
	private int ball;

	Computer com;
	Player player;

	BaseballGame() {
		com = new Computer();
		player = new Player();
	}


	void play() {
		while(true) {
			com.createNumbers();
			while(!checkAnswer()) {
				player.createNumbers();
				calculateScore();
				showResult();
			}
			restartOrExit();
		}
		
		
	}

	private void calculateScore() {
		strike = 0;
		ball = 0;
		for (int i = 0; i < DIGITS; i++) {
			if (com.comNums.get(i) == player.playerNums.get(i)) {
				strike++;
			} else if(com.comNums.contains(player.playerNums.get(i))){
				ball++;
			}
		}
	}
	
	private void showResult() {
		String result = "����";
		if (strike > 0 && ball > 0) {
			result = strike + " ��Ʈ����ũ " + ball + "��";
		} else if (strike > 0) {
			result = strike + " ��Ʈ����ũ";
		} else if (ball > 0) {
			result = ball + "��";
		}
		System.out.println(result);
	}
	
	private boolean checkAnswer() {
		if (strike == DIGITS) {
			System.out.println("3���� ���ڸ� ��� ���߼̽��ϴ�! ���� ����");
			System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���");
			return true;
		}
		return false;
	}
	
	private void restartOrExit() {
		Scanner input = new Scanner(System.in);
		int inputValue = 0;
		while (true) {
			try {
				inputValue = input.nextInt();
				break;
			} catch (InputMismatchException e) {
				checkAnswer();
				input = new Scanner(System.in);
			} catch (Exception e) {
			}
		}
		if (inputValue == EXIT) {
			System.exit(0);
		}

		strike = 0;
		ball = 0;

	}
}
