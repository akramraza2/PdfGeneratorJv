package com.akram.pdfgenerator.views;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.cardview.widget.CardView;

import com.akram.pdfgenerator.model.DataPoints;
import com.akram.pdfgenerator.model.DataPointsDB;

import java.util.ArrayList;

public class Utils {

    private Context context;
    private static DataPointsDB database;

    public static ArrayList<Bitmap> allCardViews;
    public Utils(Context context) {
        this.context = context;
        database = DataPointsDB.getInstance(context);
        if (allCardViews == null){
            allCardViews = new ArrayList<>();
        }
    }

    public ArrayList<DataPoints> getAllDataPoints() {
        return (ArrayList<DataPoints>) database.dataPointsDao().getAllGraphPoints();
    }

    public static ArrayList<Bitmap> getAllCardViews(){
        return allCardViews;
    }
}
