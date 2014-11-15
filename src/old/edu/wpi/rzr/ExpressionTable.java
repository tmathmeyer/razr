package old.edu.wpi.rzr;

import java.util.HashMap;
import java.util.Map;

import old.edu.wpi.rzr.real.LookupExpression;
import old.edu.wpi.rzr.types.Expression;

public class ExpressionTable
{
	private final Map<Expression, LookupExpression> table = new HashMap<>();
	private final static ExpressionTable INSTANCE = new ExpressionTable();
	
	
	private ExpressionTable(){}
	
	public static LookupExpression storeExpression(Expression e)
	{
		if (e instanceof LookupExpression)
		{
			return (LookupExpression) e;
		}
		
		LookupExpression le = INSTANCE.table.get(e);
		
		if (le == null)
		{
			le = new LookupExpression(INSTANCE.table.size());
			INSTANCE.table.put(e, le);
		}
		
		return le;
	}
	
	
}
