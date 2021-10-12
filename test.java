import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.Timer;




public class test
{

	private static Bounce bounce;
	private static int delay = 10;
	private static ExecutorService executor;
	private static int height = 400;
	private static Timer timer;
	private static int width = 600;

	
	public static void main( String[ ] args )
	{
		JFrame frame = new JFrame( "Bouncing Ball" );
		test.bounce = new Bounce( );

		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.add( test.bounce.getBall( ) );
		frame.setSize( test.width, test.height );

		frame.setVisible( true );
		frame.addMouseListener( new MouseAdapter( )
		{
			
			public void mouseClicked( MouseEvent e )
			{
				System.out.println( "click" );
				test.timer.start( );
			}
		} );

		test.executor = Executors.newCachedThreadPool( );
		test.timer = new Timer( test.delay, new ActionListener( )
		{

			
			public void actionPerformed( ActionEvent e )
			{
				test.executor.execute( test.bounce );
			}

		} );
	}

}