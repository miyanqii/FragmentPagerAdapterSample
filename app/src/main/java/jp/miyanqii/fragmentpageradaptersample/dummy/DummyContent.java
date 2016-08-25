package jp.miyanqii.fragmentpageradaptersample.dummy;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(
                String.valueOf(position),//id
                "1",//type
                new Category("1", "Category1", "1"),
                "Title" + position,
                makeDetails(position),
                makeDetails(position),
                "https://unsplash.it/640/480?image=2" + position);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem implements Parcelable {
        public static final Creator<DummyItem> CREATOR = new Creator<DummyItem>() {
            @Override
            public DummyItem createFromParcel(Parcel in) {
                return new DummyItem(in);
            }

            @Override
            public DummyItem[] newArray(int size) {
                return new DummyItem[size];
            }
        };
        public final String id;
        public final String type;
        public final Category category;
        public final String title;
        public final String description;
        public final String notice;
        public final String imageSource;

        protected DummyItem(Parcel in) {
            id = in.readString();
            type = in.readString();
            category = in.readParcelable(Category.class.getClassLoader());
            title = in.readString();
            description = in.readString();
            notice = in.readString();
            imageSource = in.readString();
        }

        public DummyItem(String id, String type, Category category, String title, String description, String notice, String imageSource) {
            this.id = id;
            this.type = type;
            this.category = category;
            this.title = title;
            this.description = description;
            this.notice = notice;
            this.imageSource = imageSource;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(type);
            dest.writeParcelable(category, flags);
            dest.writeString(title);
            dest.writeString(description);
            dest.writeString(notice);
            dest.writeString(imageSource);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("DummyItem{");
            sb.append("id='").append(id).append('\'');
            sb.append(", type='").append(type).append('\'');
            sb.append(", category=").append(category);
            sb.append(", title='").append(title).append('\'');
            sb.append(", description='").append(description).append('\'');
            sb.append(", notice='").append(notice).append('\'');
            sb.append(", imageSource='").append(imageSource).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
