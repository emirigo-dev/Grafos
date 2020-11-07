package Grafos.Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Grafos.DAO.PersonaDao;
import Grafos.Logica.Grafo;
import Grafos.Logica.Persona;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JMenuBar;
import java.awt.Canvas;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FirstList extends JFrame {

	private JPanel contentPane;
	private DefaultListModel persons = new DefaultListModel ();
	private ArrayList <Persona> personas;
	public static Grafo grafo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstList frame = new FirstList();
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
	public FirstList() {
		
		personas = PersonaDao.personsFromCsv();
		grafo = new Grafo (personas.size());
		for (Persona persona : personas) {
			grafo.agregarPersonas(persona);
			persons.add(persons.getSize(), persona);
		}
		grafo.grafoCompleto();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("DIVIDE GROUP");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Groups groups = new Groups(grafo);
				groups.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(238, 388, 209, 42);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 23, 638, 312);
		contentPane.add(scrollPane);
		
		JList list_1 = new JList(persons);
		scrollPane.setViewportView(list_1);
	}
}
