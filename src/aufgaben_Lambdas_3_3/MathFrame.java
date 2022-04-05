package aufgaben_Lambdas_3_3;

import java.awt.FlowLayout;
import java.util.function.IntBinaryOperator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MathFrame extends JFrame {

	private final JTextField textFieldX = new JTextField(10);
	private final JTextField textFieldY = new JTextField(10);
	private final JButton buttonPlus = new JButton("Plus");
	private final JButton buttonMinus = new JButton("Minus");
	private final JTextField textFieldResult = new JTextField(10);

	public MathFrame() {
		this.setLayout(new FlowLayout());
		this.add(this.textFieldX);
		this.add(this.textFieldY);
		this.add(this.buttonPlus);
		this.add(this.buttonMinus);
		this.add(this.textFieldResult);
		this.registerListeners();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

//	private void registerListeners() {
//		this.buttonPlus.addActionListener(e -> this.onCalc(new BinaryOperator() {
//			public int apply(int x, int y) {
//				return x + y;
//			}
//		}));
//		this.buttonMinus.addActionListener(e -> this.onCalc(new BinaryOperator() {
//			public int apply(int x, int y) {
//				return x - y;
//			}
//		}));
//	}

	private void registerListeners() {
		this.buttonPlus.addActionListener(e -> { 
			//this.onCalc(new BinaryOperator() { public int apply(int x, int y) { return x + y; } }); 
			this.onCalc((x, y) -> x + y); 
		});
		//this.buttonMinus.addActionListener(e -> this.onCalc((BinaryOperator)(int x, int y) -> (int)(x - y)));
		this.buttonMinus.addActionListener(e -> {
			this.onCalc((int x, int y) -> {
				return x - y;
			});	
		});
	}

	private void onCalc(IntBinaryOperator op) {
		try {
			int x = Integer.parseInt(this.textFieldX.getText());
			int y = Integer.parseInt(this.textFieldY.getText());
			int result = op.applyAsInt(x, y);
			this.textFieldResult.setText(String.valueOf(result));
		}
		catch (NumberFormatException e) {
			this.textFieldResult.setText("Illegal input");
		}
	}
}
