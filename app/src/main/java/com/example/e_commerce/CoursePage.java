package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commerce.model.Order;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout courseBg = findViewById(R.id.cl_course_page_background);
        ImageView courseImage = findViewById(R.id.iv_course_page);
        TextView courseTitle = findViewById(R.id.tv_course_page_title);
        TextView courseDate = findViewById(R.id.tv_course_page_date);
        TextView courseLevel = findViewById(R.id.tv_course_page_level);
        TextView courseText = findViewById(R.id.tv_course_page_text);

        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg",0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImage",0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseDate.setText(getIntent().getStringExtra("courseDate"));
        courseLevel.setText(getIntent().getStringExtra("courseLevel"));
        courseText.setText(getIntent().getStringExtra("courseText"));
    }

    public void addToCard(View view){
        int item_id = getIntent().getIntExtra("courseId",0 );
        Order.items_id.add(item_id);
        Toast.makeText(this, "Добавлено в корзину", Toast.LENGTH_SHORT).show();
    }
}