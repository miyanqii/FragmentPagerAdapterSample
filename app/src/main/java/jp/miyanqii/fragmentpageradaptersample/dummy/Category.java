package jp.miyanqii.fragmentpageradaptersample.dummy;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by miyaki on 2016/08/25.
 */
public class Category implements Parcelable {
    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
    public final String id;
    public final String name;
    public final String order;

    protected Category(Parcel in) {
        id = in.readString();
        name = in.readString();
        order = in.readString();
    }

    public Category(String id, String name, String order) {
        this.id = id;
        this.name = name;
        this.order = order;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(order);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
