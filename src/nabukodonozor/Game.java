package nabukodonozor;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import grafikus.ImagePanel;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel menus;
	private JPanel field;
	private JPanel tools;
	private JPanel infos;
	private JPanel icons;
	private GroupLayout layout;
	
	public Game() {
		menus  = new ImagePanel("pics/menu_bg.png");
		field  = new JPanel();
		tools  = new JPanel();
		infos  = new JPanel();
		icons  = new JPanel();
		
		layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
	}
	
	private void createLayout_Game() {
		field.setPreferredSize(new Dimension(960, 560));
		
		tools.setPreferredSize(new Dimension(300, 120));
		tools.setBackground(Color.GREEN);
		
		infos.setPreferredSize(new Dimension(620, 120));
		infos.setBackground(Color.YELLOW);
		
		icons.setPreferredSize(new Dimension( 40, 120));
		icons.setBackground(Color.BLUE);

		layout.setHorizontalGroup(layout.createParallelGroup()
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
						.addComponent(icons)));
	}
	
	private void createLayout_Menu() {
		menus.setPreferredSize(new Dimension(960, 680)); //a menu-kepernyo meretenek beallitasa

		//layout kialakitasa
		layout.setHorizontalGroup(layout.createParallelGroup()
				.addComponent(menus));
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(menus));
		
		//menupontok elhelyezese
	}

	public void startGame() {
		//az ablak alap beallitasai
		setTitle("A két torony");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//kezdo layout a menu
		createLayout_Menu();
		
		//megjelenites
		pack();
		setVisible(true);
	}
}