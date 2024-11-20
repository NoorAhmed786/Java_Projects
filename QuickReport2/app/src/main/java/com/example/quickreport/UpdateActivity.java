package com.example.quickreport;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.util.Calendar;

public class UpdateActivity extends AppCompatActivity {
    ImageView updateimage;
    Button updatesaveButton;
    EditText updateTopic,updateTopicDesc,updatearea;
    String imageurl;
    String title,desc,area;
    String key,oldImageUrl;
    Uri uri;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);
        init();

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if(o.getResultCode()== Activity.RESULT_OK){
                            Intent data = o.getData();
                            uri= data.getData();
                            updateimage.setImageURI(uri);
                        }else {
                            Toast.makeText(UpdateActivity.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String imageUrl = bundle.getString("dataImage");
            if (imageUrl != null && !imageUrl.isEmpty()) {
                Glide.with(UpdateActivity.this)
                        .load(imageUrl != null ? imageUrl : R.drawable.baseline_add_a_photo_24)
                        .into(updateimage);
            } else {
                // Handle the case where the image URL is null or empty
                updateimage.setImageResource(R.drawable.baseline_add_a_photo_24); // Set a placeholder image
            }
            // Set other fields as well
            updateTopic.setText(bundle.getString("dataTitle"));
            updateTopicDesc.setText(bundle.getString("dataDesc"));
            updatearea.setText(bundle.getString("dataArea"));
            key = bundle.getString("Key");
            oldImageUrl = imageUrl;
        }


//        Bundle bundle = getIntent().getExtras();
//        if(bundle != null){
//            Glide.with(UpdateActivity.this).load(bundle.getString( "dataImage")).into(updateimage);
//            updateTopic.setText(bundle.getString("dataTitle"));
//            updateTopicDesc.setText(bundle.getString("dataDesc"));
//            updatearea.setText(bundle.getString("dataArea"));
//            key= bundle.getString("Key");
//            oldImageUrl=bundle.getString("dataImage");
//        }

        databaseReference = FirebaseDatabase.getInstance().getReference("Android Tutorials").child(key);

        updateimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent photoPicker = new Intent(Intent.ACTION_PICK);
                 photoPicker.setType("image/*");
                 activityResultLauncher.launch(photoPicker);
            }
        });

        updatesaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                Intent intent = new Intent(UpdateActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });



    }
    public  void saveData(){

            if (uri == null) {
                // Use old image URL if no new image was selected
                imageurl = oldImageUrl;
                updateData();
                return;
            }

            // Upload new image if URI is not null
             storageReference = FirebaseStorage.getInstance().getReference()
                    .child("Android Images")
                    .child(uri.getLastPathSegment());

            // Proceed with upload logic

        AlertDialog.Builder builder = new AlertDialog.Builder(UpdateActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progresslayout);
        AlertDialog dialog = builder.create();
        dialog.show();

        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask =taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri urlImage =uriTask.getResult();
                imageurl = urlImage.toString();
                updateData();
                dialog.dismiss();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
            }
        });


    }
    public  void updateData(){
         title = updateTopic.getText().toString();
         desc = updateTopicDesc.getText().toString();
         area = updatearea.getText().toString();

        DataClass dataClass = new DataClass (title,desc,area,imageurl);

        databaseReference.setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    StorageReference reference = FirebaseStorage.getInstance().getReferenceFromUrl(oldImageUrl);
                    reference.delete();
                    Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UpdateActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });




    }
    void  init(){
        updateimage=findViewById(R.id.uploadimage);
        updatesaveButton=findViewById(R.id.updatesavebutton);
        updateTopic=findViewById(R.id.updatetopic);
        updatearea=findViewById(R.id.updateArea);
        updateTopicDesc=findViewById(R.id.updatetopicdesc);


    }

}