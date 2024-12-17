package entity;
import java.sql.Date;
import java.sql.Timestamp;


public class Barang {
    private String kdBarang;
    private String nama;
    private String kategori;
    private int stok;
    private int stokMinimum;
    private Date tanggalKadaluarsa;
    private int idPemasok;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Barang(){}
    public Barang(String kdBarang, String nama, String kategori, int stok, int stokMinimum, Date tanggalKadaluarsa, int idPemasok, Timestamp createdAt, Timestamp updatedAt) {
        this.kdBarang = kdBarang;
        this.nama = nama;
        this.kategori = kategori;
        this.stok = stok;
        this.stokMinimum = stokMinimum;
        this.tanggalKadaluarsa = tanggalKadaluarsa;
        this.idPemasok = idPemasok;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getKdBarang() {
        return kdBarang;
    }

    public void setKdBarang(String kdBarang) {
        this.kdBarang = kdBarang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getStokMinimum() {
        return stokMinimum;
    }

    public void setStokMinimum(int stokMinimum) {
        this.stokMinimum = stokMinimum;
    }

    public Date getTanggalKadaluarsa() {
        return tanggalKadaluarsa;
    }

    public void setTanggalKadaluarsa(Date tanggalKadaluarsa) {
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    public int getIdPemasok() {
        return idPemasok;
    }

    public void setIdPemasok(int idPemasok) {
        this.idPemasok = idPemasok;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }


    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    @Override
    public String toString() {
        return "Barang{" +
                "kdBarang='" + kdBarang + '\'' +
                ", nama='" + nama + '\'' +
                ", kategori='" + kategori + '\'' +
                ", stok=" + stok +
                ", stokMinimum=" + stokMinimum +
                ", tanggalKadaluarsa=" + tanggalKadaluarsa +
                ", idPemasok=" + idPemasok +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }


}
