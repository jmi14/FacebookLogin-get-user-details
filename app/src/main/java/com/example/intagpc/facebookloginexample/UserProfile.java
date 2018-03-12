package com.example.intagpc.facebookloginexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class UserProfile extends AppCompatActivity {

    private ImageView imgUserProfile;
    private TextView tvUserName, tvUserEmail;
    private String userName, userEmail, userImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        initWidgets();
        getUserData();
        setUserData(userName, userEmail, userImage);
    }


    private void initWidgets() {

        imgUserProfile = (ImageView) findViewById(R.id.userProfile);
        tvUserName = (TextView) findViewById(R.id.tvUserName);
        tvUserEmail = (TextView) findViewById(R.id.tvUserEmail);

    }

    private void getUserData() {

        Bundle bundleData = getIntent().getExtras();
        userName = bundleData.getString("userName");
        userEmail = bundleData.getString("userEmail");
        userImage = bundleData.getString("userImage");
    }

    private void setUserData(String userName, String userEmail, String userImage) {

        tvUserName.setText(userName);
        tvUserEmail.setText(userEmail);
        Picasso.get().load(userImage).into(imgUserProfile);
    }
}
