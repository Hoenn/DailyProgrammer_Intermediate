package Challenge_7;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import javax.swing.JApplet;
import javax.swing.JFrame;

public class Challenge_7 extends JApplet {

  public void init() {
    setBackground(Color.gray);
    setForeground(Color.white);
  }


  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    g2.setPaint(Color.white);
    
    drawFractal(500, 500,150, Math.toRadians(0), g2);
    drawFractal(500, 500,150, Math.toRadians(45), g2);
    drawFractal(500, 500,150, Math.toRadians(90), g2);
    drawFractal(500, 500,150, Math.toRadians(135), g2);
    drawFractal(500, 500,150, Math.toRadians(180), g2);
    drawFractal(500, 500,150, Math.toRadians(225), g2);
    drawFractal(500, 500,150, Math.toRadians(270), g2);
    drawFractal(500, 500,150, Math.toRadians(315), g2);

  }
  public void drawFractal(double x0, double y0, double len, double angle, Graphics g2)
  {
	  if(len>4) {
		  double x1 = x0 + len * (Math.cos(angle));
		  double y1 = y0 + len * (Math.sin(angle));
		  
		 ((Graphics2D) g2).draw(new Line2D.Double(x0, y0, x1, y1));
		 drawFractal(x1, y1, len * 0.70, angle + Math.toRadians(30), g2);
		 drawFractal(x1, y1, len * 0.70, angle - Math.toRadians(30), g2);
	  }
  }

  public static void main(String s[]) {
    JFrame f = new JFrame("Fractals");
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    JApplet applet = new Challenge_7();
    f.getContentPane().add("Center", applet);
    applet.init();
    f.pack();
    f.setSize(new Dimension(1000, 1000));
    f.show();
  }
}
           
         
    