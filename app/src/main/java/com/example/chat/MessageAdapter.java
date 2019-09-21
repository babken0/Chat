package com.example.chat;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<AwesomeMessage> {

    private List<AwesomeMessage> messages;
    private Activity activity;

    public MessageAdapter(Activity context, int resource,
                          List<AwesomeMessage> messages) {
        super(context, resource,messages);
        this.messages = messages;
        this.activity = context;
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        ViewHolder viewHolder;

        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        AwesomeMessage message = getItem(position);

        int layoutResurse = 0;
        int viewType = getItemViewType(position);

        if (viewType == 0){
            layoutResurse = R.layout.my_message_item;
        }else {
            layoutResurse = R.layout.your_message_item;
        }





        if (convertView != null){
            viewHolder = (ViewHolder) convertView.getTag();
        }else {
            convertView = layoutInflater.inflate(layoutResurse,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        boolean isText = message.getImageUrl() == null;

        if (isText){
            viewHolder.messageTextView.setVisibility(View.VISIBLE);
            viewHolder.photoImageView.setVisibility(View.GONE);
            viewHolder.messageTextView.setText(message.getText());
        }else {
            viewHolder.messageTextView.setVisibility(View.GONE);
            viewHolder.photoImageView.setVisibility(View.VISIBLE);
            Glide.with(viewHolder.photoImageView.getContext())
                    .load(message.getImageUrl())
                    .into(viewHolder.photoImageView);
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        int flag;
        AwesomeMessage message = messages.get(position);
        if (message.getMine()){
            flag = 0;
        }else {
            flag = 1;
        }
        return flag;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    private class ViewHolder{
        private TextView messageTextView;
        private ImageView photoImageView;

        public ViewHolder(View view){
            messageTextView = view.findViewById(R.id.messageTextView);
            photoImageView = view.findViewById(R.id.photoImageView);
        }
    }
}
