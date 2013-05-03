package BenskuLib.common;

public class BiomeLib {
	public static int startBiomeId = 50;
	public static int biomeId = startBiomeId;
	public static int getBiomeIdAndGotoNext() {
		biomeId++;
		return biomeId;
	}
	public static int getBiomeId() {
		biomeId++;
		return biomeId;
	}
}
