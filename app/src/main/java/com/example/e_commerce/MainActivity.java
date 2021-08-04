    package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.e_commerce.adapter.CategoryAdapter;
import com.example.e_commerce.adapter.CourseAdapter;
import com.example.e_commerce.model.Category;
import com.example.e_commerce.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

    public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course>  courseList = new ArrayList<>();
    static List<Course>  fullCoursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();

        categoryList.add(new Category(1,"Игры"));
        categoryList.add(new Category(2,"Сайты"));
        categoryList.add(new Category(3,"Языки"));
        categoryList.add(new Category(4,"Прочее"));

        setCategoryRecycler(categoryList);




        courseList.add(new Course(1, "java","Профессия разработчик Java","1 января", "низкий", "#424345","test",3));
        courseList.add(new Course(2, "python","Профессия разработчик Python","10 января", "низкий", "#9FA52D","test",3));
        courseList.add(new Course(3, "unity","Профессия Unity разработчик ","5 января", "низкий", "#651730","test",1));
        courseList.add(new Course(4, "front_end","Профессия Front-end разработчик","7 января", "низкий", "#B04935","test",2));
        courseList.add(new Course(5, "back_end","Профессия Back-end разработчик","14 января", "низкий", "#2D55A5","test",2));
        courseList.add(new Course(6, "full_stack","Профессия Full-stack разработчик","21 января", "низкий", "#FFC007","test",2));

        fullCoursesList.addAll(courseList);
        setCourseRecycler(courseList);
    }

        private void setCourseRecycler(List<Course> courseList) {
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

            courseRecycler = findViewById(R.id.rv_course);
            courseRecycler.setLayoutManager(layoutManager);
            courseAdapter = new CourseAdapter(this, courseList);
            courseRecycler.setAdapter(courseAdapter);
        }

        private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.rv_category);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
        }


        public static  void showCoursesByCategory(int category){
            courseList.clear();
            courseList.addAll(fullCoursesList);

            List<Course> filterCourses = new ArrayList<>();

            for (Course c: courseList){
                if (c.getCategory()==category)
                    filterCourses.add(c);
            }
            courseList.clear();
            courseList.addAll(filterCourses);
            courseAdapter.notifyDataSetChanged();

        }
    }