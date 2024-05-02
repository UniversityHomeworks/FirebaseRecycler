package top.jonakls.firebaserecycler;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import top.jonakls.firebaserecycler.model.PersonModel;
import top.jonakls.firebaserecycler.model.adapt.CollectPersonAdapter;

public class MainActivity extends AppCompatActivity {

    private static final List<PersonModel> PERSON_MODELS = new ArrayList<>();
    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance()
            .getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final RecyclerView recyclerView = findViewById(R.id.collectPerson);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseReference.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    PersonModel personModel = dataSnapshot.getValue(PersonModel.class);
                    PERSON_MODELS.add(personModel);
                }

                CollectPersonAdapter collectPersonAdapter = new CollectPersonAdapter(PERSON_MODELS);
                recyclerView.setAdapter(collectPersonAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("MainActivity", "onCancelled", error.toException());
            }
        });
    }
}