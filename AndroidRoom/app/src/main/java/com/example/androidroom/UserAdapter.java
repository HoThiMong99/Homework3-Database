package com.example.androidroom;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class UserAdapter extends RecyclerView.Adapter<UserAdapter.userViewHolder> {

    static List<User> userdata = new ArrayList<>();

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position) {
        holder.text_title.setText(userdata.get(position).id + "");
        holder.edtname.setText(userdata.get(position).name);
    }

    @Override
    public int getItemCount() {
        if (userdata == null) {
            return 0;
        }
        return userdata.size();
    }

    class userViewHolder extends RecyclerView.ViewHolder {
        TextView text_title;
        EditText edtname;

        public userViewHolder(@NonNull View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.edt_name);
            edtname = itemView.findViewById(R.id.edt_name);
        }
    }
}