package entity;
import java.time.LocalDateTime;

public class Pemasok {

    private Integer id;            // Primary Key
    private String nama;
    private String alamat;
    private String noTelepon;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



    // Constructor
    public Pemasok() {
    }

    public Pemasok(Integer id, String nama, String alamat, String noTelepon, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
