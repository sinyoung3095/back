package com.example.rebound.config.mybatis.handler;

import com.example.rebound.common.enumeration.ApprovalStatus;
import com.example.rebound.common.enumeration.Common;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(ApprovalStatus.class)
public class ApprovalStatusHandler implements TypeHandler<ApprovalStatus> {
    @Override
    public void setParameter(PreparedStatement ps, int i, ApprovalStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public ApprovalStatus getResult(ResultSet rs, String columnName) throws SQLException {
        return switch (rs.getString(columnName)){
            case "approval"->ApprovalStatus.APPROVAL;
            case "await"-> ApprovalStatus.AWAIT;
            case "refusal"-> ApprovalStatus.REFUSAL;
            default -> null;
        };
    }

    @Override
    public ApprovalStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
        return switch (rs.getString(columnIndex)){
            case "approval"-> ApprovalStatus.APPROVAL;
            case "await"-> ApprovalStatus.AWAIT;
            case "refusal"-> ApprovalStatus.REFUSAL;
            default -> null;
        };
    }

    @Override
    public ApprovalStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return switch (cs.getString(columnIndex)){
            case "approval"-> ApprovalStatus.APPROVAL;
            case "await"-> ApprovalStatus.AWAIT;
            case "refusal"-> ApprovalStatus.REFUSAL;
            default -> null;
        };
    }
}
