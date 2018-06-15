import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class game extends JFrame implements ActionListener, Runnable
{
   JLabel jl[][];
   JPanel jp;
   JButton jb;
   int x,y;
   Thread t;
   boolean flag;
   game()
   {
      initcomponent();	
      setTitle("Game");
      setSize(200,200);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }

   void initcomponent()
   {
      x=y=0;
      jp = new JPanel();
      jp.setLayout(new GridLayout(4,4,1,1));

      jl = new JLabel[4][4];
      int i,j;
      for(i=0;i<jl.length;i++)
      {
	 for(j=0;j<jl[i].length;j++)
	 {
	     jl[i][j] = new JLabel();
    	     jl[i][j].setOpaque(true);
	     jl[i][j].setBackground(Color.RED);
	     jp.add(jl[i][j]);
	 }
      }
      
      jb = new JButton("START");
      jb.setBackground(Color.GREEN);
      setLayout(new BorderLayout());
      add(jp, BorderLayout.CENTER);
      add(jb, BorderLayout.SOUTH);
      jl[x][y].setBackground(Color.BLUE);
      jb.addActionListener(this);
   }
   
   public void actionPerformed(ActionEvent e)
   {
 	String st;
	st = jb.getText();
 	st = st.trim();
 	if(st.equals("START"))
	{
		t = new Thread(this);
		t.start();
	}
	else
	{
		flag=false;
		jb.setText("START");
		jb.setBackground(Color.GREEN);
	}
   }

   public void run()
   {
	flag = true;
	jb.setText("STOP");
	jb.setBackground(Color.PINK);
	while(flag)
	{
		int p,q;
		p=x;
		q=y;
		y++;
		if(y==4)
		{
			x++;
			y=0;
		}
		if(x==4)
		x=0;
		jl[p][q].setBackground(Color.RED);
		jl[x][y].setBackground(Color.BLUE);
		try
		{
			t.sleep(1000);
		}
		catch(Exception ex)
		{}
	}
   }

   public static void main(String args[])
   {
      new game();
   }
}