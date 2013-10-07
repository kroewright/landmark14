package landmark;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class OpeningScreen extends JFrame {
    static int numOfPlayers=0;
        private JPanel contentPane;

        private JPanel panel;
        private JTextField txtPlayer;
        private JTextField txtEnterYourName;
        private JTextField txtEnterName;
        private JTextField textField_3;
        
        /**
         * Launch the application.
         */
        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        OpeningScreen frame = new OpeningScreen();
                                        frame.setVisible(true);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }

        
        
        public JPanel generateSelectionPage(){
                JPanel panel = new JPanel();
                
                
                BufferedImage myPicture = null;
                try {
                        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                        InputStream input = classLoader.getResourceAsStream("Start_Page.jpg");
                        myPicture = ImageIO.read(input);
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        System.out.println("Picture not found");
                }
                panel.setLayout(null);
                //frame.getContentPane().add(panel, BorderLayout.CENTER);
                
                if (numOfPlayers > 4)
                	return null;
                
                if(numOfPlayers > 0) {
                txtPlayer = new JTextField();
                txtPlayer.setBounds(190, 152, 86, 20);  
                panel.add(txtPlayer);
                txtPlayer.setColumns(100);
                
                JComboBox comboBox = new JComboBox();
                comboBox.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
                comboBox.setToolTipText("");
                comboBox.setBounds(190, 237, 80, 20);
                panel.add(comboBox);
                
                JComboBox comboBox_1 = new JComboBox();
                comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
                comboBox_1.setBounds(190, 183, 80, 20);
                panel.add(comboBox_1);
                }
                
                if(numOfPlayers > 1) {
                txtEnterYourName = new JTextField();
                txtEnterYourName.setBounds(310, 152, 86, 20);
                panel.add(txtEnterYourName);
                txtEnterYourName.setColumns(10);
                
                JComboBox comboBox_3 = new JComboBox();
                comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"})); 
                comboBox_3.setBounds(310, 185, 80, 20);
                panel.add(comboBox_3);
                
                JComboBox comboBox_2 = new JComboBox();
                comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
                comboBox_2.setToolTipText("");
                comboBox_2.setBounds(310, 237, 80, 20);  
                panel.add(comboBox_2);
                }
                
                if(numOfPlayers > 2) {
                txtEnterName = new JTextField();
                txtEnterName.setBounds(425, 152, 86, 20);
                panel.add(txtEnterName);
                txtEnterName.setColumns(10);
                
                JComboBox comboBox_5 = new JComboBox();
                comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
                comboBox_5.setBounds(425, 185, 80, 20);
                panel.add(comboBox_5);
                
                JComboBox comboBox_4 = new JComboBox();
                comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
                comboBox_4.setToolTipText("");
                comboBox_4.setBounds(425, 237, 80, 20);
                panel.add(comboBox_4);
                }
                
                if(numOfPlayers > 3) {
                textField_3 = new JTextField();
                textField_3.setBounds(535, 152, 86, 20);
                panel.add(textField_3);
                textField_3.setColumns(10);
               
                JComboBox comboBox_7 = new JComboBox();
                comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"Gold", "Navy", "White", "Black"}));
                comboBox_7.setBounds(535, 185, 80, 20);
                panel.add(comboBox_7);
            
                JComboBox comboBox_6 = new JComboBox();
                comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Business", "Scientist", "Engineer", "CS"}));
                comboBox_6.setToolTipText("");
                comboBox_6.setBounds(535, 237, 80, 20);
                panel.add(comboBox_6);
                }
                
                JLabel picLabel = new JLabel(new ImageIcon(myPicture));
                picLabel.setBounds(0, 0, 792, 576);
                panel.add(picLabel);
              
                return panel;
        }
        
        /**
         * Create the frame.
         */
        
        public OpeningScreen() {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setBounds(100, 100, 953, 617);
                contentPane = new JPanel();
                contentPane.setBackground(new Color(255, 204, 0));
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                contentPane.setLayout(new BorderLayout(0, 0));
                setContentPane(contentPane);

                
                
                JPanel center = new JPanel();
                contentPane.add(center, BorderLayout.CENTER);
                BufferedImage myPicture = null;
                try {
                        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                        InputStream input = classLoader.getResourceAsStream("Openingpage.jpg");
                        myPicture = ImageIO.read(input);
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        System.out.println("Picture not found");
                }
                
                
                
                
                JLabel lblPlayers = new JLabel("Players");
                lblPlayers.setBounds(367, 586, 58, 23);
                lblPlayers.setFont(new Font("Garuda", Font.BOLD, 17));
                center.add(lblPlayers);
                
                
                
                
                
                JButton btn2 = new JButton("1");
                btn2.setBackground(new Color(204, 255, 204));
                btn2.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg2) {
                                numOfPlayers = 1;                               
                        }
                });
                btn2.setBounds(330, 392, 65, 69);
                center.add(btn2);
                
                JButton btn3 = new JButton("2");
                btn3.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg3) {
                                numOfPlayers = 2;
                        }
                });
                btn3.setBounds(427, 392, 58, 69);
                center.add(btn3);
                
                JButton btn1 = new JButton("3");
                btn1.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg1) {
                                numOfPlayers = 3;
                        }
                });
                btn1.setBounds(245, 392, 58, 69);
                center.add(btn1);
                
                JButton btn4 = new JButton("4");
                btn4.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg4) {
                                numOfPlayers = 4;
                        }
                });
                btn4.setBounds(516, 392, 58, 69);
                center.add(btn4);
                JLabel picLabel = new JLabel(new ImageIcon(myPicture));
                picLabel.setBounds(18, 5, 792, 576);
                center.add(picLabel);
                
                
                
                
                
                
                
                
                
                

                
                
                
                
                
                JPanel south = new JPanel();
                south.setBackground(new Color(255, 204, 0));
                contentPane.add(south, BorderLayout.SOUTH);
                
                JLabel lblDifficulty = new JLabel("Difficulty:");
                lblDifficulty.setFont(new Font("Garuda", Font.BOLD, 17));
                lblDifficulty.setHorizontalAlignment(SwingConstants.LEFT);
                south.add(lblDifficulty);
                
                JRadioButton rdbtnBeginner = new JRadioButton("Beginner");
                rdbtnBeginner.setBackground(new Color(255, 204, 0));
                
                JRadioButton rdbtnAdvanced = new JRadioButton("Advanced");
                rdbtnAdvanced.setBackground(new Color(255, 204, 0));
                
                JRadioButton rdbtnTournament = new JRadioButton("Tournament");
                rdbtnTournament.setBackground(new Color(255, 204, 0));

                ButtonGroup bg1 = new ButtonGroup( );
                bg1.add(rdbtnBeginner);
                bg1.add(rdbtnAdvanced);
                bg1.add(rdbtnTournament);

                south.add(rdbtnBeginner);
                south.add(rdbtnAdvanced);
                south.add(rdbtnTournament);
                
                JButton btnStart = new JButton("START");
                btnStart.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                if(numOfPlayers != 0){
                                        JPanel selectionPage = generateSelectionPage();
                                        contentPane.setVisible(false);
                                        selectionPage.setVisible(true);
                                        setContentPane(selectionPage);


                                }
                                
                                }
                });
                south.add(btnStart);
           
        }
}


