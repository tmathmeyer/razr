package edu.wpi.razer.theory.expression;

public class Function implements Expression
{
	public String[] identifiers;
	public String   name;
	
	//TODO: use something besides string ??
	public Function(String n, String ... ids)
	{
		identifiers = ids;
		name = n;
	}
	
	@Override
	public String toString()
	{
		return name+"("+asArgString(identifiers)+")";
	}

	private String asArgString(String[] universalQuantifiers2)
	{
		StringBuilder sb = new StringBuilder();
		if (identifiers.length > 1)
		{
			int i = 0;
			sb.append(identifiers[i++]);
			do
			{
				sb.append(',');
				sb.append(identifiers[i++]);
			}
			while(i < identifiers.length);
		}
		if (identifiers.length == 1)
		{
			sb.append(identifiers[0]);
		}
		return sb.toString();
	}
}
