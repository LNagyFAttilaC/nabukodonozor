package grafikus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import nabukodonozor.Field;
import nabukodonozor.Program;
import grafikus.ImagePanel;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	private Field  field;
	public JPanel pfield;
	private JPanel ptools;
	private JPanel pinfos;
	private JPanel picons;
	
	public Game() {
		pfield			= new JPanel();
		ptools			= new JPanel();
		pinfos			= new JPanel();
		picons			= new JPanel();
				
		//az ablak alap beallitasai
		getContentPane().setLayout(null);
		setTitle("A két torony");
		setIconImage(new ImageIcon("pics/tower.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(960, 680));
		setResizable(false);
		
		//kozepre pozicionalas
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth()  - 960) / 2);
		int y = (int) ((dimension.getHeight() - 680) / 2);
		setLocation(x, y);
	}
	
	private void createLayout_Menu() {
		//uj jatek
		ImagePanel menu_new_game = new ImagePanel("pics/menu_new_game.png");
		menu_new_game.setSize(292, 44);
		menu_new_game.setLocation(339, 353);
		menu_new_game.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				getContentPane().removeAll();
				createLayout_NewGame();
				repaint();
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		add(menu_new_game);
		
		//kilepes
		ImagePanel menu_exit = new ImagePanel("pics/menu_exit.png");
		menu_exit.setSize(960, 680);
		menu_exit.setLocation(339, 435);
		menu_exit.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		add(menu_exit);
		
		//hatter
		ImagePanel menus = new ImagePanel("pics/menu_bg.png");
		menus.setSize(960, 680);
		menus.setLocation(0, 0);
		add(menus);
	}
	
	private void createLayout_NewGame() {
		//Erkezes a Fekete Kapuhoz
		ImagePanel field1 = new ImagePanel("pics/menu_field1.png");
		field1.setSize(292, 44);
		field1.setLocation(339, 353);
		field1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				try {
					field = new Field("field1");
				}
				catch (IOException ioe) {
					ioe.printStackTrace();
				}
				
				getContentPane().removeAll();
				createLayout_Game();
				repaint();
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		add(field1);
		
		//Minath Morgul
		ImagePanel field2 = new ImagePanel("pics/menu_field2.png");
		field2.setSize(292, 44);
		field2.setLocation(339, 435);
		field2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				try {
					field = new Field("field2");
				}
				catch (IOException ioe) {
					ioe.printStackTrace();
				}
				
				getContentPane().removeAll();
				createLayout_Game();
				repaint();
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		add(field2);
		
		//A kiralyok varosa
		ImagePanel field3 = new ImagePanel("pics/menu_field3.png");
		field3.setSize(292, 44);
		field3.setLocation(339, 519);
		field3.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				try {
					field = new Field("field3");
				}
				catch (IOException ioe)	{
					ioe.printStackTrace();
				}
				
				getContentPane().removeAll();
				createLayout_Game();
				repaint();
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		add(field3);
		
		//hatter
		ImagePanel menus = new ImagePanel("pics/menu_bg.png");
		menus.setSize(960, 680);
		menus.setLocation(0, 0);
		add(menus);
	}
	
	private void createLayout_Game() {
		//palya
		pfield.setSize(960, 560);
		pfield.setLocation(0, 0);
		add(pfield);
		
		//toolbox
		ptools.setSize(300, 120);
		ptools.setLocation(  0, 560);
		ptools.setBackground(Color.GREEN);
		add(ptools);
		
		//informaciok
		pinfos.setSize(620, 120);
		pinfos.setLocation(300, 560);
		pinfos.setBackground(Color.BLUE);
		add(pinfos);
		
		//ikonok
		picons.setSize( 40, 120);
		picons.setLocation(920, 560);
		picons.setBackground(Color.YELLOW);
		add(picons);
	}

	public void startGame() {
		//kezdo layout a menu
		createLayout_Menu();
		
		//megjelenites
		pack();
		setVisible(true);
	}
}