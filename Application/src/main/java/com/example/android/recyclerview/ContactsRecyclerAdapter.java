package com.example.android.recyclerview;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.common.logger.Log;

/**
 * Created by nwarner on 6/18/15.
 */
public class ContactsRecyclerAdapter extends CursorRecyclerAdapter<ContactsRecyclerAdapter.ViewHolder> {


    public static final String TAG = ContactsRecyclerAdapter.class.getSimpleName() ;

    public ContactsRecyclerAdapter(Cursor c) {
        super(c);
    }

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getPosition() + " clicked.");
                }
            });
            textView = (TextView) v.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }



    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(v);
    }
   
        //this is a little different, the onBindViewHolder(viewHolder,int) is in the superclass
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
    
        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        String name = cursor.getString(RecyclerViewFragment.ContactsQuery.DISPLAY_NAME);
        viewHolder.getTextView().setText(name);
            //TODO: 
    }
}
