package uy.edu.ude.ejemplosqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnInsert;
    private Button btnSearch;
    private Button btnDelete;
    private Button btnUpdate;
    private EditText etId;
    private EditText etName;
    private TextView tvResults;
    private final String TAG = "PrincipalActivity";
    private final String nombreBD = "BDUsuario";
    private BdHelper bdHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Iniciando la aplicacion");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = (Button) this.findViewById(R.id.btnInsert);
        btnSearch = (Button) this.findViewById(R.id.btnSearch);
        btnDelete = (Button) this.findViewById(R.id.btnDelete);
        btnUpdate = (Button) this.findViewById(R.id.btnUpdate);
        tvResults = (TextView) this.findViewById(R.id.tvResults);
        etName = (EditText) this.findViewById(R.id.etName);
        etId = (EditText) this.findViewById(R.id.etId);
        btnInsert.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        Log.i(TAG, "Iniciando la BD");
        bdHelper = new BdHelper(this, nombreBD, null, 1);
    }

    @Override
    public void onClick(View v) {
        Log.i(TAG, "Ejecutando click");
        try {
            Log.i(TAG, "Leyendo datos");
            int id = 0;
            String nombre = "";
            if (v.getId() != R.id.btnSearch) {
                id = Integer.parseInt(etId.getText().toString());
                nombre = etName.getText().toString();
            }
            switch (v.getId()) {
                case R.id.btnInsert:
                    //insertSql(id, nombre);
                    insertWithMethod(id, nombre);
                    tvResults.setText("Insert OK");
                    break;
                case R.id.btnSearch:
                    String resultado = searchWithMethod();//searchRawSql();
                    tvResults.setText("Los resultados son: \n" + resultado);
                    break;
                case R.id.btnUpdate:
                    //updateSql(id, nombre);
                    updateWithMethod(id, nombre);
                    tvResults.setText("Update OK");
                    break;
                case R.id.btnDelete:
                    //deleteSql(id);
                    deleteWithMethod(id);
                    tvResults.setText("Delete OK");
                    break;
            }
        } catch (NumberFormatException e) {
            Log.e(TAG, "Error en operacion de conversion", e);
            Toast.makeText(this, "Ocurrio un error al convertir datos", Toast.LENGTH_SHORT).show();
        }
        Log.i(TAG, "Operación completada");
    }

    public void insertSql(int id, String nombre) throws NumberFormatException {
        Log.i(TAG, "Insertando datos con execSQL");
        SQLiteDatabase db = bdHelper.getWritableDatabase();
        String sql = "insert into usuario (id,nombre) values (" + id + ",'" + nombre + "')";
        Log.i(TAG, "Ejecutando consulta: " + sql);
        db.execSQL(sql);
        db.close();
    }

    public void insertWithMethod(int id, String nombre) throws NumberFormatException {
        Log.i(TAG, "Insertando datos insert()");
        SQLiteDatabase db = bdHelper.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("id", id);
        registro.put("nombre", nombre);
        db.insert("usuario", null, registro);
    }

    public String searchRawSql() throws NumberFormatException {
        Log.i(TAG, "Buscando datos");
        SQLiteDatabase db = bdHelper.getReadableDatabase();
        //"select * from usuario where id="+id
        String sql = "select * from usuario";
        Cursor cursor = db.rawQuery(sql, null);
        String resultados = "";
        if (cursor.moveToFirst()) {
            do {
                int idFound = cursor.getInt(0);
                String nameFound = cursor.getString(1);
                resultados += "id: " + idFound + ", " + "Nombre: " + nameFound + "\n";
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return resultados;
    }
    /**/
    public String searchWithMethod() throws NumberFormatException {
        Log.i(TAG, "Buscando datos");
        SQLiteDatabase db = bdHelper.getReadableDatabase();
        String columnas[] = {"id", "nombre"};
        Cursor cursor = db.query("usuario", columnas, null, null, null, null, null);
        String resultados = "";
        if (cursor.moveToFirst()) {
            do {
                int idFound = cursor.getInt(0);
                String nameFound = cursor.getString(1);
                resultados += "id: " + idFound + ", " + "Nombre: " + nameFound + "\n";
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return resultados;
    }

    public void updateSql(int id, String nombre) throws NumberFormatException {
        Log.i(TAG, "Actualizando datos");
        SQLiteDatabase db = bdHelper.getWritableDatabase();
        String sql = "update usuario set nombre ='" + nombre + "' where id=" + id;
        Log.i(TAG, "Ejecutando consulta: " + sql);
        db.execSQL(sql);
        db.close();
    }

    public void updateWithMethod(int id, String nombre) throws NumberFormatException {
        Log.i(TAG, "Actualizando datos con update()");
        SQLiteDatabase db = bdHelper.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("id", id);
        registro.put("nombre", nombre);
        db.update("usuario", registro, "id=" + id, null);
        db.close();
    }

    public void deleteSql(int id) throws NumberFormatException {
        Log.i(TAG, "Borrando datos");
        SQLiteDatabase db = bdHelper.getWritableDatabase();
        String sql = "delete from usuario where id=" + id;
        Log.i(TAG, "Ejecutando consulta: " + sql);
        db.execSQL(sql);
        db.close();
    }

    public void deleteWithMethod(int id) throws NumberFormatException {
        Log.i(TAG, "Borrando datos con delete()");
        SQLiteDatabase db = bdHelper.getWritableDatabase();
        db.delete("usuario", "id=" + id, null);
        db.close();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "Cerrando BD");
        bdHelper.close();
        super.onDestroy();
    }
}
