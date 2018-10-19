package com.ps.ehcache.dao.domain;

import com.ps.ehcache.dao.model.VQuestionKnowledgeInfo;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface VQuestionKnowledgeInfoMapper {
    @Insert({
        "insert into v_question_knowledge_info (type, question, ",
        "course, book, knowledge)",
        "values (#{type,jdbcType=VARCHAR}, #{question,jdbcType=VARCHAR}, ",
        "#{course,jdbcType=VARCHAR}, #{book,jdbcType=VARCHAR}, #{knowledge,jdbcType=VARCHAR})"
    })
    int insert(VQuestionKnowledgeInfo record);

    @Select({
        "select",
        "type, question, course, book, knowledge",
        "from v_question_knowledge_info",
        "order by id desc"
    })
    @Results({
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="question", property="question", jdbcType=JdbcType.VARCHAR),
        @Result(column="course", property="course", jdbcType=JdbcType.VARCHAR),
        @Result(column="book", property="book", jdbcType=JdbcType.VARCHAR),
        @Result(column="knowledge", property="knowledge", jdbcType=JdbcType.VARCHAR)
    })
    List<VQuestionKnowledgeInfo> selectAll();
}