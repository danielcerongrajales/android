package com.example.ejemplo;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos extends SQLiteOpenHelper {
    private static String DB_PATH = "/data/data/com.example.ejemplo/databases/";
    private static String DB_NAME = "catalogo.db";
    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public BaseDeDatos(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory,
                       int version) {
        super(contexto, nombre, factory, version);
        this.myContext = contexto;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > oldVersion){
            myContext.deleteDatabase(DB_NAME);
           Log.d("hola","como");
            try {
                createDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
            oldVersion++;
        }

    }
    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();
        this.getWritableDatabase();
        if (dbExist) {


        } else {
            try {
                copyDataBase();

            } catch (IOException e) {
                throw new Error("Error copiando database");
            }
        }
    }

    private boolean checkDataBase() {

        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;

    }

    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);

    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    private void copyDataBase() throws IOException {

        OutputStream databaseOutputStream = new FileOutputStream("" + DB_PATH + DB_NAME);
        InputStream databaseInputStream;
        byte[] buffer = new byte[1024];
        int length;
        databaseInputStream = myContext.getAssets().open("catalogo.db");
        while ((length = databaseInputStream.read(buffer)) > 0) {
            databaseOutputStream.write(buffer);
        }
        databaseInputStream.close();
        databaseOutputStream.flush();
        databaseOutputStream.close();
    }

    public List<DatosModelo> getAll(String tabla,String condicion) {

        List<DatosModelo> array_list=new ArrayList<>();
        Log.d("hola",myDataBase.getPath());
        Cursor res = myDataBase.rawQuery("SELECT * FROM "+ tabla+ "where "+condicion,null);
        res.moveToFirst();
        while(res.isAfterLast() == false) {
            array_list.add(new DatosModelo(res.getString(res.getColumnIndex("id_unidad")),res.getString(res.getColumnIndex("uni_desc")),res.getString(res.getColumnIndex("id_marca"))));
            res.moveToNext();
        }
        return array_list;
    }
    public void deleterow(String tabla,String id) {

        //myDataBase.delete(tabla, "id_unidad="+id, null);
        myDataBase.execSQL("DELETE FROM "+tabla+" WHERE id_unidad='"+id+"'");
        //myDataBase.close();
      /*
      db.delete(DATABASE_TABLE, KEY_NAME + "=" + key_name, null);
      */

    }

}
