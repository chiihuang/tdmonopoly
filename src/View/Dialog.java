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
		 * ��I�sshow��
		 * �e�����X�@�Ӥp����
		 * �n�D�ϥΪ̫��U"��"��"����"������
		 * 
		 * ���p�L���U�𪺸ܡAreturn Yes
		 * ���p�L���U�������ܡAreturn No
		 * 
		 */
		return true;
	}
}
