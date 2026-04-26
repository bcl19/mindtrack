package com.bernardo.mindtrackapi.dto.tracking;

public class ResultResponse {
    private final String date;
    private final int moodLevel;

    public ResultResponse(String date, int moodLevel) {
        this.date = date;
        this.moodLevel = moodLevel;
    }

    public String getDate() {
        return date;
    }

    public int getMoodLevel() {
        return moodLevel;
    }
}
