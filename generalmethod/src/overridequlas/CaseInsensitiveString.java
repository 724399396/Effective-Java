package overridequlas;

import java.util.ArrayList;
import java.util.List;

// Broken - violates symmetry! 违反对称性
public class CaseInsensitiveString {
	private final String s;
	
	public CaseInsensitiveString(String s) {
		if (s == null)
			throw new NullPointerException();
		this.s = s;
	}
	
	// Broken - violates symmetry!
	@Override public boolean equals(Object o) {
		if (o instanceof CaseInsensitiveString)
			return s.equalsIgnoreCase(
					((CaseInsensitiveString)o).s);
		if (o instanceof String)	// One-way interoperability!互通性
			return s.equalsIgnoreCase((String)o);
		return false;
	}
	
	public static void main(String[] args) {
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
		String s = "polish";
		System.out.println(cis.equals(s));
		System.out.println(s.equals(cis));
		List<CaseInsensitiveString> list = 
				new ArrayList<>();
		list.add(cis);
		System.out.println(list.contains(s));
	}
}
