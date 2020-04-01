package com.codedecode.yashpwr;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.BindInt;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.logo)
    ImageView imgLogo;

    @BindView(R.id.lbl_title)
    TextView lblTitle;

    @BindView(R.id.input_name)
    EditText inputName;

    @BindDrawable(R.mipmap.ic_launcher)
    Drawable drawableLogo;

    @BindString(R.string.app_name)
    String appName;

    @BindColor(R.color.colorPrimaryDark)
    int colorTitle;

    @BindInt(R.integer.distance)
    int distance;

    @BindViews({R.id.lbl1, R.id.lbl2, R.id.lbl3})
    List<TextView> lblArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind the view using butterknife
        ButterKnife.bind(this);

        /**
         * 1. setting label color
         * */
        lblTitle.setTextColor(colorTitle);

        lblTitle.setText( "" + distance);

        /** 2. displaying logo using drawable
         * */
        imgLogo.setImageDrawable(drawableLogo);


        /** 3. applying to text to group of labels
         * */

        final String[] lblText = new String[]{"Cat", "Dog", "Rat"};


        ButterKnife.Action<TextView> APPLY_TEXT = new ButterKnife.Action<TextView>() {
            @Override
            public void apply(TextView view, int index) {
                view.setText(lblText[index]);
            }
        };

        // applying filter to array of labels
        ButterKnife.apply(lblArray, APPLY_TEXT);

        /**
         * 4. Applying color to group of labels
         * */
        ButterKnife.Action<TextView> APPLY_COLOR = new ButterKnife.Action<TextView>() {
            @Override
            public void apply(@NonNull TextView view, int index) {
                view.setTextColor(colorTitle);
            }
        };

        ButterKnife.apply(lblArray, APPLY_COLOR);
    }

    /**
     * 5. On click event of button using butter knife
     * method has to be public always
     */
    @OnClick(R.id.btn_enter)
    public void onButtonClick(View view) {
        Toast.makeText(getApplicationContext(), "You have entered: " + inputName.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_show_list) {
            startActivity(new Intent(MainActivity.this, ContactsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}