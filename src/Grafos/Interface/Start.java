package Grafos.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class Start extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public Start() {
		setTitle("Clustering Humano");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image image = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "/resourses/user.png");
		setIconImage(image);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FirstList firstlist = new FirstList();
				firstlist.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		btnNewButton.setBounds(228, 372, 226, 47);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(84, 69, 540, 270);
		contentPane.add(lblNewLabel);
		ImageIcon icon = new ImageIcon (System.getProperty("user.dir") + "/resourses/people.png");
		lblNewLabel.setIcon(icon);
		
		JTextPane txtpnClusteringHumano = new JTextPane();
		txtpnClusteringHumano.setBackground(UIManager.getColor("Button.background"));
		txtpnClusteringHumano.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtpnClusteringHumano.setText("CLUSTERING HUMANO");
		txtpnClusteringHumano.setBounds(202, 11, 283, 47);
		contentPane.add(txtpnClusteringHumano);
	}
}
