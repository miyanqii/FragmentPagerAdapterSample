package jp.miyanqii.fragmentpageradaptersample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import jp.miyanqii.fragmentpageradaptersample.dummy.DummyContent;

public class DetailActivity extends BaseActivity {

    public static final String EXTRA_ITEM = "EXTRA_ITEM";

    @Override
    protected void onSetContentView() {
        setContentView(R.layout.activity_detail);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        if (intent != null) {
            DummyContent.DummyItem item = intent.getParcelableExtra(EXTRA_ITEM);
            if (item != null) {
                getSupportActionBar().setTitle(item.content);
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(item.details);
                ImageView imageView = (ImageView) findViewById(R.id.item_image);
                Picasso.with(imageView.getContext()).load(item.imageSource).into(imageView);
            }
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
