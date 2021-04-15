import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;





import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;





public class ShowPendu extends JFrame {





		private JPanel contentPane;
		private JTextField ChoixLettre;
		private JLabel JLetoiles;
		private JLabel LeUtil ;
		private JLabel  Nbtry ;
		private String[] mots={"liste","ratio","enclume","espadon","mario","aquarium",
        "souris","pasteque","animal","voiture"};
        private String motHidden = "";
        private String mot = "";

        public char l;
        public String lettre;

        public String choixMots() {
            
            int i =(int)(Math.random()*9);
            mot = mots[i];

            System.out.println(mot);

            for(int j=0 ; j!=mot.length() ; j++){
                motHidden+="*";
            }
            return mot;
        }

        public boolean testerLettreInMot(String ChoixLettre, String mot){

            int a = 0;

            for (int i = 0; i < mot.length(); i++) {

                if (mot.charAt(i)==ChoixLettre.charAt(0)) {

                    a = 1;
                    break;
                    
                }
                else{
                    a=0;
                }

            }

            if (a==1) {
                return  true;
            }
            else{
                return false;
            }

        }

        public String afficherLettre(String mot, String choixlettre){

            for (int i = 0; i < mot.length(); i++) {
                if (mot.charAt(i) == choixlettre.charAt(0)) {

                    motHidden = motHidden.substring(0,i)+lettre+motHidden.substring(i+1);
                    JLetoiles.setText(motHidden);
                }
            }
                return motHidden;
        }

	
		/**
		* Launch the application.
		*/
		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
		try {
		ShowPendu frame = new ShowPendu();
		frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
				}
			}
		});
		}
		/**
		* Create the frame.
		*/
		public ShowPendu() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("PENDU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(-10, 11, 434, 31);
		contentPane.add(lblNewLabel);
		
		
		
		ChoixLettre = new JTextField();
		ChoixLettre.setBackground(SystemColor.activeCaptionBorder);
		ChoixLettre.setBounds(189, 153, 24, 20);
		contentPane.add(ChoixLettre);
		ChoixLettre.setColumns(10);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Choigissez une lettre :");
		lblNewLabel_1.setBounds(60, 156, 119, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(0, 0, 205));
		btnOk.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

            l = ChoixLettre.getText().charAt(0);
            lettre = String.valueOf(l);

            testerLettreInMot(lettre, mot);

            System.out.println(testerLettreInMot(lettre, mot));

            afficherLettre(mot, lettre);
                
            
		}
		});
		btnOk.setBounds(245, 153, 68, 20);
		contentPane.add(btnOk);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Lettres utilis\u00E9e :");
		lblNewLabel_2.setBounds(10, 200, 125, 14);
		contentPane.add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Nombres d'essaies : ");
		lblNewLabel_3.setBounds(291, 200, 107, 14);
		contentPane.add(lblNewLabel_3);
		
		
		choixMots();
		
		JLetoiles = new JLabel(motHidden);
		JLetoiles.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		JLetoiles.setHorizontalAlignment(SwingConstants.CENTER);
		JLetoiles.setBounds(60, 42, 297, 76);
		contentPane.add(JLetoiles);
		
		
		
		LeUtil = new JLabel();
		LeUtil.setBounds(20, 225, 141, 25);
		contentPane.add(LeUtil);
		
		Nbtry = new JLabel();
		Nbtry.setBounds(315, 225, 46, 14);
		contentPane.add(Nbtry);
		}
}