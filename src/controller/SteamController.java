package controller;

import java.io.IOException;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.swing.JOptionPane;

import contracts.ISteamController;
import service.FileService;

public class SteamController implements ISteamController {

	private FileService service;
	private String steamFile = "SteamCharts";
	
	public SteamController() {
		this.service = new FileService();
	}
	
	@Override
	public void search(int month, int year, int valueExpected) {
		try {
			String monthName = this.getMonthName(month);
			String data = this.service.readData(this.steamFile, monthName, year, valueExpected);
			
			if (data.length() <= 0) {
				JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
			}

			System.out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void saveSearch(int month, int year, String fileName) {
		// TODO Auto-generated method stub
		
	}
	
	private String getMonthName(int month) {
		return Month.of(month).getDisplayName(TextStyle.FULL, Locale.US);
	}

}
