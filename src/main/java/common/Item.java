package common;
public class Item{
	    public int cost;
		public int quantityInitial;
		public int quantityLeft;
	    public String name;
	    
		public Item(int cost, int quantityInitial, int quantityLeft, String name) {
	      this.cost=cost;
			this.quantityInitial = quantityInitial;
			this.quantityLeft = quantityLeft;
	      this.name=name;
	    }
	  }