package Grafos.Main;

import java.awt.EventQueue;

import Grafos.Interface.Start;

/**
 * <h1>Clustering Humano</h1>
 * Clustering Humano es una aplicación que permite visualizar una lista de personas unidas por intereses en común. Estos mismos son separados
 * en dos grupos distintos por un un algoritmo con Basado en la similaridad de intereses. 
 * 
 * @author Heredia Agustín
 * @author Rigobello Emiliano
 * @author Uncos Sergio
 * @since 2020
 * */

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
