package com.guilherme.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout, linearLayoutMaiores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);
        linearLayoutMaiores = findViewById(R.id.linearLayoutMaiores);

        try {
            // Criar Banco de dados
            SQLiteDatabase bancoDeDados = openOrCreateDatabase("appSQLite", MODE_PRIVATE, null);

            // Criar tabela
            bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(2))");

            // Removendo dados antigos
            bancoDeDados.execSQL("DELETE FROM pessoas");

            // Inserir dados
            bancoDeDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Guilherme', 23)");
            bancoDeDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Evelin', 20)");
            bancoDeDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Nivaldo', 45)");
            bancoDeDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Mônica', 40)");
            bancoDeDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Gustavo', 12)");
            bancoDeDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Norah', 45)");
            bancoDeDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Alessandra', 16)");
            bancoDeDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Romeu', 11)");
            bancoDeDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Daniela', 8)");

            recuperarFiltro(bancoDeDados);
            recuperarTodosDados(bancoDeDados);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void recuperarTodosDados(SQLiteDatabase bancoDeDados) {
        // Recuperar todas as pessoas
        Cursor cursorTodos = bancoDeDados.rawQuery("SELECT nome, idade FROM pessoas ORDER BY nome", null);

        // Indices da tabela
        int indiceNome = cursorTodos.getColumnIndex("nome");
        int indiceIdade = cursorTodos.getColumnIndex("idade");

        cursorTodos.moveToFirst();
        while (!cursorTodos.isAfterLast()) {
            TextView textView = new TextView(this);
            textView.setPadding(40, 40, 40, 0);

            String nome = cursorTodos.getString(indiceNome);
            String idade = cursorTodos.getString(indiceIdade);

            textView.setText(String.format("Nome: %s - Idade: %s", nome, idade));

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            linearLayout.addView(textView, layoutParams);

            cursorTodos.moveToNext();
        }
        cursorTodos.close();
    }

    private void recuperarFiltro(SQLiteDatabase bancoDeDados) {
        // Filtro
        String consulta = "SELECT nome, idade FROM pessoas WHERE idade >= 18 ORDER BY nome";
        /*
        * AND == &&
        * OR == ||
        * IN (35, 18) verifica se é um desses valores
        * BETWEEN 35 AND 18 verifica se esta entre o intervalo
        * LIKE 'Mar%' o % indica qualquer coisa apos ou antes
        *
        * ORDER BY "ASC" ascendente "DESC" decrescente
        *
        * LIMIT limita o numero de seleção
        * */
        Cursor cursorFiltro = bancoDeDados.rawQuery(consulta, null);

        // Indices da tabela
        int indiceNome = cursorFiltro.getColumnIndex("nome");
        int indiceIdade = cursorFiltro.getColumnIndex("idade");

        cursorFiltro.moveToFirst();
        while (!cursorFiltro.isAfterLast()) {
            TextView textView = new TextView(this);
            textView.setPadding(40, 40, 40, 0);

            String nome = cursorFiltro.getString(indiceNome);
            String idade = cursorFiltro.getString(indiceIdade);

            textView.setText(String.format("Nome: %s - Idade: %s", nome, idade));

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            linearLayoutMaiores.addView(textView, layoutParams);

            cursorFiltro.moveToNext();
        }
        cursorFiltro.close();
    }
}