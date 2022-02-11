package AnalyticsSystem;

class Data {
	private int maxlength;
	private int minlength;
	private float avgwordlength;
	private int totalwords;
	private String mostCommonword;

	Data() {
		this.maxlength = 0;
		this.minlength = 0;
		this.avgwordlength = 0.0f;
		this.totalwords = 0;
		this.mostCommonword = null;
	}

	public int getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(int maxlength) {
		this.maxlength = maxlength;
	}

	public int getMinlength() {
		return minlength;
	}

	public void setMinlength(int minlength) {
		this.minlength = minlength;
	}

	public float getAvgwordlength() {
		return avgwordlength;
	}

	public void setAvgwordlength(float avgwordlength) {
		this.avgwordlength = avgwordlength;
	}

	public int getTotalwords() {
		return totalwords;
	}

	public void setTotalwords(int totalwords) {
		this.totalwords = totalwords;
	}

	public String getMostCommonword() {
		return mostCommonword;
	}

	public void setMostCommonword(String mostCommonword) {
		this.mostCommonword = mostCommonword;
	}

}
