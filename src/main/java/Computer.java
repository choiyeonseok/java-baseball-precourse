package src.main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 1���� 9���� ���� �ٸ� ������ �� ���� �����ϴ� Ŭ����
 * 
 * @author smr60
 *
 */
public class Computer {

	/** ������ ���� �ʿ��� ������ �ڸ� �� */
	private static final int DIGITS = 3;
	
	/** ���ӿ� ���Ǵ� ������ ���� 1 ~ 9 �� ����� ���� ��� */
	private static final int MAX = 9;
	private static final int MIN = 1;

	/** ��ǻ�Ͱ� �������� ������ ���ڸ� �����ϴ� ����Ʈ */
	List<Integer> comNums;

	/**
	 * ��ǻ�Ͱ� 1���� 9������ ���δٸ� ������ ���� ����Ʈ�� �����ϴ� �޼ҵ� �Դϴ�.
	 */
	void createNumbers() {
		comNums = new ArrayList<>();
		while (comNums.size() < DIGITS) {
			int rand = (int) ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
			if (!comNums.contains(rand)) {
				comNums.add(rand);
			}
		}
	}
}
