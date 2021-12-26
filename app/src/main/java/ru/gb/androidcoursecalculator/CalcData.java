package ru.gb.androidcoursecalculator;

import android.os.Parcel;
import android.os.Parcelable;

public class CalcData implements Parcelable {
    private String number1;

    public CalcData () {
        this.number1 = "0";
    }

    protected CalcData(Parcel in) {
        number1 = in.readString();
    }

    public static final Creator<CalcData> CREATOR = new Creator<CalcData>() {
        @Override
        public CalcData createFromParcel(Parcel in) {
            return new CalcData(in);
        }

        @Override
        public CalcData[] newArray(int size) {
            return new CalcData[size];
        }
    };

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public void addNumber1 (String number) {
        if (this.number1.equals("0")) {
            this.number1 = "";
        }
        this.number1 += number;
    }

    public void resetNumber1 () {
        this.number1 = "0";
    }

    public boolean isNegative () {
        return this.number1.charAt(0) == '-';
    }

    public void minus () {
        if (this.isNegative()) {
            this.number1 = this.number1.subSequence(1, this.number1.length()).toString();
        } else {
            this.number1 = "-" + this.number1;
        }
    }

    public void comma () {
        if (!this.number1.contains(",")) {
            this.number1 += ",";
        }
    }

    public void deleteLastDigit() {
        if (this.number1.length() == 1 || (this.isNegative() && this.number1.length() == 2)) {
            this.resetNumber1();
        } else {
            this.number1 = this.number1.subSequence(0, this.number1.length() - 1).toString();
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.number1);
    }
}
