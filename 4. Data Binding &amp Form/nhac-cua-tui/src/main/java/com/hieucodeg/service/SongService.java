package com.hieucodeg.service;

import com.hieucodeg.model.Song;

import java.util.ArrayList;
import java.util.List;


public class SongService implements ISongService {
    private List<Song> songList = new ArrayList<>();

    @Override
    public List<Song> findAll() {
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }

    @Override
    public Song findById(int id) {
        return songList.get(id);
    }

    @Override
    public void update(int id, Song song) {
        for (Song p : songList) {
            if (p.getId() == id) {
                p = song;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getId() == id) {
                songList.remove(i);
                break;
            }
        }
    }

}