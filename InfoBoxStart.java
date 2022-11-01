import javax.swing.*;
import java.awt.event.*;

public class InfoBoxStart extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textArea1;
    private JButton currentDateButton;
    private JTextArea textArea2;
    private JButton freeMemoryButton;
    private JTextArea textArea3;
    private JButton OSButton;
    private JTextArea textArea4;

    public InfoBoxStart() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCores();
            }
        });

        currentDateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCurrentDate();
            }
        });

        freeMemoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onFreeMemory();
            }
        });

        OSButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOS();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCores() {
        int cores = Runtime.getRuntime().availableProcessors();
        textArea1.setText("Cores: "+cores);
    }

    private void onOS() {
        String ver = System.getProperty("os.version");
        String os = System.getProperty("os.name");
        textArea4.setText("OS ver: "+os + " "+ ver);
    }

    private void onCurrentDate() {
        textArea2.setText("Date: " + java.time.LocalDate.now());

    }

    private void onFreeMemory() {
        long fmemory = Runtime.getRuntime().freeMemory();
        double fmemorymb = fmemory/(1024*1024);
        long tmemory = Runtime.getRuntime().totalMemory();
        double tmemorymb = tmemory/(1024*1024);
        textArea3.setText("Free Memory: " + fmemorymb + " MB, Total Memory: "+ tmemorymb + "MB" );
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        InfoBoxStart dialog = new InfoBoxStart();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
