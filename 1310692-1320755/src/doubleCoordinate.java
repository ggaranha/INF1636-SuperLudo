
public class doubleCoordinate {
	
	private double x;
	private double y;

	public doubleCoordinate(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof doubleCoordinate))
			return false;
		if (obj == this)
			return true;

		doubleCoordinate coordinate = (doubleCoordinate) obj;

		if (coordinate.x == this.x && coordinate.y == this.y)
			return true;

		return false;
	}

}
