package jkind.writers;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import jkind.solvers.Model;

public abstract class Writer {
	public abstract void begin();
	public abstract void end();
	
	public abstract void writeValid(List<String> props, int k, long elapsed);
	public abstract void writeInvalid(List<String> props, int k, Model model, long elapsed);
	public abstract void writeUnknown(List<String> props);
	
	protected static SortedSet<String> getRelevantFunctions(Set<String> functions) {
		SortedSet<String> relevant = new TreeSet<String>();
		for (String fn : functions) {
			if (!fn.startsWith("$#")) {
				relevant.add(fn);
			}
		}
		return relevant;
	}

}
