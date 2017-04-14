package com.example.bartlomiej.bitcraftapp.view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.bartlomiej.bitcraftapp.R;

public class RecyclerViewsHolder extends RecyclerView.ViewHolder {

    private TextView idTextView;

    private TextView userIdTextView;

    private TextView titleTextView;

    private TextView bodyTextView;

    public RecyclerViewsHolder(View itemView) {
        super(itemView);

        idTextView = (TextView) itemView.findViewById(R.id.item_id);
        userIdTextView = (TextView) itemView.findViewById(R.id.item_user_id);
        titleTextView = (TextView) itemView.findViewById(R.id.item_title);
        bodyTextView = (TextView) itemView.findViewById(R.id.item_body);
    }

    public TextView getIdTextView() {
        return idTextView;
    }

    public TextView getUserIdTextView() {
        return userIdTextView;
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public TextView getBodyTextView() {
        return bodyTextView;
    }
}
