public class Bounce implements Runnable
{
	private final BouncingBall ball;

	public Bounce( )
	{
		this.ball = new BouncingBall( );
	}

	public BouncingBall getBall( )
	{
		return this.ball;
	}

	public void run( )
	{
		this.ball.step( );
	}

}