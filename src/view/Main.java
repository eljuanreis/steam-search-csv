package view;

import javax.swing.JOptionPane;

import controller.SteamController;

public class Main {

	private static SteamController controller = new SteamController();

	public static void main(String[] args) {
		GUI();
	}
	
	public static void GUI() {
		int option = 0;
		
		do {
			option = Integer.parseInt(JOptionPane.showInputDialog("Selecione a op��o \n" + "1 - Buscar dados \n 2 - Gerar relat�rios \n 9 - Sair"));
		
			switch (option) {
			case 1:
				int[] monthYear = showMonthYearSelect();
					
				int valueExpected = Integer.parseInt(JOptionPane.showInputDialog("Qual a m�dia de jogadores?"));
				
				controller.search(monthYear[0],
						monthYear[1], 
				valueExpected);
			}
		
		} while (option != 9);
	}
	
	public static int[] showMonthYearSelect() {
		try {
			int[] monthYear = new int[2];
			
			monthYear[0] = Integer.parseInt(JOptionPane.showInputDialog("Qual o m�s da pesquisa? (digite o n�mero do m�s)"));
			monthYear[1] = Integer.parseInt(JOptionPane.showInputDialog("Qual o ano da pesquisa? (digite o ano com 4 digitos)"));
		
			return monthYear;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
}
