/* Aufgabe:
 * Erweiterung von Aufgabe 3:
 * Speichern Sie die 4 Rechenarten (+ , - , *, /) mit Hilfe "intBinaryOperator" in einer Map 
 * respektive einem Enum und verwenden Sie diese in der RechnerAnwendung.
 */

package aufgaben_Lambdas_3_4;

import java.awt.FlowLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MathFrame_Map extends JFrame {
	
	private final Map<String, IntBinaryOperator> operators = new LinkedHashMap<>();
	{
		operators.put("Plus",   (x, y) -> x + y);
		operators.put("Minus",  (x, y) -> x - y);
		operators.put("Times", (x, y) -> x * y);
		operators.put("Div",   (x, y) -> x / y);
	}
	
	private final JTextField textFieldX = new JTextField(10);
	private final JTextField textFieldY = new JTextField(10);
	private final JTextField textFieldResult = new JTextField(10);
	
	public MathFrame_Map() {
		this.setTitle("Map-Variante");
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
		for (Map.Entry<String, IntBinaryOperator> entry : operators.entrySet()) {
			JButton button = new JButton(entry.getKey());
			button.addActionListener(e -> onCalc(entry.getValue()));
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
