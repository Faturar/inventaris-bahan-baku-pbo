package repository;

import entity.Barang;
import entity.Pemasok;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                barang.setTanggalKadaluarsa(resultSet.getTimestamp("tanggal_kadaluarsa"));
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
        String sql ="INSERT INTO barangs (kd_barang, nama, kategoti, stok, stok_minimum, tanggal_kadaluarsa) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setString(1, barang.getKdBarang());
            statement.setString(2, barang.getNama());
            statement.setString(3, barang.getKategori());
            statement.setInt(4, barang.getStok());
            statement.setInt(5, barang.getStokMinimum());
            statement.setTimestamp(6, barang.getTanggalKadaluarsa());

            int rows = statement.executeUpdate();
            System.out.println("Data berhasil ditambahkan. Rows Affected : " + rows);
        }catch(SQLException e){
            System.err.println("Gagal menambahkan Barang: " + e.getMessage());

        }

    }

    @Override
    public void edit(Barang barang) {

    }

    @Override
    public void delete(String kdBarang) {

    }

    @Override
    public Barang findById(String kdBarang) {
        return null;
    }
}
