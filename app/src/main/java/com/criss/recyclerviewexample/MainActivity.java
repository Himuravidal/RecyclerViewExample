package com.criss.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.criss.recyclerviewexample.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private AnimalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        adapter = new AnimalAdapter(initializeAnimals(),this,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }




    private List<Animal> initializeAnimals() {
        Animal animal1 = new Animal("https://images.unsplash.com/photo-1497752531616-c3afd9760a11?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80", "Mapache Chileno");
        Animal animal2 = new Animal("https://images.unsplash.com/photo-1539418561314-565804e349c0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80", "Flamingo");
        Animal animal3 = new Animal("https://images.unsplash.com/photo-1503066211613-c17ebc9daef0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80", "tigre tonny");
        List<Animal> animalList = new ArrayList<Animal>();
        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);
        return animalList;
    }

    private void instanceDetailFragment(String name, String url) {
        DetailFragment detailFragment = DetailFragment.newInstance(name, url);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout, detailFragment, "DetailFragment")
                .commit();

    }

    @Override
    public void onClick(AnimalAdapter.ViewHolder viewHolder, String nameAnimal, String url) {
        Toast.makeText(this,    nameAnimal, Toast.LENGTH_SHORT).show();
        instanceDetailFragment(nameAnimal, url );
    }
}
