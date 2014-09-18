//Chad Gibson
package com.fullsail.bsg;


import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class ListData {

    //create an arrayList
    private List<ListItem> ListItems = new ArrayList<ListItem>();

    private String msg = "The total list count is ";
    private String end = ".";
    private int length = 0;

    //method to return the arrayList
    public List<ListItem> getItems() {
        return ListItems;
    }

    //method to add new items to the arrayList
    public boolean addItem(ListItem item){
        boolean error = false;
        for (ListItem listItem : ListItems) {
            if(listItem.item.toLowerCase().equals(item.item.toLowerCase())){
                error = true;
                break;
            }
        }
        if(item.item.isEmpty()){
            error = true;
        }
        if(!error && !item.item.isEmpty()){
            ListItems.add(item);
            //add the length of the string to the total length of all strings
            //getAverageEntryLength(item.item.length());
        }
        return error;
    }

    //default items to be loaded into the arrayList
    public ListData(){
        addItem(new ListItem("Admiral Adama"));
        addItem(new ListItem("President Roslyn"));
        getInitialAvgLength();
    }

    private void getInitialAvgLength(){
        for(ListItem listItem: ListItems){
            length = length + listItem.item.length();
        }
    }

    public String getSizeMessage(){
        String size = String.valueOf(ListItems.size());
        return msg.concat(size).concat(end);
    }

    public String getAverageEntryLength(int itemLength){
        length = length + itemLength;
        int avg = length/ListItems.size();
        String msg = "The average length of each entry is ".concat(String.valueOf(avg)).concat(".");
        Log.i("AVG", msg);
        return msg;
    }

}
