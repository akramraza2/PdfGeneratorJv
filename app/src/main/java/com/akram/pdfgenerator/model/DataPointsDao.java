package com.akram.pdfgenerator.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataPointsDao {
    @Insert
    void insert(DataPoints dataPoints);

    @Query("SELECT * FROM graph_points")
    List<DataPoints> getAllGraphPoints();

}
