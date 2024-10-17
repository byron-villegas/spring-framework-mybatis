package cl.villegas.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import cl.villegas.mybatis.model.Document;

@Mapper
public interface DocumentRepository {
        @Delete("DELETE FROM DOCUMENT WHERE ID = #{id}")
        void delete(long id);

        @Select("SELECT * FROM DOCUMENT")
        @Results({ @Result(column = "id", property = "id"), @Result(column = "name", property = "name"),
                        @Result(column = "file", property = "file", jdbcType = JdbcType.BINARY),
                        @Result(column = "contentType", property = "contentType") })
        List<Document> findAll();

        @Select("SELECT * FROM DOCUMENT WHERE ID = #{id}")
        @Results({ @Result(column = "id", property = "id"), @Result(column = "name", property = "name"),
                        @Result(column = "file", property = "file", jdbcType = JdbcType.BINARY),
                        @Result(column = "contentType", property = "contentType") })
        Document findById(long id);

        @Insert("INSERT INTO DOCUMENT(NAME, FILE, CONTENTTYPE) VALUES(#{name}, #{file, jdbcType=BINARY}, #{contentType})")
        void save(Document document);

        @Update("UPDATE DOCUMENT SET NAME = #{name}, FILE = #{file, jdbcType=BINARY}, CONTENTTYPE = #{contentType} WHERE ID = #{id}")
        void update(Document document);
}