package com.latou.gym.mapper;

import com.latou.gym.domain.Essay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EssayMapper {
    /**
     * 返回所有文章信息
     * @return
     */
    List<Essay> findAllEssay();

    /**
     * 根据分类返回所有文章
     * @return
     */
    List<Essay> findAllEssayByBoard();

    /**
     * 添加文章
     * @param essay
     */
    void addEssay(Essay essay);

    /**
     * 根据id删除文章
     * @param id
     */
    void deleteEssay(long id);
}
