package com.prography.playeasy.mypage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;
import com.prography.playeasy.match.activity.MatchListActivity;

public class UserInformationActivity extends AppCompatActivity {

    ImageButton myProfileImage;
    //id
    TextView TextViewId;
    EditText editTextId;
    //이름
    TextView textViewName;
    EditText editTextName;
    //선호 포지션
    TextView textViewPosition;
    EditText editTextPosition;
    //나이
    TextView textViewAge;
    EditText editTextAge;
    //phonenum verification
    TextView textViewPhoneNum;
    EditText editTextPhoneNum1;
    Button editButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_myinfo);
        ToolbarInitializer.ToolBarInitialize(this, findViewById(R.id.myPageUserInfoToolBar));


//질문 1
//        myProfileImage=(ImageButton)findViewById(R.id.imageButton);
//        myProfileImage.setImageResource(R.drawable.shinja);

//getSupportActionBar의 반환형 ActionBar

//review todo
//        Glide.with(UserInformationActivity.this)
//                .load(R.drawable.shinja)
//                .placeholder(R.drawable.shinja)
//                .centerCrop()
//                .into(myProfileImage);
        TextViewId = (TextView) findViewById(R.id.TextViewId);

        editTextId= (EditText) findViewById(R.id.editTextId);
        textViewName=(TextView)findViewById(R.id.TextViewName);
        editTextName=(EditText) findViewById(R.id.editTextName);
//나이
        textViewAge = (TextView) findViewById(R.id.TextViewAge);


        editTextAge = (EditText) findViewById(R.id.editTextAge);

//선호포지션
        textViewPosition = (TextView) findViewById(R.id.TextViewPosition);
        editTextPosition = (EditText) findViewById(R.id.editTextPosition);





//휴대폰 인증
        textViewPhoneNum= (TextView) findViewById(R.id.TextViewPhoneNum1);
        editTextPhoneNum1=(EditText)findViewById(R.id.editTextPhoneNum1);

//         editTextPhoneNum2 = (EditText) findViewById(R.id.editTextPhoneNum2);
//
//         editTextPhoneNum3 = (EditText) findViewById(R.id.editTextPhoneNum3);
         //재인증 버튼
        editButton=(Button)findViewById(R.id.editButton);
        editTextPhoneNum1.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }

    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // NavUtils.navigateUpFromSameTask(this);
                Intent userInfoBack = new Intent(this, MatchListActivity.class);
                startActivity(userInfoBack);
                return true;
        }
        return super.onOptionsItemSelected(item);
    };
}
