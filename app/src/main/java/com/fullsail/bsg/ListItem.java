//Chad Gibson
package com.fullsail.bsg;


public class ListItem {

    //create a string for our item
    public String item;

    //on new ListItem this sets the string as the item's value
    public ListItem(String item){
        this.item = item;
    }

    @Override
    //returns the item as a string (for listView)
    public String toString() {
        return item;
    }

}
