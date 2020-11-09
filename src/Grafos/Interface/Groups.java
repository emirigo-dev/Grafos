package Grafos.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Grafos.Logica.BFS;
import Grafos.Logica.Grafo;
import Grafos.Logica.Persona;
import Grafos.Logica.Prim;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Groups extends JFrame {

	private JPanel contentPane;
	private DefaultListModel list1 = new DefaultListModel ();
    private DefaultListModel list2 = new DefaultListModel ();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Groups frame = new Groups(FirstList.grafo);
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
	public Groups(Grafo grafo) {
		setTitle("Clustering Human");
		
		Grafo agm = Prim.generadorArbolMinimo (grafo, 0);
		agm.eliminarAristaMasPesada();
		Persona persona;
		ArrayList <Set<Integer>> listas = Grafo.dividirGrafo(agm);
		for (Integer i : listas.get(0)) {
			persona = grafo.getGrupoPersona().get(i);
			list1.add(list1.getSize(), persona);
		}
		for (Integer i : listas.get(1)) {
			persona = grafo.getGrupoPersona().get(i);
			list2.add(list2.getSize(), persona);
		}
		
		Image icon = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "/resourses/user.png");
		setIconImage(icon);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 23, 500, 179);
		contentPane.add(scrollPane_1);
		
		JList list = new JList(list1);
		scrollPane_1.setViewportView(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 238, 500, 179);
		contentPane.add(scrollPane);
		
		JList list_1 = new JList(list2);
		scrollPane.setViewportView(list_1);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(550, 190, 144, 59);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(548, 61, 132, 34);
		lblNewLabel.setText(listas.get(0).size() + " persons");
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.PLAIN, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(550, 315, 132, 34);
		lblNewLabel_1.setText(listas.get(1).size() + " persons");
		contentPane.add(lblNewLabel_1);
		
		
	}
}
