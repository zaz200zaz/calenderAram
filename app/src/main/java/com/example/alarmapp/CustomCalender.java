package com.example.alarmapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CustomCalender extends LinearLayout {

    ImageButton nextBtn,previousBtn;
    TextView currentDate;
    GridView gridView;
    private static final int MAX = 42;
    Calendar calendar = Calendar.getInstance(Locale.JAPAN);
    Context context;

    List<Date> dates = new ArrayList<>();
    List<Events> eventsList = new ArrayList<>();

    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy",Locale.JAPAN);
    SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM",Locale.JAPAN);
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy",Locale.JAPAN);

    public CustomCalender(Context context) {
        super(context);
    }

    public CustomCalender(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        IntializeLayout();

        SetUpCalender();

        previousBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.MONTH,-1);
                SetUpCalender();
            }
        });
        nextBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.MONTH,1);
                SetUpCalender();
            }
        });

    }

    public CustomCalender(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void IntializeLayout(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.calender_layout,this);
        nextBtn = view.findViewById(R.id.nextBtn);
        previousBtn = view.findViewById(R.id.previousBtn);
        currentDate = view.findViewById(R.id.current_Date_Id);
        gridView = view.findViewById(R.id.gridViewId);
    }

    private void SetUpCalender(){
        String CurrentDate = dateFormat.format(calendar.getTime());
        currentDate.setText(CurrentDate + "年");
    }
}
