package ude.edu.uy.ejemploasynctask;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static ude.edu.uy.ejemploasynctask.MyDatabaseHelper.COLUMNS_USUARIO;
import static ude.edu.uy.ejemploasynctask.MyDatabaseHelper.NOMBRE_USUARIO;
import static ude.edu.uy.ejemploasynctask.MyDatabaseHelper.TABLE_USUARIO;

public class UsuarioDao {

    private SQLiteOpenHelper myDatabaseHelper;
    private SQLiteDatabase db;
    private static UsuarioDao usuarioDao;

    public static UsuarioDao getInstance() {
        if (usuarioDao == null) {
            usuarioDao = new UsuarioDao();
        }
        return usuarioDao;
    }

    public void open() {
        if (myDatabaseHelper == null) {
            throw new IllegalStateException("Debe inicializarse la base de datos");
        }
        db = myDatabaseHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public void insertUser(Usuario usuario) {
        open();
        ContentValues values = new ContentValues();
        //values.put(ID_USUARIO, usuario.getId());//Es autoincrement
        values.put(NOMBRE_USUARIO, usuario.getNombre());
        db.insert(TABLE_USUARIO, null, values);
        close();
    }

    public List<Usuario> findAllUsers() {
        open();
        List<Usuario> usuarios = new ArrayList<>();
        Cursor cursor = db.query(TABLE_USUARIO, COLUMNS_USUARIO, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String nombre = cursor.getString(1);
                Usuario usuario = new Usuario(id, nombre);
                usuarios.add(usuario);
            } while (cursor.moveToNext());
        }
        close();
        return usuarios;
    }

    public void setMyDatabaseHelper(SQLiteOpenHelper myDatabaseHelper) {
        if (myDatabaseHelper != null) {
            this.myDatabaseHelper = myDatabaseHelper;
        }
    }
}

