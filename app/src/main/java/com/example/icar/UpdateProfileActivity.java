package com.example.icar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UpdateProfileActivity extends AppCompatActivity {

    private final int REQUEST_CODE_IMAGE = 1;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private String name;

    private ImageView imgView;
    private Button btnPickPhoto, btnUpdate;
    private EditText edtName, edtEmail, edtPhone, edtAddress, edtBirthday;
    private RadioGroup rgGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        getSupportActionBar().setTitle("Update Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        initializeViews();

        // handle objects
        btnPickPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_IMAGE);
            }
        });
//        Toast.makeText(this, "Hello " + name, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        if (requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgView.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initializeViews() {
        imgView = findViewById(R.id.imageView);
        btnPickPhoto = findViewById(R.id.buttonPick);
        btnUpdate = findViewById(R.id.buttonUpdate);
        edtName = findViewById(R.id.editTextTextPersonName);
        edtEmail = findViewById(R.id.editTextTextEmailAddress);
        edtPhone = findViewById(R.id.editTextPhone);
        edtAddress = findViewById(R.id.editTextTextAddress);
        edtBirthday = findViewById(R.id.editTextDate);
        rgGender = findViewById(R.id.radioGroup);
        edtName.setText(name);
        edtEmail.setText(user.getEmail());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}