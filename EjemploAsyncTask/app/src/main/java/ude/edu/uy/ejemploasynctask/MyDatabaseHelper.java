package ude.edu.uy.ejemploasynctask;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper{
    public static final String DB_NAME="Usuario";
    public static final String TABLE_USUARIO="Usuarios";
    public static final String ID_USUARIO="id";
    public static final String NOMBRE_USUARIO="nombre";
    public static final String COLUMNS_USUARIO[]={ID_USUARIO,NOMBRE_USUARIO};

    private String initSql="create table "+TABLE_USUARIO+" ("+ID_USUARIO+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NOMBRE_USUARIO+" TEXT)";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(initSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
