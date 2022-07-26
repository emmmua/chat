package com.emmmua.pojo;

public class Moments {
    private long number;
    private String text;
    private int depId;
    private String time;

    @Override
    public String toString() {
        return "Moments{" +
                "number=" + number +
                ", text='" + text + '\'' +
                ", depId=" + depId +
                ", time='" + time + '\'' +
                '}';
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
