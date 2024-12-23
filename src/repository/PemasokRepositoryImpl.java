package repository;

import entity.Pemasok;
import util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PemasokRepositoryImpl implements PemasokRepository {

    @Override
    public List<Pemasok> getAll() {
        String sql = "SELECT * FROM pemasoks LIMIT 5";
        List<Pemasok> pemasokList = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Pemasok pemasok = new Pemasok();
                pemasok.setId(resultSet.getInt("id"));
                pemasok.setNama(resultSet.getString("nama"));
                pemasok.setAlamat(resultSet.getString("alamat"));
                pemasok.setNoTelepon(resultSet.getString("no_telepon"));
                pemasokList.add(pemasok);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pemasokList;
    }
    @Override
    public void add(Pemasok pemasok) {
        String sql ="INSERT INTO pemasoks (nama, alamat, no_telepon) VALUES(?, ?, ?)";
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1,pemasok.getNama() );
            statement.setString(2,pemasok.getAlamat() );
            statement.setString(3,pemasok.getNoTelepon() );

            int rowsAffected = statement.executeUpdate();
            System.out.println("Data berhasil ditambahkan. Rows affected: " + rowsAffected);

        }catch (SQLException e){
            System.err.println("Gagal menambahkan data pemasok : " + e.getMessage());
        }
    }

    @Override
    public void edit(Pemasok pemasok) {
        String sql = "UPDATE pemasoks SET nama  = ?, alamat = ?, no_telepon= ? WHERE id = ?";
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

        ){
            statement.setString(1, pemasok.getNama());
            statement.setString(2, pemasok.getAlamat());
            statement.setString(3, pemasok.getNoTelepon());
            statement.setInt(4, pemasok.getId());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pemasok berhasil diperbarui. Rows affected: " + rowsAffected);
            } else {
                System.out.println("Pemasok dengan ID " + pemasok.getId() + " tidak ditemukan.");
            }



        }catch (SQLException e){
            System.err.println("Gagal memperbarui data pemasok: " + e.getMessage());
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM pemasoks WHERE id = ?";

        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Pemasok berhasil dihapus.");
            } else {
                System.err.println("Gagal menghapus pemasok. ID tidak ditemukan.");
            }

        }catch (SQLException e){
            System.err.println("Gagal menghapus pemasok: " + e.getMessage());

        }

    }

    @Override
    public Pemasok findById(int id) {
        String sql  = "SElECT * FROM pemasoks WHERE id = ?";
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    Pemasok pemasok = new Pemasok();
                    pemasok.setId(resultSet.getInt("id"));
                    pemasok.setNama(resultSet.getString("nama"));
                    pemasok.setAlamat(resultSet.getString("alamat"));
                    pemasok.setNoTelepon(resultSet.getString("no_telepon"));
                    return pemasok;
                }
            }

        }catch (SQLException e){
            System.err.println("Gagal mencari pemasok: " + e.getMessage());

        }
        return null;
    }


}
