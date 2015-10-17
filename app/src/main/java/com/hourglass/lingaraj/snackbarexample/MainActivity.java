package com.hourglass.lingaraj.snackbarexample;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     Button showSnackbar,changeSnackBarTextColor,snackBarinParentLayout;
    CoordinatorLayout coordinatorLayoutForSnackBar;
    Snackbar snackbar;
    LinearLayout parentLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showSnackbar=(Button)findViewById(R.id.show_snackbar);
        changeSnackBarTextColor=(Button)findViewById(R.id.change_snackbar_text_color);
        snackBarinParentLayout=(Button)findViewById(R.id.snackbar_in_parent_layout);
        coordinatorLayoutForSnackBar=(CoordinatorLayout)findViewById(R.id.co_ordinated_layout_main);
        parentLinearLayout=(LinearLayout)findViewById(R.id.linearLayout_parent);

        showSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Snackbar.make(coordinatorLayoutForSnackBar,"Message",Snackbar.LENGTH_LONG).show();
               }
        });

        final View.OnClickListener snackbarClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                snackbar.dismiss();
            }
        };

        changeSnackBarTextColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar=Snackbar.make(coordinatorLayoutForSnackBar, "Message", Snackbar.LENGTH_INDEFINITE).setAction("Dismiss",snackbarClickListener);
                snackbar.setActionTextColor(Color.RED);
                View view=snackbar.getView();
                view.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimaryDark));
                TextView tv=(TextView)view.findViewById(android.support.design.R.id.snackbar_text);
                tv.setTextColor(Color.RED);
                snackbar.show();


              }
        });

        snackBarinParentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar=Snackbar.make(parentLinearLayout,"Message",Snackbar.LENGTH_INDEFINITE).setAction("Dismiss",snackbarClickListener);
                snackbar.setActionTextColor(Color.GREEN);
                View view1=snackbar.getView();
                view1.setBackgroundColor(Color.GRAY);
                TextView tv=(TextView)view1.findViewById(android.support.design.R.id.snackbar_text);
                tv.setTextColor(Color.GREEN);
                snackbar.show();


            }
        });



    }
}
