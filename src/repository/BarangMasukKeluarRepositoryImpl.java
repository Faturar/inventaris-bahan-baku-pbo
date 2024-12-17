package repository;

import entity.BarangMasukKeluar;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BarangMasukKeluarRepositoryImpl implements BarangMasukKeluarRepository{
    @Override
    public List<BarangMasukKeluar> getAllMasuk() {
        String sql = "SELECT * FROM barang_masuk_keluars WHERE tipe = 'masuk' LIMIT 5";
        List<BarangMasukKeluar> barangMasukList = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                BarangMasukKeluar barangMasukKeluar = new BarangMasukKeluar();
                barangMasukKeluar.setId(resultSet.getInt("id"));
                barangMasukKeluar.setKdBarang(resultSet.getString("kd_barang"));
                barangMasukKeluar.setJumlah(resultSet.getInt("jumlah"));
                barangMasukKeluar.setTanggal(resultSet.getDate("tanggal"));
//                barangMasukKeluar.setTipe(BarangMasukKeluar.Tipe.valueOf(resultSet.getString("tipe")));



                barangMasukList.add(barangMasukKeluar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return barangMasukList;
    }

    @Override
    public void addMasuk(BarangMasukKeluar barangMasukKeluar) {
        String sql ="INSERT INTO barang_masuk_keluars (kd_barang, jumlah,tanggal, tipe) VALUES(?, ?, ?, 'masuk')";

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setString(1, barangMasukKeluar.getKdBarang());
            statement.setInt(2, barangMasukKeluar.getJumlah());
            statement.setDate(3, barangMasukKeluar.getTanggal());

            int rows = statement.executeUpdate();
            System.out.println("Data berhasil ditambahkan. Rows Affected : " + rows);
        }catch(SQLException e){
            System.err.println("Gagal menambahkan Barang: " + e.getMessage());

        }
    }

    @Override
    public void editMasuk(BarangMasukKeluar barangMasukKeluar) {
        String sql = "UPDATE barang_masuk_keluars SET kd_barang  = ?, jumlah = ? ? WHERE id = ?";
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

        ){
            statement.setString(1, barangMasukKeluar.getKdBarang());
            statement.setInt(2, barangMasukKeluar.getJumlah());


            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Barang Masuk Keluar berhasil diperbarui. Rows affected: " + rowsAffected);
            } else {
                System.out.println("Barang Masuk Keluar dengan Kode " + barangMasukKeluar.getId() + " tidak ditemukan.");
            }



        }catch (SQLException e){
            System.err.println("Gagal memperbarui data Barang Masuk Keluar: " + e.getMessage());
        }
    }

    @Override
    public void deleteMasuk(int id) {
        String sql = "DELETE FROM barang_masuk_keluars WHERE id = ?";

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Barang Masuk Keluar berhasil dihapus.");
            } else {
                System.err.println("Gagal menghapus Barang Masuk Keluar. ID tidak ditemukan.");
            }

        }catch (SQLException e){
            System.err.println("Gagal menghapus barang masuk keluar: " + e.getMessage());

        }
    }

    @Override
    public BarangMasukKeluar findByIdMasuk(int id) {
        String sql  = "SElECT * FROM barang_masuk_keluars WHERE id = ?";
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    BarangMasukKeluar barangMasukKeluar = new BarangMasukKeluar();
                    barangMasukKeluar.setKdBarang(resultSet.getString("kd_barang"));
                    barangMasukKeluar.setId(resultSet.getInt("id"));
                    barangMasukKeluar.setJumlah(resultSet.getInt("jumlah"));
                    barangMasukKeluar.setTanggal(resultSet.getDate("tanggal"));
                    return barangMasukKeluar;
                }
            }

        }catch (SQLException e){
            System.err.println("Gagal mencari Barang Masuk Keluar: " + e.getMessage());

        }
        return null;
    }

    @Override
    public List<BarangMasukKeluar> getAllKeluar() {
        String sql = "SELECT * FROM barang_masuk_keluars WHERE tipe = 'keluar' LIMIT 5";
        List<BarangMasukKeluar> barangKeluarList = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                BarangMasukKeluar barangMasukKeluar = new BarangMasukKeluar();
                barangMasukKeluar.setId(resultSet.getInt("id"));
                barangMasukKeluar.setKdBarang(resultSet.getString("kd_barang"));
                barangMasukKeluar.setJumlah(resultSet.getInt("jumlah"));
                barangMasukKeluar.setTanggal(resultSet.getDate("tanggal"));
//                barangMasukKeluar.setTipe(BarangMasukKeluar.Tipe.valueOf(resultSet.getString("tipe")));



                barangKeluarList.add(barangMasukKeluar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return barangKeluarList;
    }

    @Override
    public void addKeluar(BarangMasukKeluar barangMasukKeluar) {
        String sql ="INSERT INTO barang_masuk_keluars (kd_barang, jumlah, tipe) VALUES(?, ?, 'keluar')";

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setString(1, barangMasukKeluar.getKdBarang());
            statement.setInt(2, barangMasukKeluar.getJumlah());
            //statement.setDate(3, barangMasukKeluar.getTanggal());




            int rows = statement.executeUpdate();
            System.out.println("Data berhasil ditambahkan. Rows Affected : " + rows);
        }catch(SQLException e){
            System.err.println("Gagal menambahkan Barang: " + e.getMessage());

        }
    }

    @Override
    public void editKeluar(BarangMasukKeluar barangMasukKeluar) {
        String sql = "UPDATE barang_masuk_keluars SET kd_barang  = ?, jumlah = ? ? WHERE id = ?";
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

        ){
            statement.setString(1, barangMasukKeluar.getKdBarang());
            statement.setInt(2, barangMasukKeluar.getJumlah());


            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Barang Masuk Keluar berhasil diperbarui. Rows affected: " + rowsAffected);
            } else {
                System.out.println("Barang Masuk Keluar dengan Kode " + barangMasukKeluar.getId() + " tidak ditemukan.");
            }



        }catch (SQLException e){
            System.err.println("Gagal memperbarui data Barang Masuk Keluar: " + e.getMessage());
        }
    }

    @Override
    public void deleteKeluar(int id) {
        String sql = "DELETE FROM barang_masuk_keluars WHERE id = ?";

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Barang Masuk Keluar berhasil dihapus.");
            } else {
                System.err.println("Gagal menghapus Barang Masuk Keluar. ID tidak ditemukan.");
            }

        }catch (SQLException e){
            System.err.println("Gagal menghapus barang masuk keluar: " + e.getMessage());

        }
    }

    @Override
    public BarangMasukKeluar findByIdKeluar(int id) {
        String sql  = "SElECT * FROM barang_masuk_keluars WHERE id = ?";
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    BarangMasukKeluar barangMasukKeluar = new BarangMasukKeluar();
                    barangMasukKeluar.setKdBarang(resultSet.getString("kd_barang"));
                    barangMasukKeluar.setId(resultSet.getInt("id"));
                    barangMasukKeluar.setJumlah(resultSet.getInt("jumlah"));
                    barangMasukKeluar.setTanggal(resultSet.getDate("tanggal"));
                    return barangMasukKeluar;
                }
            }

        }catch (SQLException e){
            System.err.println("Gagal mencari Barang Masuk Keluar: " + e.getMessage());

        }
        return null;


    }
}
