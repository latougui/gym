package com.latou.gym.mapper;

import com.latou.gym.domain.Essay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    List<Essay> findAllEssayByBoard(long essayBoardId);
    /**
     * 根据essayBoardId返回时间最近10篇文章
     * @return
     */
    List<Essay> findRecentEssay(long essayBoardId);

    /**
     * 根据id获取文章
     * @return
     */
    Essay findEssayById(long essayId);

    /**
     * 添加文章
     * @param essay
     */
    void addEssay(Essay essay);

    /**
     * 更新文章
     * @param essay
     */
    void updateEssay(Essay essay);
    /**
     * 根据id删除文章
     * @param id
     */
    void deleteEssay(long id);

    /**
     * 文章数量
     * @return
     */
    int countEssay();

    /**
     * 根据关键字获取文章列表
     * @return
     */
    List<Essay> search(@Param("content")String content);
}
