package com.example.optionmenuwithcontextmenu;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

public class ContextActivity extends Activity {

    int[] moviesCollection={R.drawable.movieone,R.drawable.movietwo,R.drawable.moviethree};
    List<Integer> movieSeries=new ArrayList<>();
    ImageView movieOne;
    Button btnContextBack;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contex_layout);
        movieOne=findViewById(R.id.movieOneImageView);
        movieOne.setImageResource(R.drawable.movietwo);
        btnContextBack=findViewById(R.id.btnContextBack);
        btnContextBack.setOnClickListener(new BtnContextBackListner());


        registerForContextMenu(movieOne);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.buyMovieContext:
                AlertDialog.Builder builder = new AlertDialog.Builder(ContextActivity.this);

                builder.setTitle("MOVIE MANIA");
                builder.setMessage("Do you want to BUY?");
                builder.setIcon(R.mipmap.ic_launcher);
                DialogInterface.OnClickListener listener = new AlertBuyClickListner();
                builder.setPositiveButton("YES", listener);
                builder.setNegativeButton("NO", listener);
                builder.setNeutralButton("Cancel", listener);

                AlertDialog buyDialog = builder.create();
                buyDialog.show();
                break;

            case R.id.rentMovieContext:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(ContextActivity.this);

                builder2.setTitle("MOVIE MANIA");
                builder2.setMessage("Do you want to Rent?");
                builder2.setIcon(R.mipmap.ic_launcher);
                DialogInterface.OnClickListener listener2 = new AlertBuyClickListner();
                builder2.setPositiveButton("YES", listener2);
                builder2.setNegativeButton("NO", listener2);
                builder2.setNeutralButton("Cancel", listener2);

                AlertDialog rentDialog = builder2.create();
                rentDialog.show();
                break;
        }
        return super.onContextItemSelected(item);
    }


    class AlertBuyClickListner implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == DialogInterface.BUTTON_POSITIVE) {
                Toast.makeText(ContextActivity.this, "Paid 350", Toast.LENGTH_SHORT).show();
            }
            if (i == DialogInterface.BUTTON_NEGATIVE) {
                Toast.makeText(ContextActivity.this, "Payment failed", Toast.LENGTH_SHORT).show();
            }

        }
    }
    class AlertRentClickListner implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == DialogInterface.BUTTON_POSITIVE) {
                Toast.makeText(ContextActivity.this, "Paid 150", Toast.LENGTH_SHORT).show();
            }
            if (i == DialogInterface.BUTTON_NEGATIVE) {
                Toast.makeText(ContextActivity.this, "Payment failed", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private class BtnContextBackListner implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent=new Intent(ContextActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
