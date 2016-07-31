package com.github.irshulx.servishero.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.irshulx.servishero.R;
import com.github.irshulx.servishero.models.Question;
import com.github.irshulx.servishero.models.QuestionSet;
import com.github.irshulx.servishero.models.Response;
import com.github.irshulx.servishero.utilities.Utilities;
import com.squareup.picasso.Downloader;

import java.util.List;
import java.util.zip.Inflater;

public class QuestionsActivity extends AppCompatActivity {
    private Utilities utilities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        String servis= getIntent().getStringExtra("servis");
        if(servis!=null){
            ((TextView)toolbar.findViewById(R.id.lblServisName)).setText(servis);
        }

        utilities =new Utilities(QuestionsActivity.this);
        initiateQuestionSet();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }


    @Override
    protected void onPause()
    {
        super.onPause();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }


    private void initiateQuestionSet() {
        String questions= getResources().getString(R.string.aircon);
        QuestionSet questionSet= utilities.deserializeToQuestions(questions);
        buildQuestions(questionSet);
    }


    private void buildQuestions(QuestionSet questionSet){
        LayoutInflater inflater = LayoutInflater.from(QuestionsActivity.this);
        LinearLayout holder= (LinearLayout) findViewById(R.id.holder);
        List<Question> questions= questionSet.getQuestions();
        for(int i=0;i<questions.size();i++) {
            final View child_layout = inflater.inflate(R.layout.question_item, holder , false);
            ((TextView)child_layout.findViewById(R.id.lblQuestion)).setText(questions.get(i).getQuestionText());
            for (Response response:questions.get(i).getResponses()){
                RadioGroup group= (RadioGroup) child_layout.findViewById(R.id.radioGroup);
                RadioButton radioButton= buildRadioButton(inflater,group,response.getResponseText());
                group.addView(radioButton);
            }
            holder.addView(child_layout);
        }
    }

    private RadioButton buildRadioButton(LayoutInflater inflater, RadioGroup holder, String text){
//        RadioButton radioButton=new RadioButton(getApplicationContext());
//        radioButton.setGravity(View.TEXT_DIRECTION_ANY_RTL);
//       // radioButton.setTextAlignment(View.LAYOUT_DIRECTION_RTL);
//    //    radioButton.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        params.gravity = Gravity.START;
//        radioButton.setPadding(5, 20, 5, 20);
//        radioButton.setText(text);
//        radioButton.setTextColor(getResources().getColor(R.color.darkertext));
//        radioButton.setLayoutParams(params);
//        radioButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_bottom));
//        radioButton.setTextSize(getResources().getDimension(R.dimen.large_text));
//        return radioButton;
         RadioButton child_layout = (RadioButton) inflater.inflate(R.layout.radio_button, holder , false);
        child_layout.setText(text);
        return child_layout;
    }


}
