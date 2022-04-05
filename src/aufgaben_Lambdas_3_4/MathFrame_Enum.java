package aufgaben_Lambdas_3_4;

import java.awt.FlowLayout;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MathFrame_Enum extends JFrame {
	
	private final JTextField textFieldX = new JTextField(10);
	private final JTextField textFieldY = new JTextField(10);
	private final JTextField textFieldResult = new JTextField(10);
	
	public MathFrame_Enum() {
		this.setTitle("Enum-Variante");
		this.setLayout(new FlowLayout());
		this.add(this.textFieldX);
		this.add(this.textFieldY);
		this.addButtons();
		this.add(this.textFieldResult);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	private void addButtons() {
		for (BinaryOperators op : BinaryOperators.values()) {
			JButton button = new JButton(op.getDisplayName());
			button.addActionListener(e -> onCalc(op.getOp()));
			this.add(button);
		}
	}
	
	private void onCalc(IntBinaryOperator op) {
		try {
			int x = Integer.parseInt(this.textFieldX.getText());
			int y = Integer.parseInt(this.textFieldY.getText());
			int result = op.applyAsInt(x, y);
			this.textFieldResult.setText(String.valueOf(result));
		}
		catch(Exception e) {
			this.textFieldResult.setText("Illegal input");
		}
	}
}
