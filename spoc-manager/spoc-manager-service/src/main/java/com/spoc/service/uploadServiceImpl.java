package com.spoc.service;

import com.spoc.mapper.FileMapper;
import com.spoc.pojo.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class uploadServiceImpl implements uploadService {

    @Autowired
    private FileMapper fileMapper;
    @Override
    public void saveFile(FileEntity entity) {
        fileMapper.saveFile(entity);
    }

    @Override
    public FileEntity findByid(long id) {
        return fileMapper.findByid(id);
    }

    @Override
    public List<FileEntity> findAll() {
        return fileMapper.findAll();
    }
}
