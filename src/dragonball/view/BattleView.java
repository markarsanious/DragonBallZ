package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.Battle;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.dragon.Dragon;
import dragonball.model.character.fighter.*;

public class BattleView extends JPanel implements Serializable {
	private JPanel fightersInfo;
	private JPanel foeInfo;
	private JPanel foeInfoFirstPanel;
	private JPanel foeDetails;
	private JPanel foeInfoThirdPanel;
	private JPanel foeTurnOptions;
	private JPanel playerInfo;
	private JPanel playerInfoFirstPanel;
	private JPanel playerDetails;
	private JPanel playerInfoThirdPanel;
	private JPanel playerTurnOptions;
	private JPanel commentPanel;
	private JTextArea comment;
	private Battle battle;
	private transient BufferedImage bufferedImage;
	private JTextArea playerName;
	private JPanel maxHealthPointsPlayer;
	private JPanel maxKiPlayer;
	private JPanel maxStaminaPlayer;
	private JTextArea foeName;
	private JPanel maxHealthPointsFoe;
	private JPanel maxKiFoe;
	private JPanel maxStaminaFoe;
	private JPanel actionsOffered;
	private JPanel southPanel;
	private JButton attack;
	private JButton block;
	private JButton use;
	private JButton physicalAttack;
	private JButton ultimateAttack;
	private JButton superAttack;
	private JPanel centerPanel;
	private JLabel playerGif;
	private JLabel playerArrow;
	private JPanel playerPanel;
	private JLabel foeGif;
	private JLabel foeArrow;
	private JPanel foePanel;
	private JComboBox<String> availableUltimateAttacks;
	private JComboBox<String> availableSuperAttacks;
	private boolean availableSuperAttacksON;
	private boolean availableUltimateAttacksON;
	private int oldLevel;
	private int oldAbilityPoints;
	private JButton submitSA;
	private JButton submitUA;
	private JPanel actionsOfferedPanel;
	
	
	
	public BattleView (Battle battle){
		
		this.battle=battle;
		this.oldLevel= ((PlayableFighter)battle.getMe()).getLevel();
		this.oldAbilityPoints=((PlayableFighter)battle.getMe()).getAbilityPoints();
				
		Dimension t=Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(t.getWidth()),(int) (t.getHeight()));
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		
		try 
		{
			bufferedImage = ImageIO.read(new File("battle2.jpg"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setLayout(new BorderLayout());
		
		//this.updateFighters();
		
		centerPanel=new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setOpaque(false);
		//centerPanel.setPreferredSize(new Dimension(200,100));
		//centerPanel.setSize(centerPanel.getPreferredSize());
		
		southPanel=new JPanel();
		southPanel.setLayout(new BorderLayout());
		southPanel.setOpaque(false);
		southPanel.setPreferredSize(new Dimension(200,100));
		southPanel.setSize(southPanel.getPreferredSize());
		
		//actions Make buttons in the middle
		actionsOfferedPanel=new JPanel();
		actionsOfferedPanel.setLayout(new BoxLayout(actionsOfferedPanel,BoxLayout.PAGE_AXIS));
		actionsOfferedPanel.setOpaque(false);
		
		actionsOffered=new JPanel();
		actionsOffered.setLayout(new BoxLayout(actionsOffered,BoxLayout.LINE_AXIS));
		actionsOffered.setOpaque(false);
	// sara you can remove return this statement according your view
		//actionsOffered.add(Box.createHorizontalStrut(350));
		actionsOfferedPanel.add(actionsOffered);
		
		attack=new JButton("ATTACK");
		attack.setOpaque(false);
		attack.setBorderPainted(true);
		attack.setContentAreaFilled(false);
		attack.setFont(new Font("Calibri", Font.PLAIN, 40));
		attack.setForeground(Color.WHITE);
		attack.setFocusPainted(false);
		attack.setVisible(true);
		actionsOffered.add(attack);
		
		block=new JButton("BLOCK");
		block.setOpaque(false);
		block.setBorderPainted(true);
		block.setContentAreaFilled(false);
		block.setFont(new Font("Calibri", Font.PLAIN, 40));
		block.setForeground(Color.WHITE);
		block.setFocusPainted(false);	
		block.setVisible(true);
		actionsOffered.add(block);

		use=new JButton("USE");
		use.setOpaque(false);
		use.setBorderPainted(true);
		use.setContentAreaFilled(false);
		use.setFont(new Font("Calibri", Font.PLAIN, 40));
		use.setForeground(Color.WHITE);
		use.setFocusPainted(false);	
		use.setVisible(true);
		actionsOffered.add(use);
	
		physicalAttack=new JButton("PhysicalAttack");
		physicalAttack.setOpaque(false);
		physicalAttack.setBorderPainted(true);
		physicalAttack.setContentAreaFilled(false);
		physicalAttack.setFont(new Font("Calibri", Font.PLAIN, 40));
		physicalAttack.setForeground(Color.WHITE);
		physicalAttack.setFocusPainted(false);	
		physicalAttack.setVisible(false);
		actionsOffered.add(physicalAttack);
		
		superAttack=new JButton("SuperAttack");
		superAttack.setOpaque(false);
		superAttack.setBorderPainted(true);
		superAttack.setContentAreaFilled(false);
		superAttack.setFont(new Font("Calibri", Font.PLAIN, 40));
		superAttack.setForeground(Color.WHITE);
		superAttack.setFocusPainted(false);	
		superAttack.setVisible(false);
		actionsOffered.add(superAttack);
		
		String[] superAttacksToBeChosenFrom=new String[(((Fighter)(battle.getMe())).getSuperAttacks().size())+1];
		superAttacksToBeChosenFrom[0]="choose a super attack";
		for(int i=1;i<superAttacksToBeChosenFrom.length;i++)
			superAttacksToBeChosenFrom[i]=((Fighter)(battle.getMe())).getSuperAttacks().get(i-1).getName();
		
		availableSuperAttacks=new JComboBox<String>(superAttacksToBeChosenFrom);
		availableSuperAttacks.setEditable(false);
		availableSuperAttacks.setSelectedIndex(0);
		availableSuperAttacks.setPreferredSize(new Dimension(200,30));
		availableSuperAttacks.setMaximumSize(availableSuperAttacks.getPreferredSize());
		availableSuperAttacks.setFont(new Font("Arial", Font.BOLD, 20));
		availableSuperAttacks.setMaximumRowCount(superAttacksToBeChosenFrom.length+1);
		availableSuperAttacks.setOpaque(false);
		availableSuperAttacks.setVisible(false);
		actionsOffered.add(availableSuperAttacks);
		
		if(superAttacksToBeChosenFrom.length>1)
			availableSuperAttacksON=true;
		
		submitSA=new JButton();
		submitSA.setText("submit");
		submitSA.setOpaque(false);
		submitSA.setContentAreaFilled(false);
		submitSA.setBorderPainted(true);
		submitSA.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		submitSA.setForeground(Color.BLACK);
		submitSA.setFocusPainted(false);	
		submitSA.setVisible(false);
		actionsOffered.add(submitSA);
		
		ultimateAttack=new JButton("UltimateAttack");
		ultimateAttack.setOpaque(false);
		ultimateAttack.setBorderPainted(true);
		ultimateAttack.setContentAreaFilled(false);
		ultimateAttack.setFont(new Font("Calibri", Font.PLAIN, 40));
		ultimateAttack.setForeground(Color.WHITE);
		ultimateAttack.setFocusPainted(false);
		ultimateAttack.setVisible(false);
		actionsOffered.add(ultimateAttack);

		
		String[] ultimateAttacksToBeChosenFrom=new String[(((Fighter)(battle.getMe())).getUltimateAttacks().size())+1];
		ultimateAttacksToBeChosenFrom[0]="choose an ultimate attack";
		for(int i=1;i<ultimateAttacksToBeChosenFrom.length;i++)
			ultimateAttacksToBeChosenFrom[i]=((Fighter)(battle.getMe())).getUltimateAttacks().get(i-1).getName();
		
		availableUltimateAttacks=new JComboBox<String>(ultimateAttacksToBeChosenFrom);
		availableUltimateAttacks.setEditable(false);
		availableUltimateAttacks.setSelectedIndex(0);
		availableUltimateAttacks.setPreferredSize(new Dimension(200,30));
		availableUltimateAttacks.setMaximumSize(availableUltimateAttacks.getPreferredSize());
		availableUltimateAttacks.setFont(new Font("Arial", Font.BOLD, 20));
		availableUltimateAttacks.setMaximumRowCount(ultimateAttacksToBeChosenFrom.length+1);
		availableUltimateAttacks.setOpaque(false);
		availableUltimateAttacks.setVisible(false);
		actionsOffered.add(availableUltimateAttacks);
		
		if(ultimateAttacksToBeChosenFrom.length>1)
			availableUltimateAttacksON=true;
		
		submitUA=new JButton();
		submitUA.setText("submit");
		submitUA.setOpaque(false);
		submitUA.setContentAreaFilled(false);
		submitUA.setBorderPainted(true);
		submitUA.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		submitUA.setForeground(Color.BLACK);
		submitUA.setFocusPainted(false);	
		submitUA.setVisible(false);
		actionsOffered.add(submitUA);
		
		
		playerPanel=new JPanel();
		playerPanel.setLayout(new BoxLayout(playerPanel,BoxLayout.PAGE_AXIS));
		playerPanel.setOpaque(false);
		
		playerArrow = new JLabel();
		playerGif =new JLabel();
		ImageIcon iconWithImage;
		ImageIcon icon;
		BufferedImage imageA;
		try {
			imageA = ImageIO.read(new File("down.png"));
			ImageIcon iconA = new ImageIcon(fitImageToACertainSize(30,30,imageA));
			playerArrow.setPreferredSize(new Dimension(30,30));
			playerArrow.setOpaque(false);
			playerArrow.setIcon(iconA);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(this.battle.getMe() instanceof Earthling)
			icon = new ImageIcon("earthling.gif");	
		else if(this.battle.getMe() instanceof Frieza)
			icon = new ImageIcon("frieza.gif");
			else if(this.battle.getMe() instanceof Majin)
				icon = new ImageIcon("majinn.gif");
				else if(this.battle.getMe() instanceof Namekian)
					icon = new ImageIcon("namekian.gif");
					else if(this.battle.getMe() instanceof Saiyan && ((Saiyan)(battle.getMe())).isTransformed())
						icon=new ImageIcon("superSaiyan.gif");
						else
							icon = new ImageIcon("saiyan.gif");
		Image image = (icon.getImage()).getScaledInstance(300, 600, Image.SCALE_FAST);
		iconWithImage = new ImageIcon(image);
		playerGif.setPreferredSize(new Dimension(300,600));
		playerGif.setVisible(true);
		playerGif.setOpaque(false);
		playerGif.setIcon(iconWithImage);
		
		
		playerPanel.add(Box.createHorizontalStrut(200));
		playerPanel.add(playerArrow);
		playerArrow.setVisible(false);
		playerPanel.add(Box.createVerticalStrut(30));
		playerPanel.add(playerGif);
		
		foePanel=new JPanel();
		foePanel.setLayout(new BoxLayout(foePanel,BoxLayout.PAGE_AXIS));
		foePanel.setOpaque(false);
		
		foeArrow = new JLabel();
		foeGif =new JLabel();
		
		try {
			imageA = ImageIO.read(new File("down.png"));
			ImageIcon iconA = new ImageIcon(fitImageToACertainSize(30,30,imageA));
			foeArrow.setPreferredSize(new Dimension(30,30));
			foeArrow.setOpaque(false);
			foeArrow.setIcon(iconA);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(this.battle.getFoe() instanceof Earthling)
			icon = new ImageIcon("earthling.gif");	
		else if(this.battle.getFoe() instanceof Frieza)
			icon = new ImageIcon("frieza.gif");
			else if(this.battle.getFoe() instanceof Majin)
				icon = new ImageIcon("majinn.gif");
				else if(this.battle.getFoe() instanceof Namekian)
					icon = new ImageIcon("namekian.gif");
				else if(this.battle.getFoe() instanceof Saiyan && ((Saiyan)(battle.getFoe())).isTransformed())
					icon=new ImageIcon("superSaiyan.gif");
					else
						icon = new ImageIcon("saiyan.gif");
		image=(icon.getImage()).getScaledInstance(300, 600, Image.SCALE_FAST);
		iconWithImage = new ImageIcon(image);
		foeGif.setPreferredSize(new Dimension(300,600));
		foeGif.setOpaque(false);
		foeGif.setIcon(iconWithImage);
		
		foePanel.add(Box.createHorizontalStrut(200));
		foePanel.add(foeArrow);
		foeArrow.setVisible(true);
		foePanel.add(Box.createVerticalStrut(30));
		foePanel.add(foeGif);
		
		//all super and ultimate attacks should be available!!
		centerPanel.add(actionsOfferedPanel,BorderLayout.CENTER);
		centerPanel.add(playerPanel,BorderLayout.WEST);
		centerPanel.add(foePanel,BorderLayout.EAST);
		//actionsOffered.setBounds((int)(t.getWidth()/2), (int)(t.getHeight()/2), 500, 500);
		
		commentPanel=new JPanel();
		commentPanel.setOpaque(false);
		commentPanel.setPreferredSize(new Dimension(100, 100));
		commentPanel.setVisible(true);
		comment=new JTextArea();
		comment.setOpaque(true);
		comment.setText("");
		comment.setFont(new Font("Calibri", Font.PLAIN, 30));
		comment.setEditable(false);
		comment.setVisible(false);
		commentPanel.add(comment);
		
		southPanel.add(commentPanel,BorderLayout.SOUTH);
		this.add(centerPanel,BorderLayout.CENTER);
		this.add(southPanel,BorderLayout.SOUTH);
		
		this.repaint();
		this.revalidate();		
		
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
	    g.drawImage((bufferedImage), 0, 0, this.getWidth(), this.getHeight(), null);
	}
	public Image fitImageToACertainSize(int width, int height, Image oldImage)
	{
		BufferedImage newImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics=newImage.createGraphics();
		graphics.drawImage(oldImage, 0, 0, width, height, null);
		graphics.dispose();
		return newImage;
	}
	
	public JPanel getFightersInfo() {
		return fightersInfo;
	}
	public void setFightersInfo(JPanel fightersInfo) {
		this.fightersInfo = fightersInfo;
	}
	public JPanel getFoeInfoFirstPanel() {
		return foeInfoFirstPanel;
	}
	public void setFoeInfoFirstPanel(JPanel foeInfoFirstPanel) {
		this.foeInfoFirstPanel = foeInfoFirstPanel;
	}
	public JPanel getFoeDetails() {
		return foeDetails;
	}
	public void setFoeDetails(JPanel foeDetails) {
		this.foeDetails = foeDetails;
	}
	public JPanel getFoeInfoThirdPanel() {
		return foeInfoThirdPanel;
	}
	public void setFoeInfoThirdPanel(JPanel foeInfoThirdPanel) {
		this.foeInfoThirdPanel = foeInfoThirdPanel;
	}
	public JPanel getFoeTurnOptions() {
		return foeTurnOptions;
	}
	public void setFoeTurnOptions(JPanel foeTurnOptions) {
		this.foeTurnOptions = foeTurnOptions;
	}
	public JPanel getPlayerInfo() {
		return playerInfo;
	}
	public void setPlayerInfo(JPanel playerInfo) {
		this.playerInfo = playerInfo;
	}
	public JPanel getPlayerInfoFirstPanel() {
		return playerInfoFirstPanel;
	}
	public void setPlayerInfoFirstPanel(JPanel playerInfoFirstPanel) {
		this.playerInfoFirstPanel = playerInfoFirstPanel;
	}
	public JPanel getPlayerDetails() {
		return playerDetails;
	}
	public void setPlayerDetails(JPanel playerDetails) {
		this.playerDetails = playerDetails;
	}
	public JPanel getPlayerInfoThirdPanel() {
		return playerInfoThirdPanel;
	}
	public void setPlayerInfoThirdPanel(JPanel playerInfoThirdPanel) {
		this.playerInfoThirdPanel = playerInfoThirdPanel;
	}
	public JPanel getPlayerTurnOptions() {
		return playerTurnOptions;
	}
	public void setPlayerTurnOptions(JPanel playerTurnOptions) {
		this.playerTurnOptions = playerTurnOptions;
	}
	public JPanel getCommentPanel() {
		return commentPanel;
	}
	public void setCommentPanel(JPanel commentPanel) {
		this.commentPanel = commentPanel;
	}
	public JTextArea getComment() {
		return comment;
	}
	public void setComment(JTextArea comment) {
		this.comment = comment;
	}
	public Battle getBattle() {
		return battle;
	}
	public void setBattle(Battle battle) {
		this.battle = battle;
	}
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}
	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
	public JTextArea getPlayerName() {
		return playerName;
	}
	public void setPlayerName(JTextArea playerName) {
		this.playerName = playerName;
	}
	
	public JButton getSubmitSA() {
		return submitSA;
	}
	public void setSubmitSA(JButton submitSA) {
		this.submitSA = submitSA;
	}



	public JButton getSubmitUA() {
		return submitUA;
	}



	public void setSubmitUA(JButton submitUA) {
		this.submitUA = submitUA;
	}



	public JPanel getMaxHealthPointsPlayer() {
		return maxHealthPointsPlayer;
	}
	public void setMaxHealthPointsPlayer(JPanel maxHealthPointsPlayer) {
		this.maxHealthPointsPlayer = maxHealthPointsPlayer;
	}
	public JPanel getMaxKiPlayer() {
		return maxKiPlayer;
	}
	public void setMaxKiPlayer(JPanel maxKiPlayer) {
		this.maxKiPlayer = maxKiPlayer;
	}
	public JPanel getFoeInfo() {
		return foeInfo;
	}
	public void setFoeInfo(JPanel foeInfo) {
		this.foeInfo = foeInfo;
	}
	public JTextArea getFoeName() {
		return foeName;
	}
	public void setFoeName(JTextArea foeName) {
		this.foeName = foeName;
	}
	public JPanel getMaxHealthPointsFoe() {
		return maxHealthPointsFoe;
	}
	public void setMaxHealthPointsFoe(JPanel maxHealthPointsFoe) {
		this.maxHealthPointsFoe = maxHealthPointsFoe;
	}
	public JPanel getMaxKiFoe() {
		return maxKiFoe;
	}
	public void setMaxKiFoe(JPanel maxKiFoe) {
		this.maxKiFoe = maxKiFoe;
	}
	public JPanel getMaxStaminaFoe() {
		return maxStaminaFoe;
	}
	public void setMaxStaminaFoe(JPanel maxStaminaFoe) {
		this.maxStaminaFoe = maxStaminaFoe;
	}
	public JPanel getMaxStaminaPlayer() {
		return maxStaminaPlayer;
	}
	public void setMaxStaminaPlayer(JPanel maxStaminaPlayer) {
		this.maxStaminaPlayer = maxStaminaPlayer;
	}
	public JPanel getActionsOffered() {
		return actionsOffered;
	}
	public void setActionsOffered(JPanel actionsOffered) {
		this.actionsOffered = actionsOffered;
	}
	public JPanel getSouthPanel() {
		return southPanel;
	}
	public void setSouthPanel(JPanel southPanel) {
		this.southPanel = southPanel;
	}
	public JButton getAttack() {
		return attack;
	}
	public void setAttack(JButton attack) {
		this.attack = attack;
	}
	public JButton getBlock() {
		return block;
	}
	public void setBlock(JButton block) {
		this.block = block;
	}
	public JButton getUse() {
		return use;
	}
	public void setUse(JButton use) {
		this.use = use;
	}
	public JButton getPhysicalAttack() {
		return physicalAttack;
	}
	public void setPhysicalAttack(JButton physicalAttack) {
		this.physicalAttack = physicalAttack;
	}
	public JButton getUltimateAttack() {
		return ultimateAttack;
	}
	public void setUltimateAttack(JButton ultimateAttack) {
		this.ultimateAttack = ultimateAttack;
	}
	public JButton getSuperAttack() {
		return superAttack;
	}
	public void setSuperAttack(JButton superAttack) {
		this.superAttack = superAttack;
	}
	public JPanel getCenterPanel() {
		return centerPanel;
	}
	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}
	public JLabel getPlayerGif() {
		return playerGif;
	}
	public void setPlayerGif(JLabel playerGif) {
		this.playerGif = playerGif;
	}
	public JLabel getPlayerArrow() {
		return playerArrow;
	}
	public void setPlayerArrow(JLabel playerArrow) {
		this.playerArrow = playerArrow;
	}
	public JPanel getPlayerPanel() {
		return playerPanel;
	}
	public void setPlayerPanel(JPanel playerPanel) {
		this.playerPanel = playerPanel;
	}
	public JLabel getFoeArrow() {
		return foeArrow;
	}
	public void setFoeArrow(JLabel foeArrow) {
		this.foeArrow = foeArrow;
	}
	public JLabel getFoeGif() {
		return foeGif;
	}
	public void setFoeGif(JLabel foeGif) {
		this.foeGif = foeGif;
	}
	public JPanel getFoePanel() {
		return foePanel;
	}
	public void setFoePanel(JPanel foePanel) {
		this.foePanel = foePanel;
	}
	public JComboBox<String> getAvailableUltimateAttacks() {
		return availableUltimateAttacks;
	}
	public void setAvailableUltimateAttacks(
			JComboBox<String> availableUltimateAttacks) {
		this.availableUltimateAttacks = availableUltimateAttacks;
	}
	public JComboBox<String> getAvailableSuperAttacks() {
		return availableSuperAttacks;
	}
	public void setAvailableSuperAttacks(
			JComboBox <String> availableSuperAttacks) {
		this.availableSuperAttacks = availableSuperAttacks;
	}
	
	public boolean isAvailableSuperAttacksON() {
		return availableSuperAttacksON;
	}

	public void setAvailableSuperAttacksON(boolean availableSuperAttacksON) {
		this.availableSuperAttacksON = availableSuperAttacksON;
	}

	public boolean isAvailableUltimateAttacksON() {
		return availableUltimateAttacksON;
	}

	public void setAvailableUltimateAttacksON(boolean availableUltimateAttacksON) {
		this.availableUltimateAttacksON = availableUltimateAttacksON;
	}
	public int getOldLevel() {
		return oldLevel;
	}

	public void setOldLevel(int oldLevel) {
		this.oldLevel = oldLevel;
	}

	public int getOldAbilityPoints() {
		return oldAbilityPoints;
	}

	public void setOldAbilityPoints(int oldAbilityPoints) {
		this.oldAbilityPoints = oldAbilityPoints;
	}

	public static void main(String[]args){
		GameView test=new GameView();
		Earthling me =new Earthling("Me");
		me.setHealthPoints(50);
		Battle myBattle=new Battle(me,new Earthling("foe"));
		BattleView testDragon=new BattleView(myBattle);
		test.setContentPane(testDragon);
	}
	
}
