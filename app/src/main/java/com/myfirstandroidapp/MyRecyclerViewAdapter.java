package com.myfirstandroidapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private static List<String> listDynamic = new ArrayList<>();
    static {
        for (int i = 0; i < 3 ; i++) {
            listDynamic.add("item Number New: " + i*10);
        }
    }

    private List<String> dataForOurRV;
    private HandleTouchEvents handleTouchEvents;

    public MyRecyclerViewAdapter(List<String> dataForOurRV, HandleTouchEvents handleTouchEvents) {
        this.dataForOurRV = dataForOurRV;
        this.handleTouchEvents = handleTouchEvents;
    }

    public void setList(List<String> dataForOurRV) {
        // this.dataForOurRV = dataForOurRV; !Bad Practice
        this.dataForOurRV.addAll(dataForOurRV);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.my_recycler_view_view_holder, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myHolderTextView
                .setText(this.dataForOurRV.get(position));
    }

    @Override
    public int getItemCount() {
        return this.dataForOurRV.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myHolderTextView;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myHolderTextView = itemView.findViewById(R.id.myTextViewOfViewHolder);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleTouchEvents
                            .onItemClickList(myHolderTextView.getText().toString());
                    setList(listDynamic);
                }
            });
        }
    }

    interface HandleTouchEvents {
        void onItemClickList(String dataPassedOnClick);
    }
}