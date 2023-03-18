package com.akram.pdfgenerator.views;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akram.pdfgenerator.databinding.FragmentMainBinding;
import com.akram.pdfgenerator.model.DataPoints;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainFragment extends Fragment {
    FragmentMainBinding fragmentMainBinding;
    RecylerViewAdapter recylerViewAdapter;
    ArrayList<DataPoints> dataPoints;

    Utils utils;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        assert getArguments() != null;
        if(getArguments().containsKey("all_data")){
           Gson gson = new Gson();
           Type type = new TypeToken<ArrayList<DataPoints>>(){}.getType();
           dataPoints = gson.fromJson(getArguments().getString("all_data"),type);

       }
        fragmentMainBinding = FragmentMainBinding.inflate(inflater,container,false);
        utils = new Utils(getActivity());
       updateViews();
        return fragmentMainBinding.getRoot();
    }

    private void updateViews() {
        fragmentMainBinding.btnGen.setOnClickListener(v -> generatePDF());
        recylerViewAdapter = new RecylerViewAdapter(requireActivity());
        fragmentMainBinding.mainRecView.setAdapter(recylerViewAdapter);

        fragmentMainBinding.mainRecView.setLayoutManager(new LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL,false));

        updateRecViews();
    }

    private void updateRecViews() {
        recylerViewAdapter.setDataPoints(dataPoints);

    }

    private void generatePDF(){
        ArrayList<Bitmap> allCardViews = utils.getAllCardViews();
        int w = 0, h = 0;
        for (int i = 0; i < allCardViews.size(); i++) {
            if (i < allCardViews.size() - 1) {
                w = allCardViews.get(i).getHeight() > allCardViews.get(i + 1).getWidth() ? allCardViews.get(i).getWidth() : allCardViews.get(i + 1).getWidth();
            }
            h += allCardViews.get(i).getHeight();
        }

        Bitmap temp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(temp);
        int top = 0;
        for (int i = 0; i < allCardViews.size(); i++) {
            top = (i == 0 ? 0 : top+allCardViews.get(i).getHeight());
            canvas.drawBitmap(allCardViews.get(i), 0f, top, null);
        }

        convertBitmapToPdf(temp);
    }

    private void convertBitmapToPdf(Bitmap bitmap) {

        PdfDocument pdfDocument = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(bitmap.getWidth(), bitmap.getHeight(), 1).create();
        PdfDocument.Page Page = pdfDocument.startPage(pageInfo);
        Page.getCanvas().drawBitmap(bitmap,0f,0f,null);
        pdfDocument.finishPage(Page);
        File file=new File( Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"generated_pdf.pdf");
        try {
            pdfDocument.writeTo(new FileOutputStream(file));
            Toast.makeText(getActivity(), "File generated", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pdfDocument.close();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
