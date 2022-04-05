package aufgaben_Lambdas_3_4;

import java.util.function.IntBinaryOperator;

public enum BinaryOperators {
	PLUS("Plus", (v1, v2) -> v1 + v2),
	MINUS("Minus", (v1, v2) -> v1 - v2),
	TIMES("Times", (v1, v2) -> v1 * v2),
	DIV("Div", (v1, v2) -> v1 / v2)
	;
	
	private final String displayName;
	private final IntBinaryOperator op;
	
	private BinaryOperators(String displayName, IntBinaryOperator op) {
		this.displayName = displayName;
		this.op = op;
	}
	
	public IntBinaryOperator getOp() {
		return op;
	}

	public String getDisplayName() {
		return this.displayName;
	}
}
