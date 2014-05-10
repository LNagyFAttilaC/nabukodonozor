package nabukodonozor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import grafikus.ImagePanel;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel menus;
	private JPanel menu_new_game;
	private JPanel menu_exit;
	private JPanel field;
	private JPanel tools;
	private JPanel infos;
	private JPanel icons;
	
	public Game() {
		menus			= new ImagePanel("pics/menu_bg.png");
		menu_new_game	= new ImagePanel("pics/menu_new_game.png");
		menu_exit		= new ImagePanel("pics/menu_exit.png");
		field			= new JPanel();
		tools			= new JPanel();
		infos			= new JPanel();
		icons			= new JPanel();
				
		//az ablak alap beallitasai
		getContentPane().setLayout(null);
		setTitle("A két torony");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(960, 680));
		setResizable(false);
	}
	
	private void createLayout_Game() {
		getContentPane().removeAll();
		
		field.setSize(960, 560);
		field.setLocation(0, 0);
		field.setBackground(Color.RED);
		add(field);
		
		tools.setSize(300, 120);
		tools.setLocation(  0, 560);
		tools.setBackground(Color.GREEN);
		add(tools);
		
		infos.setSize(620, 120);
		infos.setLocation(300, 560);
		infos.setBackground(Color.BLUE);
		add(infos);
		
		icons.setSize( 40, 120);
		icons.setLocation(920, 560);
		icons.setBackground(Color.YELLOW);
		add(icons);

		repaint();
	}
	
	private void createLayout_Menu() {
		//uj jatek
		menu_new_game.setSize(292, 44);
		menu_new_game.setLocation(339, 353);
		menu_new_game.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				createLayout_Game();
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		add(menu_new_game);
		
		//kilepes
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
		menus.setSize(960, 680);
		menus.setLocation(0, 0);
		add(menus);
	}

	public void startGame() {
		//kezdo layout a menu
		createLayout_Menu();
		
		//megjelenites
		pack();
		setVisible(true);
		
		
	}
}