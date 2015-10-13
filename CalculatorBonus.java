/**
 *Sae Hun Kim
 *CS112 - Java Programming
 *Week 3 Homework Bonus
 *Tuesday 7:00p.m. - 10:00 p.m.
 *
 *The calculator should support basic arithmetic functions(addition, subtraction, multiplication, division),
 *parenthesis(nested and side by side), negative numbers, and the use of whole numbers and decimals.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.*;

public class CalculatorBonus extends JFrame {
	// all the buttons and the text fields
	private JFormattedTextField inputField;
	private JFormattedTextField outputField;
	private JButton num0 = new JButton("0");
	private JButton num1 = new JButton("1");
	private JButton num2 = new JButton("2");
	private JButton num3 = new JButton("3");
	private JButton num4 = new JButton("4");
	private JButton num5 = new JButton("5");
	private JButton num6 = new JButton("6");
	private JButton num7 = new JButton("7");
	private JButton num8 = new JButton("8");
	private JButton num9 = new JButton("9");
	private JButton divb = new JButton("/");
	private JButton mulb = new JButton("*");
	private JButton subb = new JButton("-");
	private JButton addb = new JButton("+");
	private JButton equb = new JButton("=");
	private JButton decb = new JButton(".");
	private JButton delb = new JButton("DEL");
	private JButton lpab = new JButton("(");
	private JButton rpab = new JButton(")");
	private JButton acb = new JButton("AC");
	// number format for output field
	private NumberFormat outputFormat = NumberFormat.getNumberInstance();

	// boolean to see if enter was pressed
	boolean timeToClear = false;

	// answer for the input
	private double ans = 0;

	public CalculatorBonus() {
		// set panel and layout and document filter
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// set up the formated text area
		inputField = new JFormattedTextField();
		inputField.setEditable(false);
		inputField.setBackground(Color.WHITE);
		outputFormat.setMaximumFractionDigits(9);
		outputField = new JFormattedTextField(outputFormat);
		outputField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		outputField.setBackground(Color.WHITE);
		outputField.setEditable(false);

		// add button listener to buttons
		ButtonListener listener = new ButtonListener();
		num7.addActionListener(listener);
		num8.addActionListener(listener);
		num9.addActionListener(listener);
		divb.addActionListener(listener);
		num4.addActionListener(listener);
		num5.addActionListener(listener);
		num6.addActionListener(listener);
		mulb.addActionListener(listener);
		num1.addActionListener(listener);
		num2.addActionListener(listener);
		num3.addActionListener(listener);
		subb.addActionListener(listener);
		num0.addActionListener(listener);
		decb.addActionListener(listener);
		equb.addActionListener(listener);
		addb.addActionListener(listener);
		lpab.addActionListener(listener);
		rpab.addActionListener(listener);
		delb.addActionListener(listener);
		acb.addActionListener(listener);

		// add formated text fields
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(inputField, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(outputField, c);
		c.gridwidth = 1;// reset gridwidth

		// add row 1 buttons to panel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(lpab, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(rpab, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 2;
		panel.add(delb, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 2;
		panel.add(acb, c);
		// add row 2 buttons to panel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(num7, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(num8, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 3;
		panel.add(num9, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 3;
		panel.add(divb, c);
		// add row 3 buttons to panel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(num4, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 4;
		panel.add(num5, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 4;
		panel.add(num6, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 4;
		panel.add(mulb, c);
		// add row 4 buttons to panel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 5;
		panel.add(num1, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 5;
		panel.add(num2, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 5;
		panel.add(num3, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 5;
		panel.add(subb, c);
		// add row 5 buttons
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 6;
		panel.add(num0, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 6;
		panel.add(decb, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 6;
		panel.add(equb, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 6;
		panel.add(addb, c);

		// add the panel to the frame
		add(panel);
	}

	// sets up the frame
	public static void main(String[] args) {
		CalculatorBonus frame = new CalculatorBonus();
		frame.setTitle("Calcultor Ver.CS112HWB");
		frame.setSize(250, 350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// buttons and their listeners
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (timeToClear && !(arg0.getSource() == equb)) {
				inputField.setText("");
				outputField.setText("");
				timeToClear = false;
			}
			if (arg0.getSource() == num0) {
				inputField.setText(inputField.getText() + "0");
			} else if (arg0.getSource() == num1) {
				inputField.setText(inputField.getText() + "1");
			} else if (arg0.getSource() == num2) {
				inputField.setText(inputField.getText() + "2");
			} else if (arg0.getSource() == num3) {
				inputField.setText(inputField.getText() + "3");
			} else if (arg0.getSource() == num4) {
				inputField.setText(inputField.getText() + "4");
			} else if (arg0.getSource() == num5) {
				inputField.setText(inputField.getText() + "5");
			} else if (arg0.getSource() == num6) {
				inputField.setText(inputField.getText() + "6");
			} else if (arg0.getSource() == num7) {
				inputField.setText(inputField.getText() + "7");
			} else if (arg0.getSource() == num8) {
				inputField.setText(inputField.getText() + "8");
			} else if (arg0.getSource() == num9) {
				inputField.setText(inputField.getText() + "9");
			} else if (arg0.getSource() == divb) {
				inputField.setText(inputField.getText() + "/");
			} else if (arg0.getSource() == mulb) {
				inputField.setText(inputField.getText() + "*");
			} else if (arg0.getSource() == subb) {
				inputField.setText(inputField.getText() + "-");
			} else if (arg0.getSource() == addb) {
				inputField.setText(inputField.getText() + "+");
			} else if (arg0.getSource() == decb) {
				inputField.setText(inputField.getText() + ".");
			} else if (arg0.getSource() == lpab) {
				inputField.setText(inputField.getText() + "(");
			} else if (arg0.getSource() == rpab) {
				inputField.setText(inputField.getText() + ")");
			} else if (arg0.getSource() == equb) {
				outputField.setText(prepareCalculate());
				timeToClear = true;
			} else if (arg0.getSource() == delb) {
				String t = inputField.getText();
				if (t.length() > 0) {
					inputField.setText(t.substring(0, t.length() - 1));
				}
			} else if (arg0.getSource() == acb) {
				inputField.setText("");
			}
		}
	}

	public String prepareCalculate() {
		// used to separate the numbers and the operators
		StringBuilder equation = new StringBuilder(inputField.getText());
		ArrayList<String> eq = new ArrayList<String>();

		// checks if input field is empty and if there are no numbers or only
		// numbers
		if (equation.length() == 0) {
			return "";
		}
		boolean hasNumbers = false;
		for (int i = 0; i < equation.length(); i++) {
			if (Character.isDigit(equation.charAt(i))) {
				hasNumbers = true;
				break;
			}
		}
		if (!hasNumbers) {
			return "ERROR";
		}
		boolean onlyNumbers = true;
		for (int i = 0; i < equation.length(); i++) {
			if (!(Character.isDigit(equation.charAt(i)))) {
				onlyNumbers = false;
			}
		}
		if (onlyNumbers) {
			return inputField.getText();
		}

		// checks if the input starts and ends with a digit or parenthesis or
		// negative or decimal
		if (!(Character.isDigit(equation.charAt(0)))
				&& !(equation.charAt(0) == '(') && !(equation.charAt(0) == '-')
				&& !(equation.charAt(0) == '.')) {
			return "ERROR";
		}
		if (!(Character.isDigit(equation.charAt(equation.length() - 1)))
				&& (!(equation.charAt(equation.length() - 1) == ')'))) {
			return "ERROR";
		}

		// gets the positions of parenthesis
		ArrayList<Integer> ls = new ArrayList<Integer>();
		ArrayList<Integer> rs = new ArrayList<Integer>();
		for (int i = equation.length() - 1; i > 0; i--) {
			if (equation.charAt(i) == '(') {
				ls.add(i);
				while (i < equation.length()) {
					if (equation.charAt(i) == ')') {
						rs.add(i);
						break;
					}
					i++;
				}
				i = ls.get(ls.size() - 1);
			}
		}
		if (!(ls.size() == rs.size())) {// if number of parenthesis don't match
										// up return ERROR
			return "ERROR";
		}
		if (ls.size() == 0) {// if no parenthesis just prepare and calculate
			eq = prepare(equation, eq);
			if (calculate(eq).equals("ERROR")) {
				return "ERROR";
			}
		} else {// if parenthesis are apparent
			for (int i = 0; i < ls.size(); i++) {
				// if the equation in the parenthesis does not start with a
				// number return ERROR
				if (!(Character.isDigit(equation.charAt(ls.get(i) + 1)))
						&& !(equation.charAt(ls.get(i)) == '-')
						&& !(equation.charAt(ls.get(i)) == '.')) {
					return "ERROR";
				}
				eq = prepare(
						new StringBuilder(equation.substring(ls.get(i) + 1,
								rs.get(i))), eq);
				if (calculate(eq).equals("ERROR")) {
					return "ERROR";
				}
				// replace the equation in the parenthesis with the answer
				equation.delete(ls.get(i) + 1, rs.get(i));
				equation.insert(ls.get(i) + 1, ans);
			}
			eq = prepare(equation, eq);
			if (calculate(eq).equals("ERROR")) {
				return "ERROR";
			}
		}
		eq.clear();
		return Double.toString(ans);
	}

	// returns an ArrayList is that is ready for calculation. ArrayList includes
	// numbers and operators
	public ArrayList<String> prepare(StringBuilder part, ArrayList<String> eq) {
		eq.clear();
		int placeHolder = 0;
		for (int i = 0; i < part.length(); i++) {
			switch (part.charAt(i)) {
			case '+':
				eq.add(part.substring(placeHolder, i));
				eq.add(Character.toString(part.charAt(i)));
				placeHolder = i + 1;
				break;
			case '-':
				if (i == 0) {
					part.setCharAt(i, '-');
				} else if (i > 0
						&& (part.charAt(i - 1) == '+'
								|| part.charAt(i - 1) == '-'
								|| part.charAt(i - 1) == '*' || part
								.charAt(i - 1) == '/')) {
					part.setCharAt(i - 1, 'n');
				} else {
					eq.add(part.substring(placeHolder, i));
					eq.add(Character.toString(part.charAt(i)));
					placeHolder = i + 1;
				}
				break;
			case '*':
				eq.add(part.substring(placeHolder, i));
				eq.add(Character.toString(part.charAt(i)));
				placeHolder = i + 1;
				break;
			case '/':
				eq.add(part.substring(placeHolder, i));
				eq.add(Character.toString(part.charAt(i)));
				placeHolder = i + 1;
				break;
			case '(':
				if (i > 0
						&& (Character.isDigit(part.charAt(i - 1))
								|| part.charAt(i - 1) == '.' || part
								.charAt(i - 1) == ')')) {
					part.setCharAt(i, '*');
				} else {
					part.deleteCharAt(i);
				}
				i--;
				break;
			case ')':
				if (i < part.length() - 1
						&& (Character.isDigit(part.charAt(i + 1))
								|| part.charAt(i + 1) == '.' || part
								.charAt(i + 1) == '(')) {
					part.setCharAt(i, '*');
				} else {
					part.deleteCharAt(i);
				}
				i--;
				break;
			}
		}
		// turn to negative numbers if needed
		for (int i = 0; i < eq.size(); i++) {
			if (eq.get(i).startsWith("n")) {
				eq.set(i, "-" + eq.get(i).substring(1));
			}
			if (!Character.isDigit(eq.get(i).charAt(2))
					|| !(eq.get(i).charAt(2) == '.')) {
				eq.set(i, "ERROR");
			}
		}
		if (eq.size() == 0) {
			eq.add(part.toString());
		} else {
			if (part.substring(placeHolder).startsWith("(")) {
				eq.add(part.substring(placeHolder + 1));
			} else {
				eq.add(part.substring(placeHolder));
			}
		}
		return eq;
	}

	// calculate the equation and set the answer to the variable ans. returns
	// ERROR if there is an error
	public String calculate(ArrayList<String> eq) {
		try {
			if (eq.size() == 1) { // if only a number was inputed return that
									// number
				ans = Double.parseDouble(eq.get(0));
			} else { // else calculate
				// multiplication and division first
				for (int i = 0; i < eq.size() && eq.size() > 1; i++) {
					if (eq.get(i).equals("*") || eq.get(i).equals("/")) {
						if (eq.get(i).equals("*")) {
							ans = (double) Double.parseDouble(eq.get(i - 1))
									* Double.parseDouble(eq.get(i + 1));
						} else {
							ans = (double) Double.parseDouble(eq.get(i - 1))
									/ Double.parseDouble(eq.get(i + 1));
						}
						eq.remove(i);
						eq.add(i, Double.toString(ans));
						eq.remove(i - 1);
						eq.remove(i);
						i = 0;
					}
				}
				// addition and subtraction last
				for (int i = 0; i < eq.size() && eq.size() > 1; i++) {
					if (eq.get(i).equals("+") || eq.get(i).equals("-")) {
						if (eq.get(i).equals("+")) {
							ans = (double) Double.parseDouble(eq.get(i - 1))
									+ Double.parseDouble(eq.get(i + 1));
						} else {
							ans = (double) Double.parseDouble(eq.get(i - 1))
									- Double.parseDouble(eq.get(i + 1));
						}
						eq.remove(i);
						eq.add(i, Double.toString(ans));
						eq.remove(i - 1);
						eq.remove(i);
						i = 0;
					}
				}
			}
		} catch (NumberFormatException e) {
			return "ERROR";
		}
		return Double.toString(ans);
	}
}
