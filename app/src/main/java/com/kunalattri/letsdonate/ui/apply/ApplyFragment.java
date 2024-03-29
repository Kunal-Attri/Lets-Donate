package com.kunalattri.letsdonate.ui.apply;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kunalattri.letsdonate.R;
import com.kunalattri.letsdonate.databinding.FragmentApplyBinding;

import java.util.HashMap;
import java.util.UUID;

public class ApplyFragment extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    private FragmentApplyBinding binding;

    private AutoCompleteTextView bgAutoCompleteTextView;
    private TextInputEditText name, age, phone, city;
    Button applyBtn;

    private int receivers;

    private Dialog loadingDialog;
    private TextView loadingText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ApplyViewModel applyViewModel =
                new ViewModelProvider(this).get(ApplyViewModel.class);

        binding = FragmentApplyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        String[] bg_items = getResources().getStringArray(R.array.blood_groups);
        ArrayAdapter adapter = new ArrayAdapter<>(getContext(), R.layout.list_item, bg_items);
        bgAutoCompleteTextView = binding.bgRAutoCompleteTextView;
        bgAutoCompleteTextView.setAdapter(adapter);


        name = binding.nameRTextField;
        age = binding.ageTextField;
        phone = binding.phoneRTextField;
        city = binding.cityTextField;
        applyBtn = binding.applyBtn;

        loadingDialog = new Dialog(getContext());
        loadingDialog.setContentView(R.layout.loading);
        loadingDialog.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.rounded_corners));
        loadingDialog.getWindow().setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        loadingDialog.setCancelable(false);
        loadingText = loadingDialog.findViewById(R.id.loadingText);

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                receivers = Integer.parseInt(snapshot.child("statistics").child("receivers").getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error connecting to database...", Toast.LENGTH_SHORT).show();
            }
        });

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean errur = false;
                if (name.getText().toString().isEmpty()) {
                    name.setError("Required");
                    errur = true;
                } else if (name.getText().toString().length() <= 3) {
                    name.setError("Too short");
                    errur = true;
                }
                if (age.getText().toString().isEmpty()) {
                    age.setError("Required");
                    errur = true;
                } else if (!(Integer.parseInt(age.getText().toString()) >= 0 && Integer.parseInt(age.getText().toString()) <= 114)) {
                    age.setError("Enter valid age");
                    errur = true;
                }
                if (phone.getText().toString().isEmpty()) {
                    phone.setError("Required");
                    errur = true;
                } else if (phone.getText().length() != 10) {
                    phone.setError("Requires 10 digits");
                    errur = true;
                } else if (!(Integer.parseInt(phone.getText().toString().substring(0, 1)) >= 6 && Integer.parseInt(phone.getText().toString().substring(0, 1)) <= 9)) {
                    phone.setError("Enter valid phone no.");
                    errur = true;
                }
                if (city.getText().toString().isEmpty()) {
                    city.setError("Required");
                    errur = true;
                } else if (city.getText().toString().length() <= 3) {
                    city.setError("Too short");
                    errur = true;
                }
                if (bgAutoCompleteTextView.getText().toString().isEmpty()) {
                    bgAutoCompleteTextView.setError("Required");
                    errur = true;
                }
                if (!errur) {
                    final HashMap<String, Object> map = new HashMap<>();
                    map.put("name", name.getText().toString());
                    map.put("age", Integer.parseInt(age.getText().toString()));
                    map.put("blood_group", bgAutoCompleteTextView.getText().toString());
                    map.put("phone", phone.getText().toString());
                    map.put("city", city.getText().toString());

                    String id = UUID.randomUUID().toString();

                    loadingText.setText("Applying...");
                    loadingDialog.show();

                    myRef.child("receivers").child(id)
                            .setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                myRef.child("statistics").child("receivers").setValue(receivers+1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            receivers += 1;
                                            Toast.makeText(getContext(), "Blood request application submitted. You will be contacted within 1-3 business days!", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getContext(), "Something went wrong...", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(getContext(), "Something went wrong...", Toast.LENGTH_SHORT).show();
                            }
                            loadingDialog.dismiss();
                            loadingText.setText("Loading...");
                        }
                    });
                }
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