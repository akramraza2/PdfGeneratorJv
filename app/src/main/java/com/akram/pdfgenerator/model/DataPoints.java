package com.akram.pdfgenerator.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "graph_points")
public class DataPoints {
    @PrimaryKey(autoGenerate = true)
    private int _id;
    private int point_x1;
    private int point_y1;
    private int point_x2;
    private int point_y2;
    private int point_x3;
    private int point_y3;
    private int point_x4;
    private int point_y4;

    private int point2_x1;
    private int point2_y1;
    private int point2_x2;
    private int point2_y2;
    private int point2_x3;
    private int point2_y3;
    private int point2_x4;
    private int point2_y4;


    public DataPoints(int point_x1, int point_y1, int point_x2, int point_y2, int point_x3, int point_y3, int point_x4, int point_y4, int point2_x1, int point2_y1, int point2_x2, int point2_y2, int point2_x3, int point2_y3, int point2_x4, int point2_y4) {
        this.point_x1 = point_x1;
        this.point_y1 = point_y1;
        this.point_x2 = point_x2;
        this.point_y2 = point_y2;
        this.point_x3 = point_x3;
        this.point_y3 = point_y3;
        this.point_x4 = point_x4;
        this.point_y4 = point_y4;
        this.point2_x1 = point2_x1;
        this.point2_y1 = point2_y1;
        this.point2_x2 = point2_x2;
        this.point2_y2 = point2_y2;
        this.point2_x3 = point2_x3;
        this.point2_y3 = point2_y3;
        this.point2_x4 = point2_x4;
        this.point2_y4 = point2_y4;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getPoint_x1() {
        return point_x1;
    }

    public void setPoint_x1(int point_x1) {
        this.point_x1 = point_x1;
    }

    public int getPoint_y1() {
        return point_y1;
    }

    public void setPoint_y1(int point_y1) {
        this.point_y1 = point_y1;
    }

    public int getPoint_x2() {
        return point_x2;
    }

    public void setPoint_x2(int point_x2) {
        this.point_x2 = point_x2;
    }

    public int getPoint_y2() {
        return point_y2;
    }

    public void setPoint_y2(int point_y2) {
        this.point_y2 = point_y2;
    }

    public int getPoint_x3() {
        return point_x3;
    }

    public void setPoint_x3(int point_x3) {
        this.point_x3 = point_x3;
    }

    public int getPoint_y3() {
        return point_y3;
    }

    public void setPoint_y3(int point_y3) {
        this.point_y3 = point_y3;
    }

    public int getPoint_x4() {
        return point_x4;
    }

    public void setPoint_x4(int point_x4) {
        this.point_x4 = point_x4;
    }

    public int getPoint_y4() {
        return point_y4;
    }

    public void setPoint_y4(int point_y4) {
        this.point_y4 = point_y4;
    }

    public int getPoint2_x1() {
        return point2_x1;
    }

    public void setPoint2_x1(int point2_x1) {
        this.point2_x1 = point2_x1;
    }

    public int getPoint2_y1() {
        return point2_y1;
    }

    public void setPoint2_y1(int point2_y1) {
        this.point2_y1 = point2_y1;
    }

    public int getPoint2_x2() {
        return point2_x2;
    }

    public void setPoint2_x2(int point2_x2) {
        this.point2_x2 = point2_x2;
    }

    public int getPoint2_y2() {
        return point2_y2;
    }

    public void setPoint2_y2(int point2_y2) {
        this.point2_y2 = point2_y2;
    }

    public int getPoint2_x3() {
        return point2_x3;
    }

    public void setPoint2_x3(int point2_x3) {
        this.point2_x3 = point2_x3;
    }

    public int getPoint2_y3() {
        return point2_y3;
    }

    public void setPoint2_y3(int point2_y3) {
        this.point2_y3 = point2_y3;
    }

    public int getPoint2_x4() {
        return point2_x4;
    }

    public void setPoint2_x4(int point2_x4) {
        this.point2_x4 = point2_x4;
    }

    public int getPoint2_y4() {
        return point2_y4;
    }

    public void setPoint2_y4(int point2_y4) {
        this.point2_y4 = point2_y4;
    }

}
