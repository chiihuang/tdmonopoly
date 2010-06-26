package View;

public class Dialog extends Message
{
	String Lumber;
	String Tower;
	
	public Dialog(String _message, String choice1, String choice2)
	{
		super(_message);
		Lumber = choice1;
		Tower = choice2;
		
	}
	public boolean show()
	{
		/*
		 * 當呼叫show時
		 * 畫面跳出一個小視窗
		 * 要求使用者按下"塔"或"伐木場"的按扭
		 * 
		 * 假如他按下塔的話，return Yes
		 * 假如他按下伐木場的話，return No
		 * 
		 */
		return true;
	}
}
