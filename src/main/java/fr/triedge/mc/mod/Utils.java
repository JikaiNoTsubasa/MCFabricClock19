package fr.triedge.mc.mod;

public class Utils {

	// 10  -3
	public static float getPercent(int min, int max, int value) {
		int range = Math.abs(min-max); // 
		//System.out.println("Range: "+range);
		int newMin = max - range;
		//System.out.println("NewMin: "+newMin);
		if (value <= min && value >=max)
			return ((value - min) * 100) / (max - min);
		if (value < max && value >= max - range) {
			//System.out.println("v"+value+" n"+newMin+" m"+min);
			return ((value - newMin) * 100) / (max - newMin);
		}
		return 0;
	}
}
