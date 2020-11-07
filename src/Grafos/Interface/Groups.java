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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		Random random = new Random();
		int n = random.nextInt(grafo.getVertices());
		Grafo agm = Prim.generadorArbolMinimo (grafo, n);
		agm.eliminarAristaMasPesada();
		//agm.eliminarAristaAleatoria();
		Persona persona;
		ArrayList <Set<Integer>> listas = BFS.dividirGrafo(agm);
		for (Integer i : listas.get(0)) {
			persona = grafo.getGrupoPersona().get(i);
			list1.add(list1.getSize(), persona);
		}
		for (Integer i : listas.get(1)) {
			persona = grafo.getGrupoPersona().get(i);
			list2.add(list2.getSize(), persona);
		}
		
		
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
		btnNewButton.setBounds(550, 73, 144, 59);
		contentPane.add(btnNewButton);
	}
}
