package LectureFiles;/*
 * �������� ���������� ��� ������������ ����� While
 * �������� ��������� ���� �����, �� ������� ����������
 */


import acm.program.*;

public class Add extends ConsoleProgram{

	private static final int SENTINEL = 0; //����� ��� ������ ����� ��������
	
	public void run(){
		
		int total = 0;
		int val = readInt("������ �����:");
		
		while (val != SENTINEL){
			total += val;
			val = readInt("������ �����:");
		}
		println("���� = " + total);
	}
	
}
