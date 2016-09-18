package com.example.shankar.learnera;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.button_signup) Button mSignUp;
    @BindView(R.id.button_login) Button mLogIn;
    @BindView(R.id.button_announcement) Button mAnnouncement;
    @BindView(R.id.button_attendance) Button mAttendance;
    @BindView(R.id.button_activity_points) Button mActivityPoints;
    @BindView(R.id.button_marks) Button mMarks;
    @BindView(R.id.button_contacts) Button mContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        Thread mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                boolean previouslyStarted = preferences.getBoolean(getString(R.string.pref_previously_started), false);
                if (!previouslyStarted) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean(getString(R.string.pref_previously_started), true);
                    editor.apply();
                    startActivity(new Intent(WelcomeActivity.this, IntroActivity.class));
                }
            }
        });
        mThread.start();
    }

    @OnClick(R.id.button_signup) void signUp() {
        startActivity(new Intent(WelcomeActivity.this, SignUpActivity.class));
    }

    @OnClick(R.id.button_login) void login() {
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
    }

    @OnClick(R.id.button_announcement) void announcement() {
        startActivity(new Intent(WelcomeActivity.this, AnnouncementsActivity.class));
    }

    @OnClick(R.id.button_attendance) void attendance() {
        startActivity(new Intent(WelcomeActivity.this, AttendanceActivity.class));
    }

    @OnClick(R.id.button_activity_points) void activityPoints() {
        startActivity(new Intent(WelcomeActivity.this, ActivityPointsActivity.class));
    }

    @OnClick(R.id.button_marks) void marks() {
        startActivity(new Intent(WelcomeActivity.this, MarksActivity.class));
    }

    @OnClick(R.id.button_contacts) void contacts() {
        startActivity(new Intent(WelcomeActivity.this, ContactsActivity.class));

    }
}