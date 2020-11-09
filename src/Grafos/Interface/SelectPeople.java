package Grafos.Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class SelectPeople extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField textField;
	public static Integer count;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectPeople frame = new SelectPeople();
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
	public SelectPeople() {
		setTitle("Clustering Human");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image icon = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "/resourses/user.png");
		setIconImage(icon);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 24));
		textField.setBackground(UIManager.getColor("Button.disabledShadow"));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(243, 201, 204, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTheNumberShould = new JLabel("");
		lblTheNumberShould.setForeground(Color.RED);
		lblTheNumberShould.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTheNumberShould.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheNumberShould.setBounds(161, 270, 366, 25);
		contentPane.add(lblTheNumberShould);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				// Expresion regular para corroborar que lo ingresado es un numero
				if (textField.getText().matches("[0-9]{3}") || 
					textField.getText().matches("[0-9]{2}") ||
					textField.getText().matches("[0-9]")){
					count = Integer.parseInt(textField.getText());
					if (count > 2 && count <= 150) {
						FirstList firstlist = new FirstList(count);
						firstlist.setVisible(true);
						dispose();
					}					
				}
				lblTheNumberShould.setText("The number must be between 3 - 150");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(243, 323, 204, 73);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("SELECT THE DESIRED QUANTITY OF PEOPLE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(64, 59, 574, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("3 - 150");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(243, 131, 204, 38);
		contentPane.add(lblNewLabel_1);
	}
}
