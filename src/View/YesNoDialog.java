package View;

public class YesNoDialog extends Message
{
	
	public YesNoDialog(String _message)
	{
		super(_message);
	}
	public boolean show()
	{
		/*
		 * 當呼叫show時
		 * 畫面跳出一個小視窗
		 * 要求使用者按下Yes或 No的按扭
		 * 
		 * 假如他按下Yes的話，return Yes
		 * 假如他按下No 的話，return No
		 * 
		 */
	return true;
	}
}
