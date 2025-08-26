package com.example.rebound.config.mybatis.handler;


import com.example.rebound.common.enumeration.Grade;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Grade.class)
public class MentorHandler implements TypeHandler<Grade> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Grade parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,parameter.name());
    }

    @Override
    public Grade getResult(ResultSet rs, int columnIndex) throws SQLException {
        return switch (rs.getString(columnIndex)){
            case "mentor"-> Grade.MENTOR;
            case "none"-> Grade.NONE;
            case "subscribe"-> Grade.SUBSCRIBE;
            default -> null;
        };
    }

    @Override
    public Grade getResult(ResultSet rs, String columnName) throws SQLException {
        return switch (rs.getString(columnName)){
            case "mentor"-> Grade.MENTOR;
            case "none"-> Grade.NONE;
            case "subscribe"-> Grade.SUBSCRIBE;
            default -> null;
        };
    }

    @Override
    public Grade getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return switch (cs.getString(columnIndex)){
            case "mentor"-> Grade.MENTOR;
            case "none"-> Grade.NONE;
            case "subscribe"-> Grade.SUBSCRIBE;
            default -> null;
        };
    }
}
