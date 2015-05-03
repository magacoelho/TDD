package es.klondike.model;

public enum Suite {
	SPADE, CLUB, DIAMOND, HEART;
	 @Override
	  public String toString() {
	    switch(this) {
	      case SPADE: return "PRIMARIA";
	      case CLUB: return "CLUB";
	      case DIAMOND: return "DIAMOND";
	      case HEART: return "HEART";
	      default: throw new IllegalArgumentException();
	    }
	  }

}
