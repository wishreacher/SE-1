package LectureFiles;/*
 * ������� ����
 */



import java.awt.Color;

import acm.program.*;
import acm.graphics.*;

public class CircleExamle extends GraphicsProgram{
	
	public void run(){
		
		GOval o = filledCircle(10,10,2,Color.RED);
		add(o);
		
		//add(filledCircle(10,10,2,Color.RED));
	}
	
	//x,y ����� ����, r �����
	private GOval filledCircle(int x, int y, double r, Color color){
		GOval circle = new GOval (x-r, y-r, 2*r, 2*r);
		circle.setFilled(true);
		circle.setColor(color);
		return circle;
	}

}
