package com.example.popularmoviebycookies30.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.popularmoviebycookies30.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SqliteAdapter extends BaseAdapter {
        public Context context;
        public ArrayList<String> user_id;
        public ArrayList<String> user_name;
        public ArrayList<String> email;



        public SqliteAdapter(Context context1, ArrayList<String> ID, ArrayList<String> USERNAME, ArrayList<String> EMAIL) {
            this.context = context1;
            this.user_id = ID;
            this.user_name = USERNAME;
            this.email = EMAIL;
        }

        public class Holder {
            TextView textView_id;
            TextView textView_username;
            TextView textView_email;
        }

        @Override
        public int getCount() {
            return user_id.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Holder holder;
            LayoutInflater inflater;

            if (convertView == null) {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listviewdataakun, null);

                holder = new Holder();

                holder.textView_id = convertView.findViewById(R.id.text_id);
                holder.textView_username = convertView.findViewById(R.id.text_username);
                holder.textView_email = convertView.findViewById(R.id.text_email);

                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            holder.textView_id.setText(user_id.get(position));
            holder.textView_username.setText(user_name.get(position));
            holder.textView_email.setText(email.get(position));
            return convertView;
        }
}
