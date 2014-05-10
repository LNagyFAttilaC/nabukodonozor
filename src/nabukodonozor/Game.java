package nabukodonozor;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import grafikus.ImagePanel;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel menus;
	private JPanel field;
	private JPanel tools;
	private JPanel infos;
	private JPanel icons;
	
	public Game() {
		menus  = new ImagePanel("pics/menu_bg.png");
		field  = new JPanel();
		tools  = new JPanel();
		infos  = new JPanel();
		icons  = new JPanel();
				
		//az ablak alap beallitasai
		getContentPane().setLayout(null);
		setTitle("A két torony");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(960, 680));
		setResizable(false);
	}
	
	private void createLayout_Game() {
		field.setPreferredSize(new Dimension(960, 560));
		
		tools.setPreferredSize(new Dimension(300, 120));
		tools.setBackground(Color.GREEN);
		
		infos.setPreferredSize(new Dimension(620, 120));
		infos.setBackground(Color.YELLOW);
		
		icons.setPreferredSize(new Dimension( 40, 120));
		icons.setBackground(Color.BLUE);

		/*layout.setHorizontalGroup(layout.createParallelGroup()
				.addComponent(field)
				.addGroup(layout.createSequentialGroup()
						.addComponent(tools)
						.addComponent(infos)
						.addComponent(icons)));
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(field)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tools)
						.addComponent(infos)
						.addComponent(icons)));*/
	}
	
	private void createLayout_Menu() {
		//menupontok elhelyezese
		//uj jatek
		ImageIcon menu_new_game_bg = new ImageIcon("pics/menu_new_game.png");
		JLabel menu_new_game = new JLabel();
			menu_new_game.setIcon(menu_new_game_bg);
			menu_new_game.setSize(292, 44);
			menu_new_game.setLocation(339, 353);
		add(menu_new_game);
		
		//kilepes
		ImageIcon menu_exit_bg = new ImageIcon("pics/menu_exit.png");
		JLabel menu_exit       = new JLabel();
			menu_exit.setIcon(menu_exit_bg);
			menu_exit.setSize(292, 44);
			menu_exit.setLocation(339, 435);
		add(menu_exit);
		
		menus.setSize(960, 680); //a menu-kepernyo meretenek beallitasa
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