package com.example.fyp_work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.TextureView;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toolbar;

public class Results_humor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_results_humor);

        SpannableString s = new SpannableString("BACK");
        Typeface myTypeface = Typeface.create(ResourcesCompat.getFont(this, R.font.lato_thin),
                Typeface.BOLD);
        s.setSpan(new TypefaceSpan(myTypeface), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        s.setSpan(new ForegroundColorSpan(0xFFF30B9E), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        setTitle(s);
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
