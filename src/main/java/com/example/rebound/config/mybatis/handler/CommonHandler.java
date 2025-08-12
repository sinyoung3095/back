package com.example.rebound.config.mybatis.handler;

import com.example.rebound.common.enumeration.Common;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Common.class)
public class CommonHandler implements TypeHandler<Common> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Common parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public Common getResult(ResultSet rs, String columnName) throws SQLException {
        return switch (rs.getString(columnName)){
            case "admin"->Common.ADMIN;
            case "none"->Common.NONE;
            default -> null;
        };
    }

    @Override
    public Common getResult(ResultSet rs, int columnIndex) throws SQLException {
        return switch (rs.getString(columnIndex)) {
            case "admin" -> Common.ADMIN;
            case "none" -> Common.NONE;
            default -> null;
        };
    }

    @Override
    public Common getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return switch (cs.getString(columnIndex)){
            case "admin" -> Common.ADMIN;
            case "none" -> Common.NONE;
            default -> null;
        };
    }
}
