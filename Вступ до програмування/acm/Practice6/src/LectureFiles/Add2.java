package LectureFiles;/*
 * �������� ���������� ��� ������������ ����� While
 * �������� ��������� ���� �����, �� ������� ����������
 * � ��� ���� ��������� ���������� ������
 */


import acm.program.*;

public class Add2 extends ConsoleProgram{

	private static final int SENTINEL = 0; //����� ��� ������ ����� ��������
	
	public void run(){
		
		int total = 0;
		
		while (true){
			int val = readInt("������ �����:");
			if (val == SENTINEL) break;
			total += val;
			
		}
		println("���� = " + total);
	}
	
}
