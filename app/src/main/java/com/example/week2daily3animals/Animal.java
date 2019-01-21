package com.example.week2daily3animals;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    CallTask popResult;
    private String name;
    private String type;
    private String sound;
    private String pop;
    private String image;

    public Animal(String name, String type, String sound, String image) {
        pop();
        this.name = name;
        this.type = type;
        this.sound = sound;
        this.pop = getPop();
        this.image = image;
    }

    protected Animal(Parcel in) {
        name = in.readString();
        type = in.readString();
        sound = in.readString();
        pop = in.readString();
        image = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void pop() {
        popResult = new CallTask();
        setPop(popResult.execute().toString());
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(sound);
        dest.writeString(pop);
        dest.writeString(image);
    }

    public class CallTask extends AsyncTask<Void, Void, Integer> {
        @Override
        protected Integer doInBackground(Void... voids) {
            Integer pop = (int) (Math.random() * 1000);
            return pop;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            setPop(integer.toString());
        }

    }
}
