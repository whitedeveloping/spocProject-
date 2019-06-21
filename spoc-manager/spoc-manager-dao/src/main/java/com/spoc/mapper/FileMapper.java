package com.spoc.mapper;




import com.spoc.pojo.FileEntity;

import java.util.List;

public interface FileMapper {
	void saveFile(FileEntity entity);
	FileEntity findByid(long id);
	List<FileEntity> findAll();
}
