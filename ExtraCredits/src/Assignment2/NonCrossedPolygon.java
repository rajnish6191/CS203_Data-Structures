package Assignment2;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class NonCrossedPolygon extends Applet implements MouseListener {
	private static final long serialVersionUID = 1L;
	private int[] xCoord, yCoord; 
    private int pointCt;  
   
   @SuppressWarnings("unused")
   private final static Color polygonColor = Color.red;  

   public void init() {
      setBackground(Color.white);
      addMouseListener(this);
      xCoord = new int[500];
      yCoord = new int[500];
      pointCt = 0;
   }
   
   public void paint(Graphics g) {
      g.setColor(Color.black);
      g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);         
   } 
      
   private void putLine(int x1, int y1, int x2, int y2) {
	   Graphics g = getGraphics();
       g.drawLine(x1,y1,x2,y2);
       g.dispose();
   }
   
   private void putPolygon() {
       if (pointCt < 2)
       return;
       Graphics g = getGraphics();
       if (pointCt == 2) {
          g.drawLine(xCoord[0], yCoord[0], xCoord[1], yCoord[1]);
       }
       else {
          g.setColor(Color.red);
          g.fillPolygon(xCoord, yCoord, pointCt);
          g.setColor(Color.black);
          g.drawPolygon(xCoord, yCoord, pointCt);
       }
       g.dispose();
   }

   public void mousePressed(MouseEvent evt) { 
      if (evt.isShiftDown()) {
          pointCt = 0;
          repaint();
      }
      else if ( pointCt > 0 && (Math.abs(xCoord[0] - evt.getX()) <= 2)
                          && (Math.abs(yCoord[0] - evt.getY()) <= 2) ) {
         putPolygon();
         pointCt = 0;
      }
      else if (evt.isMetaDown() || pointCt == 500) {
         putPolygon();
         pointCt = 0;
      }
      else {
         xCoord[pointCt] = evt.getX();
         yCoord[pointCt] = evt.getY();
         pointCt++;
         if (pointCt >= 2) {
            putLine(xCoord[pointCt-2], yCoord[pointCt-2], 
                         xCoord[pointCt-1], yCoord[pointCt-1]); 
         }
      }
   } 
   
   public void mouseReleased(MouseEvent evt) { }
   public void mouseClicked(MouseEvent evt) { }
   public void mouseEntered(MouseEvent evt) { }
   public void mouseExited(MouseEvent evt) { }
}  