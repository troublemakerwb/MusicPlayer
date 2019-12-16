package com.example.hp.mymusicplayer.Music;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

public class MusicAction {
    List<Music> list=new ArrayList<Music>();
    public List<Music> findMus(Context context){
        Cursor cursor=context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,null);
        if(cursor.getCount()>0){
            Music music=new Music();
            while (cursor.moveToNext()){
                music.setName(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)));
                music.setAdress(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));
                music.setLong(cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)));
                list.add(music);
                music=new Music();
            }
        }
        return list;
    }
}
