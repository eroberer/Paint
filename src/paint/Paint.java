package paint;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;
/**
 *
 * @author fatihPC
 */
public class Paint extends JFrame{
    public Paint(){
        setSize(900, 600);
        setLayout(new FlowLayout(FlowLayout.CENTER,1,1));
        Tuval tuval = new Tuval();
        Araclar araclar = new Araclar(tuval);
        add(tuval,BorderLayout.CENTER);
        add(araclar,BorderLayout.LINE_END);
        setResizable(false);
        setTitle("Paint");
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }
    public static void main(String[] args) {
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        }
        } catch (Exception e) {

        }
        Paint paint = new Paint();
        
    }
}
