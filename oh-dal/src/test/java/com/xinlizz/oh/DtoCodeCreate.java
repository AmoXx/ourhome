package com.xinlizz.oh;

import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author xinlizz
 * @Date 2018/7/10
 */
public class DtoCodeCreate {

    private static Connection connection = null;

    private static Statement statement = null;

    private static ResultSet rs = null;

    private static String TABLE_NAME = "oh_user_info";

    public static void main(String[] args) throws Exception {
        createFileds();
    }

    private static void createFileds() throws Exception {
        List<DtoCode> dtos = queryTableColumns();
        StringBuilder sb = null;
        for (DtoCode dto : dtos) {
            sb = new StringBuilder("/** ");
            sb.append(dto.getColumnComment()).append(" */\n");
            sb.append("private ").append(dto.getDataType()).append(" ").append(dto.getColumnName()).append(";\n");
            System.out.println(sb.toString());
        }
    }

    private static List<DtoCode> queryTableColumns() throws Exception {
        getConnection();
        getStatement();

        String sql = "select t.COLUMN_NAME, t.DATA_TYPE, t.COLUMN_COMMENT  " +
                "from information_schema.columns t " +
                "where t.table_schema ='ourhome_db'  " +
                "and t.table_name = '" + TABLE_NAME + "' " +
                "AND t.COLUMN_NAME NOT IN ( 'id', 'creator', 'create_date', 'updater', 'update_date', 'is_deleted' )";
        rs = statement.executeQuery(sql);

        List<DtoCode> dtos = new ArrayList<>();
        DtoCode dtoCode = null;
        while (rs.next()) {
            dtoCode = new DtoCode();
            dtoCode.setColumnName(rs.getString("COLUMN_NAME"));
            dtoCode.setDataType(rs.getString("DATA_TYPE"));
            dtoCode.setColumnComment(new String(rs.getString("COLUMN_COMMENT").getBytes("UTF-8"), "UTF-8"));
            dtos.add(dtoCode);
        }
        closeResources();
        return dtos;
    }

    private static void getConnection() {
        String url = "jdbc:mysql://192.168.0.105:3306/ourhome_db?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "lxzz1109";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeResources() {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (null != statement) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static class DtoCode {
        private String columnName;
        private String dataType;
        private String columnComment;

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnChange(columnName);
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            if ("bigint".equals(dataType)) {
                dataType = "Long";
            } else if ("datetime".equals(dataType) || "date".equals(dataType)) {
                dataType = "Date";
            } else {
                dataType = "String";
            }
            this.dataType = dataType;
        }

        public String getColumnComment() {
            return columnComment;
        }

        public void setColumnComment(String columnComment) {
            this.columnComment = columnComment;
        }

        private String columnChange(String colunmName) {
            String[] strs = colunmName.toLowerCase().split("_");
            StringBuilder name = new StringBuilder();
            byte[] bytes = null;
            for (String str : strs) {
                bytes = str.getBytes();
                bytes[0] = (byte) ((char) bytes[0] - 32);
                str = new String(bytes);
                name.append(str);
            }

            colunmName = name.substring(0, 1).toLowerCase() + name.substring(1);
            return colunmName;
        }
    }
}


