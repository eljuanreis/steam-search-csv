package contracts;

public interface ISteamController {
	public void search(int month, int year, int valueExpected);
	public void saveSearch(int month, int year,String fileName);
	
}
