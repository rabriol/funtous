package br.com.funtous.entities;


public enum MediaType {
	VIDEO("V"),
	POTHO("P"),
	AUDIO("A");
	
	private String type;
	
	MediaType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
