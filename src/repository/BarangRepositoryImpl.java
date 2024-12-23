package repository;

import entity.Barang;
import util.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarangRepositoryImpl implements BarangRepository{
    @Override
    public List<Barang> getAll() {
        String sql = "SELECT * FROM barangs LIMIT 5";
        List<Barang> barangList = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Barang barang = new Barang();
                barang.setKdBarang(resultSet.getString("kd_barang"));
                barang.setNama(resultSet.getString("nama"));
                barang.setKategori(resultSet.getString("kategori"));
                barang.setStok(resultSet.getInt("stok"));
                barang.setStokMinimum(resultSet.getInt("stok_minimum"));
                barang.setTanggalKadaluarsa(resultSet.getDate("tanggal_kadaluarsa"));
                barang.setIdPemasok(resultSet.getInt("id_pemasok"));
                barangList.add(barang);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return barangList;
    }

    @Override
    public void add(Barang barang) {
        String sql ="INSERT INTO barangs (kd_barang, nama, kategori, stok, stok_minimum,tanggal_kadaluarsa,  id_pemasok) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setString(1, barang.getKdBarang());
            statement.setString(2, barang.getNama());
            statement.setString(3, barang.getKategori());
            statement.setInt(4, barang.getStok());
            statement.setInt(5, barang.getStokMinimum());
            statement.setDate(6, barang.getTanggalKadaluarsa());
            statement.setInt(7, barang.getIdPemasok());


            int rows = statement.executeUpdate();
            System.out.println("Data berhasil ditambahkan. Rows Affected : " + rows);
        }catch(SQLException e){
            System.err.println("Gagal menambahkan Barang: " + e.getMessage());

        }
    }

    @Override
    public void edit(Barang barang) {
        String sql = "UPDATE barangs SET  nama = ?, kategori= ?,tanggal_kadaluarsa= ?, id_pemasok= ? WHERE kd_barang = ?";
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

        ){
            statement.setString(1, barang.getNama());
            statement.setString(2, barang.getKategori());
            statement.setDate(3, barang.getTanggalKadaluarsa());
            statement.setInt(4, barang.getIdPemasok());
            statement.setString(5, barang.getKdBarang());


            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Barang berhasil diperbarui. Rows affected: " + rowsAffected);
            } else {
                System.out.println("Barang dengan ID " + barang.getKdBarang() + " tidak ditemukan.");
            }



        }catch (SQLException e){
            System.err.println("Gagal memperbarui data barang: " + e.getMessage());
        }
    }

    @Override
    public void addStok(Barang barang) {
        String sql = "UPDATE barangs SET  stok = stok + ? WHERE kd_barang = ?";
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

        ){
            statement.setInt(1, barang.getStok());
            statement.setString(2, barang.getKdBarang());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pemasok berhasil diperbarui. Rows affected: " + rowsAffected);
            } else {
                System.out.println("Pemasok dengan ID " + barang.getKdBarang() + " tidak ditemukan.");
            }



        }catch (SQLException e){
            System.err.println("Gagal memperbarui data pemasok: " + e.getMessage());
        }
    }

    @Override
    public void minStok(Barang barang) {
        String sql = "UPDATE barangs SET  stok = stok - ? WHERE kd_barang = ?";
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

        ){
            statement.setInt(1, barang.getStok());
            statement.setString(2, barang.getKdBarang());



            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pemasok berhasil diperbarui. Rows affected: " + rowsAffected);
            } else {
                System.out.println("Pemasok dengan ID " + barang.getKdBarang() + " tidak ditemukan.");
            }



        }catch (SQLException e){
            System.err.println("Gagal memperbarui data pemasok: " + e.getMessage());
        }
    }

    @Override
    public void delete(String kdBarang) {
        String sql = "DELETE FROM barangs WHERE kd_barang = ?";

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1, kdBarang);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Barang berhasil dihapus.");
            } else {
                System.err.println("Gagal menghapus Barang. Kode barang tidak ditemukan.");
            }

        }catch (SQLException e){
            System.err.println("Gagal menghapus barang: " + e.getMessage());

        }
    }

    @Override
    public Barang findById(String kdBarang) {
        String sql  = "SElECT * FROM barangs WHERE kd_barang = ?";
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1, kdBarang);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    Barang barang = new Barang();
                    barang.setKdBarang(resultSet.getString("kd_barang"));
                    barang.setNama(resultSet.getString("nama"));
                    barang.setKategori(resultSet.getString("kategori"));
                    barang.setTanggalKadaluarsa(resultSet.getDate("tanggal_kadaluarsa"));
                    barang.setIdPemasok(resultSet.getInt("id_pemasok"));
                    return barang;
                }
            }

        }catch (SQLException e){
            System.err.println("Gagal mencari pemasok: " + e.getMessage());

        }
        return null;
    }
}
