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
			String data = this.service.readData(this.steamFile, monthName, year, valueExpected, true);
			
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
		try {
			String monthName = this.getMonthName(month);
			
			String data = this.service.readData(this.steamFile, monthName, year, 0, false);
			
			if (data.length() <= 0) {
				JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
			} else {
				String[] dataSplited = data.split("\r\n");
				
				StringBuffer buffer = new StringBuffer();
				
				for (String dt : dataSplited) {
					String[] dtSplited = dt.split(",");
					
					buffer.append(dtSplited[0] + "," + dtSplited[3] + "\r\n");
				}
				
				this.service.run(fileName, buffer.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private String getMonthName(int month) {
		return Month.of(month).getDisplayName(TextStyle.FULL, Locale.US);
	}

}
