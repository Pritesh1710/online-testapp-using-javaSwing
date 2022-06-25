package com.gainjava.knowledge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  Which class creates a TCP server socket, bound to the specified port?");
			radioButton[0].setText("ServerSocket");
			radioButton[1].setText("Socket");
			radioButton[2].setText("DatagramSocket");
			radioButton[3].setText("InetAddress");
		}
		if (current == 1) {
			label.setText("Que2:  Which driver translates JDBC calls into ODBC calls and use Windows ODBC built in drivers.");
			radioButton[0].setText("Type-2");
			radioButton[1].setText("Type-1");
			radioButton[2].setText("Type-3");
			radioButton[3].setText("All of above");
		}
		if (current == 2) {
			label.setText("Que3: Which interface is used to call stored procedure?");
			radioButton[0].setText("CallabledStatement");
			radioButton[1].setText("PreparedStatement");
			radioButton[2].setText("CallableStatement");
			radioButton[3].setText("Statement");
		}
		if (current == 3) {
			label.setText("Que4: _____ is responsible to create the object of servlet?");
			radioButton[0].setText("web container");
			radioButton[1].setText("servlet container");
			radioButton[2].setText("only B");
			radioButton[3].setText("both A & B");
		}
		if (current == 4) {
			label.setText("Que5: What is MIME Type?");
			radioButton[0].setText(" Multipurpose Internet Mail Extension");
			radioButton[1].setText("Multiple Intranet Mail Extension");
			radioButton[2].setText("Multiple Internet Mail Extension");
			radioButton[3].setText("	Multipurpose Internet Mail Expansion");
		}
		if (current == 5) {
			label.setText("Que6: A JSP technically gets converted to a _____ during translation time.");
			radioButton[0].setText("web page");
			radioButton[1].setText("servlet");
			radioButton[2].setText("servlet config");
			radioButton[3].setText("JSP config");
		}
		if (current == 6) {
			label.setText("Que7:  Select the correct format of JSP comment.");
			radioButton[0].setText("/* comment */");
			radioButton[1].setText("// comment");
			radioButton[2].setText("<%-- comment --%>");
			radioButton[3].setText("<!-- html -->");
		}
		if (current == 7) {
			label.setText("Que8: A Socket Consists Of?");
			radioButton[0].setText("Only IP address");
			radioButton[1].setText("only Port address");
			radioButton[2].setText("None of these");
			radioButton[3].setText("Port+IP address");
		}
		if (current == 8) {
			label.setText("Que9: Which method executes a simple query and returns a single Result Set object?");
			radioButton[0].setText("executeQuery()");
			radioButton[1].setText("executeUpdate()");
			radioButton[2].setText("execute()");
			radioButton[3].setText("run()");
		}
		if (current == 9) {
			label.setText("Que10: Http is ______");
			radioButton[0].setText("Statefull protocol");
			radioButton[1].setText("Stateless protocol");
			radioButton[2].setText("Transfer protocol");
			radioButton[3].setText("	none of these");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[0].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[2].isSelected());
		if (current == 3)
			return (radioButton[3].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[1].isSelected());
		if (current == 6)
			return (radioButton[2].isSelected());
		if (current == 7)
			return (radioButton[3].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[1].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Online Test System");
	}

}
