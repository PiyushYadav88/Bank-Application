package com.piyush.yadav.bankmanagementsystem.ListAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.piyush.yadav.bankmanagementsystem.Data.User;
import com.piyush.yadav.bankmanagementsystem.R;

import java.util.ArrayList;

public class SendToUserAdapter extends RecyclerView.Adapter<SendToUserAdapter.ViewHolder> {
    private ArrayList<User> userArrayList;
    private OnUserListener onUserListener;

    public SendToUserAdapter(ArrayList<User> userArrayList, OnUserListener onUserListener) {
        this.userArrayList = userArrayList;
        this.onUserListener = onUserListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from (viewGroup.getContext()).inflate(R.layout.user_list_item, viewGroup, false);
        return new ViewHolder(view, onUserListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(userArrayList.get(position));
        viewHolder.userName.setText(userArrayList.get(position).getName());
        viewHolder.userAccountBalance.setText(String.format("%d", userArrayList.get(position).getBalance()));
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        TextView userName, userAccountBalance;
        OnUserListener onUserListener;

        public ViewHolder(@NonNull View itemView, OnUserListener onUserListener) {
            super(itemView);
            userName = itemView.findViewById(R.id.username);
            userAccountBalance = itemView.findViewById(R.id.amount);
            this.onUserListener = onUserListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onUserListener.onUserClick(getAdapterPosition());
        }
    }

    public interface OnUserListener {
        void onUserClick(int position);
    }
}
