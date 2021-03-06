package com.example.majorproject;

import android.net.Uri;

public class SendVideo {
    private String filepath;
    private String filename;
    private String date;
    private String timeLength;
    private boolean check;
    private boolean isSelected;
    private int index;

    public SendVideo(String filepath, String filename, String date, String timeLength) {
        this.filepath = filepath;
        this.filename = filename;
        this.date = date;
        this.timeLength = timeLength;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(String timeLength) {
        this.timeLength = timeLength;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
