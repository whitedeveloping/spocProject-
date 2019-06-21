package com.spoc.service;

import com.spoc.pojo.FileEntity;

import java.util.List;

public interface uploadService {
    void saveFile(FileEntity entity);

    FileEntity findByid(long id);

    List<FileEntity> findAll();


}
