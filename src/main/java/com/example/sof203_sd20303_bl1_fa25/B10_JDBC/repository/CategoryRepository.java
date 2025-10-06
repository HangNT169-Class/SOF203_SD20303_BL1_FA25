package com.example.sof203_sd20303_bl1_fa25.B10_JDBC.repository;

import com.example.sof203_sd20303_bl1_fa25.B10_JDBC.config.DBConnect;
import com.example.sof203_sd20303_bl1_fa25.B10_JDBC.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    // CRUD
    // hien thi => getAll (Select * FROm category)
    public List<Category>getAll(){
        List<Category>listCate = new ArrayList<>();
        // viet logic
        // B1: Tao sql
        String sql = "SELECT id, category_code, category_name\n" +
                "FROM hibernate_demo.dbo.category;";
        // mo cong ket noi
        try(Connection con = DBConnect.getConnection();
            // chuan bi cau lenh sql
            PreparedStatement ps = con.prepareStatement(sql);
        ){
            ResultSet rs = ps.executeQuery(); // tuong ung vs sql bam vao button run
            while (rs.next()){// kiem tra du lieu tung dong
                Category cate = new Category();
                cate.setId(rs.getLong(1));
                cate.setCategoryName(rs.getString(3));
                cate.setCategoryCode(rs.getString(2));
                listCate.add(cate);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return listCate;
    }

    public Category getOne(Long id1){
        // viet logic
        // B1: Tao sql
        String sql = "SELECT id, category_code, category_name\n" +
                "FROM hibernate_demo.dbo.category WHERE id = ?;";
        // mo cong ket noi
        try(Connection con = DBConnect.getConnection();
            // chuan bi cau lenh sql
            PreparedStatement ps = con.prepareStatement(sql);
        ){
            // set gia tri cho dau ?
            ps.setObject(1,id1);
//            ps.setObject(2,id1);
            ResultSet rs = ps.executeQuery(); // tuong ung vs sql bam vao button run
            if (rs.next()){// kiem tra du lieu tung dong
                Category cate = new Category();
                cate.setId(rs.getLong(1));
                cate.setCategoryName(rs.getString(3));
                cate.setCategoryCode(rs.getString(2));
                return cate;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public boolean add(Category cate){
        int check = 0 ; // chua add duoc thanh cong
        String sql = "INSERT INTO hibernate_demo.dbo.category\n" +
                "(id, category_code, category_name)\n" +
                "VALUES(?,?,?);";
        // mo cong ket noi
        try(Connection con = DBConnect.getConnection();
            // chuan bi cau lenh sql
            PreparedStatement ps = con.prepareStatement(sql);
        ){
            // truyen gia tri cho cac dau ?
            ps.setObject(1,cate.getId());
            ps.setObject(2,cate.getCategoryCode());
            ps.setObject(3,cate.getCategoryName());
            // thuc thi cau lenh sql
            // Select => excute query
            // !Select => excute update
            check = ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        return check > 0;
    }
    public boolean delete(Long id){
        int check = 0 ; // chua add duoc thanh cong
        String sql = "DELETE FROM hibernate_demo.dbo.category\n" +
                "WHERE id=?;";
        // mo cong ket noi
        try(Connection con = DBConnect.getConnection();
            // chuan bi cau lenh sql
            PreparedStatement ps = con.prepareStatement(sql);
        ){
            // truyen gia tri cho cac dau ?
            ps.setObject(1,id);
            // thuc thi cau lenh sql
            // Select => excute query
            // !Select => excute update
            check = ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        return check > 0;
    }

    public boolean update(Category categoryUpdate, Long idCanUpdate){
        int check = 0 ; // chua add duoc thanh cong
        String sql = "UPDATE hibernate_demo.dbo.category\n" +
                "SET category_code=?, category_name=?\n" +
                "WHERE id=?;";
        // mo cong ket noi
        try(Connection con = DBConnect.getConnection();
            // chuan bi cau lenh sql
            PreparedStatement ps = con.prepareStatement(sql);
        ){
            // truyen gia tri cho cac dau ?
            ps.setObject(1,categoryUpdate.getCategoryCode());
            ps.setObject(2,categoryUpdate.getCategoryName());
            ps.setObject(1,idCanUpdate);
            // thuc thi cau lenh sql
            // Select => excute query
            // !Select => excute update
            check = ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getAll());
    }
}
