package com.example.listadetarefas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class CriarTarefaActivity extends AppCompatActivity {

    private EditText editTextTitulo;
    private EditText editTextDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_tarefa);

        Toolbar toolbar = findViewById(R.id.toolbarCriar);
        setSupportActionBar(toolbar);

        editTextTitulo = findViewById(R.id.editTextTitulo);
        editTextDescricao = findViewById(R.id.editTextDescricao);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_criar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_criar_tarefa) {
            Tarefa t = new Tarefa(
                    editTextTitulo.getText().toString(),
                    editTextDescricao.getText().toString()
            );
            FirebaseApi firebaseApi = new FirebaseApi(this);
            firebaseApi.criarTarefa(t, "Tarefa criada com sucesso");
        }
        return super.onOptionsItemSelected(item);
    }
}