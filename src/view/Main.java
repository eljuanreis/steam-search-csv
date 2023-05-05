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
			option = Integer.parseInt(JOptionPane.showInputDialog("Selecione a opção \n" + "1 - Buscar dados \n 2 - Gerar relatórios \n 9 - Sair"));
		
			switch (option) {
			case 1:
				int[] monthYear = showMonthYearSelect();
					
				int valueExpected = Integer.parseInt(JOptionPane.showInputDialog("Qual a média de jogadores?"));
				
				controller.search(monthYear[0],
						monthYear[1], 
				valueExpected);
			break;
			case 2:
				int[] monthYear2 = showMonthYearSelect();
				
				String filePath = JOptionPane.showInputDialog("Qual o caminho do arquivo? (ex: C:/temp)");
				String fileName = JOptionPane.showInputDialog("Qual o nome do arquivo? (ex: teste)");
				
				final String fileAllName = String.format("%s/%s.csv", filePath, fileName);
				controller.saveSearch(monthYear2[0], monthYear2[1], fileAllName);
			break;
			case 9:
				JOptionPane.showMessageDialog(null, "Ok! Até a próxima");
		
			break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
				
			}
		
		} while (option != 9);
	}
	
	public static int[] showMonthYearSelect() {
		try {
			int[] monthYear = new int[2];
			
			monthYear[0] = Integer.parseInt(JOptionPane.showInputDialog("Qual o mês da pesquisa? (digite o número do mês)"));
			monthYear[1] = Integer.parseInt(JOptionPane.showInputDialog("Qual o ano da pesquisa? (digite o ano com 4 digitos)"));
		
			return monthYear;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}
}
