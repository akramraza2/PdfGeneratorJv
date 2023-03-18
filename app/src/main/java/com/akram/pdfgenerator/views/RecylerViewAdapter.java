package com.akram.pdfgenerator.views;

import static android.view.LayoutInflater.from;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.akram.pdfgenerator.R;
import com.akram.pdfgenerator.databinding.RecViewItemsBinding;
import com.akram.pdfgenerator.model.DataPoints;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.vipul.hp_hp.library.Layout_to_Image;

import java.util.ArrayList;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.ViewHolder> {
    ArrayList<DataPoints> dataPoints = new ArrayList<>();
    private Context context;
    private Utils utils;
    RecViewItemsBinding recViewItemsBinding;

    Layout_to_Image layout_to_image;

    public RecylerViewAdapter(Context context) {
        this.context = context;
        utils = new Utils(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        recViewItemsBinding = RecViewItemsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        ViewHolder holder = new ViewHolder(recViewItemsBinding);
        return holder;
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recViewItemsBinding.summaryTxt.setText("Summary " + (position+1) + ":-");
        holder.recViewItemsBinding.entry11.setText(String.format("%d,%d", dataPoints.get(position).getPoint_x1(), dataPoints.get(position).getPoint_y1()));
        holder.recViewItemsBinding.entry12.setText(String.format("%d,%d", dataPoints.get(position).getPoint_x2(), dataPoints.get(position).getPoint_y2()));
        holder.recViewItemsBinding.entry13.setText(String.format("%d,%d", dataPoints.get(position).getPoint_x3(), dataPoints.get(position).getPoint_y3()));
        holder.recViewItemsBinding.entry14.setText(String.format("%d,%d", dataPoints.get(position).getPoint_x4(), dataPoints.get(position).getPoint_y4()));
        holder.recViewItemsBinding.entry21.setText(String.format("%d,%d", dataPoints.get(position).getPoint2_x1(), dataPoints.get(position).getPoint2_y1()));
        holder.recViewItemsBinding.entry22.setText(String.format("%d,%d", dataPoints.get(position).getPoint2_x2(), dataPoints.get(position).getPoint2_y2()));
        holder.recViewItemsBinding.entry23.setText(String.format("%d,%d", dataPoints.get(position).getPoint2_x3(), dataPoints.get(position).getPoint2_y3()));
        holder.recViewItemsBinding.entry24.setText(String.format("%d,%d", dataPoints.get(position).getPoint2_x4(), dataPoints.get(position).getPoint2_y4()));
        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(dataPoints.get(position).getPoint_x1(), dataPoints.get(position).getPoint_y1()),
                new DataPoint(dataPoints.get(position).getPoint_x2(), dataPoints.get(position).getPoint_y2()),
                new DataPoint(dataPoints.get(position).getPoint_x3(), dataPoints.get(position).getPoint_y3()),
                new DataPoint(dataPoints.get(position).getPoint_x4(), dataPoints.get(position).getPoint_y4()),
        });
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(dataPoints.get(position).getPoint2_x1(), dataPoints.get(position).getPoint2_y1()),
                new DataPoint(dataPoints.get(position).getPoint2_x2(), dataPoints.get(position).getPoint2_y2()),
                new DataPoint(dataPoints.get(position).getPoint2_x3(), dataPoints.get(position).getPoint2_y3()),
                new DataPoint(dataPoints.get(position).getPoint2_x4(), dataPoints.get(position).getPoint2_y4()),
        });

        holder.recViewItemsBinding.graphView1.addSeries(series1);
        holder.recViewItemsBinding.graphView2.addSeries(series2);

        layout_to_image = new Layout_to_Image(context, holder.recViewItemsBinding.dataCard);
        Bitmap bitmap = layout_to_image.convert_layout();
        utils.allCardViews.add(bitmap);
    }

    @Override
    public int getItemCount() {
        return dataPoints.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        RecViewItemsBinding recViewItemsBinding;
        public ViewHolder(@NonNull RecViewItemsBinding binding) {
            super(binding.getRoot());
            this.recViewItemsBinding = binding;
        }
    }

    public void setDataPoints(ArrayList<DataPoints> dataPoints){
        this.dataPoints = dataPoints;
        notifyDataSetChanged();
    }
}
