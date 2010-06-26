package View;

public class Message
{
	String message;
	public Message(String _message)
	{
		message = new String(_message);
	}
	public boolean show()
	{
		/*
		 * 當呼叫show時
		 * 畫面跳出一個小視窗
		 * 過1.5秒後自動關閉跳出show這個method
		 * 
	
		 */
		return true;
	}
}
