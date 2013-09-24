package frame;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame
{
	public JLayeredPane layeredPanel;
	
	public JButton pro;
	public JButton rbs;
	public JButton syn;
	public JButton ter;
	public JButton help;
	public JButton aboutus;
	
	public MainFrame()
	{
		super("IGEM-XMU");
		
		//������Ļ����
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setSize(418, 556);
		setLocation((int)(width - this.getWidth()) / 2, (int)(height - this.getHeight()) / 2);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		//����ͼ��
		Image logo = Toolkit.getDefaultToolkit().getImage("Xmusoftware_iGEM.png");
		this.setIconImage(logo);

		layeredPanel = new JLayeredPane();
		layeredPanel.setBounds(0, 0, 418, 556);

		JPanel panel = new MyImage();
		panel.setBounds(0, 0, 418, 556);
		layeredPanel.add(panel, new Integer(0));

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 418, 556);
		panel1.setLayout(null);
		panel1.setOpaque(false);
		
		ImageIcon proIcon = new ImageIcon("promoter.png");
		pro = new JButton(proIcon);
		pro.addActionListener(new MyAction());
		pro.setBounds(95-9, 164-29, 235, 37);
		panel1.add(pro);
		
		ImageIcon rbsIcon = new ImageIcon("rbs.png");
		rbs = new JButton(rbsIcon);
		rbs.addActionListener(new MyAction());
		rbs.setBounds(95-9, 213-29, 235, 37);
		panel1.add(rbs);
		
		ImageIcon synIcon = new ImageIcon("protein.png");
		syn = new JButton(synIcon);
		syn.addActionListener(new MyAction());
		syn.setBounds(95-9, 264-29, 235, 37);
		panel1.add(syn);
		
		ImageIcon terIcon = new ImageIcon("terminator.png");
		ter = new JButton(terIcon);
		ter.addActionListener(new MyAction());
		ter.setBounds(95-9, 314-29, 234, 36);
		panel1.add(ter);
//		
//		ImageIcon proIcon = new ImageIcon("promoter.png");
//		pro = new JButton(proIcon);
//		pro.setBounds(95-9, 165-29, 234, 36);
//		panel1.add(pro);
//		
//		ImageIcon proIcon = new ImageIcon("promoter.png");
//		pro = new JButton(proIcon);
//		pro.setBounds(95-9, 165-29, 234, 36);
//		panel1.add(pro);
		
		layeredPanel.add(panel1, new Integer(1));
		getContentPane().add(layeredPanel);
		setVisible(true);
		
//		this.addMouseMotionListener(new MouseAdapter()
//		{
//			@Override
//			public void mouseMoved(MouseEvent e)
//			{
//				System.out.println("X:" + e.getXOnScreen()+ "  Y:" + e.getYOnScreen());
//				super.mouseMoved(e);
//			}
//		});
	}
	
	public static void main(String[] args)
	{
		MainFrame mainapp = new MainFrame();
	}
	
	private class MyAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(arg0.getSource() == pro)
			{
				CodonFrame1 app = new CodonFrame1();
			}
			if(arg0.getSource() == rbs)
			{
				RBSFrame app = new RBSFrame();
			}
			if(arg0.getSource() == syn)
			{
				ProteinFrame1 app = new ProteinFrame1();
			}
			if(arg0.getSource() == ter)
			{
				TransferExe app = new TransferExe();
			}
		}
	}
	
	class MyImage extends JPanel
	{
		public MyImage()
		{
			setLayout(new FlowLayout());
		}

		public void paint(Graphics g)
		{
			super.paint(g);
			ImageIcon img = new ImageIcon("main.jpg");
			int width = img.getIconWidth();
			int height = img.getIconHeight();
//			System.out.println(width + "," + height);
			g.drawImage(img.getImage(), 0, 0, 418, 556, this);
		}
	}
}