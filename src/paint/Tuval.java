package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author fatihPC
 */
public class Tuval extends JPanel{
    public static boolean temizle=true;
    private Point p,pEnd,pIlk;
    private final int FIRCA = 0,DIKDORTGEN = 1,OVAL = 2;
    public static int secim=0;
    public static Color color;
    public static int boyut=6;
    
    public Tuval(){
        tuval();   
    }

    public void tuval(){
        setBackground(new Color(240,240,240));
        setPreferredSize(new Dimension(690, 600));

        color = new Color(125,125,125);
        mouse ms=new mouse();
        addMouseListener(ms);
        addMouseMotionListener(ms);
        p = new Point(0,0);
        pIlk = p;
    }

    @Override
    public void paintComponent(Graphics g) {
        if(temizle){
            doDraw(g);
            super.paintComponent(g);
            temizle = false;
        }else{
            doDraw(g);
        }  
    }

    private void doDraw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(color);

        g2d.setRenderingHints(rh);
         BasicStroke stroke = new BasicStroke(boyut, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND);
         
        switch (secim) {
            case FIRCA:
                g2d.setStroke(stroke);
                g2d.drawLine(pIlk.x, pIlk.y, p.x, p.y);
                break;
            case DIKDORTGEN:
                g2d.fillRect((p.x>=pEnd.x ? pEnd.x : p.x), 
                        (p.y>=pEnd.y ? pEnd.y : p.y), 
                        (pEnd.x>p.x ? (pEnd.x-p.x):(p.x-pEnd.x)), 
                        (pEnd.y>p.y ? (pEnd.y-p.y):(p.y-pEnd.y)));
                break;
            case OVAL:
                g2d.fillOval((p.x>=pEnd.x ? pEnd.x : p.x), 
                        (p.y>=pEnd.y ? pEnd.y : p.y), 
                        (pEnd.x>p.x ? (pEnd.x-p.x):(p.x-pEnd.x)), 
                        (pEnd.y>p.y ? (pEnd.y-p.y):(p.y-pEnd.y)));
                break;
            default:
                break;
        }
         
  }

    
    public class mouse extends MouseAdapter {

        @Override
        public void mouseDragged(MouseEvent e) {   
                if(secim == FIRCA){
                    pIlk = p;
                    p = e.getPoint();
                    repaint();
                }
        }
        
        @Override
        public void mouseMoved(MouseEvent e) {
            pIlk = e.getPoint();
        }
        
        @Override
        public void mousePressed(MouseEvent e) {
            p = e.getPoint();
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            pEnd = e.getPoint();
            repaint();
        }         
        
    }

}

