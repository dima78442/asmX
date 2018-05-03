package com.dima.asmx;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by dima on 16.04.18.
 */

public class List_fragment extends ListFragment {

    /*String data[] = new String[] { "one", "two", "three", "four" };

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);
    }*/
    String data[] = new String[] {"compiler room", "intel documentation", "asm commands" };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch ((int)id){
            case 0:
                //nextactivity
                Intent intent = new Intent(getActivity(),compiler_room.class);
                startActivity(intent);
                break;
            case 1:
                //next
                break;
            case 2:
                //next
                break;
        }
    }
}
