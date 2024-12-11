package repository;

import entity.Pemasok;
import util.DatabaseUtil;
import repository.PemasokRepository;

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

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Pemasok findById(int id) {
        return null;
    }


}
