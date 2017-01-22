package com.example.singgih.chatappsexample.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.singgih.chatappsexample.Helper.Helper;
import com.example.singgih.chatappsexample.Model.Chat;
import com.example.singgih.chatappsexample.R;
import com.example.singgih.urlpreview.Preview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singg on 1/18/2017.
 */

public class ChatAdapter extends ArrayAdapter<Chat> implements Preview.PreviewListener {

    private TextView chatText;
    private TextView hourMessage;
    private Preview preview;
    private List<Chat> chatList = new ArrayList<Chat>();
    private Context context;
    private List<Chat> chats;
    private String url;
    private View row;

    @Override
    public void add(Chat object) {
        chatList.add(object);
        super.add(object);
    }

    public ChatAdapter(Context context, int textViewResourceId, List<Chat> chats) {
        super(context, textViewResourceId);
        this.context = context;
        this.chats = chats;
    }

    public int getCount() {
        return this.chats.size();
    }

    public Chat getItem(int index) {
        return this.chatList.get(index);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final Chat chatMessageObj = chats.get(position);
        String date = chatMessageObj.getTime();

        row = convertView;
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Surrounding with try catch when url has no value it will be set with empty string
        try {
            url = Helper.extractUrls(chatMessageObj.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            url = "";
        }

        // Checking the message is from me or from the other, if is from me so it will inflated xml own_message, it will be on right side reverse
        if (chatMessageObj.is_from_me()) {
            row = inflater.inflate(R.layout.own_message, parent, false);
        } else {
            row = inflater.inflate(R.layout.other_message, parent, false);
        }

        hourMessage = (TextView) row.findViewById(R.id.hour);
        chatText = (TextView) row.findViewById(R.id.message);
        preview = (Preview) row.findViewById(R.id.preview);
        preview.setListener(this);
        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = Helper.extractUrls(chatMessageObj.getMessage());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                context.startActivity(intent);
            }
        });

        // Surrounding with try catch when date has no value it will be set with 00:00
        try {
            hourMessage.setText(Helper.convertTimeTZtoHour(date));
        } catch (Exception e) {
            e.printStackTrace();
            hourMessage.setText("00:00");
        }

        // Checking value of URL if empty xml preview will be gone
        if (!url.equalsIgnoreCase("")) {
            preview.setVisibility(View.VISIBLE);
            preview.setData(url);
        }

        chatText.setText(chatMessageObj.getMessage());

        return row;
    }

    @Override
    public void onDataReady(Preview preview) {
        preview.setMessage(preview.getLink());
    }
}
