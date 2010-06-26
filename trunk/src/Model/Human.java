package Model;

public class Human extends Player
{
	public Human(int _num)
	{
		super(_num);
		setName("Human - " + _num);
	}
	public boolean YesNo(String message)
	{
		return new View.YesNoDialog(message).show();
	}
}
