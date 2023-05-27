package com.macoli.scbremotetest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.macoli.scbremotetest.R;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {
    private List<String> resultList;

    public ResultAdapter(List<String> resultList) {
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建并返回用于显示每个列表项的视图持有者
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        // 在视图持有者中设置数据
        String result = resultList.get(position);
        holder.bindData(result);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    // 定义用于存储列表项视图的视图持有者类
    public static class ResultViewHolder extends RecyclerView.ViewHolder {
        private TextView resultTextView;

        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            resultTextView = itemView.findViewById(R.id.result_item_tv);
        }

        public void bindData(String result) {
            resultTextView.setText(result);
        }
    }
}
