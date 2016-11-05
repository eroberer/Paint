package paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author fatihPC
 */
public class Araclar extends JPanel{
    private JLabel boyut =new JLabel("Boyut");
    private JLabel redLabel = new JLabel("Red");
    private JLabel greenLabel = new JLabel("Green");
    private JLabel blueLabel = new JLabel("Blue");
    private JButton temizle = new JButton("Temizle");
    private String[] data = {"FIRÇA","DİKDÖRTGEN","OVAL"};
    private JList list = new JList(data);
    private JSlider red;
    private JSlider green;
    private JSlider blue;
    private JSlider size;
    private Color color;
    private Tuval tuval;
    
    public Araclar(Tuval tuval){
        this.tuval = tuval;
        setPreferredSize(new Dimension(200, 600));
        setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        
        list.setPreferredSize(new Dimension(200, 100));
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                    Tuval.secim =list.getSelectedIndex();
            }
        });
        
        color = new Color(120,20,20);
        temizle.addMouseListener(new mouse());
        temizle.setPreferredSize(new Dimension(150, 80));
        red = new JSlider(0, 255, 125);
        green = new JSlider(0, 255, 125);
        blue = new JSlider(0, 255, 125);
        size = new JSlider(5, 20, 10);
        
        redLabel.setText("Red ("+red.getValue()+")");
        greenLabel.setText("Green ("+green.getValue()+")");
        blueLabel.setText("Blue ("+blue.getValue()+")");
        boyut.setText("Boyut ("+size.getValue()+")");
        
        red.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                redLabel.setText("Red ("+red.getValue()+")");
                color = new Color(red.getValue(),color.getGreen(),color.getBlue());
                Tuval.color = color;
            }
        });
        
        green.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                greenLabel.setText("Green ("+green.getValue()+")");
                color = new Color(color.getRed(),green.getValue(),color.getBlue());
                Tuval.color = color;
            }
        });
          
        blue.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                blueLabel.setText("Blue ("+blue.getValue()+")");
                color = new Color(color.getRed(),color.getGreen(),blue.getValue());
                Tuval.color = color;
            }
        });
        
        size.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                boyut.setText("Boyut ("+size.getValue()+")");
                Tuval.boyut = size.getValue();
            }
        });
        
        add(redLabel);
        add(red);
        add(greenLabel);
        add(green);
        add(blueLabel);
        add(blue);
        add(list);
        add(boyut);
        add(size);
        add(temizle);
        
    }
    public class mouse extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
                Tuval.temizle = true;
                tuval.repaint();  
        }
     
    }

    
}
