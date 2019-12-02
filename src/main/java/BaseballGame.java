package src.main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ���������� ������ ����ϴ� Ŭ����
 * 
 * @author smr60
 *
 */
public class BaseballGame {

	/** ������ ���� �ʿ��� ������ �ڸ� �� */
	private static final int DIGITS = 3;
	
	/** ������ ���, ������ �����ϱ� ���� ��� */
	private static final int EXIT = 2;
	
	/** ������ ���, ������ ������ϱ� ���� ��� */
	private static final int RESTART = 1;


	/** strike�� ���� */
	private int strike;
	
	/** ball�� ���� */
	private int ball;

	/** ��ǻ�Ϳ� �÷��̾��� ��ü ���� */
	Computer com;
	Player player;

	BaseballGame() {
		com = new Computer();
		player = new Player();
	}

	/**
	 * ��ü ���� ������ �����ϴ� �޼ҵ��Դϴ�. �� �ܰ迡���� �ʿ��� �޼ҵ���� ȣ���մϴ�.
	 */
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

	/**
	 * ��ǻ�Ͱ� ������ ���� �÷��̾ ������ ���� ���Ͽ� strike�� ball�� ������ ����մϴ�. 
	 * ����� �ʿ��� ������ strike�� ball�� 0���� �ʱ�ȭ�� �� ��갪�� ���� �����մϴ�.
	 */
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
	
	/**
	 * �÷��̾��� �Է¿� ���� strike�� ball�� ����� ����� �ݴϴ�.
	 */
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
	
	/**
	 * ������ Ȯ���ϴ� �޼ҵ� �Դϴ�. strike ������ 3�̸� �������� �����ϰ� ���� �޽����� �Բ� ������ �����/���� ���θ� �����ϴ�.
	 * 
	 * @return ������ ��� true�� ��ȯ, �׷��� ������ false�� ��ȯ�մϴ�.
	 */
	private boolean checkAnswer() {
		if (strike == DIGITS) {
			System.out.println("3���� ���ڸ� ��� ���߼̽��ϴ�! ���� ����");
			System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���");
			return true;
		}
		return false;
	}
	
	/**
	 * �÷��̾�� 1 �Ǵ� 2�� �Է� �ް�, 2�� ��쿡�� ���α׷��� ����˴ϴ�. 
	 * ���ڸ� �Է¹ްų�, 1 �Ǵ� 2�̿��� ���� �Է¹޾��� ���� ����ó���� �߻��Ͽ� �ٽ� �Է��� �޽��ϴ�. 
	 * 1�� �Է����� ��� strike�� ball�� 0���� �ʱ�ȭ�ǰ� ������ ������մϴ�.
	 */
	private void restartOrExit() {
		Scanner input = new Scanner(System.in);
		int inputValue = 0;
		while (true) {
			try {
				inputValue = input.nextInt();
				createException(inputValue);
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
	
	/**
	 * 1 �Ǵ� 2�̿��� ������ �Է����� �޾��� ��, ���Ƿ� ����ó���� �߻���Ű�� �޼ҵ� �Դϴ�. ���ܰ� �߻��ϸ� �Է��� �ٽ� �޽��ϴ�.
	 * 
	 * @param inputValue
	 */
	private void createException(int inputValue) {
		if (inputValue != RESTART && inputValue != EXIT) {
			throw new InputMismatchException();
		}
	}
}
