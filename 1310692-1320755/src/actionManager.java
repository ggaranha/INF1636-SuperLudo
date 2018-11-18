import java.util.HashMap;


public class actionManager {
	
	public static actionManager instance = null;

	private HashMap<doubleCoordinate, action> actionList;

	private actionManager()
	{
		actionList = new HashMap<doubleCoordinate, action>();
	}

	public static actionManager getInstance()
	{
		if (instance == null)
		{
			instance = new actionManager();
		}

		return instance;
	}

	public void registerAction(int positionX, int positionY, action a)
	{
		actionList.put(new doubleCoordinate(positionX, positionY), a);
	}
	
	public void resetActions()
	{
		actionList.clear();
	}

	public void executeAction(int positionX, int positionY) throws Exception
	{
		doubleCoordinate coordinate = new doubleCoordinate(positionX, positionY);

		if (actionList.containsKey(coordinate))
		{
			action a = actionList.get(coordinate);
			a.execute();
			a.onActionExecuted();
		}
	}

}
