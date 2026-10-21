package newOne;

import javax.swing.*;
import java.awt.*;

public class FourHouses extends JPanel{
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int cx = getWidth() / 2;
		int cy = getHeight() / 2;
		int d = 160;
		
		g.setColor(Color.RED);
		house(g, 0, cx, cy - d);
		
		g.setColor(Color.GREEN);
		house(g, 90, cx+d, cy);
		
		g.setColor(Color.ORANGE);
		house(g, 180, cx, cy+d);
		
		g.setColor(Color.MAGENTA);
		house(g, 270, cx-d, cy);
	}
	
	void house(Graphics g, int angle, int tx, int ty) {
		// Base
        tLine(g, -100, 100, 100, 100, angle, tx, ty);
        tLine(g, 100, 100, 100, 300, angle, tx, ty);
        tLine(g, 100, 300, -100, 300, angle, tx, ty);
        tLine(g, -100, 300, -100, 100, angle, tx, ty);

        // Roof
        tLine(g, -100, 100, 0, 0, angle, tx, ty);
        tLine(g, 0, 0, 100, 100, angle, tx, ty);

        // Door
        tLine(g, -30, 300, 30, 300, angle, tx, ty);
        tLine(g, 30, 300, 30, 220, angle, tx, ty);
        tLine(g, 30, 220, -30, 220, angle, tx, ty);
        tLine(g, -30, 220, -30, 300, angle, tx, ty);
	}
	
	void tLine(Graphics g, int x1, int y1, int x2, int y2, int angle, int tx, int ty) {
		double rad = Math.toRadians(angle);
		double c = Math.cos(rad);
		double s = Math.sin(rad);
		
		//scale
		double ax = (x1 - 0) * 0.6;
		double ay = (y1 - 160) * 0.6;
		double bx = (x2 - 0) * 0.6;
		double by = (y2 - 160) * 0.6;
		
		//rotate + translate
		int nx1 = (int) Math.round(ax*c - ay*s + tx);
		int ny1 = (int) Math.round(ax*s + ay*c + ty);
		int nx2 = (int) Math.round(bx*c - by*s + tx);
		int ny2 = (int) Math.round(bx*s + by*c + ty);
		
		drawDDA(g, nx1, ny1, nx2, ny2);
	}
	
	public void drawDDA(Graphics g, int x1, int y1, int x2, int y2) {
		int dx = (x2 - x1);
		int dy = (y2 - y1);
		
		int steps = Math.max(Math.abs(dx), Math.abs(dy));
		
		if(steps == 0) {
			g.fillRect(x1, y1, 2, 2);
			return;
		}
		
		float xInc = (float) dx / steps;
		float yInc = (float) dy / steps;
		
		int x = x1;
		int y = y1;
		
		for(int i = 0; i <= steps; i++) {
			g.fillRect(Math.round(x), Math.round(y), 2, 2);
			x += xInc;
			y += yInc;
			
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Assigment 4");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.add(new FourHouses());
		frame.setVisible(true);
	}
}







package newOne;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class BresenhamLine extends JPanel{

    int x1, x2, y1, y2;
 
    BresenhamLine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.RED);
        drawBresenhamLine(g, x1, y1, x2, y2);
    }

    void drawBresenhamLine(Graphics g, int x1, int y1, int x2, int y2){
    	int dx = Math.abs(x2 - x1);
    	int dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;

        int x = x1;
        int y = y1;

        if(dx >= dy){
            int p = 2 * dy - dx;
            for(int i = 0; i <= dx; i++){
            	g.fillRect(x, y, 2, 2);
                System.out.println("(" + x + ", " + y + ")");
                x += sx;
                if(p < 0){
                    p = p + 2 * dy;
                }else{
                    y += sy;
                    p = p + 2 * dy - 2 * dx;
                }
            }
        }else{
            int p = dx - dy;
            for(int i = 0; i <= dy; i++){
            	g.fillRect(x, y, 2, 2);   
                System.out.println("(" + x + ", " + y + ")");
                y += sy;
                if(p < 0){
                    p = p + 2 * dx;
                }else{
                    x += sx;
                    p = p + 2 * dx - 2 * dy;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Enter starting point x1 y1 : ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
 
        System.out.print("Enter ending point x2 y2   : ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
 
        JFrame frame = new JFrame("Bresenham Line Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new BresenhamLine(x1, y1, x2, y2));
        frame.setVisible(true);
    }
}








package newOne;

import javax.swing.*;
import java.awt.*;


public class DDALineSimple extends JPanel {

   
    int[][] lines = {
        {50,  50,  300, 200},   // slanted line
        {50,  300, 300, 300},   // horizontal line
        {400, 50,  400, 250},   // vertical line
        {100, 500, 200, 380},   // triangle side 1
        {200, 380, 300, 500},   // triangle side 2
        {300, 500, 100, 500}    // triangle side 3
    };

    
    Color[] colors = {
        Color.RED,
        Color.BLUE,
        Color.GREEN,
        Color.MAGENTA,
        Color.MAGENTA,
        Color.MAGENTA
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < lines.length; i++) {
            g.setColor(colors[i]);
            ddaLine(g, lines[i][0], lines[i][1], lines[i][2], lines[i][3]);
        }
    }

   
    void ddaLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        if (steps == 0) {                  
            g.fillRect(x1, y1, 2, 2);
            return;
        }

        float xInc = (float) dx / steps;
        float yInc = (float) dy / steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.fillRect(Math.round(x), Math.round(y), 2, 2);
            x = x + xInc;
            y = y + yInc;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DDA Line Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new DDALineSimple());
        frame.setVisible(true);
    }
}






package newOne;

import javax.swing.*;
import java.awt.*;

public class BresenhameCicle extends JPanel{
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int xc = getWidth()/2;
		int yc = getHeight()/2; 
		
		g.setColor(Color.RED);
		drawCircle(g, xc, yc, 100 );
	}
	
	void drawCircle(Graphics g, int xc, int yc, int r) {
		int x = 0;
		int y = r;
		int d = 3 - 2*r;
		
		plotPoints(g, xc, yc, x, y);
		
		while(x < y) {
			if(d<0) {
				d = d +4*x+6;
			}else {
				d = d + 4*(x-y) + 10;
				y--;
			}
			x++;
			plotPoints(g, xc, yc, x, y);
		}
	}
	    
	void plotPoints(Graphics g, int xc, int yc, int x, int y) {
		g.fillRect(xc+x, yc+y, 2, 2);
		g.fillRect(xc-x, yc+y, 2, 2);
		g.fillRect(xc+x, yc-y, 2, 2);
		g.fillRect(xc-x, yc-y, 2, 2);
		g.fillRect(xc+y, yc+x, 2, 2);
		g.fillRect(xc-y, yc+x, 2, 2);
		g.fillRect(xc+y, yc-x, 2, 2);
		g.fillRect(xc-y, yc-x, 2, 2);
	}  
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Bresenham Circle to Face");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.add(new BresenhameCicle());
		frame.setVisible(true);
	}
} 








package newOne;

import javax.swing.*;
import java.awt.*;

public class MidpointCircle extends JPanel{
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int cx = getWidth() / 2;
		int cy = getHeight() / 2;
		
		g.setColor(Color.RED);
		midPoint(g, cx, cy, 100);
		
		g.setColor(Color.BLUE);
		midPointSmile(g, cx, cy, 60);
		
		g.setColor(Color.ORANGE);
		midPoint(g, cx-50, cy-30, 20);
		
		g.setColor(Color.ORANGE);
		midPoint(g, cx+50, cy-30, 20);
	}
	
	void midPoint(Graphics g, int cx, int cy, int r) {
		int x = 0;
		int y = r;
		int p = 1 - r;
		
		plotPoint(g, cx, cy, x, y);
		
		while(x < y) {
			x++;
			if(p < 0) {
				p = p + 2 * x + 1;
			}else {
				y--;
				p = p + 2 * (x - y) + 1;
			}
			plotPoint(g, cx, cy, x, y);
		}
	}
	
	void midPointSmile(Graphics g, int cx, int cy, int r) {
		int x = 0;
		int y = r;
		int p = 1 - r;
		
		plotPointSmile(g, cx, cy, x, y);
		
		while(x < y) {
			x++;
			if(p < 0) {
				p = p + 2 * x + 1;
			}else {
				y--;
				p = p + 2 * (x - y) + 1;
			}
			plotPointSmile(g, cx, cy, x, y);
		}
	}
	
	void plotPoint(Graphics g, int cx, int cy, int x, int y) {
		g.fillRect(cx+x, cy+y, 2, 2);
		g.fillRect(cx-x, cy+y, 2, 2);
		g.fillRect(cx+x, cy-y, 2, 2);
		g.fillRect(cx-x, cy-y, 2, 2);
		g.fillRect(cx+y, cy+x, 2, 2);
		g.fillRect(cx-y, cy+x, 2, 2);
		g.fillRect(cx+y, cy-x, 2, 2);
		g.fillRect(cx-y, cy-x, 2, 2);
	}
	
	void plotPointSmile(Graphics g, int cx, int cy, int x, int y) {
		g.fillRect(cx+x, cy+y, 2, 2);
		g.fillRect(cx-x, cy+y, 2, 2);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Midpoint Circle Algorithm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.add(new MidpointCircle());
		frame.setVisible(true);
	}
}