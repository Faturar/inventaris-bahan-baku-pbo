package repository;

import entity.Barang;
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
        String sql ="INSERT INTO barang_masuk_keluars (kd_barang, jumlah, tipe) VALUES(?, ?, 'masuk')";

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setString(1, barangMasukKeluar.getKdBarang());
            statement.setInt(2, barangMasukKeluar.getJumlah());
            //statement.setString(3, barang.getKategori());
            //statement.setString(3, barangMasukKeluar.getTipe());



            int rows = statement.executeUpdate();
            System.out.println("Data berhasil ditambahkan. Rows Affected : " + rows);
        }catch(SQLException e){
            System.err.println("Gagal menambahkan Barang: " + e.getMessage());

        }
    }

    @Override
    public void editMasuk(BarangMasukKeluar barangMasukKeluar) {

    }

    @Override
    public void deleteMasuk(int id) {

    }

    @Override
    public Barang findByIdMasuk(int id) {
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

    }

    @Override
    public void editKeluar(BarangMasukKeluar barangMasukKeluar) {

    }

    @Override
    public void deleteKeluar(int id) {

    }

    @Override
    public Barang findByIdKeluar(int id) {
        return null;
    }
}
