public class Item {
  
  protected String name;
  
/**
 * Null constructor for Item class
 */
  public Item() {
    this("");
  }
/**
 * Initializes Item data
 */   
  public Item(String name) {
    if (name.length() <= GroceryStore.MAX_ITEM_NAME_SIZE)
      this.name = name;
    else 
      this.name = name.substring(0,GroceryStore.MAX_ITEM_NAME_SIZE);
  }
/**
 * Returns name of Item
 * @return name of Item
 */  
  public String getName() {
    return name;
  }
/**
 * Returns cost of Item
 * @return cost of Item
 */  
  public int getCost(){
	return 0;
  }

}