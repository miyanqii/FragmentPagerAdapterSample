package jp.miyanqii.fragmentpageradaptersample;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

import jp.miyanqii.fragmentpageradaptersample.ItemFragment.OnListFragmentInteractionListener;
import jp.miyanqii.fragmentpageradaptersample.dummy.DummyContent.DummyItem;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
        holder.mExpandableLayout.collapse();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).content);
        holder.mContentView.setText(mValues.get(position).details);
        Picasso.with(holder.mImageView.getContext()).setIndicatorsEnabled(true);
        Picasso.with(holder.mImageView.getContext()).load(mValues.get(position).imageSource).error(R.drawable.placeimg_640_480_nature2).into(holder.mImageView);
//        Picasso.with(holder.mImageView.getContext()).load(mValues.get(position).imageSource).error(R.drawable.placeimg_640_480_nature2).into(new Target() {
//            @Override
//            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//                Palette.Swatch vibrantSwatch = Palette.from(bitmap).generate().getVibrantSwatch();
//                if (vibrantSwatch != null) {
//                    holder.mIdView.setTextColor(vibrantSwatch.getTitleTextColor());
//                    holder.mContentView.setTextColor(vibrantSwatch.getBodyTextColor());
//                    holder.mCardView.setCardBackgroundColor(vibrantSwatch.getRgb());
//                } else {
//                    Log.d(getClass().getSimpleName(), "vibrantSwatch null");
//                }
//            }
//
//            @Override
//            public void onBitmapFailed(Drawable errorDrawable) {
//                Palette.Swatch vibrantSwatch = Palette.from(((BitmapDrawable) errorDrawable).getBitmap()).generate().getVibrantSwatch();
//                if (vibrantSwatch != null) {
//                    holder.mIdView.setTextColor(vibrantSwatch.getTitleTextColor());
//                    holder.mContentView.setTextColor(vibrantSwatch.getBodyTextColor());
//                    holder.mCardView.setCardBackgroundColor(vibrantSwatch.getRgb());
//                } else {
//                    Log.d(getClass().getSimpleName(), "vibrantSwatch null");
//                }
//            }
//
//            @Override
//            public void onPrepareLoad(Drawable placeHolderDrawable) {
//
//            }
//        });

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.mExpandableLayout.toggle();
            }
        });


        holder.mSeeDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem, holder.mImageView);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final ImageView mImageView;
        public final CardView mCardView;
        public final ExpandableLayout mExpandableLayout;
        public final Button mSeeDetailButton;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            mImageView = (ImageView)view.findViewById(R.id.item_image);
            mCardView =(CardView)view.findViewById(R.id.item_card);
            mExpandableLayout = (ExpandableLayout) view.findViewById(R.id.expandable_layout);
            mSeeDetailButton = (Button) view.findViewById(R.id.see_detail_button);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
