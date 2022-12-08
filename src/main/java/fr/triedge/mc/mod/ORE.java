package fr.triedge.mc.mod;

public enum ORE {

	IRON(56,16), DIAM(16,-59), GOLD(32,-16), COPPER(112,48),EMERALD(480,232);
	
	public int min, max;

	ORE(int min, int max) {
		this.min = min;
		this.max = max;
	}
}
