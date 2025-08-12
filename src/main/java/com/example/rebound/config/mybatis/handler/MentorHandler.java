package com.example.rebound.config.mybatis.handler;


import com.example.rebound.common.enumeration.Mentor;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Mentor.class)
public class MentorHandler implements TypeHandler<Mentor> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Mentor parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,parameter.name());
    }

    @Override
    public Mentor getResult(ResultSet rs, int columnIndex) throws SQLException {
        return switch (rs.getString(columnIndex)){
            case "mentor"-> Mentor.MENTOR;
            case "none"-> Mentor.NONE;
            default -> null;
        };
    }

    @Override
    public Mentor getResult(ResultSet rs, String columnName) throws SQLException {
        return switch (rs.getString(columnName)){
            case "mentor"-> Mentor.MENTOR;
            case "none"-> Mentor.NONE;
            default -> null;
        };
    }

    @Override
    public Mentor getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return switch (cs.getString(columnIndex)){
            case "mentor"-> Mentor.MENTOR;
            case "none"-> Mentor.NONE;
            default -> null;
        };
    }
}
