package src.main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * �������� ���ڸ��� ������ �Է¹ް� �迭�� �����Ѵ�. ���� ������ ���� playerNums�� ����� Ŭ����
 * 
 * @author smr60
 *
 */
public class Player {

	/** ������ ���� �ʿ��� ������ �ڸ� �� */
	private static final int DIGITS = 3;

	/** �÷��̾ �Է��� ���ڸ� �����ϴ� ����Ʈ  */
	List<Integer> playerNums;

	/**
	 * ����ڷκ��� �Է¹��� ���ڸ� �迭�� �����ϴ� �޼ҵ� �Դϴ�. 
	 * �Է¹��� ���� ���ڸ� ���� �ƴϰų�, 0�� �����ϰ� �ְų�, �ߺ��Ǵ� ���� ���ԵǾ� ������ �Է��� �ٽ� �޽��ϴ�.
	 * ���� ���׿� �ش����� ������ ����Ʈ�� playerNums�� �����մϴ�. 
	 */
	public void createNumbers() {
		List<Integer> list = inputIntValue();

		while (!isThreeDigits(list) | hasZero(list) | isDuplicated(list)) {
			list = inputIntValue();
		}
		playerNums = new ArrayList<>(list);
	}

	/**
	 * ����ڷκ��� ���������� �Է��� �޴� �޼ҵ� �Դϴ�. ���ڰ� �Է����� ������ ���, ����ó���� �߻��Ͽ� �ٽ� �Է��� �޽��ϴ�.
	 * 
	 * @return �Է¹��� ������ ���ڸ��� List�� �����Ͽ� ��ȯ�մϴ�.
	 */
	private List<Integer> inputIntValue() {
		Scanner input = new Scanner(System.in);
		System.out.print("���ڸ� �Է����ּ��� : ");
		int inputIntValue;

		while (true) {
			try {
				inputIntValue = input.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.print("���ڸ� �Է����ּ��� : ");
				input = new Scanner(System.in);
			} catch (Exception e) {
			}
		}

		List<Integer> list = new ArrayList<>();
		while (inputIntValue > 0) {
			list.add(0, inputIntValue % 10);
			inputIntValue /= 10;
		}
		return list;
	}

	private boolean isThreeDigits(List<Integer> list) {
		return list.size() == DIGITS;
	}

	private boolean hasZero(List<Integer> list) {
		return list.contains(0);
	}

	private boolean isDuplicated(List<Integer> list) {
		Set<Integer> set = new HashSet<Integer>(list);
		return set.size() < list.size();
	}
}
