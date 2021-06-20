package com.example.icar.ui.profile;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.icar.Customer;
import com.example.icar.databinding.FragmentProfileBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mReference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FirebaseApp.initializeApp(getContext());
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mAuth = FirebaseAuth.getInstance();
        mReference = FirebaseDatabase.getInstance().getReference();
        mUser = mAuth.getCurrentUser();
        /*
            write code here
         */

        final ImageView igmAvatar;
        final TextView txtName, txtEmail, txtPhone, txtAddress, txtBirthday, txtGender;
        final Button btnEdit;
        final ProgressBar progressBar;

        igmAvatar = binding.imageViewAvatarProfileFragment;
        txtName = binding.textViewNameProFrm;
        txtEmail = binding.textViewEmailProFrm;
        txtPhone = binding.textViewPhoneProFrm;
        txtAddress = binding.textViewAddressProFrm;
        txtBirthday = binding.textViewBirthdayProFrm;
        txtGender = binding.textViewGenderProFrm;
        btnEdit = binding.buttonEditProFrm;
        progressBar = binding.progressBarProFrm;

        progressBar.setVisibility(View.VISIBLE);
        String uid = mUser.getUid();
        mReference.child("Customers").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                Customer customer = snapshot.getValue(Customer.class);
                try {
//                    Select * from Customers where UID = KEY
                    txtName.setText(txtName.getText().toString() + customer.full_name);
                    txtEmail.setText(txtEmail.getText().toString() + customer.email);
                    txtPhone.setText(txtPhone.getText().toString() + customer.phone);
                    txtAddress.setText(txtAddress.getText().toString() + customer.address);
                    txtBirthday.setText(txtBirthday.getText().toString() + customer.birthday);
                    txtGender.setText(txtGender.getText().toString() + (customer.gender ? "Nam" : "Nu"));
                    Glide.with(getContext()).asBitmap().load(mUser.getPhotoUrl()).into(igmAvatar);
                } catch (Exception e) {
                    Log.d("AAA", e.getMessage());
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}