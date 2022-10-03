package com.bluewhitecat.dao;

import com.bluewhitecat.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    // 使用DBUtils
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update用来执行Insert\\update\\Delete语句
     * @param sql   sql语句
     * @param args  sql参数
     * @return 返回-1表示执行失败；返回其他表示影响的行数
     */
    public int update(String sql, Object ... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            int update = queryRunner.update(connection, sql, args);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查询单个数据
     * @param type
     * @param sql   sql语句
     * @param args  sql参数
     * @param <T>
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object ... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询多条数据
     * @param type
     * @param sql   sql语句
     * @param args  sql参数
     * @param <T>   查询对象类型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql   sql语句
     * @param args  sql参数
     * @return
     */
    public Object queryForSingleValue(String sql, Object ... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
}
