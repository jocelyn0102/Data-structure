import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import java.awt.color.*;

public class MainFrame extends JFrame {
	final int FRAME_WIDTH = 1250;
	final int FRAME_HEIGHT = 700;
	final int FIELD_WIDTH = 70;
	final int AREA_WIDTH = 90;
	final int AREA_HEIGHT = 10;
	private TextField serchField;
	private JButton serchBtn;

	public MainFrame() {
		add(createMainPanel());
		setTitle("Fun Fang Found NEWS");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setBackground(new Color(78, 71, 154));
	}

	public JPanel createMainPanel() {
		// JLabel fun = new JLabel("<html><br>Fun" + "<br>Fang" +
		// "<br>Found</br></html>");
		// JLabel news = new JLabel("NEWS");
		Image fang = new ImageIcon(this.getClass().getResource("/fang.png")).getImage();
		Image title = new ImageIcon(this.getClass().getResource("/white.png")).getImage();
		Image fang0 = new ImageIcon(this.getClass().getResource("/tea.png")).getImage();
		// fun.setFont(new Font("DIALOG", Font.BOLD, 50));
		// news.setFont(new Font("DIALOG", Font.BOLD, 150));

		JLabel aLabel = new JLabel();
		aLabel.setIcon(new ImageIcon(fang0));
		JLabel bLabel = new JLabel();
		bLabel.setIcon(new ImageIcon(fang));
		JLabel cLabel = new JLabel();
		cLabel.setIcon(new ImageIcon(title));

		JPanel titlePanel = new JPanel();
		// titlePanel.add(aLabel);
		titlePanel.add(cLabel);
		titlePanel.setOpaque(false);
		// titlePanel.add(fun);
		// titlePanel.add(news);
		// titlePanel.add(bLabel);

		Image bg = new ImageIcon(this.getClass().getResource("/fang.png")).getImage();
		JLabel bgLabel = new JLabel();
		bgLabel.setIcon(new ImageIcon(bg));
		// bgLabel.setBounds(0, 0,bg.getIconWidth(), bg.getIconHeight()); //
		// 把含有背景圖之Label位置設置為圖片剛好填充整個版面
		// 把内容視窗轉為JPanel，否則不能使用setOpaque()來使視窗變成透明
		JPanel imagePanel = new JPanel();
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE)); // 把背景圖添加到分層窗格的最底層以作為背景

		serchField = new TextField(FIELD_WIDTH);
		// int a= (int) (Math.random()* 255 -0);
		// serchField.setText(Integer.toString(a));
		serchField.setText("站在郁方的肩膀上");
		serchField.setFont(new Font("DIALOG", Font.PLAIN, 20));
		serchBtn = new JButton("GO");
		serchBtn.setBackground(new Color(231, 39, 48));
		serchBtn.setFont(new Font("DIALOG", Font.BOLD, 20));
		serchBtn.setForeground(Color.white);

		JPanel conditionPanel = new JPanel();
		// conditionPanel.setOpaque(false);
		// conditionPanel.setBackground(new Color(255, 255, 255));

		JLabel conditionLabel = new JLabel("Condition Filter: ");
		conditionLabel.setFont(new Font("DIALOG", Font.PLAIN, 25));
		JCheckBox conditionCheckBox11 = new JCheckBox("Politics");
		JCheckBox conditionCheckBox12 = new JCheckBox("Social");
		JCheckBox conditionCheckBox21 = new JCheckBox("Entertainment");
		JCheckBox conditionCheckBox22 = new JCheckBox("Travel");
		JCheckBox conditionCheckBox31 = new JCheckBox("Finance");
		JCheckBox conditionCheckBox32 = new JCheckBox("Finance");
		JCheckBox conditionCheckBox41 = new JCheckBox("Finance");
		JCheckBox conditionCheckBox42 = new JCheckBox("Finance");
		conditionCheckBox11.setOpaque(false);
		conditionCheckBox12.setOpaque(false);
		conditionCheckBox21.setOpaque(false);
		conditionCheckBox22.setOpaque(false);
		conditionCheckBox31.setOpaque(false);
		conditionCheckBox32.setOpaque(false);
		conditionCheckBox41.setOpaque(false);
		conditionCheckBox42.setOpaque(false);
		// conditionCheckBox11.setBackground(new Color(255, 255, 255));
		// conditionCheckBox12.setBackground(new Color(255,255, 255));
		// conditionCheckBox21.setBackground(new Color(255, 255, 255));
		// conditionCheckBox22.setBackground(new Color(255, 255, 255));
		// conditionCheckBox31.setBackground(new Color(255,255, 255));
		// conditionCheckBox32.setBackground(new Color(255, 255, 255));
		// conditionCheckBox41.setBackground(new Color(255, 255, 255));
		// conditionCheckBox42.setBackground(new Color(255, 255, 255));
		conditionCheckBox11.setFont(new Font("DIALOG", Font.PLAIN, 20));
		conditionCheckBox12.setFont(new Font("DIALOG", Font.PLAIN, 20));
		conditionCheckBox21.setFont(new Font("DIALOG", Font.PLAIN, 20));
		conditionCheckBox22.setFont(new Font("DIALOG", Font.PLAIN, 20));
		conditionCheckBox31.setFont(new Font("DIALOG", Font.PLAIN, 20));
		conditionCheckBox32.setFont(new Font("DIALOG", Font.PLAIN, 20));
		conditionCheckBox41.setFont(new Font("DIALOG", Font.PLAIN, 20));
		conditionCheckBox42.setFont(new Font("DIALOG", Font.PLAIN, 20));

		conditionPanel.add(conditionLabel);
		JPanel conditionPanel1 = new JPanel();
		conditionPanel1.setLayout(new GridLayout(4, 2));
		conditionPanel1.add(conditionCheckBox11);
		conditionPanel1.add(conditionCheckBox12);
		conditionPanel1.add(conditionCheckBox21);
		conditionPanel1.add(conditionCheckBox22);
		conditionPanel1.add(conditionCheckBox31);
		conditionPanel1.add(conditionCheckBox32);
		conditionPanel1.add(conditionCheckBox41);
		conditionPanel1.add(conditionCheckBox42);
		conditionPanel.add(conditionPanel1);

		conditionPanel.setBorder(BorderFactory.createEtchedBorder());
		ButtonGroup groupCondition = new ButtonGroup();
		groupCondition.add(conditionCheckBox11);
		groupCondition.add(conditionCheckBox12);
		groupCondition.add(conditionCheckBox21);
		groupCondition.add(conditionCheckBox22);
		groupCondition.add(conditionCheckBox31);
		groupCondition.add(conditionCheckBox32);
		groupCondition.add(conditionCheckBox41);
		groupCondition.add(conditionCheckBox42);

		JPanel serchPanel = new JPanel();
		serchPanel.add(serchField);
		serchPanel.add(serchBtn);
		serchPanel.setOpaque(false);
		JPanel midPanel = new JPanel();
		midPanel.add(serchPanel);
		midPanel.add(conditionPanel);
		midPanel.setOpaque(false);

		JPanel panel = new JPanel();

		panel.setOpaque(false);
		panel.setLayout(new BorderLayout());
		panel.add(titlePanel, BorderLayout.NORTH);
		panel.add(midPanel, BorderLayout.CENTER);
		panel.setOpaque(false);

		// setBounds()

		return panel;
	}

	// public void dooo() {
	// try {
	// check();

	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * public void maching() { try { match(); } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 */

	// public String getAccName() {
	// Scanner in = new Scanner(accountField.getText());
	// if (in.hasNext()) {
	// in.close();
	// return in.next();
	// } else {
	// System.out.println("null");
	// return null;
	// }

	// }
}

// public void check() throws SQLException {
// Connection conn = Connect.getConnection();
// String query = "SELECT `Password` FROM MG04.member WHERE `Account`=?";
// PreparedStatement accStatement = conn.prepareStatement(query);
// accStatement.setString(1, accountField.getText());
// ResultSet resultChoose = accStatement.executeQuery();
// if (resultChoose.next() &&
// resultChoose.getString("Password").equals(passwordField.getText())) {
// HomeFrame home = new HomeFrame();
// home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// home.setVisible(true);
// dispose();

// } else {
// text.setText("Please enter correct password or accounts!" + '\n' + "Try
// again!" + '\n');
// accountField.setText("");
// passwordField.setText("");
// }

// conn.close();
// }
