package com.faresa.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.faresa.myapplication.pojo.getbarang.GetBarang;

import java.util.ArrayList;

import static com.faresa.myapplication.db.DbContract.FavoriteColoumn.ID;
import static com.faresa.myapplication.db.DbContract.FavoriteColoumn.IMAGE;
import static com.faresa.myapplication.db.DbContract.FavoriteColoumn.TABLE_FAVORITE_NAME;
import static com.faresa.myapplication.db.DbContract.FavoriteColoumn.TITLE;


public class FavoriteHelper {

    private static final String DB_TABLE =TABLE_FAVORITE_NAME ;
    private static FavoriteDbHelper favoriteDbHelper;
    private static FavoriteHelper INST;
    private static SQLiteDatabase db;

    public FavoriteHelper(Context context){
        favoriteDbHelper = new FavoriteDbHelper(context);
    }

    public static FavoriteHelper getInst(Context context){
        if (INST == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INST == null) {
                    INST= new FavoriteHelper(context);
                }
            }
        }
        return INST;
    }

    public void open() throws SQLException {
        db = favoriteDbHelper.getWritableDatabase();
//        db = favoriteDbHelper.getReadableDatabase();
    }

    public void close() {
        favoriteDbHelper.close();

        if (db.isOpen())
            db.close();
    }

    public ArrayList<GetBarang> getAllFavorites(){
        ArrayList<GetBarang> arrayList = new ArrayList<>();
        Cursor cursor = db.query(DB_TABLE,null,
                null,
                null,
                null,
                null,
                ID+ " ASC",
                null);
        cursor.moveToFirst();
        GetBarang userResponse;
        if (cursor.getCount()>0){
            do{
                userResponse = new GetBarang();
                userResponse.setBarangId(cursor.getInt(cursor.getColumnIndexOrThrow(ID)));
                userResponse.setNama(cursor.getString(cursor.getColumnIndexOrThrow(TITLE)));
                userResponse.setHarga(cursor.getInt(cursor.getColumnIndexOrThrow(IMAGE)));
                arrayList.add(userResponse);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        } cursor.close();
        return arrayList;
    }

    public long favoriteInsert (GetBarang userResponse){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,userResponse.getBarangId());
        contentValues.put(TITLE,userResponse.getNama());
        contentValues.put(IMAGE,userResponse.getHarga());

        return db.insert(DB_TABLE,null,contentValues);
    }

    public int favoriteDelete(String title) {
        return db.delete(TABLE_FAVORITE_NAME, TITLE + " = '" + title + "'", null);
    }
    public Cursor cursorFavoriteGet() {
        return db.query(DB_TABLE, null, null, null, null, null, ID+" ASC");
    }
    public Cursor cursorFavoriteGetId(String id) {
        return db.query(DB_TABLE, null
                , ID + " = ?"
                , new String[]{id}
                , null
                , null
                , null
                , null);
    }
    public int favoriteDeleteProvider(String id) {
        return db.delete(TABLE_FAVORITE_NAME, ID+ "=?",new String[]{id});
    }
    public int favoriteUpdateProvider(String id, ContentValues values) {
        return db.update(DB_TABLE, values, ID + " =?", new String[]{id});
    }
    public long favoriteInsertProvider(ContentValues values) {
        return db.insert(DB_TABLE, null, values);
    }
}
