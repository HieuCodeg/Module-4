package com.hieucodeg.service;

import com.hieucodeg.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song product);

    Song findById(int id);

    void update(int id, Song song);

    void remove(int id);

}
